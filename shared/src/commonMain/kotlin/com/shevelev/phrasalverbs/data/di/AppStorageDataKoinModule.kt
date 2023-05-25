package com.shevelev.phrasalverbs.data.di

import com.shevelev.phrasalverbs.data.api.DatabaseDriverFactory
import com.shevelev.phrasalverbs.data.api.appstorage.AppStorageDatabase
import com.shevelev.phrasalverbs.data.repository.appstorage.CardsRepository
import com.shevelev.phrasalverbs.data.repository.appstorage.CardsRepositoryImpl
import com.shevelev.phrasalverbs.data.repository.appstorage.CardsRepositoryMapper
import com.shevelev.phrasalverbs.data.repository.appstorage.CardsRepositoryMapperImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val AppStorageDataKoinModule = module {
    single {
        AppStorageDatabase(
            driver = get<DatabaseDriverFactory>().createAppStorageDriver(),
        )
    }

    factoryOf<CardsRepositoryMapper>(::CardsRepositoryMapperImpl)

    single<CardsRepository> {
        CardsRepositoryImpl(
            appStorageDatabase = get(),
            ioDispatcher = Dispatchers.IO,
            mapper = get(),
        )
    }
}
