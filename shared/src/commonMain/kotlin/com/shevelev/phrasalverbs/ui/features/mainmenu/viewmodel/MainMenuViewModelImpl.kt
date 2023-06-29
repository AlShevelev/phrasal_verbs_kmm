package com.shevelev.phrasalverbs.ui.features.mainmenu.viewmodel

import com.shevelev.phrasalverbs.core.koin.KoinScopeClosable
import com.shevelev.phrasalverbs.core.log.Logger
import com.shevelev.phrasalverbs.core.resource.toLocString
import com.shevelev.phrasalverbs.core.ui.viewmodel.ViewModelBase
import com.shevelev.phrasalverbs.data.repository.appstorage.CardsRepository
import com.shevelev.phrasalverbs.domain.usecases.batchupdate.BatchCardsUpdateUseCase
import com.shevelev.phrasalverbs.resources.MR
import com.shevelev.phrasalverbs.ui.navigation.NavigationGraph
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

internal class MainMenuViewModelImpl(
    private val navigation: NavigationGraph,
    private val cardsRepository: CardsRepository,
    private val batchCardsUpdate: BatchCardsUpdateUseCase,
    scopeClosable: KoinScopeClosable,
) : ViewModelBase(scopeClosable), MainMenuViewModel {

    private val _state = MutableStateFlow<MainMenuState>(MainMenuState.Loading)
    override val state: StateFlow<MainMenuState>
        get() = _state.asStateFlow()

    init {
        viewModelScope.launch {
            try {
                batchCardsUpdate.update()
                val bunchesCount = cardsRepository.getGroupsCount()

                _state.emit(
                    MainMenuState.Content(
                        isLearningEnabled = bunchesCount > 0,
                    ),
                )
            } catch (ex: Exception) {
                Logger.e(ex)
                showPopup(MR.strings.general_error.toLocString())
            }
        }
    }

    override fun onEditClick() {
        navigation.navigateToSelectGroup(isAddNewButtonVisible = true)
    }

    override fun onLearnClick() {
        navigation.navigateToSelectGroup(isAddNewButtonVisible = false)
    }

    override fun onWatchAllCardsClick() {
        navigation.navigateToWatchAllCards(null)
    }

    override fun onSettingsClick() {
        navigation.navigateToSettings()
    }
}
