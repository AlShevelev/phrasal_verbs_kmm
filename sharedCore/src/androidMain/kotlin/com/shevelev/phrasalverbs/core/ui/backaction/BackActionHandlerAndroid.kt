package com.shevelev.phrasalverbs.core.ui.backaction

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable

@Composable
actual fun BackActionHandler(
    onBackClick: () -> Unit,
) {
    BackHandler {
        onBackClick()
    }
}
