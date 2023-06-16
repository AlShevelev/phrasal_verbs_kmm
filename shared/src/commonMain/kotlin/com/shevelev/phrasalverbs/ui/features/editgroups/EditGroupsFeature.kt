package com.shevelev.phrasalverbs.ui.features.editgroups

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
import com.shevelev.phrasalverbs.ui.features.editgroups.di.EditGroupsKoinScope
import com.shevelev.phrasalverbs.ui.features.editgroups.ui.ContentState
import com.shevelev.phrasalverbs.ui.features.editgroups.viewmodel.EditGroupsState
import com.shevelev.phrasalverbs.ui.features.editgroups.viewmodel.EditGroupsViewModel
import com.shevelev.phrasalverbs.ui.navigation.FeatureParams
import dev.icerock.moko.resources.compose.painterResource

@Composable
internal fun EditGroupsFeature(
    params: FeatureParams.EditGroups,
    modifier: Modifier = Modifier,
) {
    Feature<EditGroupsViewModel>(
        scope = EditGroupsKoinScope,
        modifier = modifier,
    ) { viewModel, contentModifier ->
        val state = viewModel.state.collectAsState()

        Scaffold(
            topBar = {
                TopBar(
                    title = MR.strings.edit_groups.toLocString(),
                    navigation = TopBarAction(
                        icon = painterResource(MR.images.arrow_back),
                        onClick = { viewModel.onBackClick() },
                    ),
                    TopBarAction(
                        icon = painterResource(MR.images.save),
                        onClick = { viewModel.onSaveClick() },
                    ),
                )
            },
        ) { contentPadding ->
            when (val stateValue = state.value) {
                is EditGroupsState.Loading -> {
                    LoadingState(
                        modifier = contentModifier.padding(contentPadding),
                    )
                }

                is EditGroupsState.Content -> {
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
