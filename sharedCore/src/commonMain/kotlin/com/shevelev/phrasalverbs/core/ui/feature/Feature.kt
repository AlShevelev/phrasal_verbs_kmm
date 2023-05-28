package com.shevelev.phrasalverbs.core.ui.feature

import androidx.compose.animation.core.animate
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import com.shevelev.phrasalverbs.core.koin.KoinScopeDescriptor
import com.shevelev.phrasalverbs.core.koin.getKoin
import com.shevelev.phrasalverbs.core.ui.popup.ErrorPopup
import com.shevelev.phrasalverbs.core.ui.popup.MessagePopupData
import com.shevelev.phrasalverbs.core.ui.theme.AnimationTime
import com.shevelev.phrasalverbs.core.ui.viewmodel.ViewModel

@Composable
inline fun <reified TVM : ViewModel>Feature(
    scope: KoinScopeDescriptor,
    modifier: Modifier = Modifier,
    content: @Composable (TVM, Modifier) -> Unit,
) {
    val viewModel = getKoin<TVM>(scope)

    var shutterAlpha by remember { mutableStateOf(0f) }

    content(viewModel, modifier.alpha(shutterAlpha))

    var popupData by remember { mutableStateOf<MessagePopupData?>(null) }

    popupData?.let {
        ErrorPopup(
            data = it,
            onComplete = {
                popupData = null
            },
        )
    }

    LaunchedEffect(Unit) {
        viewModel.messagePopup.collect {
            popupData = it
        }
    }

    LaunchedEffect(Unit) {
        animate(0f, 1f, animationSpec = tween(AnimationTime.FADE)) { value, _ ->
            shutterAlpha = value
        }
    }

    DisposableEffect(Unit) {
        onDispose {
            viewModel.close()
        }
    }
}
