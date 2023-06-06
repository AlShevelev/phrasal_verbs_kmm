package com.shevelev.phrasalverbs.ui.features.editgroups.viewmodel.data

internal interface DropTargetType {
    object SourceListGeneral : DropTargetType

    object GroupListGeneral : DropTargetType

    data class SourceListInside(
        val separatorId: Long,
    ) : DropTargetType

    data class GroupListInside(
        val separatorId: Long,
    ) : DropTargetType
}
