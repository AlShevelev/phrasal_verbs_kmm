package com.shevelev.phrasalverbs.ui.features.watchallcards.viewmodel

import com.shevelev.phrasalverbs.core.ui.viewmodel.ViewModel
import kotlinx.coroutines.flow.StateFlow

internal interface WatchAllCardsViewModel : ViewModel {
    val state: StateFlow<WatchAllCardsState>

    fun onBackClick()

    fun onSwitchLanguageClick()
}
