package com.shevelev.phrasalverbs.ui.features.mainmenu.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.shevelev.phrasalverbs.core.resource.toLocString
import com.shevelev.phrasalverbs.resources.MR
import com.shevelev.phrasalverbs.ui.features.mainmenu.viewmodel.MainMenuState
import com.shevelev.phrasalverbs.ui.features.mainmenu.viewmodel.MainMenuViewModel
import com.shevelev.phrasalverbs.ui.theme.Dimens

@Composable
internal fun ContentState(
    modifier: Modifier = Modifier,
    state: MainMenuState.Content,
    viewModel: MainMenuViewModel,
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier,
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Button(
                onClick = { viewModel.onEditClick() },
            ) {
                Text(MR.strings.edit_groups.toLocString())
            }
            Button(
                modifier = Modifier.padding(vertical = Dimens.margin),
                enabled = state.isLearningEnabled,
                onClick = { viewModel.onLearnClick() },
            ) {
                Text(MR.strings.learning.toLocString())
            }
            Button(
                onClick = { viewModel.onSettingsClick() },
            ) {
                Text(MR.strings.settings.toLocString())
            }
        }
    }
}
