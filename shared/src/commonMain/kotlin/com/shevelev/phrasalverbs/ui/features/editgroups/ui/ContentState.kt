package com.shevelev.phrasalverbs.ui.features.editgroups.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.shevelev.phrasalverbs.core.resource.toLocString
import com.shevelev.phrasalverbs.core.ui.dialogs.EditTextAlertDialog
import com.shevelev.phrasalverbs.core.ui.dialogs.StaticTextAlertDialog
import com.shevelev.phrasalverbs.core.ui.theme.Dimens
import com.shevelev.phrasalverbs.ui.resources.MR
import com.shevelev.phrasalverbs.ui.features.editgroups.viewmodel.EditGroupsState
import com.shevelev.phrasalverbs.ui.features.editgroups.viewmodel.EditGroupsViewModel

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
                onDrop = { card, separatorId -> viewModel.onDropCard(card.id, separatorId) },
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
                onDrop = { card, separatorId -> viewModel.onDropCard(card.id, separatorId) },
            )
        }
    }

    if (state.isNameDialogShown) {
        EditTextAlertDialog(
            titleText = MR.strings.enter_group_name.toLocString(),
            startText = state.name,
            confirmButtonText = MR.strings.ok.toLocString(),
            cancelButtonText = MR.strings.cancel.toLocString(),
            onConfirm = { viewModel.onNameDialogClose(it, isConfirmed = true) },
            onDismiss = { viewModel.onNameDialogClose(null, isConfirmed = false) },
            onCancel = { viewModel.onNameDialogClose(null, isConfirmed = false) },
        )
    }

    if (state.isDeleteDialogShown) {
        StaticTextAlertDialog(
            titleText = MR.strings.delete_group_title.toLocString(),
            text = MR.strings.delete_group_request.toLocString(),
            confirmButtonText = MR.strings.yes.toLocString(),
            cancelButtonText = MR.strings.cancel.toLocString(),
            onConfirm = { viewModel.onDeleteDialogClose(isConfirmed = true) },
            onDismiss = { viewModel.onDeleteDialogClose(isConfirmed = false) },
            onCancel = { viewModel.onDeleteDialogClose(isConfirmed = false) },
        )
    }

    if (state.isCancelConfirmationDialogShown) {
        StaticTextAlertDialog(
            titleText = MR.strings.cancel_group_title.toLocString(),
            text = MR.strings.cancel_group_request.toLocString(),
            confirmButtonText = MR.strings.yes.toLocString(),
            cancelButtonText = MR.strings.cancel.toLocString(),
            onConfirm = { viewModel.onCancelConfirmationDialogClose(isConfirmed = true) },
            onDismiss = { viewModel.onCancelConfirmationDialogClose(isConfirmed = false) },
            onCancel = { viewModel.onCancelConfirmationDialogClose(isConfirmed = false) },
        )
    }
}
