package com.shevelev.phrasalverbs.ui.features.learning

import androidx.compose.foundation.layout.Box
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.shevelev.phrasalverbs.ui.features.learning.di.LearningKoinScope
import com.shevelev.phrasalverbs.ui.features.learning.viewmodel.LearningViewModel
import com.shevelev.phrasalverbs.ui.navigation.FeatureParams
import com.shevelev.phrasalverbs.utils.ui.Feature

@Composable
internal fun LearningFeature(
    params: FeatureParams.Learning,
    modifier: Modifier = Modifier
) {
    Feature<LearningViewModel>(
        scope = LearningKoinScope,
    ) {  viewModel ->
        Box(
            contentAlignment = Alignment.Center,
            modifier = modifier,
        ) {
            Button(
                onClick = { viewModel.onNextClick() },
            ) {
                Text("[Learning (${viewModel.id})] Next screen: Edit")
            }
        }
    }
}
