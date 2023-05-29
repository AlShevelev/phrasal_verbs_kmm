package com.shevelev.phrasalverbs.domain.entities

internal data class CardContentItem(
    val value: String,
    val valueVoicing: String? = null,
    val description: String? = null,
)
