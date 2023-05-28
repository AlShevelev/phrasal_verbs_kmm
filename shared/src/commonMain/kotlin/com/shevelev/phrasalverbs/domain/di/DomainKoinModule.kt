package com.shevelev.phrasalverbs.domain.di

import com.shevelev.phrasalverbs.domain.usecases.batchupdate.BatchCardsUpdateUseCase
import com.shevelev.phrasalverbs.domain.usecases.batchupdate.BatchCardsUpdateUseCaseImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

val DomainKoinModule = module {
    factoryOf(::BatchCardsUpdateUseCaseImpl) bind BatchCardsUpdateUseCase::class
}
