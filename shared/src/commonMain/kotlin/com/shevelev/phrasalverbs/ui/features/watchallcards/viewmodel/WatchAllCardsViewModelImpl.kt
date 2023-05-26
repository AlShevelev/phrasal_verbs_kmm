package com.shevelev.phrasalverbs.ui.features.watchallcards.viewmodel

import com.shevelev.phrasalverbs.core.koin.KoinScopeClosable
import com.shevelev.phrasalverbs.core.ui.viewmodel.ViewModelBase
import com.shevelev.phrasalverbs.ui.navigation.NavigationGraph

internal class WatchAllCardsViewModelImpl(
    val navigation: NavigationGraph,
    scopeClosable: KoinScopeClosable,
) : ViewModelBase(scopeClosable), WatchAllCardsViewModel {

    override fun onNextClick() {
        navigation.navigateToMainMenu()
    }
}
