package com.shevelev.phrasalverbs.ui.features.settings

import androidx.compose.foundation.layout.Box
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.shevelev.phrasalverbs.core.ui.Feature
import com.shevelev.phrasalverbs.ui.features.settings.di.SettingsKoinScope
import com.shevelev.phrasalverbs.ui.features.settings.viewmodel.SettingsViewModel
import com.shevelev.phrasalverbs.ui.navigation.FeatureParams

@Composable
internal fun SettingsFeature(
    params: FeatureParams.Settings,
    modifier: Modifier = Modifier,
) {
    Feature<SettingsViewModel>(
        scope = SettingsKoinScope,
        modifier = modifier,
    ) { viewModel, contentModifier ->
        Box(
            contentAlignment = Alignment.Center,
            modifier = contentModifier,
        ) {
            Button(
                onClick = { viewModel.onNextClick() },
            ) {
                Text("[Settings (${viewModel.hashCode()})] Next screen: Learning")
            }
        }
    }
}
