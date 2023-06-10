package com.shevelev.phrasalverbs.ui.features.editgroups.viewmodel

import com.shevelev.phrasalverbs.ui.features.editgroups.domain.entities.CardsListItem

internal sealed interface EditGroupsState {
    object Loading : EditGroupsState

    data class Content(
        val sourceList: List<CardsListItem>,
        val groupList: List<CardsListItem>,
    ) : EditGroupsState
}
