package com.shevelev.phrasalverbs.ui.navigation.di

import com.shevelev.phrasalverbs.ui.navigation.NavigationGraph
import com.shevelev.phrasalverbs.ui.navigation.NavigationGraphImpl
import org.koin.dsl.module

val NavigationKoinModule = module {
    single<NavigationGraph> {
        NavigationGraphImpl()
    }
}
