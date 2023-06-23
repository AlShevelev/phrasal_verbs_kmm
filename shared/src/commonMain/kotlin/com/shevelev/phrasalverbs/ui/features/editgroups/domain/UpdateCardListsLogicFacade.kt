package com.shevelev.phrasalverbs.ui.features.editgroups.domain

import com.shevelev.phrasalverbs.core.exclude
import com.shevelev.phrasalverbs.data.repository.appstorage.CardsRepository
import com.shevelev.phrasalverbs.ui.features.editgroups.domain.entities.CardLists

internal class UpdateCardListsLogicFacade(
    cardsRepository: CardsRepository,
    private val groupId: Long,
) : CreateCardListsLogicFacade(cardsRepository) {
    override suspend fun getStartLists(): CardLists {
        val allCards = cardsRepository.getAllCards()
        val group = cardsRepository.getGroup(groupId)

        return CardLists(
            sourceList = getList(allCards.exclude(group.cards) { l, r -> l.id == r.id }),
            groupList = getList(group.cards),
        )
    }
}
