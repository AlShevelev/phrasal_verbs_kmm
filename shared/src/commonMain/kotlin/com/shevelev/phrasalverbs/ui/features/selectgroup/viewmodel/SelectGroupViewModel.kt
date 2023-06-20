package com.shevelev.phrasalverbs.ui.features.selectgroup.viewmodel

import com.shevelev.phrasalverbs.core.ui.viewmodel.ViewModel
import kotlinx.coroutines.flow.StateFlow

internal interface SelectGroupViewModel : ViewModel {
    val state: StateFlow<SelectGroupState>

    fun init(isAddNewButtonVisible: Boolean)

    fun onBackClick()

    fun onNewGroupClick()

    fun onGroupClick(groupId: Long)
}
