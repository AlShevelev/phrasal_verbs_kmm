package com.shevelev.phrasalverbs.data.di

import com.shevelev.phrasalverbs.data.api.DatabaseDriverFactory
import com.shevelev.phrasalverbs.data.repository.keyvaluestorage.KeyValueStorageFactory
import com.shevelev.phrasalverbs.data.repository.keyvaluestorage.KeyValueStorageFactoryImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import org.koin.dsl.module

val KeyValueStorageKoinModule = module {
    factory<KeyValueStorageFactory> {
        KeyValueStorageFactoryImpl(
            dbDriverFactory = get<DatabaseDriverFactory>(),
            ioDispatcher = Dispatchers.IO,
        )
    }
}
