package com.shevelev.phrasalverbs.ui.features.settings.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.shevelev.phrasalverbs.core.resource.toLocString
import com.shevelev.phrasalverbs.core.ui.theme.Dimens
import com.shevelev.phrasalverbs.resources.MR
import com.shevelev.phrasalverbs.ui.features.settings.viewmodel.SettingsState
import com.shevelev.phrasalverbs.ui.features.settings.viewmodel.SettingsViewModel

@Composable
internal fun ContentState(
    modifier: Modifier = Modifier,
    state: SettingsState.Content,
    viewModel: SettingsViewModel,
) {
    Column(
        modifier = modifier
            .padding(all = Dimens.margin),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Checkbox(
                checked = state.isRussianSideDefault,
                onCheckedChange = { viewModel.updateIsRussianSideDefault(it) },
            )
            Text(MR.strings.russian_side_default.toLocString())
        }
    }
}
