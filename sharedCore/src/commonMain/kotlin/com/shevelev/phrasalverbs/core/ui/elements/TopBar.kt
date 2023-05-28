package com.shevelev.phrasalverbs.core.ui.elements

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

@Composable
fun TopBar(
    title: String = "",
    navigationButton: Painter? = null,
    onNavigationButtonClick: (() -> Unit)? = null,
) {
    TopAppBar(
        title = {
            Text(
                text = title,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
            )
        },
        navigationIcon = navigationButton?.let {
            {
                IconButton(onClick = { onNavigationButtonClick?.invoke() }) {
                    Icon(
                        painter = it,
                        contentDescription = null,
                        modifier = Modifier.padding(12.dp),
                    )
                }
            }
        },
    )
}
