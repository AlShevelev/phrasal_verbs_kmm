package com.shevelev.phrasalverbs.domain.entities

internal data class Card(
    val id: Long,
    val color: Color? = null,
    val side: Map<Language, CardSide>
)
