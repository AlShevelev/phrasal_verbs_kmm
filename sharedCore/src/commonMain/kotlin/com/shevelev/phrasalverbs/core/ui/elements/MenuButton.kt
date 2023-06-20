package com.shevelev.phrasalverbs.core.ui.elements

import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.shevelev.phrasalverbs.core.resource.toLocString
import com.shevelev.phrasalverbs.core.ui.theme.ColorsTheme
import dev.icerock.moko.resources.StringResource

@Composable
fun MenuButton(
    text: StringResource,
    modifier: Modifier = Modifier,
    backgroundColor: Color? = null,
    contentColor: Color? = null,
    enabled: Boolean = true,
    onClick: () -> Unit,
) {
    MenuButton(
        text = text.toLocString(),
        modifier = modifier,
        backgroundColor = backgroundColor,
        contentColor = contentColor,
        enabled = enabled,
        onClick = onClick,
    )
}

@Composable
fun MenuButtonAlternative(
    text: StringResource,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    onClick: () -> Unit,
) {
    MenuButton(
        text = text.toLocString(),
        modifier = modifier,
        backgroundColor = ColorsTheme.PrimaryVariant,
        contentColor = ColorsTheme.OnPrimary,
        enabled = enabled,
        onClick = onClick,
    )
}

@Composable
fun MenuButton(
    text: String,
    modifier: Modifier = Modifier,
    backgroundColor: Color? = null,
    contentColor: Color? = null,
    enabled: Boolean = true,
    onClick: () -> Unit,
) {
    val colors = if (backgroundColor != null) {
        ButtonDefaults.buttonColors(backgroundColor = backgroundColor)
    } else {
        ButtonDefaults.buttonColors()
    }

    Button(
        modifier = modifier,
        enabled = enabled,
        onClick = onClick,
        colors = colors,
    ) {
        Text(
            text = text,
            color = contentColor ?: Color.Unspecified,
        )
    }
}
