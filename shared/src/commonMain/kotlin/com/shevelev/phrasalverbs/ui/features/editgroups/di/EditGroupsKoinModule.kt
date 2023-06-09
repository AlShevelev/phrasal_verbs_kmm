package com.shevelev.phrasalverbs.ui.features.editgroups.di

import com.shevelev.phrasalverbs.core.koin.KoinScopeClosable
import com.shevelev.phrasalverbs.core.koin.KoinScopeDescriptor
import com.shevelev.phrasalverbs.core.koin.closeKoinScope
import com.shevelev.phrasalverbs.ui.features.editgroups.domain.CardListsLogicFacade
import com.shevelev.phrasalverbs.ui.features.editgroups.domain.CreateCardListsLogicFacade
import com.shevelev.phrasalverbs.ui.features.editgroups.viewmodel.EditGroupsViewModel
import com.shevelev.phrasalverbs.ui.features.editgroups.viewmodel.EditGroupsViewModelImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.core.qualifier.StringQualifier
import org.koin.core.qualifier.named
import org.koin.dsl.bind
import org.koin.dsl.module

internal object EditGroupsKoinScope : KoinScopeDescriptor {
    override val name: StringQualifier = named("EDIT_GROUPS_SCOPE")
    override val id: String = "7fbab1ca-9300-47a0-85d4-371f6b26b8d5"
}

val EditGroupsFeatureKoinModule = module {
    scope(EditGroupsKoinScope.name) {
        scoped<EditGroupsViewModel> {
            EditGroupsViewModelImpl(
                navigation = get(),
                cardsRepository = get(),
                scopeClosable = object : KoinScopeClosable {
                    override fun closeScope() {
                        closeKoinScope(EditGroupsKoinScope)
                    }
                },
            )
        }
    }

    factoryOf(::CreateCardListsLogicFacade) bind CardListsLogicFacade::class
}
