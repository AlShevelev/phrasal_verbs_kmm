package com.shevelev.phrasalverbs.data.api

import android.content.Context
import com.shevelev.phrasalverbs.data.api.appstorage.AppStorageDatabase
import com.shevelev.phrasalverbs.data.api.keyvaluestorage.KeyValueStorageDatabase
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver

actual class DatabaseDriverFactory(private val context: Context) {
    actual fun createKeyValueStorageDriver(): SqlDriver {
        return AndroidSqliteDriver(KeyValueStorageDatabase.Schema, context, "key_value_storage.db")
    }

    actual fun createAppStorageDriver(): SqlDriver {
        return AndroidSqliteDriver(AppStorageDatabase.Schema, context, "app_storage.db")
    }
}