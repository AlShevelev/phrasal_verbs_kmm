package com.shevelev.phrasalverbs.core.ui.dialogs

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextOverflow

/**
 * @param onCancel A user closed the dialog explicitly (by pressing the cancel button)
 * @param onDismiss A user closed the dialog implicitly (by using the back action
 * or via click outside of the dialog)
 */
@Composable
fun StaticTextAlertDialog(
    dismissByTapOutside: Boolean = true,
    dismissByBackAction: Boolean = true,
    titleText: String? = null,
    text: String,
    confirmButtonText: String,
    cancelButtonText: String? = null,
    onConfirm: () -> Unit,
    onDismiss: () -> Unit = { },
    onCancel: () -> Unit = { },
) {
    AlertDialog<Unit>(
        dismissByTapOutside = dismissByTapOutside,
        dismissByBackAction = dismissByBackAction,
        titleText = titleText,
        confirmButtonText = confirmButtonText,
        cancelButtonText = cancelButtonText,
        onConfirm = { onConfirm() },
        onDismiss = onDismiss,
        onCancel = onCancel,
    ) { modifier, _ ->
        Text(
            modifier = modifier,
            text = text,
            maxLines = 5,
            overflow = TextOverflow.Ellipsis,
            style = MaterialTheme.typography.body1,
        )
    }
}
