package com.shevelev.phrasalverbs.ui.navigation

internal sealed interface FeatureParams {
    object EditGroups : FeatureParams

    object Learning : FeatureParams

    object MainMenu : FeatureParams

    object Settings : FeatureParams
}
