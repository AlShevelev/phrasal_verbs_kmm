package com.shevelev.phrasalverbs.ui.features.mainmenu.viewmodel

import com.shevelev.phrasalverbs.core.koin.KoinScopeClosable
import com.shevelev.phrasalverbs.core.ui.viewmodel.ViewModelBase
import com.shevelev.phrasalverbs.ui.navigation.NavigationGraph

internal class MainMenuViewModelImpl(
    val navigation: NavigationGraph,
    scopeClosable: KoinScopeClosable,
) : ViewModelBase(scopeClosable), MainMenuViewModel {
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
