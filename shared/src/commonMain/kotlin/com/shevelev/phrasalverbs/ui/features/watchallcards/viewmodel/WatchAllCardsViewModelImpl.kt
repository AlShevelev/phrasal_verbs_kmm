package com.shevelev.phrasalverbs.ui.features.watchallcards.viewmodel

import com.shevelev.phrasalverbs.core.koin.KoinScopeClosable
import com.shevelev.phrasalverbs.core.log.Logger
import com.shevelev.phrasalverbs.core.resource.toLocString
import com.shevelev.phrasalverbs.core.ui.viewmodel.ViewModelBase
import com.shevelev.phrasalverbs.data.repository.appstorage.CardsRepository
import com.shevelev.phrasalverbs.data.repository.keyvaluestorage.KeyValueStorageRepository
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

    init {
        viewModelScope.launch {
            try {
                val allCards = cardsRepository.getAllCards()

                val cardsProvider = if (keyValueStorageRepository.getIsInfiniteCardsList()) {
                    InfiniteListCardsProvider(allCards)
                } else {
                    FiniteListCardsProvider(allCards)
                }

                _state.emit(
                    WatchAllCardsState.Content(
                        isRussianSideDefault = keyValueStorageRepository.getIsRussianSideDefault(),
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
        navigation.navigateToMainMenu()
    }

    override fun onSwitchLanguageClick() {
        (_state.value as? WatchAllCardsState.Content)?.let {
            _state.tryEmit(
                it.copy(isRussianSideDefault = !it.isRussianSideDefault),
            )
        }
    }
}
