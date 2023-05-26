package com.shevelev.phrasalverbs.ui.features.mainmenu.di

import com.shevelev.phrasalverbs.core.koin.KoinScopeClosable
import com.shevelev.phrasalverbs.core.koin.KoinScopeDescriptor
import com.shevelev.phrasalverbs.core.koin.closeKoinScope
import com.shevelev.phrasalverbs.ui.features.mainmenu.viewmodel.MainMenuViewModel
import com.shevelev.phrasalverbs.ui.features.mainmenu.viewmodel.MainMenuViewModelImpl
import org.koin.core.qualifier.StringQualifier
import org.koin.core.qualifier.named
import org.koin.dsl.module

internal object MainMenuKoinScope : KoinScopeDescriptor {
    override val name: StringQualifier = named("MAIN_MENU_SCOPE")
    override val id: String = "4feea9bf-bd98-4af8-887e-00311f3a9417"
}

val MainMenuFeatureKoinModule = module {
    scope(MainMenuKoinScope.name) {
        scoped<MainMenuViewModel> {
            MainMenuViewModelImpl(
                navigation = get(),
                cardsRepository = get(),
                batchCardsUpdate = get(),
                scopeClosable = object : KoinScopeClosable {
                    override fun closeScope() {
                        closeKoinScope(MainMenuKoinScope)
                    }
                },
            )
        }
    }
}
