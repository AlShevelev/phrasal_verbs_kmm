package com.shevelev.phrasalverbs.domain.entities

internal data class CardGroup(
    val id: Long,
    val name: String,
    val cards: List<Card> = emptyList()
)
