package com.shevelev.phrasalverbs.data.di

import com.shevelev.phrasalverbs.data.api.DatabaseDriverFactory
import org.koin.dsl.module

val DatabaseDriverKoinModuleAndroid = module {
    factory {
        DatabaseDriverFactory(
            context = get(),
        )
    }
}
