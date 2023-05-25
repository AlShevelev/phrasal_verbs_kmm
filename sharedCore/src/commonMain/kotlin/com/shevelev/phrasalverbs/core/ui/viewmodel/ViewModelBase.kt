package com.shevelev.phrasalverbs.core.ui.viewmodel

import com.shevelev.phrasalverbs.core.koin.KoinScopeClosable
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob

abstract class ViewModelBase(
    private val scopeClosable: KoinScopeClosable,
) : ViewModel {
    private val viewModelJob = SupervisorJob()

    protected val viewModelScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    override fun close() {
        viewModelJob.cancel()
        scopeClosable.closeScope()
    }
}
