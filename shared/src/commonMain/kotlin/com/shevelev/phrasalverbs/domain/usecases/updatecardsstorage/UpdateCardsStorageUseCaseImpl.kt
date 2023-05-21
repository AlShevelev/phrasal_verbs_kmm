package com.shevelev.phrasalverbs.domain.usecases.updatecardsstorage

import com.shevelev.phrasalverbs.domain.usecases.updatecardsstorage.batches.SyncCardsVersion1Batch
import com.shevelev.phrasalverbs.data.repository.appstorage.CardsRepository
import com.shevelev.phrasalverbs.data.repository.keyvaluestorage.KeyValueStorage
import com.shevelev.phrasalverbs.domain.usecases.updatecardsstorage.batches.SyncCardsBatch

private const val LAST_CARDS_BATCH_VERSION = "LAST_CARDS_BATCH_VERSION"

/**
 * This in a logic for create/update card's database
 */
class UpdateCardsStorageUseCaseImpl(
    private val keyValueStorage: KeyValueStorage,
    private val repository: CardsRepository,
) : UpdateCardsStorageUseCase {

    private val batches: List<SyncCardsBatch> by lazy {
        listOf(
            SyncCardsVersion1Batch(repository),
        )
    }

    override suspend fun updateCards() {
        val lastVersion = keyValueStorage.reader.getInt(LAST_CARDS_BATCH_VERSION) ?: 0

        val batchesToProcess = batches.filter { it.version > lastVersion }

        batchesToProcess.forEach { batch ->
            batch.update()

            keyValueStorage.writer.update {
                it.setInt(LAST_CARDS_BATCH_VERSION, batch.version)
            }
        }
    }
}
