package com.shevelev.phrasalverbs.ui.navigation

import kotlinx.coroutines.flow.StateFlow

internal interface NavigationGraph {
    val activeFeature: StateFlow<FeatureParams>

    fun navigateToEditGroups(groupId: Long?)

    fun navigateToSelectGroup(isAddNewButtonVisible: Boolean)

    fun navigateToWatchAllCards()

    fun navigateToLearning()

    fun navigateToMainMenu()

    fun navigateToSettings()
}
