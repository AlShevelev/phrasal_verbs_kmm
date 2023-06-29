package com.shevelev.phrasalverbs.ui.navigation

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

internal class NavigationGraphImpl : NavigationGraph {
    private val _activeFeature = MutableStateFlow<FeatureParams>(FeatureParams.MainMenu)
    override val activeFeature: StateFlow<FeatureParams>
        get() = _activeFeature.asStateFlow()

    override fun navigateToEditGroups(groupId: Long?) {
        _activeFeature.tryEmit(FeatureParams.EditGroups(groupId))
    }

    override fun navigateToSelectGroup(isAddNewButtonVisible: Boolean) {
        _activeFeature.tryEmit(FeatureParams.SelectGroup(isAddNewButtonVisible))
    }

    override fun navigateToWatchAllCards(groupId: Long?) {
        _activeFeature.tryEmit(FeatureParams.WatchAllCards(groupId))
    }

    override fun navigateToMainMenu() {
        _activeFeature.tryEmit(FeatureParams.MainMenu)
    }

    override fun navigateToSettings() {
        _activeFeature.tryEmit(FeatureParams.Settings)
    }
}
