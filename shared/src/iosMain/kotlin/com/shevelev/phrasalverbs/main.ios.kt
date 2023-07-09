package com.shevelev.phrasalverbs

import androidx.compose.ui.window.ComposeUIViewController
import com.shevelev.phrasalverbs.ui.compositionlocal.PlatformInfo

fun MainViewController(
    versionName: String,
    versionCode: String,
) = ComposeUIViewController {
    App(
        PlatformInfo(
            versionName = versionName,
            versionCode = versionCode,
        ),
    )
}
