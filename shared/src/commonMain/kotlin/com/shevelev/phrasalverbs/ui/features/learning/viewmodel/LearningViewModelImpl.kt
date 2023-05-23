package com.shevelev.phrasalverbs.ui.features.learning.viewmodel

import com.shevelev.phrasalverbs.ui.navigation.NavigationGraph
import com.shevelev.phrasalverbs.utils.koin.KoinScopeClosable
import com.shevelev.phrasalverbs.utils.ui.viewmodel.ViewModelBase

class LearningViewModelImpl(
    val navigation: NavigationGraph,
    scopeClosable: KoinScopeClosable,
) : ViewModelBase(scopeClosable), LearningViewModel {

    override fun onNextClick() {
        navigation.navigateToEditGroups()
    }
}
