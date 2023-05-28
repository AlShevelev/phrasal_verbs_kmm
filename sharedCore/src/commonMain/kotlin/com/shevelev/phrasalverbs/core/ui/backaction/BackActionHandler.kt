package com.shevelev.phrasalverbs.core.ui.backaction

import androidx.compose.runtime.Composable

@Composable
expect fun BackActionHandler(
    onBackClick: () -> Unit,
)
