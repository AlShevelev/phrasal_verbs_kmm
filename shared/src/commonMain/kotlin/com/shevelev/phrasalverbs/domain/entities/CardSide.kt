package com.shevelev.phrasalverbs.domain.entities

internal data class CardSide(
    val clarification: CardContentItem? = null,
    val mainItems: List<CardContentItem>,
    val examples: List<CardContentItem>
)
