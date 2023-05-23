package com.shevelev.phrasalverbs.ui.features.editgroups.di

import com.shevelev.phrasalverbs.ui.features.editgroups.viewmodel.EditGroupsViewModel
import com.shevelev.phrasalverbs.ui.features.editgroups.viewmodel.EditGroupsViewModelImpl
import com.shevelev.phrasalverbs.utils.koin.KoinScopeClosable
import com.shevelev.phrasalverbs.utils.koin.KoinScopeDescriptor
import com.shevelev.phrasalverbs.utils.koin.closeKoinScope
import org.koin.core.qualifier.StringQualifier
import org.koin.core.qualifier.named
import org.koin.dsl.module

object EditGroupsKoinScope : KoinScopeDescriptor {
    override val name: StringQualifier = named("EDIT_GROUPS_SCOPE")
    override val id: String = "7fbab1ca-9300-47a0-85d4-371f6b26b8d5"
}

val EditGroupsKoinModule = module {
    scope(EditGroupsKoinScope.name) {
        scoped<EditGroupsViewModel> {
            EditGroupsViewModelImpl(
                navigation = get(),
                scopeClosable = object : KoinScopeClosable {
                    override fun closeScope() {
                        closeKoinScope(EditGroupsKoinScope)
                    }
                },
            )
        }
    }
}
