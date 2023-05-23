package com.shevelev.phrasalverbs.data.api

import com.squareup.sqldelight.db.SqlDriver

internal expect class DatabaseDriverFactory {
    fun createKeyValueStorageDriver(): SqlDriver

    fun createAppStorageDriver(): SqlDriver
}