package com.shevelev.phrasalverbs.data.repository.keyvaluestorage

import com.shevelev.phrasalverbs.data.repository.keyvaluestorage.storage.KeyValueStorage

internal class KeyValueStorageRepositoryImpl(
    private val keyValueStorage: KeyValueStorage,
) : KeyValueStorageRepository {
    override suspend fun getIsRussianSideDefault(): Boolean =
        keyValueStorage.reader.getBoolean(IS_RUSSIAN_SIDE_DEFAULT) ?: false

    override suspend fun setIsRussianSideDefault(value: Boolean) {
        keyValueStorage.writer.update {
            it.setBoolean(IS_RUSSIAN_SIDE_DEFAULT, value)
        }
    }

    override suspend fun getIsInfiniteCardsList(): Boolean =
        keyValueStorage.reader.getBoolean(IS_INFINITE_CARDS_LIST) ?: false

    override suspend fun setIsInfiniteCardsList(value: Boolean) {
        keyValueStorage.writer.update {
            it.setBoolean(IS_INFINITE_CARDS_LIST, value)
        }
    }

    override suspend fun getLastCardsBatchVersion(): Int =
        keyValueStorage.reader.getInt(LAST_CARDS_BATCH_VERSION) ?: 0

    override suspend fun setLastCardsBatchVersion(value: Int) {
        keyValueStorage.writer.update {
            it.setInt(LAST_CARDS_BATCH_VERSION, value)
        }
    }

    companion object {
        private const val IS_RUSSIAN_SIDE_DEFAULT = "IS_RUSSIAN_SIDE_DEFAULT"
        private const val IS_INFINITE_CARDS_LIST = "IS_INFINITE_CARDS_LIST"
        private const val LAST_CARDS_BATCH_VERSION = "LAST_CARDS_BATCH_VERSION"
    }
}
