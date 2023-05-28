package com.shevelev.phrasalverbs.ui.features.watchallcards

import androidx.compose.foundation.layout.Box
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.shevelev.phrasalverbs.core.ui.feature.Feature
import com.shevelev.phrasalverbs.ui.features.watchallcards.di.WatchAllCardsKoinScope
import com.shevelev.phrasalverbs.ui.features.watchallcards.viewmodel.WatchAllCardsViewModel
import com.shevelev.phrasalverbs.ui.navigation.FeatureParams

@Composable
internal fun WatchAllCardsFeature(
    params: FeatureParams.WatchAllCards,
    modifier: Modifier = Modifier,
) {
    Feature<WatchAllCardsViewModel>(
        scope = WatchAllCardsKoinScope,
        modifier = modifier,
    ) { viewModel, contentModifier ->
        Box(
            contentAlignment = Alignment.Center,
            modifier = contentModifier,
        ) {
            Button(
                onClick = { viewModel.onNextClick() },
            ) {
                Text("[WatchAllCards (${viewModel.hashCode()})] Next screen: MainMenu")
            }
        }
    }
}
