package com.shevelev.phrasalverbs.domain.entities

data class CardContentItem(
    val value: String,
    val valueVoicing: String? = null,
    val description: String? = null
)
