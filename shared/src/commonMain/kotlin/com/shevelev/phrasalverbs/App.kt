package com.shevelev.phrasalverbs

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.shevelev.phrasalverbs.ui.navigation.NavigationHost
import com.shevelev.phrasalverbs.ui.theme.MainTheme
import org.jetbrains.compose.resources.ExperimentalResourceApi

@OptIn(ExperimentalResourceApi::class)
@Composable
fun App() {
    MainTheme {
        NavigationHost(
            modifier = Modifier.fillMaxSize(),
        )
    }
}
