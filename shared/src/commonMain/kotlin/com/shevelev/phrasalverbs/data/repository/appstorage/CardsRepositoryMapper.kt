package com.shevelev.phrasalverbs.data.repository.appstorage

import com.shevelev.phrasalverbs.domain.entities.Color
import com.shevelev.phrasalverbs.domain.entities.ContentItemType
import com.shevelev.phrasalverbs.domain.entities.Language

interface CardsRepositoryMapper {
    fun colorToDb(color: Color?): Short?

    fun colorFromDb(color: Short?): Color?

    fun contentItemTypeToDb(type: ContentItemType): Short

    fun contentItemTypeFromDb(type: Short?): ContentItemType?

    fun languageToDb(language: Language): Short

    fun languageFromDb(language: Short?): Language?
}
