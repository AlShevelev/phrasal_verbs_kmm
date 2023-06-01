package com.shevelev.phrasalverbs.ui.features.watchallcards.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.HorizontalAlignmentLine
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.shevelev.phrasalverbs.core.ui.theme.Dimens
import com.shevelev.phrasalverbs.domain.entities.Card
import com.shevelev.phrasalverbs.domain.entities.CardContentItem
import com.shevelev.phrasalverbs.domain.entities.Language

@Composable
internal fun CardFull(
    modifier: Modifier = Modifier,
    card: Card,
    isRussianSideDefault: Boolean,
) {
    val side = if (isRussianSideDefault) {
        card.side[Language.RUSSIAN]
    } else {
        card.side[Language.ENGLISH]
    }

    Card(
        modifier = modifier
            .height(250.dp)
            .fillMaxWidth(),
        elevation = Dimens.elevation,
        shape = RoundedCornerShape(15.dp),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(all = Dimens.margin),
        ) {
            with(side!!) {
                Clarification(
                    item = clarification,
                )

                Spacer(
                    modifier = Modifier.weight(1f),
                )

                MainItems(
                    items = mainItems,
                )

                Spacer(
                    modifier = Modifier.weight(1f),
                )

                Examples(
                    items = examples,
                )
            }
        }
    }
}

@Composable
private fun Clarification(
    item: CardContentItem?,
    modifier: Modifier = Modifier,
) {
    Text(
        text = item?.value ?: " ",
        modifier = modifier,
        style = MaterialTheme.typography.body1,
        fontStyle = FontStyle.Italic,
    )
}

@Composable
private fun MainItems(
    items: List<CardContentItem>,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        items.forEachIndexed { index, item ->
            Text(
                text = item.value,
                style = MaterialTheme.typography.h4,
                modifier = Modifier
                    .padding(top = if (index > 0) Dimens.marginSmall else 0.dp),
                textAlign = TextAlign.Center,
            )

            item.description?.let {
                Text(
                    text = it,
                    style = MaterialTheme.typography.subtitle1,
                    modifier = Modifier,
                )
            }
        }
    }
}

@Composable
private fun Examples(
    items: List<CardContentItem>,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        items.forEachIndexed { index, item ->
            Text(
                text = item.value,
                style = MaterialTheme.typography.subtitle2,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(top = if (index > 0) Dimens.marginSmall else 0.dp),
            )
        }
    }
}
