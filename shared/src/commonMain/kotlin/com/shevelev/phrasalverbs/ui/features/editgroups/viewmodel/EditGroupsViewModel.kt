package com.shevelev.phrasalverbs.ui.features.editgroups.viewmodel

import com.shevelev.phrasalverbs.core.ui.viewmodel.ViewModel
import com.shevelev.phrasalverbs.domain.entities.Card
import com.shevelev.phrasalverbs.ui.features.editgroups.viewmodel.data.DropTargetType
import kotlinx.coroutines.flow.StateFlow

internal interface EditGroupsViewModel : ViewModel {
    val state: StateFlow<EditGroupsState>

    fun onBackClick()

    fun onDropCard(card: Card, target: DropTargetType)
}
