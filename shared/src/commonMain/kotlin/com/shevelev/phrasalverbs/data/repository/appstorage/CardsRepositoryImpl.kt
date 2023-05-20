package com.shevelev.phrasalverbs.data.repository.appstorage

import com.shevelev.phrasalverbs.data.api.appstorage.AppStorageDatabase
import com.shevelev.phrasalverbs.data.api.appstorage.Card_side
import com.shevelev.phrasalverbs.data.api.appstorage.Card_side_content_item
import com.shevelev.phrasalverbs.domain.entities.Card
import com.shevelev.phrasalverbs.domain.entities.CardContentItem
import com.shevelev.phrasalverbs.domain.entities.CardSide
import com.shevelev.phrasalverbs.domain.entities.ContentItemType
import com.shevelev.phrasalverbs.domain.entities.Language
import com.shevelev.phrasalverbs.utils.idgenerator.IdGenerator
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class CardsRepositoryImpl(
    private val appStorageDatabase: AppStorageDatabase,
    private val ioDispatcher: CoroutineDispatcher,
    private val mapper: CardsRepositoryMapper,
) : CardsRepository {

    private val queries by lazy { appStorageDatabase.appStorageQueries }

    /**
     * Returns all cards in random order
     */
    override suspend fun getAllCards(): List<Card> = withContext(ioDispatcher) {
        val cards = queries
            .readAllCards()
            .executeAsList()

        cards.map { dbCard ->
            val dbCardSides = queries
                .readCardSide(dbCard.card_id)
                .executeAsList()

            Card(
                id = dbCard.card_id,
                color = mapper.colorFromDb(dbCard.color),
                side = mapOf(
                    Language.RUSSIAN to dbCardSides.mapFromDb(Language.RUSSIAN),
                    Language.ENGLISH to dbCardSides.mapFromDb(Language.ENGLISH),
                ),
            )
        }
    }

    private fun List<Card_side>.mapFromDb(language: Language): CardSide {
        val dbSide = this.single { it.language_code == mapper.languageToDb(language) }

        val dbSideItems = queries
            .readCardSideContentItems(dbSide.card_side_id)
            .executeAsList()

        return CardSide(
            clarification = dbSideItems
                .firstOrNull { it.type == mapper.contentItemTypeToDb(ContentItemType.CLARIFICATION) }
                ?.mapFromDb(),

            mainItems = dbSideItems
                .filter { it.type == mapper.contentItemTypeToDb(ContentItemType.MAIN) }
                .sortedBy { it.sort_order }
                .map { it.mapFromDb() },

            examples = dbSideItems
                .filter { it.type == mapper.contentItemTypeToDb(ContentItemType.EXAMPLE) }
                .sortedBy { it.sort_order }
                .map { it.mapFromDb() },
        )
    }

    private fun Card_side_content_item.mapFromDb(): CardContentItem =
        CardContentItem(
            value = value_,
            valueVoicing = value_voicing,
            description = description,
        )

    /**
     * Saves a card in the storage
     */
    override suspend fun createCard(card: Card) = withContext(ioDispatcher) {
        queries.transaction {
            val cardId = IdGenerator.newId()
            queries.createCard(cardId, mapper.colorToDb(card.color))

            Language.ENGLISH.let { createCardSide(it, cardId, card.side[it]) }
            Language.RUSSIAN.let { createCardSide(it, cardId, card.side[it]) }
        }
    }

    private fun createCardSide(language: Language, cardId: Long, cardSide: CardSide?) {
        if (cardSide != null) {
            val cardSideId = IdGenerator.newId()

            queries.createCardSide(cardSideId, cardId, mapper.languageToDb(language))

            createCardContentItem(ContentItemType.CLARIFICATION, cardSideId, cardSide.clarification, 0)

            cardSide.mainItems.forEachIndexed { index, item ->
                createCardContentItem(ContentItemType.MAIN, cardSideId, item, index)
            }

            cardSide.examples.forEachIndexed { index, item ->
                createCardContentItem(ContentItemType.EXAMPLE, cardSideId, item, index)
            }
        }
    }

    private fun createCardContentItem(
        type: ContentItemType,
        cardSideId: Long,
        contentItem: CardContentItem?,
        sortOrder: Int,
    ) {
        if (contentItem != null) {
            val itemId = IdGenerator.newId()

            queries.createCardSideContentItem(
                itemId,
                cardSideId,
                mapper.contentItemTypeToDb(type),
                contentItem.value,
                contentItem.valueVoicing,
                contentItem.description,
                sortOrder.toShort(),
            )
        }
    }
}
