package com.shevelev.phrasalverbs.ui.features.selectgroup.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.shevelev.phrasalverbs.core.ui.elements.MenuButton
import com.shevelev.phrasalverbs.core.ui.elements.MenuButtonAlternative
import com.shevelev.phrasalverbs.core.ui.theme.ColorsTheme
import com.shevelev.phrasalverbs.core.ui.theme.Dimens
import com.shevelev.phrasalverbs.resources.MR
import com.shevelev.phrasalverbs.ui.features.selectgroup.viewmodel.SelectGroupItem
import com.shevelev.phrasalverbs.ui.features.selectgroup.viewmodel.SelectGroupState
import com.shevelev.phrasalverbs.ui.features.selectgroup.viewmodel.SelectGroupViewModel

@Composable
internal fun ContentState(
    modifier: Modifier = Modifier,
    state: SelectGroupState.Content,
    viewModel: SelectGroupViewModel,
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.padding(Dimens.padding),
    ) {
        LazyColumn(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            items(
                count = state.items.size,
            ) { index ->
                when (val item = state.items[index]) {
                    is SelectGroupItem.NewGroup -> {
                        MenuButtonAlternative(
                            text = MR.strings.create,
                            onClick = { viewModel.onNewGroupClick() },
                        )
                    }

                    is SelectGroupItem.Group -> {
                        MenuButton(
                            text = item.name,
                            onClick = { viewModel.onGroupClick(item.id) },
                        )
                    }
                }
            }
        }
    }
}
