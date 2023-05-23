package com.shevelev.phrasalverbs.ui.navigation

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

internal class NavigationGraphImpl : NavigationGraph {
    private val _activeFeature = MutableStateFlow<FeatureParams>(FeatureParams.MainMenu)
    override val activeFeature: StateFlow<FeatureParams>
        get() = _activeFeature.asStateFlow()

    override fun navigateToEditGroups() {
        _activeFeature.tryEmit(FeatureParams.EditGroups)
    }

    override fun navigateToLearning() {
        _activeFeature.tryEmit(FeatureParams.Learning)
    }

    override fun navigateToMainMenu() {
        _activeFeature.tryEmit(FeatureParams.MainMenu)
    }

    override fun navigateToSettings() {
        _activeFeature.tryEmit(FeatureParams.Settings)
    }
}
