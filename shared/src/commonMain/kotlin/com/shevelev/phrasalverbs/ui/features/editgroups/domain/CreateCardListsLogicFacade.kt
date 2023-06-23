package com.shevelev.phrasalverbs.ui.features.editgroups.domain

import com.shevelev.phrasalverbs.data.repository.appstorage.CardsRepository
import com.shevelev.phrasalverbs.domain.entities.Card
import com.shevelev.phrasalverbs.ui.features.editgroups.domain.entities.CardLists
import com.shevelev.phrasalverbs.ui.features.editgroups.domain.entities.CardsListItem

internal open class CreateCardListsLogicFacade(
    protected val cardsRepository: CardsRepository,
) : CardListsLogicFacade {

    override suspend fun getStartLists(): CardLists =
        CardLists(
            sourceList = getList(cardsRepository.getAllCards()),
            groupList = getList(emptyList()),
        )

    override fun processDropCard(lists: CardLists, cardId: Long, separatorId: Long): CardLists =
        CardDragResultCalculator.calculateUpdates(lists, cardId, separatorId)

    protected fun getList(cards: List<Card>): List<CardsListItem> {
        val editor = CardListEditor()

        editor.addSeparator()

        cards.forEach {
            editor.addCard(it)
            editor.addSeparator()
        }

        return editor.result
    }
}
