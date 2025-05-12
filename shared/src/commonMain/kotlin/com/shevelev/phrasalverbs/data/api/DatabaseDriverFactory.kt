package com.shevelev.phrasalverbs.data.api

import app.cash.sqldelight.db.SqlDriver

internal expect class DatabaseDriverFactory {
    fun createAppStorageDriver(): SqlDriver
}