package com.shevelev.phrasalverbs.ui.features.editgroups

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.shevelev.phrasalverbs.ui.features.editgroups.di.EditGroupsKoinScope
import com.shevelev.phrasalverbs.ui.features.editgroups.viewmodel.EditGroupsViewModel
import com.shevelev.phrasalverbs.ui.navigation.FeatureParams
import com.shevelev.phrasalverbs.core.ui.Feature

@Composable
internal fun EditGroupsFeature(
    params: FeatureParams.EditGroups,
    modifier: Modifier = Modifier,
) {
    Feature<EditGroupsViewModel>(
        scope = EditGroupsKoinScope,
        modifier = modifier,
    ) { viewModel, contentModifier ->
        Box(
            contentAlignment = Alignment.Center,
            modifier = contentModifier.background(Color.Red),
        ) {
            Button(
                onClick = { viewModel.onNextClick() },
            ) {
                Text("[Edit (${viewModel.id})] Next screen: Main menu")
            }
        }
    }
}
