package com.shevelev.phrasalverbs.domain.usecases.batchupdate

import com.shevelev.phrasalverbs.data.repository.appstorage.CardsRepository
import com.shevelev.phrasalverbs.data.repository.keyvaluestorage.KeyValueStorageRepository
import com.shevelev.phrasalverbs.domain.usecases.batchupdate.batches.SyncCardsBatch
import com.shevelev.phrasalverbs.domain.usecases.batchupdate.batches.SyncCardsVersion1Batch

internal class BatchCardsUpdateUseCaseImpl(
    private val keyValueStorageRepository: KeyValueStorageRepository,
    private val cardsRepository: CardsRepository,
) : BatchCardsUpdateUseCase {

    override suspend fun update() {
        val lastVersion = keyValueStorageRepository.getLastCardsBatchVersion()

        val batches = getBatchesList()

        val batchesToProcess = batches.filter { it.version > lastVersion }

        batchesToProcess.forEach { batch ->
            batch.update()

            keyValueStorageRepository.setLastCardsBatchVersion(batch.version)
        }
    }

    private fun getBatchesList(): List<SyncCardsBatch> =
        listOf(
            SyncCardsVersion1Batch(cardsRepository),
        )
}
