package com.shevelev.phrasalverbs.ui.features.editgroups.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.shevelev.phrasalverbs.ui.features.editgroups.viewmodel.data.CardsListItem

@Composable
internal fun CardsBriefList(
    cards: List<CardsListItem>,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier,
    ) {
        items(
            count = cards.size,
            key = { index -> cards[index].id },
        ) { index ->
            when (val item = cards[index]) {
                is CardsListItem.SeparatorItem -> {
                    CardSeparator(
                        isSelected = item.selected,
                        modifier = Modifier.fillMaxWidth(),
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
