package com.shevelev.phrasalverbs.ui.features.settings.viewmodel

import com.shevelev.phrasalverbs.core.ui.viewmodel.ViewModel
import kotlinx.coroutines.flow.StateFlow

internal interface SettingsViewModel : ViewModel {
    val state: StateFlow<SettingsState>

    fun onBackClick()

    fun updateIsRussianSideDefault(value: Boolean)
}
