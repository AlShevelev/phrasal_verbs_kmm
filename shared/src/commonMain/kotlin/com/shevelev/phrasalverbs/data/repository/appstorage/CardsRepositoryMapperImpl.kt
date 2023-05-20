package com.shevelev.phrasalverbs.data.repository.appstorage

import com.shevelev.phrasalverbs.domain.entities.Color
import com.shevelev.phrasalverbs.domain.entities.ContentItemType
import com.shevelev.phrasalverbs.domain.entities.Language

internal class CardsRepositoryMapperImpl : CardsRepositoryMapper {
    override fun colorToDb(color: Color?): Short? =
        color?.let {
            when (it) {
                Color.RED -> 0
                Color.GREEN -> 1
                Color.BLUE -> 2
                Color.YELLOW -> 3
                Color.GRAY -> 4
                Color.BROWN -> 5
            }
        }

    override fun colorFromDb(color: Short?): Color? =
        color?.let {
            when (it.toInt()) {
                0 -> Color.RED
                1 -> Color.GREEN
                2 -> Color.BLUE
                3 -> Color.YELLOW
                4 -> Color.GRAY
                5 -> Color.BROWN
                else -> null
            }
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
