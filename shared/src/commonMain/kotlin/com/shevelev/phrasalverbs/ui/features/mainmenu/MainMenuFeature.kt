package com.shevelev.phrasalverbs.ui.features.mainmenu

import androidx.compose.foundation.layout.Box
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.shevelev.phrasalverbs.ui.features.mainmenu.di.MainMenuKoinScope
import com.shevelev.phrasalverbs.ui.features.mainmenu.viewmodel.MainMenuViewModel
import com.shevelev.phrasalverbs.ui.navigation.FeatureParams
import com.shevelev.phrasalverbs.utils.ui.Feature

@Composable
fun MainMenuFeature(
    params: FeatureParams.MainMenu,
    modifier: Modifier = Modifier
) {
    Feature<MainMenuViewModel>(
        scope = MainMenuKoinScope,
    ) {  viewModel ->
        Box(
            contentAlignment = Alignment.Center,
            modifier = modifier,
        ) {
            Button(
                onClick = { viewModel.onNextClick() },
            ) {
                Text("[MainMenu (${viewModel.id})] Next screen: Settings")
            }
        }
    }
}
