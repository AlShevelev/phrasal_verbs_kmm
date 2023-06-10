package com.shevelev.phrasalverbs.ui.features.editgroups.domain

import com.shevelev.phrasalverbs.core.idgenerator.IdGenerator
import com.shevelev.phrasalverbs.domain.entities.Card
import com.shevelev.phrasalverbs.ui.features.editgroups.domain.entities.CardsListItem

internal class CardListEditor(
    source: List<CardsListItem>,
) {
    constructor() : this(listOf())

    private val sourceMutable = source.toMutableList()

    val result: List<CardsListItem>
        get() = sourceMutable

    val size: Int
        get() = sourceMutable.size

    fun addSeparator() = sourceMutable.add(createSeparator())

    fun addCard(card: Card) = sourceMutable.add(CardsListItem.CardItem(card = card))

    fun addSeparatorAndCard(index: Int, card: Card) {
        add(
            index,
            createSeparator(),
            CardsListItem.CardItem(card),
        )
    }

    fun add(index: Int, vararg card: CardsListItem) {
        sourceMutable.addAll(index, card.toList())
    }

    fun removeAndGetCard(index: Int): Card {
        val card = (sourceMutable[index] as CardsListItem.CardItem).card

        remove(index)

        return card
    }

    fun remove(index: Int) = sourceMutable.removeAt(index)

    private fun createSeparator() =
        CardsListItem.SeparatorItem(
            id = IdGenerator.newId(),
        )
}
