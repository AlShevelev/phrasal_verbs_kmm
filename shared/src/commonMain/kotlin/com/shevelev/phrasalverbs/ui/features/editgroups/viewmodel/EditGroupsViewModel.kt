package com.shevelev.phrasalverbs.ui.features.editgroups.viewmodel

import com.shevelev.phrasalverbs.core.ui.viewmodel.ViewModel
import kotlinx.coroutines.flow.StateFlow

internal interface EditGroupsViewModel : ViewModel {
    val state: StateFlow<EditGroupsState>

    fun onBackClick()

    fun onDropCard(cardId: Long, separatorId: Long)
}
