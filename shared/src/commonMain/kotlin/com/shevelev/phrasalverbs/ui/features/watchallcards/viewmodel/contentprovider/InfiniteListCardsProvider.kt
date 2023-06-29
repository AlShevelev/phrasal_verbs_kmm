package com.shevelev.phrasalverbs.ui.features.watchallcards.viewmodel.contentprovider

import com.shevelev.phrasalverbs.domain.entities.Card

internal class InfiniteListCardsProvider(
    cards: List<Card>,
) : CardsProvider(cards) {
    override val count: Int
        get() = Int.MAX_VALUE

    override fun getKey(index: Int): Long = index.toLong()

    override fun getItem(index: Int): Card = cards[index % cards.size]
}
