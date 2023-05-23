package com.shevelev.phrasalverbs.utils.koin

import org.koin.core.qualifier.StringQualifier

internal interface KoinScopeDescriptor {
    val name: StringQualifier
    val id: String
}
