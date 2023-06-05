package com.shevelev.phrasalverbs.ui.features.editgroups.viewmodel

import com.shevelev.phrasalverbs.core.koin.KoinScopeClosable
import com.shevelev.phrasalverbs.core.log.Logger
import com.shevelev.phrasalverbs.core.resource.toLocString
import com.shevelev.phrasalverbs.core.ui.viewmodel.ViewModelBase
import com.shevelev.phrasalverbs.data.repository.appstorage.CardsRepository
import com.shevelev.phrasalverbs.domain.entities.Card
import com.shevelev.phrasalverbs.resources.MR
import com.shevelev.phrasalverbs.ui.features.editgroups.viewmodel.data.CardsListItem
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
                        mainList = getMainList(allCards),
                        groupList = mutableListOf(
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

    private fun getMainList(allCards: List<Card>): List<CardsListItem> {
        val result = mutableListOf<CardsListItem>()

        allCards.forEach {
            result.add(
                CardsListItem.SeparatorItem(
                    itemId = --separatorIdCounter,
                    selected = false,
                ),
            )
            result.add(CardsListItem.CardItem(card = it))
        }

        result.add(
            CardsListItem.SeparatorItem(
                itemId = --separatorIdCounter,
                selected = false,
            ),
        )

        return result
    }
}
