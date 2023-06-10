package com.shevelev.phrasalverbs.ui.features.editgroups.domain.entities

import com.shevelev.phrasalverbs.domain.entities.Card

internal sealed interface CardsListItem {
    val id: Long

    data class CardItem(
        val card: Card,
    ) : CardsListItem {
        override val id: Long
            get() = card.id
    }

    class SeparatorItem(
        override val id: Long,
    ) : CardsListItem
}
