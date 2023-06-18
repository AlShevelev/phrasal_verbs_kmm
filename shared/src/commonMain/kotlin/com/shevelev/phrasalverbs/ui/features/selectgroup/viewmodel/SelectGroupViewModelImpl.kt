package com.shevelev.phrasalverbs.ui.features.selectgroup.viewmodel

import com.shevelev.phrasalverbs.core.koin.KoinScopeClosable
import com.shevelev.phrasalverbs.core.ui.viewmodel.ViewModelBase
import com.shevelev.phrasalverbs.data.repository.appstorage.CardsRepository
import com.shevelev.phrasalverbs.ui.navigation.NavigationGraph
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

internal class SelectGroupViewModelImpl(
    private val navigation: NavigationGraph,
    private val cardsRepository: CardsRepository,
    scopeClosable: KoinScopeClosable,
) : ViewModelBase(scopeClosable), SelectGroupViewModel {

    private val _state = MutableStateFlow<SelectGroupState>(SelectGroupState.Loading)
    override val state: StateFlow<SelectGroupState>
        get() = _state.asStateFlow()

    override fun onBackClick() {
        TODO("Not yet implemented")
    }

    override fun onNewGroupClick() {
        TODO("Not yet implemented")
    }

    override fun onGroupClick(groupId: Long) {
        TODO("Not yet implemented")
    }
}
