package com.shevelev.phrasalverbs.ui.features.editgroups.domain

import com.shevelev.phrasalverbs.ui.features.editgroups.domain.entities.CardLists

internal interface CardListsLogicFacade {
    suspend fun getStartLists(): CardLists

    fun processDropCard(lists: CardLists, cardId: Long, separatorId: Long): CardLists
}
