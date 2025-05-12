package com.shevelev.phrasalverbs.data.repository.appstorage

import com.shevelev.phrasalverbs.domain.entities.ContentItemType
import com.shevelev.phrasalverbs.domain.entities.Language

internal interface CardsRepositoryMapper {
    fun booleanToDb(value: Boolean): Long

    fun booleanFromDb(value: Long?): Boolean

    fun contentItemTypeToDb(type: ContentItemType): Long

    fun contentItemTypeFromDb(type: Long?): ContentItemType?

    fun languageToDb(language: Language): Long

    fun languageFromDb(language: Long?): Language?
}
