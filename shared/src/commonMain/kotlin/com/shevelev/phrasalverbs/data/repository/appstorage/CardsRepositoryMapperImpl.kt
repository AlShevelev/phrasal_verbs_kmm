package com.shevelev.phrasalverbs.data.repository.appstorage

import com.shevelev.phrasalverbs.domain.entities.ContentItemType
import com.shevelev.phrasalverbs.domain.entities.Language

internal class CardsRepositoryMapperImpl : CardsRepositoryMapper {
    override fun booleanToDb(value: Boolean): Long = if (value) 1 else 0

    override fun booleanFromDb(value: Long?): Boolean {
        return value == 1L
    }

    override fun contentItemTypeToDb(type: ContentItemType): Long =
        when (type) {
            ContentItemType.CLARIFICATION -> 0L
            ContentItemType.MAIN -> 1L
            ContentItemType.EXAMPLE -> 2L
        }

    override fun contentItemTypeFromDb(type: Long?): ContentItemType? =
        type?.let {
            when (it.toInt()) {
                0 -> ContentItemType.CLARIFICATION
                1 -> ContentItemType.MAIN
                2 -> ContentItemType.EXAMPLE
                else -> null
            }
        }

    override fun languageToDb(language: Language): Long =
        when (language) {
            Language.RUSSIAN -> 0L
            Language.ENGLISH -> 1L
        }

    override fun languageFromDb(language: Long?): Language? =
        language?.let {
            when (it.toInt()) {
                0 -> Language.RUSSIAN
                1 -> Language.ENGLISH
                else -> null
            }
        }
}
