package com.shevelev.phrasalverbs.core.ui.dialogs

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.ImeAction
import com.shevelev.phrasalverbs.core.ui.theme.ColorsTheme

/**
 * @param onCancel A user closed the dialog explicitly (by pressing the cancel button)
 * @param onDismiss A user closed the dialog implicitly (by using the back action
 * or via click outside of the dialog)
 */
@Composable
fun EditTextAlertDialog(
    dismissByTapOutside: Boolean = true,
    dismissByBackAction: Boolean = true,
    titleText: String? = null,
    startText: String? = null,
    confirmButtonText: String,
    cancelButtonText: String? = null,
    maxLen: Int = 32,
    onConfirm: (String?) -> Unit,
    onDismiss: () -> Unit = { },
    onCancel: () -> Unit = { },
) {
    @Suppress("RemoveExplicitTypeArguments")
    AlertDialog<String>(
        dismissByTapOutside = dismissByTapOutside,
        dismissByBackAction = dismissByBackAction,
        titleText = titleText,
        confirmButtonText = confirmButtonText,
        cancelButtonText = cancelButtonText,
        onConfirm = onConfirm,
        onDismiss = onDismiss,
        onCancel = onCancel,
    ) { modifier, onValueChange ->

        var value by remember { mutableStateOf(startText.orEmpty()) }

        TextField(
            modifier = modifier
                .fillMaxWidth(),
            value = value,
            onValueChange = {
                if(it.length <= maxLen) {
                    value = it
                    onValueChange(it)
                }
            },
            textStyle = MaterialTheme.typography.body1,
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done,
            ),
            singleLine = true,
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = ColorsTheme.Surface,
            ),
        )
    }
}
