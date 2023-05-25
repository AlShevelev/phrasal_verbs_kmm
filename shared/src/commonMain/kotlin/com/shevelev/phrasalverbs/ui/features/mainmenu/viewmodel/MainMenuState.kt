package com.shevelev.phrasalverbs.ui.features.mainmenu.viewmodel

internal sealed interface MainMenuState {
    object Loading : MainMenuState

    data class Content(
        val isLearningEnabled: Boolean,
    ) : MainMenuState
}
