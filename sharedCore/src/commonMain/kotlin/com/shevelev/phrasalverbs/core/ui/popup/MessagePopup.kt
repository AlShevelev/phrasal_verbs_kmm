package com.shevelev.phrasalverbs.core.ui.popup

import androidx.compose.animation.core.animate
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup
import com.shevelev.phrasalverbs.core.ui.theme.AnimationTime
import com.shevelev.phrasalverbs.core.ui.theme.ColorsTheme
import com.shevelev.phrasalverbs.core.ui.theme.Dimens
import kotlinx.coroutines.delay

@Composable
fun ErrorPopup(
    data: MessagePopupData,
    onComplete: () -> Unit,
) {
    var shutterAlpha by remember { mutableStateOf(0f) }

    Popup(
        alignment = Alignment.BottomCenter,
    ) {
        Card(
            shape = RoundedCornerShape(20.dp),
            backgroundColor = ColorsTheme.Error,
            elevation = Dimens.elevation,
            border = BorderStroke(Dimens.border, ColorsTheme.OnError),
            modifier = Modifier
                .padding(bottom = 64.dp)
                .padding(horizontal = Dimens.margin)
                .alpha(shutterAlpha),
        ) {
            Text(
                modifier = Modifier.padding(Dimens.margin),
                text = data.text,
                color = ColorsTheme.OnError,
                textAlign = TextAlign.Center,
            )
        }
    }

    LaunchedEffect(data.key) {
        animate(0f, 1f, animationSpec = tween(AnimationTime.FADE)) { value, _ ->
            shutterAlpha = value
        }

        delay(AnimationTime.POPUP.toLong())

        animate(1f, 0f, animationSpec = tween(AnimationTime.FADE)) { value, _ ->
            shutterAlpha = value
        }
        onComplete()
    }
}
