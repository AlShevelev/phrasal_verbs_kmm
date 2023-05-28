package com.shevelev.phrasalverbs.data.repository.keyvaluestorage.storage

import com.shevelev.phrasalverbs.data.api.keyvaluestorage.KeyValueStorageQueries
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

/**
 * An implementation for reading data from a key-value storage that based on
 * SQLDelight database
 */
internal class KeyValueStorageReaderImpl(
    private val dbQueries: KeyValueStorageQueries,
    private val storageKey: String,
    private val ioDispatcher: CoroutineDispatcher,
) : KeyValueStorageReader {
    /**
     * Get a boolean value from the storage by its key
     * @param key value's key
     * @return resulted value or null if the value has not been found
     */
    override suspend fun getBoolean(key: String): Boolean? = getValue(key, Types.BOOLEAN)?.toBoolean()

    /**
     * Get a list of boolean values from the storage by its key
     * @param key value's key
     * @return resulted list or null if the value has not been found
     */
    override suspend fun getBooleanList(key: String): List<Boolean>? =
        getValuesList(key, Types.BOOLEAN)
            ?.map { it.toBoolean() }

    /**
     * Get a float value from the storage by its key
     * @param key value's key
     * @return resulted value or null if the value has not been found
     */
    override suspend fun getFloat(key: String): Float? = getValue(key, Types.FLOAT)?.toFloat()

    /**
     * Get a list of float values from the storage by its key
     * @param key value's key
     * @return resulted list or null if the value has not been found
     */
    override suspend fun getFloatList(key: String): List<Float>? =
        getValuesList(key, Types.FLOAT)
            ?.map { it.toFloat() }

    /**
     * Get an integer value from the storage by its key
     * @param key value's key
     * @return resulted value or null if the value has not been found
     */
    override suspend fun getInt(key: String): Int? = getValue(key, Types.INTEGER)?.toInt()

    /**
     * Get a list of integer values from the storage by its key
     * @param key value's key
     * @return resulted list or null if the value has not been found
     */
    override suspend fun getIntList(key: String): List<Int>? =
        getValuesList(key, Types.INTEGER)
            ?.map { it.toInt() }

    /**
     * Get a long integer value from the storage by its key
     * @param key value's key
     * @return resulted value or null if the value has not been found
     */
    override suspend fun getLong(key: String): Long? = getValue(key, Types.LONG)?.toLong()

    /**
     * Get a list of long integer values from the storage by its key
     * @param key value's key
     * @return resulted list or null if the value has not been found
     */
    override suspend fun getLongList(key: String): List<Long>? =
        getValuesList(key, Types.LONG)
            ?.map { it.toLong() }

    /**
     * Get a short value from the storage by its key
     * @param key value's key
     * @return resulted value or null if the value has not been found
     */
    override suspend fun getShort(key: String): Short? = getValue(key, Types.SHORT)?.toShort()

    /**
     * Get a list of short integer values from the storage by its key
     * @param key value's key
     * @return resulted list or null if the value has not been found
     */
    override suspend fun getShortList(key: String): List<Short>? =
        getValuesList(key, Types.SHORT)
            ?.map { it.toShort() }

    /**
     * Get a string value from the storage by its key
     * @param key value's key
     * @return resulted value or null if the value has not been found
     */
    override suspend fun getString(key: String): String? = getValue(key, Types.STRING)

    /**
     * Get a list of strings from the storage by its key
     * @param key value's key
     * @return resulted list or null if the value has not been found
     */
    override suspend fun getStringList(key: String): List<String>? = getValuesList(key,
        Types.STRING
    )

    /**
     * Checks for the existence of a value in the store
     * @param key value's key
     * @return checking result
     */
    override suspend fun contains(key: String): Boolean = withContext(ioDispatcher) {
        dbQueries.readKey(key, storageKey).executeAsOneOrNull()
            ?.let { true }
            ?: false
    }

    private suspend fun getValue(key: String, type: Short): String? = withContext(ioDispatcher) {
        dbQueries.readCombinedList(key, storageKey).executeAsOneOrNull()
            ?.takeIf { it.type == type && it.single }
            ?.value_
    }

    private suspend fun getValuesList(key: String, type: Short): List<String>? = withContext(ioDispatcher) {
        dbQueries.transactionWithResult {
            dbQueries.readKey(key, storageKey).executeAsOneOrNull()
                ?.takeIf { !it.single && it.type == type }
                ?.let { keyRecord ->
                    dbQueries.readValuesList(keyRecord.key_id).executeAsList()
                }
        }
    }
}
