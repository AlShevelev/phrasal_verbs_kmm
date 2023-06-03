package com.shevelev.phrasalverbs.core.ui.elements

import androidx.compose.ui.graphics.painter.Painter

data class TopBarAction(
    val icon: Painter,
    val onClick: () -> Unit,
)
