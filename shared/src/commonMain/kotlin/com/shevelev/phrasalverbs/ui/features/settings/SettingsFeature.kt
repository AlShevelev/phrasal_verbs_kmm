package com.shevelev.phrasalverbs.ui.features.settings

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.shevelev.phrasalverbs.core.resource.toLocString
import com.shevelev.phrasalverbs.core.ui.backaction.BackActionHandler
import com.shevelev.phrasalverbs.core.ui.elements.TopBar
import com.shevelev.phrasalverbs.core.ui.elements.TopBarAction
import com.shevelev.phrasalverbs.core.ui.feature.Feature
import com.shevelev.phrasalverbs.core.ui.feature.LoadingState
import com.shevelev.phrasalverbs.resources.MR
import com.shevelev.phrasalverbs.ui.features.settings.di.SettingsKoinScope
import com.shevelev.phrasalverbs.ui.features.settings.ui.ContentState
import com.shevelev.phrasalverbs.ui.features.settings.viewmodel.SettingsState
import com.shevelev.phrasalverbs.ui.features.settings.viewmodel.SettingsViewModel
import com.shevelev.phrasalverbs.ui.navigation.FeatureParams
import dev.icerock.moko.resources.compose.painterResource

@Composable
internal fun SettingsFeature(
    params: FeatureParams.Settings,
    modifier: Modifier = Modifier,
) {
    Feature<SettingsViewModel>(
        scope = SettingsKoinScope,
        modifier = modifier,
    ) { viewModel, contentModifier ->
        val state = viewModel.state.collectAsState()

        Scaffold(
            topBar = {
                TopBar(
                    title = MR.strings.settings.toLocString(),
                    navigation = TopBarAction(
                        icon = painterResource(MR.images.arrow_back),
                        onClick = { viewModel.onBackClick() },
                    ),
                )
            },
        ) { contentPadding ->
            when (val stateValue = state.value) {
                is SettingsState.Loading -> {
                    LoadingState(
                        modifier = contentModifier.padding(contentPadding),
                    )
                }

                is SettingsState.Content -> {
                    ContentState(
                        modifier = contentModifier.padding(contentPadding),
                        state = stateValue,
                        viewModel = viewModel,
                    )
                }
            }
        }

        BackActionHandler(
            onBackClick = { viewModel.onBackClick() },
        )
    }
}
