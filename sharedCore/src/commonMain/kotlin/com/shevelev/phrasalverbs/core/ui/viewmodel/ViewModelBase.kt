package com.shevelev.phrasalverbs.core.ui.viewmodel

import com.shevelev.phrasalverbs.core.koin.KoinScopeClosable

abstract class ViewModelBase(
    private val scopeClosable: KoinScopeClosable,
) : ViewModel {
    override val id = hashCode().toString()

    override fun closeScope() = scopeClosable.closeScope()
}
