package com.shevelev.phrasalverbs.data.repository.keyvaluestorage

import com.shevelev.phrasalverbs.data.api.DatabaseDriverFactory
import kotlinx.coroutines.CoroutineDispatcher

class KeyValueStorageFactoryImpl(
    private val dbDriverFactory: DatabaseDriverFactory,
    private val ioDispatcher: CoroutineDispatcher,
) : KeyValueStorageFactory {

    /**
     * Getting a storage
     * @param storageKey a unique key of a storage (consider it as a name of alias)
     */
    override fun get(storageKey: String): KeyValueStorage =
        KeyValueStorageImpl(
            dbDriverFactory,
            storageKey,
            ioDispatcher,
        )
}
