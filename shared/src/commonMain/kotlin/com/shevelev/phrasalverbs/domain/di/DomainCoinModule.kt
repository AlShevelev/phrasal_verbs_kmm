package com.shevelev.phrasalverbs.domain.di

import com.shevelev.phrasalverbs.data.repository.keyvaluestorage.KeyValueStorageFactory
import com.shevelev.phrasalverbs.domain.usecases.batchupdate.BatchCardsUpdateUseCase
import com.shevelev.phrasalverbs.domain.usecases.batchupdate.BatchCardsUpdateUseCaseImpl
import org.koin.dsl.module

private const val BATCH_CARDS_UPDATE_KEY_VALUE_STORAGE = "BatchCardsUpdateKeyValueStorage"

val DomainCoinModule = module {
    factory<BatchCardsUpdateUseCase> {
        BatchCardsUpdateUseCaseImpl(
            keyValueStorage = get<KeyValueStorageFactory>()[BATCH_CARDS_UPDATE_KEY_VALUE_STORAGE],
            repository = get(),
        )
    }
}
