package com.shevelev.phrasalverbs.utils.koin

import org.koin.mp.KoinPlatform.getKoin

inline fun <reified T : Any>getKoin() = getKoin().get<T>()

inline fun <reified T : Any>getKoin(scope: KoinScopeDescriptor) =
    getKoin().getOrCreateScope(scope.id, scope.name).get<T>()

fun closeKoinScope(scope: KoinScopeDescriptor) =
    getKoin().getScopeOrNull(scope.id)?.takeIf { !it.closed }?.close()
