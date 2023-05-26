package com.shevelev.phrasalverbs.domain.usecases.batchupdate.batches

internal interface SyncCardsBatch {
    val version: Int

    suspend fun update()
}
