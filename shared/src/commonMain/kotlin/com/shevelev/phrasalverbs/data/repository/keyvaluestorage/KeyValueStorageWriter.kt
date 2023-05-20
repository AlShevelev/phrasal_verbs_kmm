package com.shevelev.phrasalverbs.data.repository.keyvaluestorage

/**
 * An interface for updating data in a key-value storage
 */
interface KeyValueStorageWriter {
    /**
     * Executes writing operations inside [updateAction] block with reading data opportunity
     */
    suspend fun updateWithRead(
        updateAction: suspend (KeyValueStorageReader, KeyValueStorageWriteOperations) -> Unit,
    )

    /**
     * Executes writing operations inside [updateAction] block
     */
    suspend fun update(updateAction: suspend (KeyValueStorageWriteOperations) -> Unit)
}
