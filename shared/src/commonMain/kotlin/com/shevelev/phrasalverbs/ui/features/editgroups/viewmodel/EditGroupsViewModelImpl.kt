package com.shevelev.phrasalverbs.ui.features.editgroups.viewmodel

import com.shevelev.phrasalverbs.core.koin.KoinScopeClosable
import com.shevelev.phrasalverbs.core.log.Logger
import com.shevelev.phrasalverbs.core.resource.toLocString
import com.shevelev.phrasalverbs.core.ui.viewmodel.ViewModelBase
import com.shevelev.phrasalverbs.data.repository.appstorage.CardsRepository
import com.shevelev.phrasalverbs.resources.MR
import com.shevelev.phrasalverbs.ui.features.editgroups.domain.CardListsLogicFacade
import com.shevelev.phrasalverbs.ui.features.editgroups.domain.CreateCardListsLogicFacade
import com.shevelev.phrasalverbs.ui.features.editgroups.domain.UpdateCardListsLogicFacade
import com.shevelev.phrasalverbs.ui.features.editgroups.domain.entities.CardLists
import com.shevelev.phrasalverbs.ui.features.editgroups.domain.entities.CardsListItem
import com.shevelev.phrasalverbs.ui.navigation.NavigationGraph
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

internal class EditGroupsViewModelImpl(
    private val navigation: NavigationGraph,
    private val cardsRepository: CardsRepository,
    scopeClosable: KoinScopeClosable,
) : ViewModelBase(scopeClosable), EditGroupsViewModel {

    private val _state = MutableStateFlow<EditGroupsState>(EditGroupsState.Loading)
    override val state: StateFlow<EditGroupsState>
        get() = _state.asStateFlow()

    private var groupId: Long? = null

    private lateinit var cardListsLogicFacade: CardListsLogicFacade

    private var wasUserAction = false

    private val isEdit: Boolean
        get() = groupId != null

    override fun init(groupId: Long?) {
        this.groupId = groupId

        cardListsLogicFacade = if (isEdit) {
            UpdateCardListsLogicFacade(cardsRepository, groupId!!)
        } else {
            CreateCardListsLogicFacade(cardsRepository)
        }

        viewModelScope.launch {
            try {
                val lists = cardListsLogicFacade.getStartLists()
                val groupName = groupId?.let { cardsRepository.getGroupBrief(it) }?.name

                _state.emit(
                    EditGroupsState.Content(
                        name = groupName,
                        isDeleteButtonShown = isEdit,
                        sourceList = lists.sourceList,
                        groupList = lists.groupList,
                    ),
                )
            } catch (ex: Exception) {
                Logger.e(ex)
                showPopup(MR.strings.general_error.toLocString())
            }
        }
    }

    override fun onBackClick() {
        (_state.value as? EditGroupsState.Content)?.let { activeState ->
            if (!activeState.isDialogShown) {
                if (wasUserAction) {
                    _state.tryEmit(activeState.copy(isCancelConfirmationDialogShown = true))
                } else {
                    navigateBack()
                }
            }
        }
    }

    override fun onDropCard(cardId: Long, separatorId: Long) {
        val newState = (_state.value as? EditGroupsState.Content)?.let { activeState ->
            val lists = CardLists(
                sourceList = activeState.sourceList,
                groupList = activeState.groupList,
            )

            val processingResult = cardListsLogicFacade.processDropCard(lists, cardId, separatorId)

            wasUserAction = true

            activeState.copy(
                sourceList = processingResult.sourceList,
                groupList = processingResult.groupList,
            )
        }

        newState?.let { _state.tryEmit(it) }
    }

    override fun onSaveClick() {
        (_state.value as? EditGroupsState.Content)?.let { activeState ->
            if (!activeState.groupList.any { it is CardsListItem.CardItem }) {
                showPopup(MR.strings.cant_save_empty_group)
                return
            }

            _state.tryEmit(activeState.copy(isNameDialogShown = true))
        }
    }

    override fun onDeleteClick() {
        (_state.value as? EditGroupsState.Content)?.let { activeState ->
            _state.tryEmit(activeState.copy(isDeleteDialogShown = true))
        }
    }

    override fun onNameDialogClose(value: String?, isConfirmed: Boolean) {
        (_state.value as? EditGroupsState.Content)?.let { activeState ->
            if (!isConfirmed || value.isNullOrBlank()) {
                val newState = activeState.copy(
                    isNameDialogShown = false,
                )
                _state.tryEmit(newState)
            } else {
                val newState = activeState.copy(
                    isNameDialogShown = false,
                    name = value,
                )
                _state.tryEmit(newState)

                save(value, newState.groupList)
                navigateBack()
            }
        }
    }

    override fun onDeleteDialogClose(isConfirmed: Boolean) {
        (_state.value as? EditGroupsState.Content)?.let { activeState ->
            _state.tryEmit(activeState.copy(isDeleteDialogShown = false))

            if (isConfirmed) {
                viewModelScope.launch {
                    cardsRepository.deleteGroup(groupId!!)
                    navigateBack()
                }
            }
        }
    }

    override fun onCancelConfirmationDialogClose(isConfirmed: Boolean) {
        (_state.value as? EditGroupsState.Content)?.let { activeState ->
            _state.tryEmit(activeState.copy(isCancelConfirmationDialogShown = false))

            if (isConfirmed) {
                navigateBack()
            }
        }
    }

    private fun save(name: String, cardsOnView: List<CardsListItem>) {
        viewModelScope.launch {
            try {
                val allCards = cardsOnView.mapNotNull { (it as? CardsListItem.CardItem)?.card }

                if (isEdit) {
                    cardsRepository.updateGroup(groupId!!, name, allCards)
                } else {
                    cardsRepository.createGroup(name = name, cards = allCards)
                }
            } catch (ex: Exception) {
                Logger.e(ex)
                showPopup(MR.strings.general_error.toLocString())
            }
        }
    }

    private fun navigateBack() {
        navigation.navigateToSelectGroup(isAddNewButtonVisible = true)
    }
}
