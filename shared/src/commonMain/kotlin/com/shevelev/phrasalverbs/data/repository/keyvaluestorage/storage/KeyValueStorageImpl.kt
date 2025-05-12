package com.shevelev.phrasalverbs.data.repository.keyvaluestorage.storage

import com.shevelev.phrasalverbs.data.api.DatabaseDriverFactory
import com.shevelev.phrasalverbs.data.api.appstorage.AppStorageDatabase
import kotlinx.coroutines.CoroutineDispatcher

/**
 * An implementation for access to a key-value storage based on SQLDelight
 */
internal class KeyValueStorageImpl(
    private val dbDriverFactory: DatabaseDriverFactory,
    private val storageKey: String,
    private val ioDispatcher: CoroutineDispatcher,
) : KeyValueStorage {

    private val database by lazy { AppStorageDatabase(dbDriverFactory.createAppStorageDriver()) }

    /**
     * An entity for reading data from a key-value storage
     */
    override val reader: KeyValueStorageReader by lazy {
        KeyValueStorageReaderImpl(
            dbQueries = database.appStorageQueries,
            storageKey = storageKey,
            ioDispatcher = ioDispatcher,
        )
    }

    /**
     * An entity for updating data in a key-value storage
     */
    override val writer: KeyValueStorageWriter by lazy {
        KeyValueStorageWriterImpl(
            reader = reader,
            writerOperations = KeyValueStorageWriteOperationsImpl(
                dbQueries = database.appStorageQueries,
                storageKey = storageKey,
                ioDispatcher = ioDispatcher,
            ),
        )
    }
}
