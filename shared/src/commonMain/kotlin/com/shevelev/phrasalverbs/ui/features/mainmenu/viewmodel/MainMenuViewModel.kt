package com.shevelev.phrasalverbs.ui.features.mainmenu.viewmodel

import com.shevelev.phrasalverbs.core.ui.viewmodel.ViewModel

internal interface MainMenuViewModel : ViewModel {
    fun onEditClick()

    fun onLearnClick()

    fun onSettingsClick()
}
