package com.shevelev.phrasalverbs.ui.features.watchallcards.viewmodel

import com.shevelev.phrasalverbs.ui.features.watchallcards.viewmodel.contentprovider.CardsProvider

internal sealed interface WatchAllCardsState {
    object Loading : WatchAllCardsState

    data class Content(
        val isRussianSideDefault: Boolean,
        val cardsProvider: CardsProvider,
    ) : WatchAllCardsState
}
