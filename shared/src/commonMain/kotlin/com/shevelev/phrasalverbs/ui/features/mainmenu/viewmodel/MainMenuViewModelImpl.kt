package com.shevelev.phrasalverbs.ui.features.mainmenu.viewmodel

import com.shevelev.phrasalverbs.ui.navigation.NavigationGraph
import com.shevelev.phrasalverbs.utils.koin.KoinScopeClosable
import com.shevelev.phrasalverbs.utils.ui.viewmodel.ViewModelBase

class MainMenuViewModelImpl(
    val navigation: NavigationGraph,
    scopeClosable: KoinScopeClosable,
) : ViewModelBase(scopeClosable), MainMenuViewModel {

    override fun onNextClick() {
        navigation.navigateToSettings()
    }
}

