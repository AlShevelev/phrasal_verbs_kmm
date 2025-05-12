package com.shevelev.phrasalverbs.data.api

import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.shevelev.phrasalverbs.data.api.appstorage.AppStorageDatabase

internal actual class DatabaseDriverFactory(private val context: Context) {
    actual fun createAppStorageDriver(): SqlDriver {
        return AndroidSqliteDriver(AppStorageDatabase.Schema, context, "app_storage.db")
    }
}
