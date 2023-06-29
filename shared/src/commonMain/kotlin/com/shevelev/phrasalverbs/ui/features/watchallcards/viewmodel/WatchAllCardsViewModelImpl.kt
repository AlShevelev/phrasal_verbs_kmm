package com.shevelev.phrasalverbs.ui.features.watchallcards.viewmodel

import com.shevelev.phrasalverbs.core.koin.KoinScopeClosable
import com.shevelev.phrasalverbs.core.log.Logger
import com.shevelev.phrasalverbs.core.resource.toLocString
import com.shevelev.phrasalverbs.core.ui.viewmodel.ViewModelBase
import com.shevelev.phrasalverbs.data.repository.appstorage.CardsRepository
import com.shevelev.phrasalverbs.data.repository.keyvaluestorage.KeyValueStorageRepository
import com.shevelev.phrasalverbs.domain.entities.Card
import com.shevelev.phrasalverbs.resources.MR
import com.shevelev.phrasalverbs.ui.features.watchallcards.viewmodel.contentprovider.FiniteListCardsProvider
import com.shevelev.phrasalverbs.ui.features.watchallcards.viewmodel.contentprovider.InfiniteListCardsProvider
import com.shevelev.phrasalverbs.ui.navigation.NavigationGraph
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

internal class WatchAllCardsViewModelImpl(
    private val navigation: NavigationGraph,
    private val cardsRepository: CardsRepository,
    private val keyValueStorageRepository: KeyValueStorageRepository,
    scopeClosable: KoinScopeClosable,
) : ViewModelBase(scopeClosable), WatchAllCardsViewModel {

    private val _state = MutableStateFlow<WatchAllCardsState>(WatchAllCardsState.Loading)
    override val state: StateFlow<WatchAllCardsState>
        get() = _state.asStateFlow()

    private var groupId: Long? = null

    private val isInLearningMode: Boolean
        get() = groupId != null

    var isLearntMessageShown = false

    override fun init(groupId: Long?) {
        this.groupId = groupId

        viewModelScope.launch {
            try {
                val allCards = if (isInLearningMode) {
                    cardsRepository.getGroup(groupId!!).cards
                } else {
                    cardsRepository.getAllCards()
                }

                val cardsProvider = if (keyValueStorageRepository.getIsInfiniteCardsList()) {
                    InfiniteListCardsProvider(allCards)
                } else {
                    FiniteListCardsProvider(allCards)
                }

                _state.emit(
                    WatchAllCardsState.Content(
                        isRussianSideDefault = keyValueStorageRepository.getIsRussianSideDefault(),
                        isInLearningMode = isInLearningMode,
                        cardsProvider = cardsProvider,
                    ),
                )
            } catch (ex: Exception) {
                Logger.e(ex)
                showPopup(MR.strings.general_error.toLocString())
            }
        }
    }

    override fun onBackClick() {
        if (isInLearningMode) {
            navigation.navigateToSelectGroup(isAddNewButtonVisible = false)
        } else {
            navigation.navigateToMainMenu()
        }
    }

    override fun onSwitchLanguageClick() =
        updateState {
            it.copy(isRussianSideDefault = !it.isRussianSideDefault)
        }

    override fun onLearntClick(card: Card) {
        val activeState = _state.value as? WatchAllCardsState.Content ?: return
        val isLearnt = !card.isLearnt

        viewModelScope.launch {
            cardsRepository.updateIsLearnt(card.id, isLearnt)
            activeState.cardsProvider.updateIsLearnt(card.id, isLearnt)

            if (isLearnt && !isLearntMessageShown) {
                isLearntMessageShown = true
                showPopup(MR.strings.card_is_learnt.toLocString())
            }
        }
    }

    private fun updateState(update: (WatchAllCardsState.Content) -> WatchAllCardsState.Content) {
        val activeState = _state.value as? WatchAllCardsState.Content ?: return
        _state.tryEmit(update(activeState))
    }
}
