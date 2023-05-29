package com.shevelev.phrasalverbs.domain.entities

internal data class Card(
    val id: Long,
    val isLearnt: Boolean,
    val side: Map<Language, CardSide>,
)
