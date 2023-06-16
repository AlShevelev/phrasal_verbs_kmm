package com.shevelev.phrasalverbs.core.ui.dialogs

import androidx.compose.animation.core.animate
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import com.shevelev.phrasalverbs.core.ui.backaction.BackActionHandler
import com.shevelev.phrasalverbs.core.ui.theme.AnimationValues
import com.shevelev.phrasalverbs.core.ui.theme.ColorsTheme
import com.shevelev.phrasalverbs.core.ui.theme.Dimens

/**
 * @param onDismiss A user closed the dialog implicitly (by using the back action
 * or via click outside of the dialog)
 */
@Composable
fun BaseDialog(
    dismissByTapOutside: Boolean = true,
    dismissByBackAction: Boolean = true,
    onDismiss: () -> Unit = { },
    content: @Composable () -> Unit,
) {
    var shutterAlpha by remember { mutableStateOf(0f) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = ColorsTheme.OnSurface.copy(alpha = shutterAlpha * 0.25f))
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
            ) {
                if (dismissByTapOutside) {
                    onDismiss()
                }
            },
        contentAlignment = Alignment.Center,
    ) {
        Card(
            shape = RoundedCornerShape(Dimens.dialogCorner),
            backgroundColor = ColorsTheme.Surface,
            elevation = Dimens.elevation,
            modifier = Modifier
                .padding(all = Dimens.padding)
                .alpha(shutterAlpha)
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = null,
                    onClick = { },
                ),
        ) {
            content()
        }
    }

    if (dismissByBackAction) {
        BackActionHandler(
            onBackClick = onDismiss,
        )
    }

    LaunchedEffect(Unit) {
        animate(0f, 1f, animationSpec = tween(AnimationValues.FADE)) { value, _ ->
            shutterAlpha = value
        }
    }
}
