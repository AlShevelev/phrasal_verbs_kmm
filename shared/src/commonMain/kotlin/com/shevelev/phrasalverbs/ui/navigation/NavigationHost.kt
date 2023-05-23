package com.shevelev.phrasalverbs.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.shevelev.phrasalverbs.ui.features.editgroups.EditGroupsFeature
import com.shevelev.phrasalverbs.ui.features.learning.LearningFeature
import com.shevelev.phrasalverbs.ui.features.mainmenu.MainMenuFeature
import com.shevelev.phrasalverbs.ui.features.settings.SettingsFeature
import com.shevelev.phrasalverbs.utils.koin.getKoin

@Composable
fun NavigationHost(
    modifier: Modifier = Modifier
) {
    val navigationGraph = getKoin<NavigationGraph>()
    val feature = navigationGraph.activeFeature.collectAsState()

    when(val params = feature.value) {
        is FeatureParams.EditGroups -> {
            EditGroupsFeature(
                params = params,
                modifier = modifier
            )
        }
        is FeatureParams.Learning -> {
            LearningFeature(
                params = params,
                modifier = modifier
            )
        }
        is FeatureParams.MainMenu -> {
            MainMenuFeature(
                params = params,
                modifier = modifier
            )
        }
        is FeatureParams.Settings -> {
            SettingsFeature(
                params = params,
                modifier = modifier
            )
        }
    }
}
