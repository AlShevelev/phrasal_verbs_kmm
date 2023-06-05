package com.shevelev.phrasalverbs.ui.features.editgroups.viewmodel.data

import com.shevelev.phrasalverbs.domain.entities.Card

internal sealed class CardsListItem(
    val id: Long,
) {
    data class CardItem(
        val card: Card,
    ) : CardsListItem(card.id)

    data class SeparatorItem(
        private val itemId: Long,
        val selected: Boolean,
    ) : CardsListItem(itemId)
}
