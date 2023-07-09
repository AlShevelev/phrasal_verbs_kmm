package com.shevelev.phrasalverbs.core.log

object Logger {
    fun e(ex: Throwable, tag: String? = null, message: String? = null) {
        print("${tag.orEmpty()}: ${message ?: ex.message.orEmpty()}")
    }

    fun d(tag: String? = null, message: String, ex: Throwable? = null) {
        print("${tag.orEmpty()}: $message: ${ex?.message.orEmpty()}")
    }
}
