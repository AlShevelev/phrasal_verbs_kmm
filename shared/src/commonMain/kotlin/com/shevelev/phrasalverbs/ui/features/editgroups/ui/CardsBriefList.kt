package com.shevelev.phrasalverbs.ui.features.editgroups.ui

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.shevelev.phrasalverbs.domain.entities.Card
import com.shevelev.phrasalverbs.ui.features.editgroups.domain.entities.CardsListItem

@Composable
/**
 * [onDrop] the second param is id of a separator
 */
internal fun CardsBriefList(
    cards: List<CardsListItem>,
    modifier: Modifier = Modifier,
    onDrop: (Card, Long) -> Unit,
) {
    var priorItemsTotalHeight = 0.dp

    cards.forEach {
        priorItemsTotalHeight += when (it) {
            is CardsListItem.SeparatorItem -> CardListDimens.separatorHeightTotal
            is CardsListItem.CardItem -> CardListDimens.cardHeight
        }
    }

    BoxWithConstraints(
        modifier = modifier,
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
        ) {
            items(
                count = cards.size,
                key = { index -> cards[index].id },
            ) { index ->
                when (val item = cards[index]) {
                    is CardsListItem.SeparatorItem -> {
                        CardSeparator(
                            priorItemsTotalHeight = if (index == cards.lastIndex) {
                                priorItemsTotalHeight
                            } else {
                                null
                            },
                            listHeight = maxHeight,
                            modifier = Modifier.fillMaxWidth(),
                            onDrop = { onDrop(it, item.id) },
                        )
                    }

                    is CardsListItem.CardItem -> {
                        CardBrief(
                            item = item,
                        )
                    }
                }
            }
        }
    }
}
