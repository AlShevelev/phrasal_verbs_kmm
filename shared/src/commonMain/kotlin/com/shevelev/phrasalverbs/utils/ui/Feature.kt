package com.shevelev.phrasalverbs.utils.ui

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
import com.shevelev.phrasalverbs.utils.koin.KoinScopeDescriptor
import com.shevelev.phrasalverbs.utils.koin.getKoin
import com.shevelev.phrasalverbs.utils.ui.viewmodel.ViewModel

@Composable
internal inline fun <reified TVM : ViewModel>Feature(
    scope: KoinScopeDescriptor,
    modifier: Modifier = Modifier,
    content: @Composable (TVM, Modifier) -> Unit,
) {
    val viewModel = getKoin<TVM>(scope)

    var shutterAlpha by remember { mutableStateOf(0f) }

    content(viewModel, modifier.alpha(shutterAlpha))

    LaunchedEffect(Unit) {
        animate(0f, 1f, animationSpec = tween(300)) { value, _ -> shutterAlpha = value }
    }

    DisposableEffect(Unit) {
        onDispose {
            viewModel.closeScope()
        }
    }
}
