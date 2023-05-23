package com.shevelev.phrasalverbs.data.repository.keyvaluestorage

/**
 * A set of operations for updating data in a key-value storage
 */
internal interface KeyValueStorageWriteOperations {
    /**
     * Puts a value with given key to a storage. If the value exists, it'll be overwritten
     * @param key value's key
     * @param value to put
     */
    suspend fun setBoolean(key: String, value: Boolean)

    /**
     * Puts a value with given key to a storage. If the value exists, it'll be overwritten
     * @param key value's key
     * @param values to put
     */
    suspend fun setBooleanList(key: String, values: List<Boolean>)

    /**
     * Puts a value with given key to a storage. If the value exists, it'll be overwritten
     * @param key value's key
     * @param value to put
     */
    suspend fun setFloat(key: String, value: Float)

    /**
     * Puts a value with given key to a storage. If the value exists, it'll be overwritten
     * @param key value's key
     * @param values to put
     */
    suspend fun setFloatList(key: String, values: List<Float>)

    /**
     * Puts a value with given key to a storage. If the value exists, it'll be overwritten
     * @param key value's key
     * @param value to put
     */
    suspend fun setInt(key: String, value: Int)

    /**
     * Puts a value with given key to a storage. If the value exists, it'll be overwritten
     * @param key value's key
     * @param values to put
     */
    suspend fun setIntList(key: String, values: List<Int>)

    /**
     * Puts a value with given key to a storage. If the value exists, it'll be overwritten
     * @param key value's key
     * @param value to put
     */
    suspend fun setLong(key: String, value: Long)

    /**
     * Puts a value with given key to a storage. If the value exists, it'll be overwritten
     * @param key value's key
     * @param values to put
     */
    suspend fun setLongList(key: String, values: List<Long>)

    /**
     * Puts a value with given key to a storage. If the value exists, it'll be overwritten
     * @param key value's key
     * @param value to put
     */
    suspend fun setShort(key: String, value: Short)

    /**
     * Puts a value with given key to a storage. If the value exists, it'll be overwritten
     * @param key value's key
     * @param values to put
     */
    suspend fun setShortList(key: String, values: List<Short>)

    /**
     * Puts a value with given key to a storage. If the value exists, it'll be overwritten
     * @param key value's key
     * @param value to put
     */
    suspend fun setString(key: String, value: String)

    /**
     * Puts a value with given key to a storage. If the value exists, it'll be overwritten
     * @param key value's key
     * @param values to put
     */
    suspend fun setStringList(key: String, values: List<String>)

    /**
     * Removes a value with the given key from a storage.
     */
    suspend fun remove(key: String)
}
