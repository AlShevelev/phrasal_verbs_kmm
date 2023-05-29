package com.shevelev.phrasalverbs.ui.features.watchallcards.di

import com.shevelev.phrasalverbs.core.koin.KoinScopeClosable
import com.shevelev.phrasalverbs.core.koin.KoinScopeDescriptor
import com.shevelev.phrasalverbs.core.koin.closeKoinScope
import com.shevelev.phrasalverbs.ui.features.watchallcards.viewmodel.WatchAllCardsViewModel
import com.shevelev.phrasalverbs.ui.features.watchallcards.viewmodel.WatchAllCardsViewModelImpl
import org.koin.core.qualifier.StringQualifier
import org.koin.core.qualifier.named
import org.koin.dsl.module

internal object WatchAllCardsKoinScope : KoinScopeDescriptor {
    override val name: StringQualifier = named("WATCH_ALL_CARDS_SCOPE")
    override val id: String = "899fcb9c-5ab0-4f63-9f68-0d52b2fff759"
}

val WatchAllCardsFeatureKoinModule = module {
    scope(WatchAllCardsKoinScope.name) {
        scoped<WatchAllCardsViewModel> {
            WatchAllCardsViewModelImpl(
                navigation = get(),
                cardsRepository = get(),
                keyValueStorageRepository = get(),
                scopeClosable = object : KoinScopeClosable {
                    override fun closeScope() {
                        closeKoinScope(WatchAllCardsKoinScope)
                    }
                },
            )
        }
    }
}
