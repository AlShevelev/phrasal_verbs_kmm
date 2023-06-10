package com.shevelev.phrasalverbs.ui.features.editgroups.domain

import com.shevelev.phrasalverbs.data.repository.appstorage.CardsRepository
import com.shevelev.phrasalverbs.domain.entities.Card
import com.shevelev.phrasalverbs.ui.features.editgroups.domain.entities.CardLists
import com.shevelev.phrasalverbs.ui.features.editgroups.domain.entities.CardsListItem

internal class CardListsLogicFacadeImpl(
    private val cardsRepository: CardsRepository,
) : CardListsLogicFacade {

    override suspend fun getStartLists(): CardLists =
        CardLists(
            sourceList = getSourceList(cardsRepository.getAllCards()),
            groupList = getGroupsList(),
        )

    override fun processDropCard(lists: CardLists, cardId: Long, separatorId: Long): CardLists =
        CardDragResultCalculator.calculateUpdates(lists, cardId, separatorId)

    private fun getSourceList(allCards: List<Card>): List<CardsListItem> {
        val editor = CardListEditor()

        editor.addSeparator()

        allCards.forEach {
            editor.addCard(it)
            editor.addSeparator()
        }

        return editor.result
    }

    private fun getGroupsList(): List<CardsListItem> {
        val editor = CardListEditor()

        editor.addSeparator()

        return editor.result
    }
}
