package com.shevelev.phrasalverbs.utils.koin

import org.koin.core.qualifier.StringQualifier

interface KoinScopeDescriptor {
    val name: StringQualifier
    val id: String
}
