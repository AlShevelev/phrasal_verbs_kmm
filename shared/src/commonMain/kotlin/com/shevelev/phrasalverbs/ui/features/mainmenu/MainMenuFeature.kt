package com.shevelev.phrasalverbs.ui.features.mainmenu

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.shevelev.phrasalverbs.ui.features.mainmenu.di.MainMenuKoinScope
import com.shevelev.phrasalverbs.ui.features.mainmenu.viewmodel.MainMenuViewModel
import com.shevelev.phrasalverbs.ui.navigation.FeatureParams
import com.shevelev.phrasalverbs.utils.ui.Feature

@Composable
internal fun MainMenuFeature(
    params: FeatureParams.MainMenu,
    modifier: Modifier = Modifier,
) {
    Feature<MainMenuViewModel>(
        scope = MainMenuKoinScope,
        modifier = modifier,
    ) { viewModel, contentModifier ->
        Box(
            contentAlignment = Alignment.Center,
            modifier = contentModifier.background(Color.Blue),
        ) {
            Button(
                onClick = { viewModel.onNextClick() },
            ) {
                Text("[MainMenu (${viewModel.id})] Next screen: Settings")
            }
        }
    }
}
