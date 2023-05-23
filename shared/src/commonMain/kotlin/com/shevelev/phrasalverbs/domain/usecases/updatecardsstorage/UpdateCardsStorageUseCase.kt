package com.shevelev.phrasalverbs.domain.usecases.updatecardsstorage

/**
 * This in an interface for create/update card's database logic
 */
internal interface UpdateCardsStorageUseCase {
    suspend fun updateCards()
}
