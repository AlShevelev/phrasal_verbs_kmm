package com.shevelev.phrasalverbs.ui.features.watchallcards.viewmodel

import com.shevelev.phrasalverbs.core.ui.viewmodel.ViewModel
import com.shevelev.phrasalverbs.domain.entities.Card
import kotlinx.coroutines.flow.StateFlow

internal interface WatchAllCardsViewModel : ViewModel {
    val state: StateFlow<WatchAllCardsState>

    fun init(groupId: Long?)

    fun onBackClick()

    fun onSwitchLanguageClick()

    fun onLearntClick(card: Card)
}
