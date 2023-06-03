package com.shevelev.phrasalverbs.ui.features.watchallcards.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.shevelev.phrasalverbs.core.ui.theme.Dimens
import com.shevelev.phrasalverbs.ui.features.watchallcards.viewmodel.WatchAllCardsState
import com.shevelev.phrasalverbs.ui.features.watchallcards.viewmodel.WatchAllCardsViewModel

@Composable
internal fun ContentState(
    modifier: Modifier = Modifier,
    state: WatchAllCardsState.Content,
    viewModel: WatchAllCardsViewModel,
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = Dimens.padding),
    ) {
        items(
            count = state.cardsProvider.count,
            key = { index -> state.cardsProvider.getKey(index) },
        ) { index ->
            val card = state.cardsProvider.getItem(index)
            CardFull(
                modifier = Modifier
                    .padding(bottom = Dimens.padding)
                    .padding(top = if (index == 0) Dimens.padding else 0.dp),
                card = card,
                isRussianSideDefault = state.isRussianSideDefault,
            )
        }
    }
}
