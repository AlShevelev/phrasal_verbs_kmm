package com.shevelev.phrasalverbs.ui.features.editgroups.domain

import com.shevelev.phrasalverbs.ui.features.editgroups.domain.entities.CardLists
import com.shevelev.phrasalverbs.ui.features.editgroups.domain.entities.CardsListItem
import kotlin.math.absoluteValue

internal object CardDragResultCalculator {
    private class InListPosition(
        val list: List<CardsListItem>,
        val index: Int,
    )

    fun calculateUpdates(lists: CardLists, cardId: Long, separatorId: Long): CardLists {
        val dragStart = getInListPosition(lists, cardId)
        val dragEnd = getInListPosition(lists, separatorId)

        val dragStartListEditor = CardListEditor(dragStart.list)
        val dragEndListEditor = CardListEditor(dragEnd.list)

        if (dragStart.list == dragEnd.list) { // the same lists
            if ((dragStart.index - dragEnd.index).absoluteValue > 1) {
                val card = dragStartListEditor.removeAndGetCard(dragStart.index) // Card
                dragStartListEditor.remove(dragStart.index) // Separator

                val indexToAdd = if (dragEnd.index < dragStart.index) {
                    dragEnd.index
                } else {
                    dragEnd.index - 2
                }

                dragStartListEditor.addSeparatorAndCard(indexToAdd, card)
            }
        } else { // lists are different
            val card = dragStartListEditor.removeAndGetCard(dragStart.index) // Card

            if (dragStartListEditor.size > 1) {
                dragStartListEditor.remove(dragStart.index) // Separator
            }

            dragEndListEditor.addSeparatorAndCard(dragEnd.index, card)
        }

        val resultSourceList = if (dragStart.list == lists.sourceList) {
            dragStartListEditor.result
        } else {
            dragEndListEditor.result
        }

        val resultGroupsList = if (dragStart.list == lists.groupList) {
            dragStartListEditor.result
        } else {
            dragEndListEditor.result
        }

        return CardLists(
            sourceList = resultSourceList,
            groupList = resultGroupsList,
        )
    }

    private fun getInListPosition(lists: CardLists, id: Long): InListPosition {
        val index = lists.sourceList.indexOfFirst { it.id == id }
        if (index != -1) {
            return InListPosition(
                list = lists.sourceList,
                index = index,
            )
        }

        return InListPosition(
            list = lists.groupList,
            index = lists.groupList.indexOfFirst { it.id == id },
        )
    }
}
