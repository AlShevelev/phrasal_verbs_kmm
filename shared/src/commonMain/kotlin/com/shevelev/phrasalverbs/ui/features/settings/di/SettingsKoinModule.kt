package com.shevelev.phrasalverbs.ui.features.settings.di

import com.shevelev.phrasalverbs.core.koin.KoinScopeClosable
import com.shevelev.phrasalverbs.core.koin.KoinScopeDescriptor
import com.shevelev.phrasalverbs.core.koin.closeKoinScope
import com.shevelev.phrasalverbs.ui.features.settings.viewmodel.SettingsViewModel
import com.shevelev.phrasalverbs.ui.features.settings.viewmodel.SettingsViewModelImpl
import org.koin.core.qualifier.StringQualifier
import org.koin.core.qualifier.named
import org.koin.dsl.module

internal object SettingsKoinScope : KoinScopeDescriptor {
    override val name: StringQualifier = named("SETTINGS_SCOPE")
    override val id: String = "1230bec8-8211-41c9-b2b5-4b43183a2103"
}

val SettingsFeatureKoinModule = module {
    scope(SettingsKoinScope.name) {
        scoped<SettingsViewModel> {
            SettingsViewModelImpl(
                navigation = get(),
                scopeClosable = object : KoinScopeClosable {
                    override fun closeScope() {
                        closeKoinScope(SettingsKoinScope)
                    }
                },
            )
        }
    }
}
