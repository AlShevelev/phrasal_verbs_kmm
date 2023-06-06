package com.shevelev.phrasalverbs.ui.features.editgroups.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.shevelev.phrasalverbs.core.log.Logger
import com.shevelev.phrasalverbs.core.ui.theme.Dimens
import com.shevelev.phrasalverbs.domain.entities.Card
import com.shevelev.phrasalverbs.ui.features.editgroups.viewmodel.EditGroupsState
import com.shevelev.phrasalverbs.ui.features.editgroups.viewmodel.EditGroupsViewModel
import com.shevelev.phrasalverbs.ui.features.editgroups.viewmodel.data.DropTargetType

@Composable
internal fun ContentState(
    modifier: Modifier = Modifier,
    state: EditGroupsState.Content,
    viewModel: EditGroupsViewModel,
) {
    LongPressDraggable(
        modifier = modifier,
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            CardsBriefList(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(start = Dimens.padding)
                    .weight(1f),
                cards = state.sourceList,
            )

            Spacer(
                modifier = Modifier.width(Dimens.padding),
            )

            DropTarget<Card>(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(end = Dimens.padding)
                    .weight(1f),
                onDrop = { card ->
                    viewModel.onDropCard(card, DropTargetType.GroupListGeneral)
                },
            ) { isInBound ->
                Logger.d("DRAG", "isInbound: $isInBound")

                CardsBriefList(
                    modifier = Modifier.fillMaxSize(),
                    cards = state.groupList,
                )
            }
        }
    }
}
