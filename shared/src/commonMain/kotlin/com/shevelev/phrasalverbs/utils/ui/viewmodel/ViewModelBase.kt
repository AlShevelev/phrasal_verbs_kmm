package com.shevelev.phrasalverbs.utils.ui.viewmodel

import com.shevelev.phrasalverbs.utils.koin.KoinScopeClosable

abstract class ViewModelBase(
    private val scopeClosable: KoinScopeClosable,
) : ViewModel {
    override val id = hashCode().toString()

    override fun closeScope() = scopeClosable.closeScope()
}
