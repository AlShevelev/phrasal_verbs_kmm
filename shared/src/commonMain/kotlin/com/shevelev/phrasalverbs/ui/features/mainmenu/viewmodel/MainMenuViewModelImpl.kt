package com.shevelev.phrasalverbs.ui.features.mainmenu.viewmodel

import com.shevelev.phrasalverbs.core.koin.KoinScopeClosable
import com.shevelev.phrasalverbs.core.ui.viewmodel.ViewModelBase
import com.shevelev.phrasalverbs.data.repository.appstorage.CardsRepository
import com.shevelev.phrasalverbs.ui.navigation.NavigationGraph
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

internal class MainMenuViewModelImpl(
    private val navigation: NavigationGraph,
    private val cardsRepository: CardsRepository,
    scopeClosable: KoinScopeClosable,
) : ViewModelBase(scopeClosable), MainMenuViewModel {

    private val _state = MutableStateFlow<MainMenuState>(MainMenuState.Loading)
    override val state: StateFlow<MainMenuState>
        get() = _state.asStateFlow()

    init {
        viewModelScope.launch {
            val bunchesCount = cardsRepository.getBunchesCount()

            _state.emit(
                MainMenuState.Content(
                    isLearningEnabled = bunchesCount > 0,
                ),
            )
        }
    }

    override fun onEditClick() {
        navigation.navigateToEditGroups()
    }

    override fun onLearnClick() {
        navigation.navigateToLearning()
    }

    override fun onSettingsClick() {
        navigation.navigateToSettings()
    }
}
