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
import com.shevelev.phrasalverbs.core.ui.theme.Dimens
import dev.icerock.moko.resources.StringResource

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
            MenuButton(
                text = MR.strings.edit_groups,
                onClick = { viewModel.onEditClick() },
            )
            MenuButton(
                text = MR.strings.watch_all_cards,
                modifier = Modifier.padding(top = Dimens.padding),
                onClick = { viewModel.onWatchAllCardsClick() },
            )
            MenuButton(
                text = MR.strings.learning,
                enabled = state.isLearningEnabled,
                modifier = Modifier.padding(top = Dimens.padding),
                onClick = { viewModel.onLearnClick() },
            )
            MenuButton(
                text = MR.strings.settings,
                modifier = Modifier.padding(top = Dimens.padding),
                onClick = { viewModel.onSettingsClick() },
            )
        }
    }
}

@Composable
private fun MenuButton(
    text: StringResource,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    onClick: () -> Unit,
) {
    Button(
        modifier = modifier,
        enabled = enabled,
        onClick = onClick,
    ) {
        Text(text.toLocString())
    }
}
