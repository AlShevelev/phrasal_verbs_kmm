package com.shevelev.phrasalverbs.utils.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import com.shevelev.phrasalverbs.utils.koin.KoinScopeDescriptor
import com.shevelev.phrasalverbs.utils.koin.getKoin
import com.shevelev.phrasalverbs.utils.ui.viewmodel.ViewModel

@Composable
inline fun <reified TVM : ViewModel>Feature(
    scope: KoinScopeDescriptor,
    content: @Composable (TVM) -> Unit,
) {
    val viewModel = getKoin<TVM>(scope)

    content(viewModel)

    DisposableEffect(Unit) {
        onDispose {
            viewModel.closeScope()
        }
    }
}
