package com.shevelev.phrasalverbs.core.log

import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier

object Logger {
    fun init() {
        Napier.base(DebugAntilog())
    }

    fun e(ex: Throwable, tag: String? = null, message: String? = null) {
        Napier.e(message ?: ex.message.orEmpty(), ex, tag)
    }

    fun d(tag: String? = null, message: String, ex: Throwable? = null) {
        Napier.d(message, ex, tag)
    }
}
