package com.shevelev.phrasalverbs.data.repository.keyvaluestorage.storage

import com.shevelev.phrasalverbs.data.api.appstorage.AppStorageQueries
import com.shevelev.phrasalverbs.core.idgenerator.IdGenerator
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

/**
 * An implementation for updating data in a key-value storage that based on
 * SQLDelight database
 */
internal class KeyValueStorageWriteOperationsImpl(
    private val dbQueries: AppStorageQueries,
    private val storageKey: String,
    private val ioDispatcher: CoroutineDispatcher,
) : KeyValueStorageWriteOperations {
    /**
     * Puts a value with given key to a storage. If the value exists, it'll be overwritten
     * @param key value's key
     * @param value to put
     */
    override suspend fun setBoolean(key: String, value: Boolean) =
        setValue(key, Types.BOOLEAN, value.toString())

    /**
     * Puts a value with given key to a storage. If the value exists, it'll be overwritten
     * @param key value's key
     * @param values to put
     */
    override suspend fun setBooleanList(key: String, values: List<Boolean>) =
        setValuesList(key, Types.BOOLEAN, values.map { it.toString() })

    /**
     * Puts a value with given key to a storage. If the value exists, it'll be overwritten
     * @param key value's key
     * @param value to put
     */
    override suspend fun setFloat(key: String, value: Float) =
        setValue(key, Types.FLOAT, value.toString())

    /**
     * Puts a value with given key to a storage. If the value exists, it'll be overwritten
     * @param key value's key
     * @param values to put
     */
    override suspend fun setFloatList(key: String, values: List<Float>) =
        setValuesList(key, Types.FLOAT, values.map { it.toString() })

    /**
     * Puts a value with given key to a storage. If the value exists, it'll be overwritten
     * @param key value's key
     * @param value to put
     */
    override suspend fun setInt(key: String, value: Int) =
        setValue(key, Types.INTEGER, value.toString())

    /**
     * Puts a value with given key to a storage. If the value exists, it'll be overwritten
     * @param key value's key
     * @param values to put
     */
    override suspend fun setIntList(key: String, values: List<Int>) =
        setValuesList(key, Types.INTEGER, values.map { it.toString() })

    /**
     * Puts a value with given key to a storage. If the value exists, it'll be overwritten
     * @param key value's key
     * @param value to put
     */
    override suspend fun setLong(key: String, value: Long) =
        setValue(key, Types.LONG, value.toString())

    /**
     * Puts a value with given key to a storage. If the value exists, it'll be overwritten
     * @param key value's key
     * @param values to put
     */
    override suspend fun setLongList(key: String, values: List<Long>) =
        setValuesList(key, Types.LONG, values.map { it.toString() })

    /**
     * Puts a value with given key to a storage. If the value exists, it'll be overwritten
     * @param key value's key
     * @param value to put
     */
    override suspend fun setShort(key: String, value: Short) =
        setValue(key, Types.SHORT, value.toString())

    /**
     * Puts a value with given key to a storage. If the value exists, it'll be overwritten
     * @param key value's key
     * @param values to put
     */
    override suspend fun setShortList(key: String, values: List<Short>) =
        setValuesList(key, Types.SHORT, values.map { it.toString() })

    /**
     * Puts a value with given key to a storage. If the value exists, it'll be overwritten
     * @param key value's key
     * @param value to put
     */
    override suspend fun setString(key: String, value: String) = setValue(key, Types.STRING, value)

    /**
     * Puts a value with given key to a storage. If the value exists, it'll be overwritten
     * @param key value's key
     * @param values to put
     */
    override suspend fun setStringList(key: String, values: List<String>) =
        setValuesList(key, Types.STRING, values.map { it })

    /**
     * Removes a value with the given key from a storage.
     */
    override suspend fun remove(key: String) = withContext(ioDispatcher) {
        dbQueries.transaction {
            dbQueries.readKey(key, storageKey)
                .executeAsOneOrNull()
                ?.let {
                    dbQueries.deleteValue(it.key_id)
                    dbQueries.deleteKey(it.key_id)
                }
        }
    }

    private suspend fun setValue(key: String, type: Long, value: String) = withContext(ioDispatcher) {
        dbQueries.transaction {
            val keyRecord = dbQueries.readKey(key, storageKey).executeAsOneOrNull()

            if (keyRecord == null) {
                val keyId = IdGenerator.newId()
                val valueId = IdGenerator.newId()

                dbQueries.createKey(keyId, key, storageKey, type, single = 1L)
                dbQueries.createValue(valueId, keyId, value, 0)
            } else {
                val keyId = keyRecord.key_id

                if (keyRecord.single != 1L) {
                    val valueId = IdGenerator.newId()

                    dbQueries.deleteValue(keyId)
                    dbQueries.createValue(valueId, keyId, value, 0)

                    dbQueries.updateKey(type, single = 1L, keyId)
                } else {
                    dbQueries.updateValue(value, keyId)

                    if (keyRecord.type != type) {
                        dbQueries.updateKey(type, single = 1L, keyId)
                    }
                }
            }
        }
    }

    private suspend fun setValuesList(key: String, type: Long, values: List<String>) = withContext(ioDispatcher) {
        dbQueries.transaction {
            val keyRecord = dbQueries.readKey(key, storageKey).executeAsOneOrNull()

            if (keyRecord == null) {
                val keyId = IdGenerator.newId()
                dbQueries.createKey(keyId, key, storageKey, type, single = 0L)

                values.forEachIndexed { index, value ->
                    val valueId = IdGenerator.newId()
                    dbQueries.createValue(valueId, keyId, value, index.toLong())
                }
            } else {
                val keyId = keyRecord.key_id

                dbQueries.deleteValue(keyId)

                values.forEachIndexed { index, value ->
                    val valueId = IdGenerator.newId()
                    dbQueries.createValue(valueId, keyId, value, index.toLong())
                }

                if (keyRecord.single == 1L || keyRecord.type != type) {
                    dbQueries.updateKey(type, single = 0L, keyId)
                }
            }
        }
    }
}
