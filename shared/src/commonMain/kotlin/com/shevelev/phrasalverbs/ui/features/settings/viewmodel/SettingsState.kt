package com.shevelev.phrasalverbs.ui.features.settings.viewmodel

internal sealed interface SettingsState {
    object Loading : SettingsState

    data class Content(
        val isRussianSideDefault: Boolean,
    ) : SettingsState
}
