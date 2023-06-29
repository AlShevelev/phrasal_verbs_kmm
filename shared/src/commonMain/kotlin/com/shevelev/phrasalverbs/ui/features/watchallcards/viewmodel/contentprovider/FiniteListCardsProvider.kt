package com.shevelev.phrasalverbs.ui.features.watchallcards.viewmodel.contentprovider

import com.shevelev.phrasalverbs.domain.entities.Card

internal class FiniteListCardsProvider(
    cards: List<Card>
) : CardsProvider(cards) {

    override val count: Int
        get() = cards.size

    override fun getKey(index: Int): Long = cards[index].id

    override fun getItem(index: Int): Card = cards[index]
}
