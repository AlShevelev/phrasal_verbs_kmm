package com.shevelev.phrasalverbs.data.api

import com.shevelev.phrasalverbs.data.api.appstorage.AppStorageDatabase
import com.shevelev.phrasalverbs.data.api.keyvaluestorage.KeyValueStorageDatabase
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver

actual class DatabaseDriverFactory {
    actual fun createKeyValueStorageDriver(): SqlDriver {
        return NativeSqliteDriver(KeyValueStorageDatabase.Schema, "key_value_storage.db")
    }

    actual fun createAppStorageDriver(): SqlDriver {
        return NativeSqliteDriver(AppStorageDatabase.Schema, "app_storage.db")
    }
}