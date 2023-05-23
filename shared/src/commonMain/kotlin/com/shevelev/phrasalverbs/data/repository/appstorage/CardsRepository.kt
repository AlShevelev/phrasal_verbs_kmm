package com.shevelev.phrasalverbs.data.repository.appstorage

import com.shevelev.phrasalverbs.domain.entities.Card

internal interface CardsRepository {
    /**
     * Returns all cards in random order
     */
    suspend fun getAllCards(): List<Card>

    /**
     * Saves a card in the storage
     */
    suspend fun createCard(card: Card)
}
