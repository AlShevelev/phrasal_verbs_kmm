package com.shevelev.phrasalverbs.ui.navigation

sealed interface FeatureParams {
    object EditGroups : FeatureParams

    object Learning : FeatureParams

    object MainMenu : FeatureParams

    object Settings : FeatureParams
}
