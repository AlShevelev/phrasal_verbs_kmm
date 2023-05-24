package com.shevelev.phrasalverbs.ui.features.learning.viewmodel

import com.shevelev.phrasalverbs.ui.navigation.NavigationGraph
import com.shevelev.phrasalverbs.core.koin.KoinScopeClosable
import com.shevelev.phrasalverbs.core.ui.viewmodel.ViewModelBase

internal class LearningViewModelImpl(
    val navigation: NavigationGraph,
    scopeClosable: KoinScopeClosable,
) : ViewModelBase(scopeClosable), LearningViewModel {

    override fun onNextClick() {
        navigation.navigateToEditGroups()
    }
}
