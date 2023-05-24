package com.shevelev.phrasalverbs.ui.features.settings.viewmodel

import com.shevelev.phrasalverbs.ui.navigation.NavigationGraph
import com.shevelev.phrasalverbs.core.koin.KoinScopeClosable
import com.shevelev.phrasalverbs.core.ui.viewmodel.ViewModelBase

internal class SettingsViewModelImpl(
    val navigation: NavigationGraph,
    scopeClosable: KoinScopeClosable,
) : ViewModelBase(scopeClosable), SettingsViewModel {

    override fun onNextClick() {
        navigation.navigateToLearning()
    }
}
