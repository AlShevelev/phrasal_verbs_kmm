package com.shevelev.phrasalverbs.ui.features.watchallcards.viewmodel.contentprovider

import com.shevelev.phrasalverbs.domain.entities.Card

internal interface CardsProvider {
    val count: Int

    fun getKey(index: Int): Long

    fun getItem(index: Int): Card
}
