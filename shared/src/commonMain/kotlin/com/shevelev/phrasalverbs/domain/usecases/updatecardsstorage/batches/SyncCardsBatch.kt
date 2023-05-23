package com.shevelev.phrasalverbs.domain.usecases.updatecardsstorage.batches

/**
 * This is an interface for one batch of creating/updating maps
 */
internal interface SyncCardsBatch {
    val version: Int

    suspend fun update()
}
