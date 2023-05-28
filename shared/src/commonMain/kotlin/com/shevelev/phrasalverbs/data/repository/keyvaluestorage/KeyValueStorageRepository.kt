package com.shevelev.phrasalverbs.data.repository.keyvaluestorage

internal interface KeyValueStorageRepository {
    suspend fun getIsRussianSideDefault(): Boolean

    suspend fun setIsRussianSideDefault(value: Boolean)

    suspend fun getLastCardsBatchVersion(): Int

    suspend fun setLastCardsBatchVersion(value: Int)
}
