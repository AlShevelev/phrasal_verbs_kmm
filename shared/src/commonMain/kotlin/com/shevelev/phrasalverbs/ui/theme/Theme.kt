package com.shevelev.phrasalverbs.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Typography
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
internal fun MainTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colors = lightColors(
            primary = ColorsTheme.Primary,
            primaryVariant = ColorsTheme.PrimaryVariant,
            secondary = ColorsTheme.Secondary,
            secondaryVariant = ColorsTheme.SecondaryVariant,
            background = ColorsTheme.Background,
            surface = ColorsTheme.Surface,
            error = ColorsTheme.Error,
            onPrimary = ColorsTheme.OnPrimary,
            onSecondary = ColorsTheme.OnSecondary,
            onBackground = ColorsTheme.OnBackground,
            onSurface = ColorsTheme.OnSurface,
            onError = ColorsTheme.OnError,
        ),
        typography = Typography(
            h3 = TextStyle(
                fontSize = 24.sp,
                fontWeight = FontWeight.W700,
                lineHeight = 24.sp,
            ),
            subtitle1 = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.W700,
                lineHeight = 17.sp,
            ),
            subtitle2 = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.W400,
                lineHeight = 17.sp,
            ),
            body1 = TextStyle(
                fontWeight = FontWeight.W400,
                fontSize = 14.sp,
                lineHeight = 14.sp,
            ),
            button = TextStyle(
                fontWeight = FontWeight.W400,
                fontSize = 16.sp,
                lineHeight = 17.sp,
                color = ColorsTheme.OnPrimary,
            ),
        ),
        content = content,
    )
}
