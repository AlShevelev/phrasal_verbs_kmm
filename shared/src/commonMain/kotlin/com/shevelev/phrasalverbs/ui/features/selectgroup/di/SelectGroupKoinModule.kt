package com.shevelev.phrasalverbs.ui.features.selectgroup.di

import com.shevelev.phrasalverbs.core.koin.KoinScopeClosable
import com.shevelev.phrasalverbs.core.koin.KoinScopeDescriptor
import com.shevelev.phrasalverbs.core.koin.closeKoinScope
import com.shevelev.phrasalverbs.ui.features.selectgroup.viewmodel.SelectGroupViewModel
import com.shevelev.phrasalverbs.ui.features.selectgroup.viewmodel.SelectGroupViewModelImpl
import org.koin.core.qualifier.StringQualifier
import org.koin.core.qualifier.named
import org.koin.dsl.module

internal object SelectGroupKoinScope : KoinScopeDescriptor {
    override val name: StringQualifier = named("SELECT_GROUP_SCOPE")
    override val id: String = "ffb36861-90cd-43a2-b22c-776d91225c48"
}

val SelectGroupKoinModule = module {
    scope(SelectGroupKoinScope.name) {
        scoped<SelectGroupViewModel> {
            SelectGroupViewModelImpl(
                navigation = get(),
                cardsRepository = get(),
                scopeClosable = object : KoinScopeClosable {
                    override fun closeScope() {
                        closeKoinScope(SelectGroupKoinScope)
                    }
                },
            )
        }
    }
}
