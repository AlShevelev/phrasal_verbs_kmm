package com.shevelev.phrasalverbs.core.ui.popup

import kotlin.random.Random

class MessagePopupData private constructor(
    val key: Long,
    val text: String,
) {
    constructor(text: String) : this(Random.nextLong(), text)

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false

        other as MessagePopupData

        if (key != other.key) return false
        if (text != other.text) return false

        return true
    }

    override fun hashCode(): Int {
        var result = key.hashCode()
        result = 31 * result + text.hashCode()
        return result
    }
}
