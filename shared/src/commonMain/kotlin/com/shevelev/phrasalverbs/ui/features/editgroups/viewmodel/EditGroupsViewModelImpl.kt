package com.shevelev.phrasalverbs.ui.features.editgroups.viewmodel

import com.shevelev.phrasalverbs.ui.navigation.NavigationGraph
import com.shevelev.phrasalverbs.utils.koin.KoinScopeClosable
import com.shevelev.phrasalverbs.utils.ui.viewmodel.ViewModelBase

internal class EditGroupsViewModelImpl(
    private val navigation: NavigationGraph,
    scopeClosable: KoinScopeClosable,
) : ViewModelBase(scopeClosable),
    EditGroupsViewModel {

    override fun onNextClick() {
        navigation.navigateToMainMenu()
    }
}
