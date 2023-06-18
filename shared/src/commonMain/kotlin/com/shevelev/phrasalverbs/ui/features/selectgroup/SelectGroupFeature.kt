package com.shevelev.phrasalverbs.ui.features.selectgroup

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
import com.shevelev.phrasalverbs.ui.features.selectgroup.di.SelectGroupKoinScope
import com.shevelev.phrasalverbs.ui.features.selectgroup.ui.ContentState
import com.shevelev.phrasalverbs.ui.features.selectgroup.viewmodel.SelectGroupState
import com.shevelev.phrasalverbs.ui.features.selectgroup.viewmodel.SelectGroupViewModel
import com.shevelev.phrasalverbs.ui.navigation.FeatureParams
import dev.icerock.moko.resources.compose.painterResource

@Composable
internal fun SelectGroupFeature(
    params: FeatureParams.SelectGroup,
    modifier: Modifier = Modifier,
) {
    Feature<SelectGroupViewModel>(
        scope = SelectGroupKoinScope,
        modifier = modifier,
    ) { viewModel, contentModifier ->
        val state = viewModel.state.collectAsState()

        Scaffold(
            topBar = {
                TopBar(
                    title = MR.strings.select_group.toLocString(),
                    navigation = TopBarAction(
                        icon = painterResource(MR.images.arrow_back),
                        onClick = { viewModel.onBackClick() },
                    ),
                )
            },
        ) { contentPadding ->
            when (val stateValue = state.value) {
                is SelectGroupState.Loading -> {
                    LoadingState(
                        modifier = contentModifier.padding(contentPadding),
                    )
                }

                is SelectGroupState.Content -> {
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
