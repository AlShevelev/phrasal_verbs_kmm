package com.shevelev.phrasalverbs.ui.features.editgroups.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.shevelev.phrasalverbs.core.ui.theme.Dimens
import com.shevelev.phrasalverbs.ui.features.editgroups.viewmodel.EditGroupsState
import com.shevelev.phrasalverbs.ui.features.editgroups.viewmodel.EditGroupsViewModel

@Composable
internal fun ContentState(
    modifier: Modifier = Modifier,
    state: EditGroupsState.Content,
    viewModel: EditGroupsViewModel,
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        CardsBriefList(
            modifier = Modifier
                .fillMaxHeight()
                .padding(start = Dimens.padding)
                .weight(1f),
            cards = state.mainList,
        )

        Spacer(
            modifier = Modifier.width(Dimens.padding),
        )

        CardsBriefList(
            modifier = Modifier
                .fillMaxHeight()
                .padding(end = Dimens.padding)
                .weight(1f),
            cards = state.groupList,
        )
    }
}
