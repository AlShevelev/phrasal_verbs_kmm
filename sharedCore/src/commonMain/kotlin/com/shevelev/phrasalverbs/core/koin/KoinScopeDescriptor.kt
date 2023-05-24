package com.shevelev.phrasalverbs.core.koin

import org.koin.core.qualifier.StringQualifier

interface KoinScopeDescriptor {
    val name: StringQualifier
    val id: String
}
