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
import dev.icerock.moko.resources.StringResource

@Composable
internal fun ContentState(
    modifier: Modifier = Modifier,
    state: SettingsState.Content,
    viewModel: SettingsViewModel,
) {
    Column(
        modifier = modifier
            .padding(all = Dimens.padding),
    ) {
        OneSetting(
            modifier = Modifier.padding(bottom = Dimens.padding),
            isChecked = state.isRussianSideDefault,
            text = MR.strings.russian_side_default,
            updateCheckAction = { viewModel.updateIsRussianSideDefault(it) },
        )

        OneSetting(
            isChecked = state.isInfiniteCardsList,
            text = MR.strings.infinite_lists,
            updateCheckAction = { viewModel.updateIsIsInfiniteCardsList(it) },
        )
    }
}

@Composable
private fun OneSetting(
    modifier: Modifier = Modifier,
    isChecked: Boolean,
    text: StringResource,
    updateCheckAction: (Boolean) -> Unit,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Checkbox(
            checked = isChecked,
            onCheckedChange = updateCheckAction,
        )
        Text(text.toLocString())
    }
}
