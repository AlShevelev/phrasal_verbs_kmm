package com.shevelev.phrasalverbs.core.ui.dialogs

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.shevelev.phrasalverbs.core.ui.theme.Dimens

/**
 * @param T type of edited value (if we have one)
 * @param onCancel A user closed the dialog explicitly (by pressing the cancel button)
 * @param onDismiss A user closed the dialog implicitly (by using the back action
 * or via click outside of the dialog)
 * @param content a content of the dialog with on value receiving callback
 */
@Composable
fun <T>AlertDialog(
    dismissByTapOutside: Boolean = true,
    dismissByBackAction: Boolean = true,
    titleText: String? = null,
    confirmButtonText: String,
    cancelButtonText: String? = null,
    onConfirm: (T?) -> Unit,
    onDismiss: () -> Unit = { },
    onCancel: () -> Unit = { },
    content: @Composable (Modifier, (T?) -> Unit) -> Unit,
) {
    BaseDialog(
        dismissByTapOutside = dismissByTapOutside,
        dismissByBackAction = dismissByBackAction,
        onDismiss = onDismiss,
    ) {
        var value by remember { mutableStateOf<T?>(null) }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(Dimens.padding),
        ) {
            titleText?.let {
                Text(
                    modifier = Modifier.padding(bottom = Dimens.padding),
                    text = it,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.h4,
                )
            }

            content(
                Modifier.padding(top = 0.dp),
            ) { newValue ->
                value = newValue
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = Dimens.padding),
                horizontalArrangement = Arrangement.End,
            ) {
                AlertDialogButton(
                    text = confirmButtonText,
                    onClick = { onConfirm(value) },
                )

                cancelButtonText?.let {
                    AlertDialogButton(
                        text = it,
                        onClick = onCancel,
                        modifier = Modifier.padding(start = Dimens.padding),
                    )
                }
            }
        }
    }
}

@Composable
private fun AlertDialogButton(
    text: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    onClick: () -> Unit,
) {
    Button(
        modifier = modifier.defaultMinSize(minWidth = Dimens.dialogMinButtonWidth),
        enabled = enabled,
        onClick = onClick,
    ) {
        Text(text)
    }
}
