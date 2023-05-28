package com.shevelev.phrasalverbs.data.di

import com.shevelev.phrasalverbs.data.repository.keyvaluestorage.KeyValueStorageRepository
import com.shevelev.phrasalverbs.data.repository.keyvaluestorage.KeyValueStorageRepositoryImpl
import com.shevelev.phrasalverbs.data.repository.keyvaluestorage.storage.KeyValueStorage
import com.shevelev.phrasalverbs.data.repository.keyvaluestorage.storage.KeyValueStorageFactory
import com.shevelev.phrasalverbs.data.repository.keyvaluestorage.storage.KeyValueStorageFactoryImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

private const val GENERAL_KEY_VALUE_STORAGE = "GENERAL_KEY_VALUE_STORAGE"

val KeyValueStorageKoinModule = module {
    factory<KeyValueStorageFactory> {
        KeyValueStorageFactoryImpl(
            dbDriverFactory = get(),
            ioDispatcher = Dispatchers.IO,
        )
    }

    single<KeyValueStorage> {
        get<KeyValueStorageFactory>()[GENERAL_KEY_VALUE_STORAGE]
    }

    factoryOf(::KeyValueStorageRepositoryImpl) bind KeyValueStorageRepository::class
}
