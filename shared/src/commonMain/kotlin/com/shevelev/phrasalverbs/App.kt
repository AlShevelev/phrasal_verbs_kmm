package com.shevelev.phrasalverbs

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Modifier
import com.shevelev.phrasalverbs.ui.compositionlocal.LocalPlatform
import com.shevelev.phrasalverbs.ui.compositionlocal.PlatformInfo
import com.shevelev.phrasalverbs.ui.navigation.NavigationHost
import com.shevelev.phrasalverbs.ui.theme.MainTheme

@Suppress("LocalVariableName")
@Composable
fun App(
    platformInfo: PlatformInfo
) {
    MainTheme {
        CompositionLocalProvider(LocalPlatform provides platformInfo) {
            NavigationHost(
                modifier = Modifier.fillMaxSize(),
            )
        }
    }
}
