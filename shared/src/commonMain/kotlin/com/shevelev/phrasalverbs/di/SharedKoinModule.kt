package com.shevelev.phrasalverbs.di

import com.shevelev.phrasalverbs.AppViewModel
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val SharedKoinModule = module {
    singleOf(::AppViewModel)
}
