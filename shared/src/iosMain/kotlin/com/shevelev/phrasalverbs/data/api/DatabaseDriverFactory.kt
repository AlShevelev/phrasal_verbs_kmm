package com.shevelev.phrasalverbs.data.api

import app.cash.sqldelight.db.SqlDriver
import com.shevelev.phrasalverbs.data.api.appstorage.AppStorageDatabase

internal actual class DatabaseDriverFactory {
    actual fun createAppStorageDriver(): SqlDriver {
        return NativeSqliteDriver(AppStorageDatabase.Schema, "app_storage.db")
    }
}