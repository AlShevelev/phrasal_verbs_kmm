package com.shevelev.phrasalverbs.domain.usecases.batchupdate

import com.shevelev.phrasalverbs.data.repository.appstorage.CardsRepository
import com.shevelev.phrasalverbs.data.repository.keyvaluestorage.KeyValueStorage
import com.shevelev.phrasalverbs.domain.usecases.batchupdate.batches.SyncCardsBatch
import com.shevelev.phrasalverbs.domain.usecases.batchupdate.batches.SyncCardsVersion1Batch

private const val LAST_CARDS_BATCH_VERSION = "LAST_CARDS_BATCH_VERSION"

internal class BatchCardsUpdateUseCaseImpl(
    private val keyValueStorage: KeyValueStorage,
    private val repository: CardsRepository,
) : BatchCardsUpdateUseCase {

    override suspend fun update() {
        val lastVersion = keyValueStorage.reader.getInt(LAST_CARDS_BATCH_VERSION) ?: 0

        val batches = getBatchesList()

        val batchesToProcess = batches.filter { it.version > lastVersion }

        batchesToProcess.forEach { batch ->
            batch.update()

            keyValueStorage.writer.update {
                it.setInt(LAST_CARDS_BATCH_VERSION, batch.version)
            }
        }
    }

    private fun getBatchesList(): List<SyncCardsBatch> =
        listOf(
            SyncCardsVersion1Batch(repository),
        )
}
