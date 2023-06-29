package com.shevelev.phrasalverbs.ui.features.watchallcards.viewmodel.contentprovider

import com.shevelev.phrasalverbs.domain.entities.Card

internal abstract class CardsProvider(
    cards: List<Card>,
) {
    protected val cards = cards.toMutableList()

    abstract val count: Int

    abstract fun getKey(index: Int): Long

    abstract fun getItem(index: Int): Card

    fun updateIsLearnt(cardId: Long, isLearnt: Boolean) {
        val index = cards.indexOfFirst { it.id == cardId }

        if (index != -1) {
            cards[index] = cards[index].copy(isLearnt = isLearnt)
        }
    }
}
