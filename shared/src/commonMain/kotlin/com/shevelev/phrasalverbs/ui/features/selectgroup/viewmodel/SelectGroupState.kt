package com.shevelev.phrasalverbs.ui.features.selectgroup.viewmodel

internal sealed interface SelectGroupState {
    object Loading : SelectGroupState

    data class Content(
        val items: List<SelectGroupItem>,
    ) : SelectGroupState
}
