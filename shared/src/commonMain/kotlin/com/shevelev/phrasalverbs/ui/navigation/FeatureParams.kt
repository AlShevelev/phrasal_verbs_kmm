package com.shevelev.phrasalverbs.ui.navigation

internal sealed interface FeatureParams {
    /**
     * @property groupId if the parameter is null - it means we should create a new one
     */
    data class EditGroups(
        val groupId: Long?,
    ) : FeatureParams

    object WatchAllCards : FeatureParams

    object Learning : FeatureParams

    object MainMenu : FeatureParams

    object Settings : FeatureParams

    data class SelectGroup(
        val isAddNewButtonVisible: Boolean,
    ) : FeatureParams
}
