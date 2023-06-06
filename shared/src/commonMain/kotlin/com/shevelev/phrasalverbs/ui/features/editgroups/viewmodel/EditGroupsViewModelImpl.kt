package com.shevelev.phrasalverbs.ui.features.editgroups.viewmodel

import com.shevelev.phrasalverbs.core.koin.KoinScopeClosable
import com.shevelev.phrasalverbs.core.log.Logger
import com.shevelev.phrasalverbs.core.resource.toLocString
import com.shevelev.phrasalverbs.core.ui.viewmodel.ViewModelBase
import com.shevelev.phrasalverbs.data.repository.appstorage.CardsRepository
import com.shevelev.phrasalverbs.domain.entities.Card
import com.shevelev.phrasalverbs.resources.MR
import com.shevelev.phrasalverbs.ui.features.editgroups.viewmodel.data.CardsListItem
import com.shevelev.phrasalverbs.ui.features.editgroups.viewmodel.data.DropTargetType
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

    private var separatorIdCounter = -1L

    private val _state = MutableStateFlow<EditGroupsState>(EditGroupsState.Loading)
    override val state: StateFlow<EditGroupsState>
        get() = _state.asStateFlow()

    init {
        viewModelScope.launch {
            try {
                val allCards = cardsRepository.getAllCards()

                _state.emit(
                    EditGroupsState.Content(
                        sourceList = getSourceList(allCards),
                        groupList = listOf(
                            CardsListItem.SeparatorItem(
                                itemId = --separatorIdCounter,
                                selected = false,
                            ),
                        ),
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

    override fun onDropCard(card: Card, target: DropTargetType) {
        val newState = (_state.value as? EditGroupsState.Content)?.let { activeState ->
            val sourceList = activeState.sourceList.toMutableList()
            val groupList = activeState.groupList.toMutableList()

            when (target) {
                DropTargetType.GroupListGeneral -> {
                    val index = removeCard(sourceList, card)
                    removeItem(sourceList, index)

                    addCard(groupList, card)
                    addSeparator(groupList)
                }

                else -> throw UnsupportedOperationException()
            }

            activeState.copy(sourceList = sourceList, groupList = groupList)
        }

        newState?.let { _state.tryEmit(it) }
    }

    private fun getSourceList(allCards: List<Card>): List<CardsListItem> {
        val result = mutableListOf<CardsListItem>()

        addSeparator(result)

        allCards.forEach {
            addCard(result, it)
            addSeparator(result)
        }

        return result
    }

    private fun addSeparator(listToAdd: MutableList<CardsListItem>) =
        listToAdd.add(
            CardsListItem.SeparatorItem(
                itemId = --separatorIdCounter,
                selected = false,
            ),
        )

    private fun addCard(listToAdd: MutableList<CardsListItem>, card: Card) =
        listToAdd.add(CardsListItem.CardItem(card = card))

    private fun removeCard(listToRemove: MutableList<CardsListItem>, card: Card): Int {
        val index = listToRemove.indexOfFirst {
            it is CardsListItem.CardItem && it.card.id == card.id
        }
        listToRemove.removeAt(index)

        return index
    }

    private fun removeItem(listToRemove: MutableList<CardsListItem>, index: Int) =
        listToRemove.removeAt(index)
}
