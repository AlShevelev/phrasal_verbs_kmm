package com.shevelev.phrasalverbs.ui.navigation

internal sealed interface FeatureParams {
    object EditGroups : FeatureParams

    object WatchAllCards : FeatureParams

    object Learning : FeatureParams

    object MainMenu : FeatureParams

    object Settings : FeatureParams
}
