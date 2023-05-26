package com.shevelev.phrasalverbs.ui.navigation

import kotlinx.coroutines.flow.StateFlow

internal interface NavigationGraph {
    val activeFeature: StateFlow<FeatureParams>

    fun navigateToEditGroups()

    fun navigateToWatchAllCards()

    fun navigateToLearning()

    fun navigateToMainMenu()

    fun navigateToSettings()
}
