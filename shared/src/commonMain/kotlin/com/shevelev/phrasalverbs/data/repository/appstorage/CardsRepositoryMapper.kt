package com.shevelev.phrasalverbs.data.repository.appstorage

import com.shevelev.phrasalverbs.domain.entities.ContentItemType
import com.shevelev.phrasalverbs.domain.entities.Language

internal interface CardsRepositoryMapper {
    fun booleanToDb(value: Boolean): Short

    fun booleanFromDb(value: Short?): Boolean

    fun contentItemTypeToDb(type: ContentItemType): Short

    fun contentItemTypeFromDb(type: Short?): ContentItemType?

    fun languageToDb(language: Language): Short

    fun languageFromDb(language: Short?): Language?
}
