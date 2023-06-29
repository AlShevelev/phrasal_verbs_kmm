package com.shevelev.phrasalverbs.ui.features.watchallcards

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.shevelev.phrasalverbs.core.resource.toLocString
import com.shevelev.phrasalverbs.core.ui.backaction.BackActionHandler
import com.shevelev.phrasalverbs.core.ui.elements.TopBar
import com.shevelev.phrasalverbs.core.ui.elements.TopBarAction
import com.shevelev.phrasalverbs.core.ui.feature.Feature
import com.shevelev.phrasalverbs.core.ui.feature.LoadingState
import com.shevelev.phrasalverbs.resources.MR
import com.shevelev.phrasalverbs.ui.features.watchallcards.di.WatchAllCardsKoinScope
import com.shevelev.phrasalverbs.ui.features.watchallcards.ui.ContentState
import com.shevelev.phrasalverbs.ui.features.watchallcards.viewmodel.WatchAllCardsState
import com.shevelev.phrasalverbs.ui.features.watchallcards.viewmodel.WatchAllCardsViewModel
import com.shevelev.phrasalverbs.ui.navigation.FeatureParams
import dev.icerock.moko.resources.compose.painterResource

@Composable
internal fun WatchAllCardsFeature(
    params: FeatureParams.WatchAllCards,
    modifier: Modifier = Modifier,
) {
    Feature<WatchAllCardsViewModel>(
        scope = WatchAllCardsKoinScope,
        modifier = modifier,
    ) { viewModel, contentModifier ->
        val state = viewModel.state.collectAsState()

        Scaffold(
            topBar = {
                TopBar(
                    title = MR.strings.watch_all_cards.toLocString(),
                    navigation = TopBarAction(
                        icon = painterResource(MR.images.arrow_back),
                        onClick = { viewModel.onBackClick() },
                    ),
                    TopBarAction(
                        icon = painterResource(MR.images.language),
                        onClick = { viewModel.onSwitchLanguageClick() },
                    ),
                )
            },
        ) { contentPadding ->
            when (val stateValue = state.value) {
                is WatchAllCardsState.Loading -> {
                    LoadingState(
                        modifier = contentModifier.padding(contentPadding),
                    )
                }

                is WatchAllCardsState.Content -> {
                    ContentState(
                        modifier = contentModifier.padding(contentPadding),
                        state = stateValue,
                        viewModel = viewModel,
                    )
                }
            }
        }

        LaunchedEffect(Unit) {
            viewModel.init(params.groupId)
        }

        BackActionHandler(
            onBackClick = { viewModel.onBackClick() },
        )
    }
}
