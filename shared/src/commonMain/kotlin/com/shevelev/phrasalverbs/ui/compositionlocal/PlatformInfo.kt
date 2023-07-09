package com.shevelev.phrasalverbs.ui.compositionlocal

import androidx.compose.runtime.staticCompositionLocalOf

data class PlatformInfo(
    var versionName: String = "",
    val versionCode: String = "0"
)

val LocalPlatform = staticCompositionLocalOf { PlatformInfo() }
