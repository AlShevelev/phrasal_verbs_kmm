package com.shevelev.phrasalverbs.ui.features.editgroups.viewmodel

import com.shevelev.phrasalverbs.core.koin.KoinScopeClosable
import com.shevelev.phrasalverbs.core.log.Logger
import com.shevelev.phrasalverbs.core.resource.toLocString
import com.shevelev.phrasalverbs.core.ui.viewmodel.ViewModelBase
import com.shevelev.phrasalverbs.resources.MR
import com.shevelev.phrasalverbs.ui.features.editgroups.domain.CardListsLogicFacade
import com.shevelev.phrasalverbs.ui.features.editgroups.domain.entities.CardLists
import com.shevelev.phrasalverbs.ui.features.editgroups.domain.entities.CardsListItem
import com.shevelev.phrasalverbs.ui.navigation.NavigationGraph
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

internal class EditGroupsViewModelImpl(
    private val navigation: NavigationGraph,
    private val cardListsLogicFacade: CardListsLogicFacade,
    scopeClosable: KoinScopeClosable,
) : ViewModelBase(scopeClosable), EditGroupsViewModel {

    private val _state = MutableStateFlow<EditGroupsState>(EditGroupsState.Loading)
    override val state: StateFlow<EditGroupsState>
        get() = _state.asStateFlow()

    init {
        viewModelScope.launch {
            try {
                val lists = cardListsLogicFacade.getStartLists()

                _state.emit(
                    EditGroupsState.Content(
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
        navigation.navigateToMainMenu()
    }

    override fun onDropCard(cardId: Long, separatorId: Long) {
        val newState = (_state.value as? EditGroupsState.Content)?.let { activeState ->
            val lists = CardLists(
                sourceList = activeState.sourceList,
                groupList = activeState.groupList,
            )

            val processingResult = cardListsLogicFacade.processDropCard(lists, cardId, separatorId)

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

            if (activeState.name.isNullOrBlank()) {
                _state.tryEmit(activeState.copy(isNameDialogShown = true))
            } else {
                // save here
            }
        }
    }

    override fun onNameDialogClose(value: String?, isConfirmed: Boolean) {
        (_state.value as? EditGroupsState.Content)?.let { activeState ->
            val newState = activeState.copy(
                isNameDialogShown = false,
                name = if (value.isNullOrBlank()) activeState.name else value,
            )
            _state.tryEmit(newState)

            if (!isConfirmed) {
                return
            }

            if (!value.isNullOrBlank()) {
                // save here
            }
        }
    }
}
