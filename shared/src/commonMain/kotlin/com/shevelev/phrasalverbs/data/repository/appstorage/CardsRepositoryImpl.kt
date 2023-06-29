package com.shevelev.phrasalverbs.data.repository.appstorage

import com.shevelev.phrasalverbs.core.idgenerator.IdGenerator
import com.shevelev.phrasalverbs.core.innerJoin
import com.shevelev.phrasalverbs.data.api.appstorage.AppStorageDatabase
import com.shevelev.phrasalverbs.data.api.appstorage.Card_side
import com.shevelev.phrasalverbs.data.api.appstorage.Card_side_content_item
import com.shevelev.phrasalverbs.domain.entities.Card
import com.shevelev.phrasalverbs.domain.entities.CardContentItem
import com.shevelev.phrasalverbs.domain.entities.CardGroup
import com.shevelev.phrasalverbs.domain.entities.CardSide
import com.shevelev.phrasalverbs.domain.entities.ContentItemType
import com.shevelev.phrasalverbs.domain.entities.Language
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

internal class CardsRepositoryImpl(
    private val appStorageDatabase: AppStorageDatabase,
    private val ioDispatcher: CoroutineDispatcher,
    private val mapper: CardsRepositoryMapper,
) : CardsRepository {

    private val queries by lazy { appStorageDatabase.appStorageQueries }

    /**
     * Returns all cards in random order
     */
    override suspend fun getAllCards(): List<Card> = withContext(ioDispatcher) {
        getAllCardsInternal()
    }

    /**
     * Saves a card in the storage
     */
    override suspend fun createCard(card: Card) = withContext(ioDispatcher) {
        queries.transaction {
            val cardId = card.id
            queries.createCard(cardId, mapper.booleanToDb(card.isLearnt))

            Language.ENGLISH.let { createCardSide(it, cardId, card.side[it]) }
            Language.RUSSIAN.let { createCardSide(it, cardId, card.side[it]) }
        }
    }

    override suspend fun getGroupsCount(): Int = withContext(ioDispatcher) {
        queries
            .readAllBunches()
            .executeAsList()
            .size
    }

    override suspend fun createGroup(name: String, cards: List<Card>) =
        withContext(ioDispatcher) {
            queries.transaction {
                createGroupInternal(null, name, cards)
            }
        }

    override suspend fun getAllGroups(): List<CardGroup> = withContext(ioDispatcher) {
        queries
            .readAllBunches()
            .executeAsList()
            .map { CardGroup(it.bunch_id, it.title) }
    }

    override suspend fun getGroup(groupId: Long): CardGroup = withContext(ioDispatcher) {
        queries.transactionWithResult {
            val group = queries.readBunch(groupId).executeAsOne()

            val cardGroupLink = queries
                .readCardBunch(groupId)
                .executeAsList()
                .sortedBy { it.sort_order }

            val allCards = getAllCardsInternal()

            val cards = cardGroupLink
                .innerJoin(allCards) { g, c -> g.card_id == c.id }
                .map { it.second }

            CardGroup(
                id = groupId,
                name = group.title,
                cards = cards,
            )
        }
    }

    override suspend fun getGroupBrief(groupId: Long): CardGroup = withContext(ioDispatcher) {
        val group = queries.readBunch(groupId).executeAsOne()

        CardGroup(
            id = groupId,
            name = group.title,
        )
    }

    override suspend fun deleteGroup(groupId: Long) = withContext(ioDispatcher) {
        queries.transaction {
            deleteGroupInternal(groupId)
        }
    }

    override suspend fun updateGroup(groupId: Long, name: String, cards: List<Card>) =
        withContext(ioDispatcher) {
            queries.transaction {
                deleteGroupInternal(groupId)
                createGroupInternal(groupId, name, cards)
            }
        }

    override suspend fun updateIsLearnt(cardId: Long, isLearnt: Boolean) =
        withContext(ioDispatcher) {
            queries.updateCardColor(mapper.booleanToDb(isLearnt), cardId)
        }

    /**
     * Returns all cards in random order
     */
    private fun getAllCardsInternal(): List<Card> {
        val cards = queries
            .readAllCards()
            .executeAsList()
            .sortedBy { it.card_id }

        return cards.map { dbCard ->
            val dbCardSides = queries
                .readCardSide(dbCard.card_id)
                .executeAsList()

            Card(
                id = dbCard.card_id,
                isLearnt = mapper.booleanFromDb(dbCard.is_learnt),
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

    private fun createGroupInternal(groupId: Long?, name: String, cards: List<Card>) {
        val dbGroupId = groupId ?: IdGenerator.newId()
        queries.createBunch(dbGroupId, name)

        cards.forEachIndexed { index, card ->
            queries.createCardBunch(
                card.id,
                dbGroupId,
                index.toShort(),
            )
        }
    }

    private fun deleteGroupInternal(groupId: Long) {
        queries.deleteCardBunch(groupId)
        queries.deleteBunch(groupId)
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
