package com.shevelev.phrasalverbs.data.di

import com.shevelev.phrasalverbs.data.api.DatabaseDriverFactory
import org.koin.dsl.module

val DatabaseDriverKoinModuleIos = module {
    factory {
        DatabaseDriverFactory()
    }
}
