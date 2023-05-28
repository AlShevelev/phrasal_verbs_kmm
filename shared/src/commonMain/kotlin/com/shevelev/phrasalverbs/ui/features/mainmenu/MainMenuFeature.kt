package com.shevelev.phrasalverbs.ui.features.mainmenu

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.shevelev.phrasalverbs.core.resource.toLocString
import com.shevelev.phrasalverbs.core.ui.feature.Feature
import com.shevelev.phrasalverbs.resources.MR
import com.shevelev.phrasalverbs.ui.features.mainmenu.di.MainMenuKoinScope
import com.shevelev.phrasalverbs.ui.features.mainmenu.ui.BottomBar
import com.shevelev.phrasalverbs.ui.features.mainmenu.ui.ContentState
import com.shevelev.phrasalverbs.core.ui.feature.LoadingState
import com.shevelev.phrasalverbs.core.ui.elements.TopBar
import com.shevelev.phrasalverbs.ui.features.mainmenu.viewmodel.MainMenuState
import com.shevelev.phrasalverbs.ui.features.mainmenu.viewmodel.MainMenuViewModel
import com.shevelev.phrasalverbs.ui.navigation.FeatureParams

@Composable
internal fun MainMenuFeature(
    params: FeatureParams.MainMenu,
    modifier: Modifier = Modifier,
) {
    Feature<MainMenuViewModel>(
        scope = MainMenuKoinScope,
        modifier = modifier,
    ) { viewModel, contentModifier ->

        val state = viewModel.state.collectAsState()

        Scaffold(
            topBar = { TopBar(MR.strings.app_title.toLocString()) },
            bottomBar = { BottomBar() },
        ) { contentPadding ->

            when (val stateValue = state.value) {
                is MainMenuState.Loading -> {
                    LoadingState(
                        modifier = contentModifier.padding(contentPadding),
                    )
                }

                is MainMenuState.Content -> {
                    ContentState(
                        modifier = contentModifier.padding(contentPadding),
                        state = stateValue,
                        viewModel = viewModel,
                    )
                }
            }
        }
    }
}
