package com.shevelev.phrasalverbs.utils.koin

import org.koin.core.qualifier.named
import org.koin.mp.KoinPlatform.getKoin

inline fun <reified T : Any>getKoin() = getKoin().get<T>()

inline fun <reified T : Any>getKoin(scopeId: String, scopeName: String) =
    getKoin().getOrCreateScope(scopeId, named(scopeName)).get<T>()