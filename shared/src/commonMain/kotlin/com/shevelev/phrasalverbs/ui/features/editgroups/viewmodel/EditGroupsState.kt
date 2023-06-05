package com.shevelev.phrasalverbs.ui.features.editgroups.viewmodel

import com.shevelev.phrasalverbs.ui.features.editgroups.viewmodel.data.CardsListItem

internal sealed interface EditGroupsState {
    object Loading : EditGroupsState

    data class Content(
        val mainList: List<CardsListItem>,
        val groupList: List<CardsListItem>,
    ) : EditGroupsState
}
