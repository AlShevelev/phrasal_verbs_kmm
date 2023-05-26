package com.shevelev.phrasalverbs.ui.features.mainmenu.viewmodel

import com.shevelev.phrasalverbs.core.ui.viewmodel.ViewModel
import kotlinx.coroutines.flow.StateFlow

internal interface MainMenuViewModel : ViewModel {
    val state: StateFlow<MainMenuState>

    fun onEditClick()

    fun onLearnClick()

    fun onWatchAllCardsClick()

    fun onSettingsClick()
}
