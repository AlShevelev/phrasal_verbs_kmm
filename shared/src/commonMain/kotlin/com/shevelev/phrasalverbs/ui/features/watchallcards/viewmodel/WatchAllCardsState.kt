package com.shevelev.phrasalverbs.ui.features.watchallcards.viewmodel

import com.shevelev.phrasalverbs.domain.entities.Card

internal sealed interface WatchAllCardsState {
    object Loading : WatchAllCardsState

    data class Content(
        val isRussianSideDefault: Boolean,
        val cards: List<Card>,
    ) : WatchAllCardsState
}
