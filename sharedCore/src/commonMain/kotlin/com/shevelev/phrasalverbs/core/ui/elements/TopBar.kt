package com.shevelev.phrasalverbs.core.ui.elements

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import com.shevelev.phrasalverbs.core.ui.theme.Dimens

@Composable
fun TopBar(
    title: String = "",
    navigation: TopBarAction? = null,
    vararg action: TopBarAction,
) {
    TopAppBar(
        title = {
            Text(
                text = title,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
            )
        },
        navigationIcon = navigation?.let {
            {
                TopBarIcon(it)
            }
        },
        actions = {
            action.forEach {
                TopBarIcon(it)
            }
        },
    )
}

@Composable
private fun TopBarIcon(
    action: TopBarAction,
) {
    IconButton(onClick = action.onClick) {
        Icon(
            painter = action.icon,
            contentDescription = null,
            modifier = Modifier.padding(Dimens.paddingIcon),
        )
    }
}
