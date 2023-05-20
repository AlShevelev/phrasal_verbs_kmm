package com.shevelev.phrasalverbs.data.repository.keyvaluestorage

/**
 * An interface for reading data from a key-value storage
 */
interface KeyValueStorageReader {

    /**
     * Get a boolean value from the storage by its key
     * @param key value's key
     * @return resulted value or null if the value has not been found
     */
    suspend fun getBoolean(key: String): Boolean?

    /**
     * Get a list of boolean values from the storage by its key
     * @param key value's key
     * @return resulted list or null if the value has not been found
     */
    suspend fun getBooleanList(key: String): List<Boolean>?

    /**
     * Get a float value from the storage by its key
     * @param key value's key
     * @return resulted value or null if the value has not been found
     */
    suspend fun getFloat(key: String): Float?

    /**
     * Get a list of float values from the storage by its key
     * @param key value's key
     * @return resulted list or null if the value has not been found
     */
    suspend fun getFloatList(key: String): List<Float>?

    /**
     * Get an integer value from the storage by its key
     * @param key value's key
     * @return resulted value or null if the value has not been found
     */
    suspend fun getInt(key: String): Int?

    /**
     * Get a list of integer values from the storage by its key
     * @param key value's key
     * @return resulted list or null if the value has not been found
     */
    suspend fun getIntList(key: String): List<Int>?

    /**
     * Get a long integer value from the storage by its key
     * @param key value's key
     * @return resulted value or null if the value has not been found
     */
    suspend fun getLong(key: String): Long?

    /**
     * Get a list of long integer values from the storage by its key
     * @param key value's key
     * @return resulted list or null if the value has not been found
     */
    suspend fun getLongList(key: String): List<Long>?

    /**
     * Get a short value from the storage by its key
     * @param key value's key
     * @return resulted value or null if the value has not been found
     */
    suspend fun getShort(key: String): Short?

    /**
     * Get a list of short integer values from the storage by its key
     * @param key value's key
     * @return resulted list or null if the value has not been found
     */
    suspend fun getShortList(key: String): List<Short>?

    /**
     * Get a string value from the storage by its key
     * @param key value's key
     * @return resulted value or null if the value has not been found
     */
    suspend fun getString(key: String): String?

    /**
     * Get a list of strings from the storage by its key
     * @param key value's key
     * @return resulted list or null if the value has not been found
     */
    suspend fun getStringList(key: String): List<String>?

    /**
     * Checks for the existence of a value in the store
     * @param key value's key
     * @return checking result
     */
    suspend fun contains(key: String): Boolean
}
