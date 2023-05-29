package com.shevelev.phrasalverbs.ui.features.editgroups.viewmodel

import com.shevelev.phrasalverbs.core.koin.KoinScopeClosable
import com.shevelev.phrasalverbs.core.ui.viewmodel.ViewModelBase
import com.shevelev.phrasalverbs.ui.navigation.NavigationGraph

internal class EditGroupsViewModelImpl(
    private val navigation: NavigationGraph,
    scopeClosable: KoinScopeClosable,
) : ViewModelBase(scopeClosable),
    EditGroupsViewModel {

    override fun onNextClick() {
        navigation.navigateToMainMenu()
    }
}
