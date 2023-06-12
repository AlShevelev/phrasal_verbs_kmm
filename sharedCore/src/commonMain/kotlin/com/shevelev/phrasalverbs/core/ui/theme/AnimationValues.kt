package com.shevelev.phrasalverbs.core.ui.theme

import androidx.compose.animation.core.CubicBezierEasing
import androidx.compose.animation.core.Easing

object AnimationValues {
    const val FADE = 300

    const val CARD_ROTATION = 400

    const val POPUP = 4000

    // This easing speeds up quickly and slows down gradually
    val slowOutFastInEasing: Easing = CubicBezierEasing(1.0f, 0.2f, 0f, 0.4f)
}
