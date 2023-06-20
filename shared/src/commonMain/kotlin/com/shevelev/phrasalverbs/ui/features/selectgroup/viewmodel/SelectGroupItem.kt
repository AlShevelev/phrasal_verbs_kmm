package com.shevelev.phrasalverbs.ui.features.selectgroup.viewmodel

internal interface SelectGroupItem {
    object NewGroup : SelectGroupItem

    data class Group(
        val id: Long,
        val name: String,
    ) : SelectGroupItem
}
