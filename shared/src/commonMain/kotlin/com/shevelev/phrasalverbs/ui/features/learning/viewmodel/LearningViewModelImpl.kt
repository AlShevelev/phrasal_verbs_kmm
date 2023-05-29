package com.shevelev.phrasalverbs.ui.features.learning.viewmodel

import com.shevelev.phrasalverbs.core.koin.KoinScopeClosable
import com.shevelev.phrasalverbs.core.ui.viewmodel.ViewModelBase
import com.shevelev.phrasalverbs.ui.navigation.NavigationGraph

internal class LearningViewModelImpl(
    private val navigation: NavigationGraph,
    scopeClosable: KoinScopeClosable,
) : ViewModelBase(scopeClosable), LearningViewModel {

    override fun onNextClick() {
        navigation.navigateToEditGroups()
    }
}
