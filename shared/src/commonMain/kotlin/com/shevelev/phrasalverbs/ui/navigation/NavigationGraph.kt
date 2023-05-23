package com.shevelev.phrasalverbs.ui.navigation

import kotlinx.coroutines.flow.StateFlow

interface NavigationGraph {
    val activeFeature: StateFlow<FeatureParams>

    fun navigateToEditGroups()

    fun navigateToLearning()

    fun navigateToMainMenu()

    fun navigateToSettings()
}
