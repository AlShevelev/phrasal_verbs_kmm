package com.shevelev.phrasalverbs.data.repository.appstorage

import com.shevelev.phrasalverbs.domain.entities.ContentItemType
import com.shevelev.phrasalverbs.domain.entities.Language

internal class CardsRepositoryMapperImpl : CardsRepositoryMapper {
    override fun booleanToDb(value: Boolean): Short = if (value) 1 else 0

    override fun booleanFromDb(value: Short?): Boolean {
        return value == 1.toShort()
    }

    override fun contentItemTypeToDb(type: ContentItemType): Short =
        when (type) {
            ContentItemType.CLARIFICATION -> 0
            ContentItemType.MAIN -> 1
            ContentItemType.EXAMPLE -> 2
        }

    override fun contentItemTypeFromDb(type: Short?): ContentItemType? =
        type?.let {
            when (it.toInt()) {
                0 -> ContentItemType.CLARIFICATION
                1 -> ContentItemType.MAIN
                2 -> ContentItemType.EXAMPLE
                else -> null
            }
        }

    override fun languageToDb(language: Language): Short =
        when (language) {
            Language.RUSSIAN -> 0
            Language.ENGLISH -> 1
        }

    override fun languageFromDb(language: Short?): Language? =
        language?.let {
            when (it.toInt()) {
                0 -> Language.RUSSIAN
                1 -> Language.ENGLISH
                else -> null
            }
        }
}
