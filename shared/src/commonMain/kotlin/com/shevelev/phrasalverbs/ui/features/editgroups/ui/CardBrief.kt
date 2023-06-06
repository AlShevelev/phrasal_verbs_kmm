package com.shevelev.phrasalverbs.ui.features.editgroups.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.shevelev.phrasalverbs.core.ui.theme.ColorsGeneral
import com.shevelev.phrasalverbs.core.ui.theme.Dimens
import com.shevelev.phrasalverbs.domain.entities.Language
import com.shevelev.phrasalverbs.ui.features.editgroups.viewmodel.data.CardsListItem

@OptIn(ExperimentalMaterialApi::class)
@Composable
internal fun CardBrief(
    item: CardsListItem.CardItem,
    modifier: Modifier = Modifier,
) {
    DragTarget(
        dataToDrop = item.card,
    ) { contentModifier ->
        Card(
            modifier = contentModifier.height(120.dp),
            elevation = Dimens.elevation,
            shape = RoundedCornerShape(7.dp),
            border = BorderStroke(
                width = 1.dp,
                brush = SolidColor(ColorsGeneral.LightGray),
            ),
            onClick = { },
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(all = Dimens.padding),
            ) {
                item.card.side[Language.ENGLISH]?.let {
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
}
