package com.shevelev.phrasalverbs.data.repository.keyvaluestorage.storage

/**
 * An interface of a factory that creates a key-value storage
 */
internal interface KeyValueStorageFactory {
    /**
     * Getting a storage
     * @param storageKey a unique key of a storage (consider it as a name of alias)
     */
    operator fun get(storageKey: String): KeyValueStorage
}
