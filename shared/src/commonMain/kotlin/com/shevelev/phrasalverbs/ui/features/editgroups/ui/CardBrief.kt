package com.shevelev.phrasalverbs.ui.features.editgroups.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.shevelev.phrasalverbs.core.ui.theme.Dimens
import com.shevelev.phrasalverbs.domain.entities.Card
import com.shevelev.phrasalverbs.domain.entities.Language

@OptIn(ExperimentalMaterialApi::class)
@Composable
internal fun CardBrief(
    card: Card,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier
            .height(120.dp)
            .fillMaxWidth(),
        elevation = Dimens.elevation,
        shape = RoundedCornerShape(7.dp),
        onClick = { },
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(all = Dimens.padding),
        ) {
            card.side[Language.ENGLISH]?.let {
                it.mainItems.forEachIndexed { index, text ->
                    Text(
                        text = text.value,
                        style = MaterialTheme.typography.body1,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(
                            top = if (index == 0) 0.dp else Dimens.paddingSmall,
                        ),
                        fontWeight = FontWeight.Bold,
                    )
                }
            }
        }
    }
}
