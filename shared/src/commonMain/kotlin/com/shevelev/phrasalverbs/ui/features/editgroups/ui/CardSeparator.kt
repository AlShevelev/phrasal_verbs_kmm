package com.shevelev.phrasalverbs.ui.features.editgroups.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.shevelev.phrasalverbs.core.ui.theme.ColorsGeneral

@Composable
internal fun CardSeparator(
    isSelected: Boolean,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .padding(vertical = 4.dp)
            .height(5.dp)
            .background(
                color = if (isSelected) {
                    ColorsGeneral.Green.copy(alpha = 0.25f)
                } else {
                    Color.Transparent
                },
                shape = RoundedCornerShape(5.dp),
            ),
    )
}
/*
Card - an issue with several items (verbs)
*/
