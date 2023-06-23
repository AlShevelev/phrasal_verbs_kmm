package com.shevelev.phrasalverbs.data.repository.appstorage

import com.shevelev.phrasalverbs.domain.entities.Card
import com.shevelev.phrasalverbs.domain.entities.CardGroup

internal interface CardsRepository {
    /**
     * Returns all cards in random order
     */
    suspend fun getAllCards(): List<Card>

    /**
     * Saves a card in the storage
     */
    suspend fun createCard(card: Card)

    suspend fun getGroupsCount(): Int

    suspend fun createGroup(name: String, cards: List<Card>)

    suspend fun getAllGroups(): List<CardGroup>

    suspend fun getGroup(groupId: Long): CardGroup

    suspend fun getGroupBrief(groupId: Long): CardGroup

    suspend fun deleteGroup(groupId: Long)

    suspend fun updateGroup(groupId: Long, name: String, cards: List<Card>)
}
