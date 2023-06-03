package com.shevelev.phrasalverbs.domain.usecases.batchupdate.batches

import com.shevelev.phrasalverbs.data.repository.appstorage.CardsRepository
import com.shevelev.phrasalverbs.domain.entities.Card
import com.shevelev.phrasalverbs.domain.entities.CardContentItem
import com.shevelev.phrasalverbs.domain.entities.CardSide
import com.shevelev.phrasalverbs.domain.entities.Language

internal class SyncCardsVersion1Batch(
    private val repository: CardsRepository,
) : SyncCardsBatch {

    private var idCounter = 1L

    override val version: Int
        get() = 1

    override suspend fun update() {
        createCard1()
        createCard2()
        createCard3()
        createCard4()
        createCard5()
        createCard6()
        createCard7()
        createCard8()
        createCard9()
        createCard10()

        createCard11()
        createCard12()
        createCard13()
        createCard14()
        createCard15()
        createCard16()
        createCard17()
        createCard18()
        createCard19()
        createCard20()

        createCard21()
        createCard22()
        createCard23()
        createCard24()
        createCard25()
        createCard26()
        createCard27()
        createCard28()
        createCard29()
        createCard30()

        createCard31()
        createCard32()
        createCard33()
        createCard34()
        createCard35()
        createCard36()
        createCard37()
        createCard38()
        createCard39()
        createCard40()

        createCard41()
        createCard42()
        createCard43()
        createCard44()
        createCard45()
        createCard46()
        createCard47()
        createCard48()
        createCard49()
        createCard50()

        createCard51()
        createCard52()
        createCard53()
        createCard54()
        createCard55()
        createCard56()
        createCard57()
        createCard58()
        createCard59()
        createCard60()

        createCard61()
        createCard62()
        createCard63()
        createCard64()
        createCard65()
        createCard66()
        createCard67()
        createCard68()
        createCard69()
        createCard70()

        createCard71()
        createCard72()
        createCard73()
        createCard74()
        createCard75()
        createCard76()
        createCard77()
        createCard78()
        createCard79()
        createCard80()

        createCard81()
        createCard82()
        createCard83()
        createCard84()
        createCard85()
        createCard86()
        createCard87()
        createCard88()
        createCard89()
        createCard90()

        createCard91()
        createCard92()
        createCard93()
        createCard94()
        createCard95()
        createCard96()
        createCard97()
        createCard98()
        createCard99()
        createCard100()

        createCard101()
        createCard102()
        createCard103()
        createCard104()
        createCard105()
        createCard106()
        createCard107()
        createCard108()
        createCard109()
        createCard110()

        createCard111()
        createCard112()
        createCard113()
        createCard114()
        createCard115()
        createCard116()
        createCard117()
        createCard118()
        createCard119()
        createCard120()

        createCard121()
        createCard122()
        createCard123()
        createCard124()
        createCard125()
        createCard126()
        createCard127()
        createCard128()
        createCard129()
        createCard130()

        createCard131()
        createCard132()
        createCard133()
        createCard134()
        createCard135()
        createCard136()
        createCard137()
        createCard138()
        createCard139()
        createCard140()

        createCard141()
        createCard142()
        createCard143()
        createCard144()
        createCard145()
        createCard146()
        createCard147()
        createCard148()
        createCard149()
        createCard150()

        createCard151()
        createCard152()
        createCard153()
        createCard154()
        createCard155()
        createCard156()
        createCard157()
        createCard158()
        createCard159()
        createCard160()

        createCard161()
        createCard162()
        createCard163()
        createCard164()
        createCard165()
        createCard166()
        createCard167()
        createCard168()
        createCard169()
        createCard170()

        createCard171()
    }

    private suspend fun createCard1() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("intransitive"),
                mainItems = listOf(
                    CardContentItem(
                        value = "add up",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Your story is impressive but it doesn't add up"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("непереходный"),
                mainItems = listOf(
                    CardContentItem(
                        value = "складываться",
                        description = "о фактах, истории",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Твоя история впечатляет, но что-то в ней не складывается"),
                ),
            ),
        )

    private suspend fun createCard2() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("separable (always)"),
                mainItems = listOf(
                    CardContentItem(
                        value = "ask [somebody] out",
                        valueVoicing = "ask somebody out",
                    ),
                ),
                examples = listOf(
                    CardContentItem("I asked her out and she said yes"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("всегда разделяемый"),
                mainItems = listOf(
                    CardContentItem(
                        value = "пригласить сходить куда-нибудь",
                        description = "обычно о свидании",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Я пригласил ее на свидание, и она сказала \"да\""),
                ),
            ),
        )

    private suspend fun createCard3() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("inseparable"),
                mainItems = listOf(
                    CardContentItem(
                        value = "be after [something]",
                        valueVoicing = "be after something",
                    ),
                ),
                examples = listOf(
                    CardContentItem("He is after my job"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("неразделяемый"),
                mainItems = listOf(
                    CardContentItem("пытаться что-то заполучить"),
                ),
                examples = listOf(
                    CardContentItem("Он пытается заполучить мою работу"),
                ),
            ),
        )

    private suspend fun createCard4() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("intransitive"),
                mainItems = listOf(
                    CardContentItem(
                        value = "be away",
                    ),
                ),
                examples = listOf(
                    CardContentItem("He is away on vacation"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("непереходный"),
                mainItems = listOf(
                    CardContentItem("отсутствовать, уехать"),
                ),
                examples = listOf(
                    CardContentItem("Он уехал в отпуск"),
                ),
            ),
        )

    private suspend fun createCard5() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("inseparable"),
                mainItems = listOf(
                    CardContentItem(
                        value = "be down with [something]",
                        valueVoicing = "be down with something",
                    ),
                ),
                examples = listOf(
                    CardContentItem("I can't go to school, I'm down with the cold"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("неразделяемый"),
                mainItems = listOf(
                    CardContentItem(value = "приболеть чем-то", description = "несерьезным"),
                ),
                examples = listOf(
                    CardContentItem("Я не могу пойти в школу я приболел простудой (простудился)"),
                ),
            ),
        )

    private suspend fun createCard6() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("inseparable"),
                mainItems = listOf(
                    CardContentItem(
                        value = "be fed up with [something]",
                        valueVoicing = "be fed up with something",
                    ),
                ),
                examples = listOf(
                    CardContentItem("We are fed up with your lies!"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("неразделяемый"),
                mainItems = listOf(
                    CardContentItem("быть сытым чем-то по горло"),
                ),
                examples = listOf(
                    CardContentItem("Мы сыты по горло твоей ложью!"),
                ),
            ),
        )

    private suspend fun createCard7() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("intransitive"),
                mainItems = listOf(
                    CardContentItem(value = "be in/out", valueVoicing = "be in or out"),
                ),
                examples = listOf(
                    CardContentItem("Someone is in"),
                    CardContentItem("He is out"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("непереходный"),
                mainItems = listOf(
                    CardContentItem(
                        value = "присутствовать/отсутствовать",
                        description = "обычно дома или на работе",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Кто-то (есть) дома"),
                    CardContentItem("Его (здесь) нет"),
                ),
            ),
        )

    private suspend fun createCard8() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("intransitive"),
                mainItems = listOf(
                    CardContentItem(
                        value = "be on/off",
                        valueVoicing = "be on or off",
                    ),
                ),
                examples = listOf(
                    CardContentItem("The phone is on now"),
                    CardContentItem("The phone is off now"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("непереходный"),
                mainItems = listOf(
                    CardContentItem(
                        value = "быть включенным/выключенным",
                        valueVoicing = "быть включенным или выключенным",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Телефон сейчас включен"),
                    CardContentItem("Телефон сейчас выключен"),
                ),
            ),
        )

    private suspend fun createCard9() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("inseparable"),
                mainItems = listOf(
                    CardContentItem(
                        value = "be up to [somebody]",
                        valueVoicing = "be up to somebody",
                    ),
                ),
                examples = listOf(
                    CardContentItem("It's up to you to decide"),
                    CardContentItem("It's up to the captain to make the final decision"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("неразделяемый"),
                mainItems = listOf(
                    CardContentItem(value = "зависеть от кого-то", description = "о принятии решения"),
                ),
                examples = listOf(
                    CardContentItem("Это тебе решать"),
                    CardContentItem("Финальное решение за капитаном (он решает)"),
                ),
            ),
        )

    private suspend fun createCard10() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("inseparable"),
                mainItems = listOf(
                    CardContentItem(
                        value = "be up to [something]",
                        valueVoicing = "be up to something",
                    ),
                ),
                examples = listOf(
                    CardContentItem("He is up to something really bad"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("неразделяемый"),
                mainItems = listOf(
                    CardContentItem(
                        value = "замышлять",
                        description = "обычно что-то плохое",
                    ),
                    CardContentItem("собираться сделать"),
                ),
                examples = listOf(
                    CardContentItem("Он замыслил что-то действительно плохое"),
                ),
            ),
        )

    private suspend fun createCard11() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("intransitive"),
                mainItems = listOf(
                    CardContentItem(
                        value = "break down",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Sorry, I'm late, my car broke down"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("непереходный"),
                mainItems = listOf(
                    CardContentItem(
                        value = "сломаться",
                        description = "о машине, механизме",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Извините за опоздание, моя машина сломалась"),
                ),
            ),
        )

    private suspend fun createCard12() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("separable"),
                mainItems = listOf(
                    CardContentItem(
                        value = "break [something] down",
                        valueVoicing = "break something down",
                    ),
                ),
                examples = listOf(
                    CardContentItem("You broke down my glasses"),
                    CardContentItem("Let's break down this text"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("разделяемый"),
                mainItems = listOf(
                    CardContentItem(
                        value = "сломать",
                    ),
                    CardContentItem(
                        value = "объяснить, разобрать",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Вы сломали мои очки"),
                    CardContentItem("Давайте разберем этот текст"),
                ),
            ),
        )

    private suspend fun createCard13() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("inseparable or intransitive"),
                mainItems = listOf(
                    CardContentItem(
                        value = "break up (with somebody)",
                        valueVoicing = "break up (with somebody)",
                    ),
                ),
                examples = listOf(
                    CardContentItem("We broke up"),
                    CardContentItem("Larry and Jane broke up"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("неразделяемый или непереходный"),
                mainItems = listOf(
                    CardContentItem(
                        value = "расставаться",
                        description = "об отношениях",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Мы расстались"),
                    CardContentItem("Ларри и Джейн расстались"),
                ),
            ),
        )

    private suspend fun createCard14() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("separable"),
                mainItems = listOf(
                    CardContentItem(
                        value = "bring [somebody] up",
                        valueVoicing = "bring somebody up",
                    ),
                ),
                examples = listOf(
                    CardContentItem("They have no idea how to bring up children"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("разделяемый"),
                mainItems = listOf(
                    CardContentItem(
                        value = "воспитывать",
                        description = "о воспитании детей",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Они понятия не имеют, как воспитывать детей"),
                ),
            ),
        )

    private suspend fun createCard15() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("separable"),
                mainItems = listOf(
                    CardContentItem(
                        value = "bring [something] up",
                        valueVoicing = "bring something up",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Please, don't bring up business at lunch"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("разделяемый"),
                mainItems = listOf(
                    CardContentItem(
                        value = "упоминать что-то, поднять тему",
                        description = "в разговоре",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Пожалуйста, не говорите о бизнесе за обедом"),
                ),
            ),
        )

    private suspend fun createCard16() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("separable"),
                mainItems = listOf(
                    CardContentItem(
                        value = "call [somebody] back",
                        valueVoicing = "call somebody back",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Thank you for coming, we'll call you back"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("разделяемый"),
                mainItems = listOf(
                    CardContentItem(
                        value = "перезванивать кому-то",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Спасибо, что пришли, мы вам перезвоним"),
                ),
            ),
        )

    private suspend fun createCard17() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("separable"),
                mainItems = listOf(
                    CardContentItem(
                        value = "calm [somebody] down",
                        valueVoicing = "calm somebody down",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Calm down!"),
                    CardContentItem("Could you calm your dog down, please?"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("разделяемый"),
                mainItems = listOf(
                    CardContentItem(
                        value = "успокоить (-ся)",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Успокойся!"),
                    CardContentItem("Не могли бы вы успокоить свою собаку, пожалуйста?"),
                ),
            ),
        )

    private suspend fun createCard18() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("intransitive"),
                mainItems = listOf(
                    CardContentItem(
                        value = "check in/out",
                        valueVoicing = "check in or check out",
                    ),
                ),
                examples = listOf(
                    CardContentItem("I'll check in at front desk and get our key"),
                    CardContentItem("We check out at 10 a.m."),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("непереходный"),
                mainItems = listOf(
                    CardContentItem(
                        value = "регистироваться в гостинице/выписываться",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Я зарегистрируюсь в приемной и возьму наш ключ"),
                    CardContentItem("Мы уезжаем (выселяемся) в 10 утра"),
                ),
            ),
        )

    private suspend fun createCard19() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("separable"),
                mainItems = listOf(
                    CardContentItem(
                        value = "check out [somebody or something]",
                        valueVoicing = "check out somebody or something",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Check out my new phone"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("разделяемый"),
                mainItems = listOf(
                    CardContentItem(
                        value = "\"заценить\" что-то, кого-то",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Зацени мой новый телефон"),
                ),
            ),
        )

    private suspend fun createCard20() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("inseparable"),
                mainItems = listOf(
                    CardContentItem(
                        value = "come across [something]",
                        valueVoicing = "come across something",
                    ),
                ),
                examples = listOf(
                    CardContentItem("I came across your photo in the desk"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("неразделяемый"),
                mainItems = listOf(
                    CardContentItem(
                        value = "случайно наткнуться на что-то",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Я наткнулся на твое фото в столе"),
                ),
            ),
        )

    private suspend fun createCard21() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("intransitive"),
                mainItems = listOf(
                    CardContentItem("come apart"),
                ),
                examples = listOf(
                    CardContentItem("Your boots are coming apart"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("непереходный"),
                mainItems = listOf(
                    CardContentItem("развалиться на части"),
                ),
                examples = listOf(
                    CardContentItem("Твои ботинки разваливаются"),
                ),
            ),
        )

    private suspend fun createCard22() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("intransitive"),
                mainItems = listOf(
                    CardContentItem("come back"),
                ),
                examples = listOf(
                    CardContentItem("Go away and never come back!"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("непереходный"),
                mainItems = listOf(
                    CardContentItem(
                        value = "вернуться",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Уходи и никогда не возвращайся!"),
                ),
            ),
        )

    private suspend fun createCard23() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("inseparable"),
                mainItems = listOf(
                    CardContentItem(
                        value = "come down with [something]",
                        valueVoicing = "come down with something",
                    ),
                ),
                examples = listOf(
                    CardContentItem("I'm coming down with the cold"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("неразделяемый"),
                mainItems = listOf(
                    CardContentItem("начать чем-то болеть"),
                ),
                examples = listOf(
                    CardContentItem("У меня начинается простуда"),
                ),
            ),
        )

    private suspend fun createCard24() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("intransitive"),
                mainItems = listOf(
                    CardContentItem("come from"),
                ),
                examples = listOf(
                    CardContentItem("Where do you come from?"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("непереходный"),
                mainItems = listOf(
                    CardContentItem(
                        value = "быть откуда-то",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Откуда ты?"),
                ),
            ),
        )

    private suspend fun createCard25() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("intransitive"),
                mainItems = listOf(
                    CardContentItem("come in"),
                ),
                examples = listOf(
                    CardContentItem("Come in, please!"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("непереходный"),
                mainItems = listOf(
                    CardContentItem("входить"),
                ),
                examples = listOf(
                    CardContentItem("Войдите, пожалуйста!"),
                ),
            ),
        )

    private suspend fun createCard26() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("intransitive"),
                mainItems = listOf(
                    CardContentItem("come off"),
                ),
                examples = listOf(
                    CardContentItem("The door knob came off"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("непереходный"),
                mainItems = listOf(
                    CardContentItem("отвалиться"),
                ),
                examples = listOf(
                    CardContentItem("Дверная ручка отвалилась"),
                ),
            ),
        )

    private suspend fun createCard27() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("intransitive"),
                mainItems = listOf(
                    CardContentItem("Come on!"),
                ),
                examples = listOf(
                    CardContentItem("Come on! You can do it!"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("непереходный"),
                mainItems = listOf(
                    CardContentItem("Давай! Вперед!"),
                ),
                examples = listOf(
                    CardContentItem("Давай! Ты можешь это сделать!"),
                ),
            ),
        )

    private suspend fun createCard28() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("intransitive"),
                mainItems = listOf(
                    CardContentItem("come out"),
                ),
                examples = listOf(
                    CardContentItem("That movie is coming out in March"),
                    CardContentItem("His secrets came out"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("непереходный"),
                mainItems = listOf(
                    CardContentItem(value = "выходить в свет, раскрываться", description = "о тайне"),
                ),
                examples = listOf(
                    CardContentItem("Этот фильм выходит в марте"),
                    CardContentItem("Его секреты стали известны"),
                ),
            ),
        )

    private suspend fun createCard29() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("intransitive"),
                mainItems = listOf(
                    CardContentItem("come over"),
                ),
                examples = listOf(
                    CardContentItem("I'm gonna need your help. Can you come over?"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("непереходный"),
                mainItems = listOf(
                    CardContentItem("прийти к кому-то"),
                ),
                examples = listOf(
                    CardContentItem("Мне понадобится твоя помощь. Можешь зайти?"),
                ),
            ),
        )

    private suspend fun createCard30() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("intransitive"),
                mainItems = listOf(
                    CardContentItem("come round (around)", valueVoicing = "come round"),
                ),
                examples = listOf(
                    CardContentItem("The patient came round"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("непереходный"),
                mainItems = listOf(
                    CardContentItem("прийти в себя"),
                ),
                examples = listOf(
                    CardContentItem("Пациент пришел в себя"),
                ),
            ),
        )

    private suspend fun createCard31() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("inseparable"),
                mainItems = listOf(
                    CardContentItem(
                        value = "come up with [something]",
                        valueVoicing = "come up with something",
                    ),
                ),
                examples = listOf(
                    CardContentItem("I came up with a great idea!"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("неразделяемый"),
                mainItems = listOf(
                    CardContentItem("придумывать что-то, додумываться"),
                ),
                examples = listOf(
                    CardContentItem("Я придумал отличную идею! (пришла в голову отличная идея)"),
                ),
            ),
        )

    private suspend fun createCard32() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("inseparable"),
                mainItems = listOf(
                    CardContentItem(
                        value = "count on [somebody]",
                        valueVoicing = "count on somebody",
                    ),
                    CardContentItem(
                        value = "rely on [somebody]",
                        valueVoicing = "rely on somebody",
                    ),
                ),
                examples = listOf(
                    CardContentItem("You can always count on me"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("неразделяемый"),
                mainItems = listOf(
                    CardContentItem(
                        value = "полагаться на кого-то",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Ты всегда можешь на меня положиться"),
                ),
            ),
        )

    private suspend fun createCard33() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("intransitive"),
                mainItems = listOf(
                    CardContentItem(
                        value = "dress up",
                    ),
                ),
                examples = listOf(
                    CardContentItem("This is a formal event, you'll need to dress up"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("непереходный"),
                mainItems = listOf(
                    CardContentItem(
                        value = "нарядиться, официально одеться",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Это официальное мероприятие, тебе нужно будет одеться подобающе (нарядиться)"),
                ),
            ),
        )

    private suspend fun createCard34() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("inseparable"),
                mainItems = listOf(
                    CardContentItem(
                        value = "dress up as [somebody]",
                        valueVoicing = "dress up as somebody",
                    ),
                ),
                examples = listOf(
                    CardContentItem("She dressed up as a witch for Halloween"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("неразделяемый"),
                mainItems = listOf(
                    CardContentItem(
                        value = "нарядиться кем-то, переодеться",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Она нарядилась ведьмой на Хеллоуин"),
                ),
            ),
        )

    private suspend fun createCard35() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("separable"),
                mainItems = listOf(
                    CardContentItem(
                        value = "drop [somebody] off",
                        valueVoicing = "drop somebody off",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Drop me off by that building, please"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("разделяемый"),
                mainItems = listOf(
                    CardContentItem(
                        value = "высадить пассажира",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Остановите (чтобы я вышел) у того здания, пожалуйста"),
                ),
            ),
        )

    private suspend fun createCard36() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("inseparable"),
                mainItems = listOf(
                    CardContentItem(
                        value = "end up [doing something]",
                        valueVoicing = "end up doing something",
                    ),
                ),
                examples = listOf(
                    CardContentItem("I wanted to become a famous artist, but ended up drawing comic books"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("неразделяемый"),
                mainItems = listOf(
                    CardContentItem(
                        value = "в итоге делать что-то",
                    ),
                    CardContentItem(
                        value = "закончить тем, что делать что-то",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Я хотел стать знаменитым художником, а закончил тем, что рисую комиксы"),
                ),
            ),
        )

    private suspend fun createCard37() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("intransitive"),
                mainItems = listOf(
                    CardContentItem("fall apart"),
                ),
                examples = listOf(
                    CardContentItem("The house fell apart"),
                    CardContentItem("After the accident, he fell apart"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("непереходный"),
                mainItems = listOf(
                    CardContentItem("разваливаться на части"),
                    CardContentItem(
                        value = "упасть духом, \"сдать\"",
                        description = "о человеке, переживающем стресс",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Дом развалился"),
                    CardContentItem("После аварии он сильно сдал"),
                ),
            ),
        )

    private suspend fun createCard38() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("inseparable"),
                mainItems = listOf(
                    CardContentItem(
                        value = "fall back on [something]",
                        valueVoicing = "fall back on something",
                    ),
                ),
                examples = listOf(
                    CardContentItem("In case you lose your job, you can fall back on your savings"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("неразделяемый"),
                mainItems = listOf(
                    CardContentItem(
                        value = "полагаться, рассчитывать на что-то",
                        description = "обычно о сбережениях",
                    ),
                ),
                examples = listOf(
                    CardContentItem("На случай, если потеряешь работу, ты можешь положиться на свои сбережения"),
                ),
            ),
        )

    private suspend fun createCard39() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("intransitive"),
                mainItems = listOf(
                    CardContentItem("fall behind"),
                ),
                examples = listOf(
                    CardContentItem("I fell behind and got lost"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("непереходный"),
                mainItems = listOf(
                    CardContentItem("отставать"),
                ),
                examples = listOf(
                    CardContentItem("Я отстал и заблудился"),
                ),
            ),
        )

    private suspend fun createCard40() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("intransitive"),
                mainItems = listOf(
                    CardContentItem("fall down"),
                ),
                examples = listOf(
                    CardContentItem("The tree fell down"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("непереходный"),
                mainItems = listOf(
                    CardContentItem("упасть"),
                ),
                examples = listOf(
                    CardContentItem("Дерево упало"),
                ),
            ),
        )

    private suspend fun createCard41() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("inseparable"),
                mainItems = listOf(
                    CardContentItem(
                        value = "fall for [somebody]",
                        valueVoicing = "fall for somebody",
                    ),
                ),
                examples = listOf(
                    CardContentItem("She really fell for you!"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("неразделяемый"),
                mainItems = listOf(
                    CardContentItem("влюбиться, запасть, втюриться в кого-то"),
                ),
                examples = listOf(
                    CardContentItem("Она реально на тебя запала!"),
                ),
            ),
        )

    private suspend fun createCard42() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("inseparable"),
                mainItems = listOf(
                    CardContentItem(
                        value = "fall for [something]",
                        valueVoicing = "fall for something",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Don't fall for his tricks!"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("неразделяемый"),
                mainItems = listOf(
                    CardContentItem(
                        value = "поверить, попасться",
                        description = "на уловку",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Не ведись на его уловки!"),
                ),
            ),
        )

    private suspend fun createCard43() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("inseparable"),
                mainItems = listOf(
                    CardContentItem(
                        value = "fall in with [somebody]",
                        valueVoicing = "fall in with somebody",
                    ),
                ),
                examples = listOf(
                    CardContentItem("The boy fell in with bad guys"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("неразделяемый"),
                mainItems = listOf(
                    CardContentItem(
                        value = "связаться с кем-то",
                        description = "обычно о плохой компании",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Мальчик связался с плохими парнями"),
                ),
            ),
        )

    private suspend fun createCard44() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("intransitive"),
                mainItems = listOf(
                    CardContentItem("fall out"),
                ),
                examples = listOf(
                    CardContentItem("My dog's teeth are falling out"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("непереходный"),
                mainItems = listOf(
                    CardContentItem(value = "выпадать", description = "о волосах, зубах"),
                ),
                examples = listOf(
                    CardContentItem("У моей собаки выпадают зубы"),
                ),
            ),
        )

    private suspend fun createCard45() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("inseparable"),
                mainItems = listOf(
                    CardContentItem(
                        value = "fall out of [something]",
                        valueVoicing = "fall out of something",
                    ),
                ),
                examples = listOf(
                    CardContentItem("The key fell out of my pocket"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("неразделяемый"),
                mainItems = listOf(
                    CardContentItem("выпасть, вывалиться из чего-то"),
                ),
                examples = listOf(
                    CardContentItem("Ключ выпал из моего кармана"),
                ),
            ),
        )

    private suspend fun createCard46() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("inseparable or intransitive"),
                mainItems = listOf(
                    CardContentItem(
                        value = "fall through [something]",
                        valueVoicing = "fall through something",
                    ),
                ),
                examples = listOf(
                    CardContentItem("I fell through the roof"),
                    CardContentItem("My weekend plans fell through"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("неразделяемый или непереходный"),
                mainItems = listOf(
                    CardContentItem("провалиться (буквально)"),
                    CardContentItem("провалиться (о неудаче)"),
                ),
                examples = listOf(
                    CardContentItem("Я провалился сквозь крышу"),
                    CardContentItem("Мои планы на выходные провалились"),
                ),
            ),
        )

    private suspend fun createCard47() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("separable"),
                mainItems = listOf(
                    CardContentItem(
                        value = "figure [something] out",
                        valueVoicing = "figure something out",
                    ),
                ),
                examples = listOf(
                    CardContentItem("I don't know the answer yet, but I'll figure it out"),
                    CardContentItem("Let's figure out how it works"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("разделяемый"),
                mainItems = listOf(
                    CardContentItem(
                        value = "выяснить, разобраться в чем-то",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Я еще не знаю ответ, но я выясню"),
                    CardContentItem("Let's figure out how it works"),
                ),
            ),
        )

    private suspend fun createCard48() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("separable"),
                mainItems = listOf(
                    CardContentItem(
                        value = "fill [something] in/out",
                        valueVoicing = "fill something in or out",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Fill in this form, please"),
                    CardContentItem("Fill out this form, please"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("разделяемый"),
                mainItems = listOf(
                    CardContentItem(
                        value = "заполнять бланки, бумаг",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Заполните этот бланк, пожалуйста"),
                ),
            ),
        )

    private suspend fun createCard49() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("inseparable"),
                mainItems = listOf(
                    CardContentItem(
                        value = "fill in for [somebody]",
                        valueVoicing = "fill in for somebody",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Can you fill in for me tomorrow?"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("неразделяемый"),
                mainItems = listOf(
                    CardContentItem(
                        value = "подменить кого-то на работе",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Ты можешь меня завтра подменить?"),
                ),
            ),
        )

    private suspend fun createCard50() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("separable"),
                mainItems = listOf(
                    CardContentItem(
                        value = "find [something] out",
                        valueVoicing = "find something out",
                    ),
                ),
                examples = listOf(
                    CardContentItem("I don't know what you're going to do, but I will find it out"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("разделяемый"),
                mainItems = listOf(
                    CardContentItem(
                        value = "выяснить, узнать что-то",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Я не знаю, что ты собираешься сделать, но я выясню это"),
                ),
            ),
        )

    private suspend fun createCard51() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("intransitive"),
                mainItems = listOf(
                    CardContentItem(
                        value = "freak out",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Tell me the bad news, I promise you I'll not freak out"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("непереходный"),
                mainItems = listOf(
                    CardContentItem(
                        value = "выражать сильные эмоции",
                        description = "психовать, кричать, радоваться, паниковать и т. д.",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Расскажи мне плохие новости, обещаю, что не буду сходить с ума"),
                ),
            ),
        )

    private suspend fun createCard52() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("separable"),
                mainItems = listOf(
                    CardContentItem(
                        value = "freak [somebody] out",
                        valueVoicing = "freak somebody out",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Stop speaking like a movie villain, you're freaking me out"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("разделяемый"),
                mainItems = listOf(
                    CardContentItem(
                        value = "напугать, вывести из себя, нагнать жути, заставлять нервничать",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Перестань говорить, как злодей из фильмов, ты заставляешь меня нервничать"),
                ),
            ),
        )

    private suspend fun createCard53() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("inseparable"),
                mainItems = listOf(
                    CardContentItem(
                        value = "get along with [somebody]",
                        valueVoicing = "get along with somebody",
                    ),
                ),
                examples = listOf(
                    CardContentItem("He doesn't get along with his classmates"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("неразделяемый"),
                mainItems = listOf(
                    CardContentItem("ладить с кем-то"),
                ),
                examples = listOf(
                    CardContentItem("Он не ладит с одноклассниками"),
                ),
            ),
        )

    private suspend fun createCard54() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("intransitive"),
                mainItems = listOf(
                    CardContentItem("get around"),
                ),
                examples = listOf(
                    CardContentItem("In a big city, it's hard to get around without a car"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("непереходный"),
                mainItems = listOf(
                    CardContentItem(value = "перемещаться", description = "например, по городу"),
                ),
                examples = listOf(
                    CardContentItem("В большом городе трудно перемещаться без машины"),
                ),
            ),
        )

    private suspend fun createCard55() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("intransitive"),
                mainItems = listOf(
                    CardContentItem("get away"),
                ),
                examples = listOf(
                    CardContentItem("They got away from the police"),
                    CardContentItem("I need to get away for a few days"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("непереходный"),
                mainItems = listOf(
                    CardContentItem("убежать, скрыться"),
                    CardContentItem("уехать на отдых"),
                ),
                examples = listOf(
                    CardContentItem("Они убежали от полиции"),
                    CardContentItem("Мне нужно уехать на отдых на пару дней"),
                ),
            ),
        )

    private suspend fun createCard56() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("inseparable"),
                mainItems = listOf(
                    CardContentItem(
                        value = "get away with [something]",
                        valueVoicing = "get away with something",
                    ),
                ),
                examples = listOf(
                    CardContentItem("You can't get away with this!"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("неразделяемый"),
                mainItems = listOf(
                    CardContentItem("избежать наказания за что-то"),
                ),
                examples = listOf(
                    CardContentItem("Тебе это не сойдет с рук!"),
                ),
            ),
        )

    private suspend fun createCard57() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("intransitive"),
                mainItems = listOf(
                    CardContentItem("get back"),
                ),
                examples = listOf(
                    CardContentItem("I'll get back soon"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("непереходный"),
                mainItems = listOf(
                    CardContentItem("вернуться"),
                ),
                examples = listOf(
                    CardContentItem("Я скоро вернусь"),
                ),
            ),
        )

    private suspend fun createCard58() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("separable"),
                mainItems = listOf(
                    CardContentItem(
                        value = "get [something] back",
                        valueVoicing = "get something back",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Tomorrow you will get your money back"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("разделяемый"),
                mainItems = listOf(
                    CardContentItem("получить что-то обратно, вернуть себе"),
                ),
                examples = listOf(
                    CardContentItem("Завтра ты получишь свои деньги обратно"),
                ),
            ),
        )

    private suspend fun createCard59() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("inseparable"),
                mainItems = listOf(
                    CardContentItem(
                        value = "get back to [something]",
                        valueVoicing = "get back to something",
                    ),
                    CardContentItem(
                        value = "get back into [something]",
                        valueVoicing = "get back into something",
                    ),
                ),
                examples = listOf(
                    CardContentItem("I got back to jogging"),
                    CardContentItem("I got back into jogging"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("неразделяемый"),
                mainItems = listOf(
                    CardContentItem(
                        value = "вернуться к занятию",
                        description = "когда что-то забросили и вернулись",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Я снова занялся бегом"),
                ),
            ),
        )

    private suspend fun createCard60() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("inseparable"),
                mainItems = listOf(
                    CardContentItem(
                        value = "get down to [something]",
                        valueVoicing = "get down to something",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Let's get down to business"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("неразделяемый"),
                mainItems = listOf(
                    CardContentItem(value = "перейти к чему-то", description = "задаче"),
                ),
                examples = listOf(
                    CardContentItem("Давайте перейдем к делу"),
                ),
            ),
        )

    private suspend fun createCard61() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("intransitive"),
                mainItems = listOf(
                    CardContentItem("get in"),
                    CardContentItem("get off"),
                ),
                examples = listOf(
                    CardContentItem("Get in!"),
                    CardContentItem("I'll get off by that building"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("непереходный"),
                mainItems = listOf(
                    CardContentItem("садиться в машину"),
                    CardContentItem("выходить из машины"),
                ),
                examples = listOf(
                    CardContentItem("Садись! (в машину)"),
                    CardContentItem("Я выйду у того здания"),
                ),
            ),
        )

    private suspend fun createCard62() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("intransitive or inseparable"),
                mainItems = listOf(
                    CardContentItem("get on"),
                ),
                examples = listOf(
                    CardContentItem("Call me when you get on the plane"),
                    CardContentItem("I got on"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("неразделяемый или непереходный"),
                mainItems = listOf(
                    CardContentItem(value = "садиться", description = "на самолет, судно, поезд"),
                ),
                examples = listOf(
                    CardContentItem("Позвони, когда сядешь на самолет"),
                    CardContentItem("Я сел (на самолет)"),
                ),
            ),
        )

    private suspend fun createCard63() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("inseparable"),
                mainItems = listOf(
                    CardContentItem(
                        value = "get over [somebody]",
                        valueVoicing = "get over somebody",
                    ),
                ),
                examples = listOf(
                    CardContentItem("You need to get over her and continue with your life"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("неразделяемый"),
                mainItems = listOf(
                    CardContentItem("оставить позади отношения с кем-то"),
                ),
                examples = listOf(
                    CardContentItem("Тебе нужно оставить ее позади и продолжить жить"),
                ),
            ),
        )

    private suspend fun createCard64() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("inseparable"),
                mainItems = listOf(
                    CardContentItem(
                        value = "get over [something]",
                        valueVoicing = "get over something",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Don't worry, you'll get over your break up"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("неразделяемый"),
                mainItems = listOf(
                    CardContentItem("преодолеть трудность и идти дальше"),
                ),
                examples = listOf(
                    CardContentItem("Не переживай, ты переживешь (преодолеешь) ваше расставание"),
                ),
            ),
        )

    private suspend fun createCard65() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("intransitive"),
                mainItems = listOf(
                    CardContentItem("get through"),
                ),
                examples = listOf(
                    CardContentItem("I can't get through"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("непереходный"),
                mainItems = listOf(
                    CardContentItem("дозвониться"),
                ),
                examples = listOf(
                    CardContentItem("Я не могу дозвониться"),
                ),
            ),
        )

    private suspend fun createCard66() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("intransitive"),
                mainItems = listOf(
                    CardContentItem("get up"),
                ),
                examples = listOf(
                    CardContentItem("I woke up at 7 and got up at 8"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("непереходный"),
                mainItems = listOf(
                    CardContentItem("встать, подняться"),
                ),
                examples = listOf(
                    CardContentItem("Я проснулся в 7, а встал в 8"),
                ),
            ),
        )

    private suspend fun createCard67() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("separable"),
                mainItems = listOf(
                    CardContentItem(
                        value = "give [something] away",
                        valueVoicing = "give something away",
                    ),
                ),
                examples = listOf(
                    CardContentItem("These are good books, don't give them away"),
                    CardContentItem("You gave my secret away!"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("разделяемый"),
                mainItems = listOf(
                    CardContentItem("раздавать, отдавать даром"),
                    CardContentItem("раскрыть тайну, проговориться"),
                ),
                examples = listOf(
                    CardContentItem("Это хорошие книги, не отдавай их"),
                    CardContentItem("Ты выдал мою тайну!"),
                ),
            ),
        )

    private suspend fun createCard68() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("separable"),
                mainItems = listOf(
                    CardContentItem(
                        value = "give [somebody or something] back",
                        valueVoicing = "give somebody or something back",
                    ),
                ),
                examples = listOf(
                    CardContentItem("I can't give (you) your money back right now"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("разделяемый"),
                mainItems = listOf(
                    CardContentItem("вернуть кому-то, отдать"),
                ),
                examples = listOf(
                    CardContentItem("Я не могу вернуть (тебе) твои деньги прямо сейчас"),
                ),
            ),
        )

    private suspend fun createCard69() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("intransitive or inseparable"),
                mainItems = listOf(
                    CardContentItem(
                        value = "give in (to somebody)",
                        valueVoicing = "give in (to somebody)",
                    ),
                ),
                examples = listOf(
                    CardContentItem("I didn't want to have a huge wedding, but my fiancée wanted it, and I gave in (to her)"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("неразделяемый или непереходный"),
                mainItems = listOf(
                    CardContentItem("поддаться, уступить (кому-то)"),
                ),
                examples = listOf(
                    CardContentItem("Я не хотел устраивать большую свадьбу, но этого хотела моя невеста, и я поддался (ей)"),
                ),
            ),
        )

    private suspend fun createCard70() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("separable"),
                mainItems = listOf(
                    CardContentItem(
                        value = "give out [something]",
                        valueVoicing = "give out something",
                    ),
                ),
                examples = listOf(
                    CardContentItem("He gave out his business cards at the meeting"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("разделяемый"),
                mainItems = listOf(
                    CardContentItem(value = "раздавать", description = "большому кол-ву людей"),
                ),
                examples = listOf(
                    CardContentItem("Он раздал свои визитки на встрече"),
                ),
            ),
        )

    private suspend fun createCard71() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("intransitive"),
                mainItems = listOf(
                    CardContentItem("give up"),
                ),
                examples = listOf(
                    CardContentItem("Keep fighting and never give up!"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("непереходный"),
                mainItems = listOf(
                    CardContentItem("сдаваться"),
                ),
                examples = listOf(
                    CardContentItem("Продолжай бороться и никогда не сдавайся!"),
                ),
            ),
        )

    private suspend fun createCard72() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("separable"),
                mainItems = listOf(
                    CardContentItem(
                        value = "give up [something]",
                        valueVoicing = "give up something",
                    ),
                ),
                examples = listOf(
                    CardContentItem("I want to give up smoking"),
                    CardContentItem("I can't give it up"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("разделяемый"),
                mainItems = listOf(
                    CardContentItem(
                        value = "бросить, завязать",
                        description = "обычно о вредных привычках",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Я хочу бросить курить"),
                    CardContentItem("Я не могу с этим завязать"),
                ),
            ),
        )

    private suspend fun createCard73() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("inseparable"),
                mainItems = listOf(
                    CardContentItem(
                        value = "go after [somebody or something]",
                        valueVoicing = "go after somebody or something",
                    ),
                ),
                examples = listOf(
                    CardContentItem("My dog went after a sparrow"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("неразделяемый"),
                mainItems = listOf(
                    CardContentItem("преследовать, пытаться заполучить"),
                ),
                examples = listOf(
                    CardContentItem("Моя собака попыталась поймать воробья"),
                ),
            ),
        )

    private suspend fun createCard74() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("intransitive"),
                mainItems = listOf(
                    CardContentItem("go ahead"),
                ),
                examples = listOf(
                    CardContentItem("Did you want to say something? Go ahead!"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("непереходный"),
                mainItems = listOf(
                    CardContentItem(value = "вперед, давай", description = "побуждение к действию"),
                ),
                examples = listOf(
                    CardContentItem("Ты хотел что-то сказать? Давай (говори)!"),
                ),
            ),
        )

    private suspend fun createCard75() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("intransitive"),
                mainItems = listOf(
                    CardContentItem("go back"),
                ),
                examples = listOf(
                    CardContentItem("I forgot my keys at home, but I can't go back now"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("непереходный"),
                mainItems = listOf(
                    CardContentItem("возвращаться, приходить куда-то снова"),
                ),
                examples = listOf(
                    CardContentItem("Я забыл ключи дома, но я не могу сейчас вернуться"),
                ),
            ),
        )

    private suspend fun createCard76() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("inseparable"),
                mainItems = listOf(
                    CardContentItem(value = "go by", description = "name"),
                ),
                examples = listOf(
                    CardContentItem("I go by Abby, but my full name is Abigail"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("неразделяемый"),
                mainItems = listOf(
                    CardContentItem(value = "зваться", description = "о том, как вас называют"),
                ),
                examples = listOf(
                    CardContentItem("Меня зовут (называют) Эбби, но мое полное имя - Эбигейл"),
                ),
            ),
        )

    private suspend fun createCard77() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("intransitive"),
                mainItems = listOf(
                    CardContentItem("go off"),
                ),
                examples = listOf(
                    CardContentItem("The alarm went off"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("непереходный"),
                mainItems = listOf(
                    CardContentItem(
                        value = "сработать, издав громкий звук",
                        description = "о сигнализации, будильнике",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Сигнализация сработала"),
                ),
            ),
        )

    private suspend fun createCard78() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("intransitive or inseparable"),
                mainItems = listOf(
                    CardContentItem(value = "go on", description = "with something"),
                ),
                examples = listOf(
                    CardContentItem("The show must go on"),
                    CardContentItem("Go on with your work"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("неразделяемый или непереходный"),
                mainItems = listOf(
                    CardContentItem(value = "продолжать", description = "делать что-то"),
                ),
                examples = listOf(
                    CardContentItem("Шоу должно продолжаться"),
                    CardContentItem("Продолжайте работать"),
                ),
            ),
        )

    private suspend fun createCard79() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("intransitive"),
                mainItems = listOf(
                    CardContentItem("go out"),
                ),
                examples = listOf(
                    CardContentItem("He's such an introvert, never goes out"),
                    CardContentItem("Jake and Annie go out"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("непереходный"),
                mainItems = listOf(
                    CardContentItem("ходить куда-то, гулять"),
                    CardContentItem(value = "встречаться", description = "об отношениях"),
                ),
                examples = listOf(
                    CardContentItem("Он такой интроверт, никогда никуда не ходит"),
                    CardContentItem("Джейк и Энни встречаются"),
                ),
            ),
        )

    private suspend fun createCard80() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("inseparable"),
                mainItems = listOf(
                    CardContentItem(
                        value = "go out with [somebody]",
                        valueVoicing = "go out with somebody",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Jake goes out with Annie"),
                    CardContentItem("I'm going out with my friends tonight"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("неразделяемый"),
                mainItems = listOf(
                    CardContentItem("встречаться, быть в отношениях"),
                    CardContentItem(value = "гулять, тусить с кем-то"),
                ),
                examples = listOf(
                    CardContentItem("Джейк встречается с Энни"),
                    CardContentItem("Я иду гулять с друзьями сегодня вечером"),
                ),
            ),
        )

    private suspend fun createCard81() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("inseparable"),
                mainItems = listOf(
                    CardContentItem(
                        value = "go over [something]",
                        valueVoicing = "go over something",
                    ),
                ),
                examples = listOf(
                    CardContentItem("I went over my notes before the exam"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("неразделяемый"),
                mainItems = listOf(
                    CardContentItem("просмотреть, повторить"),
                ),
                examples = listOf(
                    CardContentItem("Я просмотрел конспекты перед экзаменом"),
                ),
            ),
        )

    private suspend fun createCard82() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("inseparable"),
                mainItems = listOf(
                    CardContentItem(
                        value = "go well with [something]",
                        valueVoicing = "go well with something",
                    ),
                ),
                examples = listOf(
                    CardContentItem("This tie goes well with your shirt"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("неразделяемый"),
                mainItems = listOf(
                    CardContentItem(value = "подходить к чему-то", description = "об одежде, еде"),
                ),
                examples = listOf(
                    CardContentItem("Этот галстук хорошо подходит к твоей рубашке"),
                ),
            ),
        )

    private suspend fun createCard83() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("inseparable"),
                mainItems = listOf(
                    CardContentItem(
                        value = "go without [something]",
                        valueVoicing = "go without something",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Smokers can't go without smoking"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("неразделяемый"),
                mainItems = listOf(
                    CardContentItem("обходиться без чего-то"),
                ),
                examples = listOf(
                    CardContentItem("Курильщики не могут обходиться без курения"),
                ),
            ),
        )

    private suspend fun createCard84() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("intransitive"),
                mainItems = listOf(
                    CardContentItem("go wrong"),
                ),
                examples = listOf(
                    CardContentItem("Everything went wrong"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("непереходный"),
                mainItems = listOf(
                    CardContentItem("идти не так, не по плану"),
                ),
                examples = listOf(
                    CardContentItem("Все пошло не по плану"),
                ),
            ),
        )

    private suspend fun createCard85() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("intransitive"),
                mainItems = listOf(
                    CardContentItem("go up / down", description = "go up or down"),
                ),
                examples = listOf(
                    CardContentItem("Go up the stairs"),
                    CardContentItem("Go down the stairs"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("непереходный"),
                mainItems = listOf(
                    CardContentItem("перемещаться вверх / вниз"),
                ),
                examples = listOf(
                    CardContentItem("Поднимитесь по лестнице"),
                    CardContentItem("Спуститесь по лестнице"),
                ),
            ),
        )

    private suspend fun createCard86() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("intransitive"),
                mainItems = listOf(
                    CardContentItem(
                        value = "grow up",
                    ),
                ),
                examples = listOf(
                    CardContentItem("He was born in Scotland but grew up in England"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("непереходный"),
                mainItems = listOf(
                    CardContentItem(
                        value = "расти",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Он родился в Шотландии, но вырос в Англии"),
                ),
            ),
        )

    private suspend fun createCard87() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("intransitive"),
                mainItems = listOf(
                    CardContentItem(
                        value = "hang in there",
                    ),
                ),
                examples = listOf(
                    CardContentItem("I'm coming to help you! Hang in there!"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("непереходный"),
                mainItems = listOf(
                    CardContentItem(
                        value = "держаться, не сдаваться",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Я иду на помощь! Держись!"),
                ),
            ),
        )

    private suspend fun createCard88() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("intransitive or inseparable"),
                mainItems = listOf(
                    CardContentItem(
                        value = "hang out (with somebody)",
                        valueVoicing = "hang out (with somebody)",
                    ),
                ),
                examples = listOf(
                    CardContentItem("My boss hangs out in that bar, we're not going there"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("неразделяемый или непереходный"),
                mainItems = listOf(
                    CardContentItem(
                        value = "тусоваться, проводить время с кем-то",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Мой босс тусуется в этом баре, мы туда не пойдем"),
                ),
            ),
        )

    private suspend fun createCard89() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("intransitive"),
                mainItems = listOf(
                    CardContentItem(
                        value = "hang up",
                    ),
                ),
                examples = listOf(
                    CardContentItem("I lost my temper and hung up"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("непереходный"),
                mainItems = listOf(
                    CardContentItem(
                        value = "повесить трубку",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Я вышел из себя и повесил трубку"),
                ),
            ),
        )

    private suspend fun createCard90() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("separable"),
                mainItems = listOf(
                    CardContentItem(
                        value = "help [somebody] out",
                        valueVoicing = "help somebody out",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Thank you for your advice, you really helped me out"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("разделяемый"),
                mainItems = listOf(
                    CardContentItem(
                        value = "выручить, помочь кому-то",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Спасибо за твой совет, ты действительно меня выручил"),
                ),
            ),
        )

    private suspend fun createCard91() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("intransitive"),
                mainItems = listOf(
                    CardContentItem("hold back"),
                ),
                examples = listOf(
                    CardContentItem("I wanted to argue but held back"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("непереходный"),
                mainItems = listOf(
                    CardContentItem("сдерживаться, не делать что-то"),
                ),
                examples = listOf(
                    CardContentItem("Я хотел поспорить, но сдержался"),
                ),
            ),
        )

    private suspend fun createCard92() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("separable"),
                mainItems = listOf(
                    CardContentItem(
                        value = "hold [somebody or something] back",
                        valueVoicing = "hold something or somebody back",
                    ),
                ),
                examples = listOf(
                    CardContentItem("He held his anger back"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("разделяемый"),
                mainItems = listOf(
                    CardContentItem("сдерживать кого-то, что-то"),
                ),
                examples = listOf(
                    CardContentItem("Он сдержал свой гнев"),
                ),
            ),
        )

    private suspend fun createCard93() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("separable"),
                mainItems = listOf(
                    CardContentItem(
                        value = "hold [somebody] down",
                        valueVoicing = "hold somebody down",
                    ),
                ),
                examples = listOf(
                    CardContentItem("You are late, what held you down?"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("разделяемый"),
                mainItems = listOf(
                    CardContentItem("задерживать, замедлять"),
                ),
                examples = listOf(
                    CardContentItem("Ты опоздал, что тебя задержало?"),
                ),
            ),
        )

    private suspend fun createCard94() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("inseparable"),
                mainItems = listOf(
                    CardContentItem(
                        value = "hold it against [somebody]",
                        valueVoicing = "hold it against somebody",
                    ),
                ),
                examples = listOf(
                    CardContentItem("I don't hold it against her"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("неразделяемый"),
                mainItems = listOf(
                    CardContentItem("держать зло на кого-то"),
                ),
                examples = listOf(
                    CardContentItem("Я не держу зла на нее"),
                ),
            ),
        )

    private suspend fun createCard95() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("intransitive"),
                mainItems = listOf(
                    CardContentItem("hold on"),
                ),
                examples = listOf(
                    CardContentItem("Hold on, I'm writing it down"),
                    CardContentItem("Hold on, we are coming to save you"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("непереходный"),
                mainItems = listOf(
                    CardContentItem("подождать немного"),
                    CardContentItem("держаться, не сдаваться"),
                ),
                examples = listOf(
                    CardContentItem("Подожди, я записываю"),
                    CardContentItem("Держитесь, мы уже идем, чтобы спасти вас"),
                ),
            ),
        )

    private suspend fun createCard96() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("inseparable"),
                mainItems = listOf(
                    CardContentItem(
                        value = "hold on to [something]",
                        valueVoicing = "hold on to something",
                    ),
                ),
                examples = listOf(
                    CardContentItem("The road is bumpy, hold on to something!"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("неразделяемый"),
                mainItems = listOf(
                    CardContentItem("держаться, вцепиться во что-то"),
                ),
                examples = listOf(
                    CardContentItem("Дорога неровная, держитесь за что-нибудь"),
                ),
            ),
        )

    private suspend fun createCard97() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("separable"),
                mainItems = listOf(
                    CardContentItem(
                        value = "hold [somebody] up",
                        valueVoicing = "hold somebody up",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Did you see the face of the guy who held you up?"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("разделяемый"),
                mainItems = listOf(
                    CardContentItem("грабить"),
                ),
                examples = listOf(
                    CardContentItem("Вы видели лицо парня, который вас ограбил?"),
                ),
            ),
        )

    private suspend fun createCard98() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("separable"),
                mainItems = listOf(
                    CardContentItem(
                        value = "keep [something] away from [somebody]",
                        valueVoicing = "keep something away from somebody",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Keep the pills away from children"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("разделяемый"),
                mainItems = listOf(
                    CardContentItem("держать что-то подальше от кого-то"),
                ),
                examples = listOf(
                    CardContentItem("Держите таблетки подальше от детей"),
                ),
            ),
        )

    private suspend fun createCard99() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("inseparable"),
                mainItems = listOf(
                    CardContentItem(
                        value = "keep doing [something]",
                        valueVoicing = "keep doing something",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Keep learning phrasal verbs"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("неразделяемый"),
                mainItems = listOf(
                    CardContentItem("продолжать делать что-то"),
                ),
                examples = listOf(
                    CardContentItem("Продолжайте учить фразовые глаголы"),
                ),
            ),
        )

    private suspend fun createCard100() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("inseparable"),
                mainItems = listOf(
                    CardContentItem(
                        value = "keep from doing [something]",
                        valueVoicing = "keep from doing something",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Keep from arguing with her parents"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("неразделяемый"),
                mainItems = listOf(
                    CardContentItem("сдерживаться, не делать что-то"),
                ),
                examples = listOf(
                    CardContentItem("Воздержитесь от споров с ее родителями"),
                ),
            ),
        )

    private suspend fun createCard101() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("intransitive or separable"),
                mainItems = listOf(
                    CardContentItem(
                        value = "keep [somebody] out (of something)",
                        valueVoicing = "keep somebody out (of something)",
                    ),
                ),
                examples = listOf(
                    CardContentItem("The police kept the crowd out (of the building)"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("разделяемый или непереходный"),
                mainItems = listOf(
                    CardContentItem("не впускать кого-то, не давать подойти"),
                ),
                examples = listOf(
                    CardContentItem("Полиция не впускала толпу (в здание)"),
                ),
            ),
        )

    private suspend fun createCard102() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("intransitive or separable"),
                mainItems = listOf(
                    CardContentItem("keep up"),
                ),
                examples = listOf(
                    CardContentItem("You are walking fast, I can't keep up"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("разделяемый или непереходный"),
                mainItems = listOf(
                    CardContentItem("не отставать"),
                ),
                examples = listOf(
                    CardContentItem("Вы быстро идете, я не успеваю"),
                ),
            ),
        )

    private suspend fun createCard103() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("separable"),
                mainItems = listOf(
                    CardContentItem(
                        value = "let [somebody] in/out",
                        valueVoicing = "let somebody in or out",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Could you let me in?"),
                    CardContentItem("Let the cat out"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("разделяемый"),
                mainItems = listOf(
                    CardContentItem(
                        value = "впускать/выпускать кого-то",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Не могли бы вы меня впустить?"),
                    CardContentItem("Выпустите кота"),
                ),
            ),
        )

    private suspend fun createCard104() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("inseparable"),
                mainItems = listOf(
                    CardContentItem(
                        value = "look after [somebody or something]",
                        valueVoicing = "look after somebody (or something)",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Look after my dogs"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("неразделяемый"),
                mainItems = listOf(
                    CardContentItem("присматривать за чем-то (кем-то)"),
                ),
                examples = listOf(
                    CardContentItem("Присмотрите за моими собаками"),
                ),
            ),
        )

    private suspend fun createCard105() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("inseparable"),
                mainItems = listOf(
                    CardContentItem(
                        value = "look down on [somebody or something]",
                        valueVoicing = "look down on somebody or something",
                    ),
                ),
                examples = listOf(
                    CardContentItem("He looks down on his employees"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("неразделяемый"),
                mainItems = listOf(
                    CardContentItem("смотреть свысока, относиться снисходительно"),
                ),
                examples = listOf(
                    CardContentItem("Он смотрит свысока на своих работников"),
                ),
            ),
        )

    private suspend fun createCard106() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("inseparable"),
                mainItems = listOf(
                    CardContentItem("look for"),
                ),
                examples = listOf(
                    CardContentItem("What are you looking for?"),
                    CardContentItem("Who are you looking for?"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("неразделяемый"),
                mainItems = listOf(
                    CardContentItem("искать что-то (или кого-то)"),
                ),
                examples = listOf(
                    CardContentItem("Что вы ищете?"),
                    CardContentItem("Кого вы ищете?"),
                ),
            ),
        )

    private suspend fun createCard107() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("inseparable"),
                mainItems = listOf(
                    CardContentItem(
                        value = "look forward to [something]",
                        valueVoicing = "look forward to something",
                    ),
                    CardContentItem(
                        value = "look forward to doing [something]",
                        valueVoicing = "look forward to doing something",
                    ),
                ),
                examples = listOf(
                    CardContentItem("I'm looking forward to (celebrating) my Birthday"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("неразделяемый"),
                mainItems = listOf(
                    CardContentItem("ждать чего-то с нетерпением"),
                ),
                examples = listOf(
                    CardContentItem("Жду с нетерпением (когда отпраздную) свой День рожденья"),

                ),
            ),
        )

    private suspend fun createCard108() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("inseparable"),
                mainItems = listOf(
                    CardContentItem(
                        value = "look into [something]",
                        valueVoicing = "look into something",
                    ),
                ),
                examples = listOf(
                    CardContentItem("We'll look into the problem and give you a full report"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("неразделяемый"),
                mainItems = listOf(
                    CardContentItem("изучить, разобраться, проверить что-то"),
                ),
                examples = listOf(
                    CardContentItem("Мы изучим проблему и дадим вам полный отчет"),

                ),
            ),
        )

    private suspend fun createCard109() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("intransitive"),
                mainItems = listOf(
                    CardContentItem("Look out!"),
                ),
                examples = listOf(
                    CardContentItem("Look out! There is an alligator there!"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("непереходный"),
                mainItems = listOf(
                    CardContentItem("Берегись!"),
                ),
                examples = listOf(
                    CardContentItem("Берегись! Там аллигатор!"),

                ),
            ),
        )

    private suspend fun createCard110() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("inseparable"),
                mainItems = listOf(
                    CardContentItem(
                        value = "look out for [somebody]",
                        valueVoicing = "look out for somebody",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Look out for your friend"),
                    CardContentItem("Look out for those suspicious people"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("неразделяемый"),
                mainItems = listOf(
                    CardContentItem("заботиться, присматривать"),
                    CardContentItem("опасаться, быть настороже"),
                ),
                examples = listOf(
                    CardContentItem("Присматривай за своим другом"),
                    CardContentItem("Опасайтесь тех подозрительных людей"),
                ),
            ),
        )

    private suspend fun createCard111() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("inseparable"),
                mainItems = listOf(
                    CardContentItem(
                        value = "look through [something]",
                        valueVoicing = "look through something",
                    ),
                ),
                examples = listOf(
                    CardContentItem("I looked through the article to find the key points"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("неразделяемый"),
                mainItems = listOf(
                    CardContentItem(value = "бегло просмотреть", description = "обычно текст"),
                ),
                examples = listOf(
                    CardContentItem("Я просмотрел статью, чтобы найти основные мысли"),
                ),
            ),
        )

    private suspend fun createCard112() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("separable"),
                mainItems = listOf(
                    CardContentItem(
                        value = "look [something] up",
                        valueVoicing = "look something up",
                    ),
                ),
                examples = listOf(
                    CardContentItem("I know how to spell this word, I looked it up"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("разделяемый"),
                mainItems = listOf(
                    CardContentItem("посмотреть что-то в словаре, интернете и т. д."),
                ),
                examples = listOf(
                    CardContentItem("Я знаю, как пишется это слово, я посмотрел (в каком-то источнике)"),
                ),
            ),
        )

    private suspend fun createCard113() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("inseparable"),
                mainItems = listOf(
                    CardContentItem(
                        value = "look up to [somebody]",
                        valueVoicing = "look up to somebody",
                    ),
                ),
                examples = listOf(
                    CardContentItem("The boy looks up to his brother"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("неразделяемый"),
                mainItems = listOf(
                    CardContentItem("равняться на кого-то, брать пример"),
                ),
                examples = listOf(
                    CardContentItem("Мальчик берет пример со своего брата"),
                ),
            ),
        )

    private suspend fun createCard114() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("separable"),
                mainItems = listOf(
                    CardContentItem(
                        value = "make [something] up",
                        valueVoicing = "make something up",
                    ),
                ),
                examples = listOf(
                    CardContentItem("I don't believe you, you made it up"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("разделяемый"),
                mainItems = listOf(
                    CardContentItem(
                        value = "выдумать что-то",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Я тебе не верю, ты это выдумал"),
                ),
            ),
        )

    private suspend fun createCard115() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("intransitive"),
                mainItems = listOf(
                    CardContentItem(
                        value = "move in/out",
                        valueVoicing = "move in or out",
                    ),
                ),
                examples = listOf(
                    CardContentItem("I'm your new neighbor, we just moved in"),
                    CardContentItem("She doesn't live here, she moved out"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("непереходный"),
                mainItems = listOf(
                    CardContentItem(
                        value = "заехать/съехать",
                        description = "о жилье",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Я ваш новый сосед, мы только заехали"),
                    CardContentItem("Она здесь не живет, она съехала"),
                ),
            ),
        )

    private suspend fun createCard116() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("separable"),
                mainItems = listOf(
                    CardContentItem(
                        value = "pick up",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Don't pick it up, it's my boss calling"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("разделяемый"),
                mainItems = listOf(
                    CardContentItem(
                        value = "поднять трубку, отвечать на звонок",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Не отвечай на звонок, это мой начальник звонит"),
                ),
            ),
        )

    private suspend fun createCard117() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("separable"),
                mainItems = listOf(
                    CardContentItem(
                        value = "pick [somebody] up",
                        valueVoicing = "pick somebody up",
                    ),
                ),
                examples = listOf(
                    CardContentItem("I'll pick you up at ten"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("разделяемый"),
                mainItems = listOf(
                    CardContentItem(
                        value = "взять пассажира",
                        description = "заехать за кем-то",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Я заеду за тобой в десять"),
                ),
            ),
        )

    private suspend fun createCard118() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("separable"),
                mainItems = listOf(
                    CardContentItem(
                        value = "pick [something] up",
                        valueVoicing = "pick something up",
                    ),
                ),
                examples = listOf(
                    CardContentItem("The boy picked up a coin"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("разделяемый"),
                mainItems = listOf(
                    CardContentItem(
                        value = "поднять что-то",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Мальчик подобрал монетку"),
                ),
            ),
        )

    private suspend fun createCard119() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("intransitive"),
                mainItems = listOf(
                    CardContentItem(
                        value = "pull off",
                    ),
                    CardContentItem(
                        value = "pull over",
                    ),
                ),
                examples = listOf(
                    CardContentItem("My passenger asked me to pull off, he wanted to stretch his legs"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("непереходный"),
                mainItems = listOf(
                    CardContentItem(
                        value = "остановить машину у дороги",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Мой пассажир попросил остановиться, он хотел размять ноги"),
                ),
            ),
        )

    private suspend fun createCard120() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("separable"),
                mainItems = listOf(
                    CardContentItem(
                        value = "pull [somebody] over",
                        valueVoicing = "pull somebody over",
                    ),
                ),
                examples = listOf(
                    CardContentItem("The police pulled me over"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("разделяемый"),
                mainItems = listOf(
                    CardContentItem(
                        value = "остановить машину, заставить остановиться у дороги",
                        description = "обычно о полиции",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Меня (машину) остановила полиция"),
                ),
            ),
        )

    private suspend fun createCard121() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("intransitive"),
                mainItems = listOf(
                    CardContentItem(
                        value = "put [something] on",
                        valueVoicing = "put something on",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Put on this hat"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("непереходный"),
                mainItems = listOf(
                    CardContentItem(
                        value = "надеть что-то",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Надень эту шляпу"),
                ),
            ),
        )

    private suspend fun createCard122() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("inseparable"),
                mainItems = listOf(
                    CardContentItem(
                        value = "run after [somebody or something]",
                        valueVoicing = "run after somebody of something",
                    ),
                ),
                examples = listOf(
                    CardContentItem("A pack of dogs ran after a cat"),
                    CardContentItem("He's been running after her for a long time, but she doesn't like him"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("неразделяемый"),
                mainItems = listOf(
                    CardContentItem("гнаться, преследовать кого-то, что-то"),
                    CardContentItem("\"бегать\" за кем-то, добиваясь романтического внимания"),
                ),
                examples = listOf(
                    CardContentItem("Стая собак гналась за кошкой"),
                    CardContentItem("Он бегает за ней уже давно, но ей он не нравится"),
                ),
            ),
        )

    private suspend fun createCard123() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("intransitive"),
                mainItems = listOf(
                    CardContentItem("run around"),
                ),
                examples = listOf(
                    CardContentItem("I'm so tired, I've been running around all day"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("непереходный"),
                mainItems = listOf(
                    CardContentItem(value = "\"бегать\", быть занятым"),
                ),
                examples = listOf(
                    CardContentItem("Я так устал, я был занят весь день"),
                ),
            ),
        )

    private suspend fun createCard124() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("intransitive"),
                mainItems = listOf(
                    CardContentItem(
                        value = "run away",
                        description = "from somebody",
                    ),
                ),
                examples = listOf(
                    CardContentItem("The rabbit was able to run away (from the fox)"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("непереходный"),
                mainItems = listOf(
                    CardContentItem(value = "убегать", description = "от кого-то"),
                ),
                examples = listOf(
                    CardContentItem("Кролик сумел сбежать (от лисы)"),
                ),
            ),
        )

    private suspend fun createCard125() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("separable"),
                mainItems = listOf(
                    CardContentItem(
                        value = "run [somebody or something] down",
                        valueVoicing = "run somebody (or something) down",
                    ),
                ),
                examples = listOf(
                    CardContentItem("He was driving fast and ran someone down"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("разделяемый"),
                mainItems = listOf(
                    CardContentItem("сбить кого-то (что-то) на машине"),
                ),
                examples = listOf(
                    CardContentItem("Он быстро ехал и сбил кого-то"),
                ),
            ),
        )

    private suspend fun createCard126() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("inseparable"),
                mainItems = listOf(
                    CardContentItem("run for (position)"),
                ),
                examples = listOf(
                    CardContentItem("He ran for President in 1988"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("неразделяемый"),
                mainItems = listOf(
                    CardContentItem(value = "участвовать в выборах", description = "как кандидат"),
                ),
                examples = listOf(
                    CardContentItem("Он участвовал в президентских выборах в 1988"),
                ),
            ),
        )

    private suspend fun createCard127() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("inseparable"),
                mainItems = listOf(
                    CardContentItem(
                        value = "run for [somebody or something]",
                        valueVoicing = "run for somebody or something",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Don't run for the bus, it's dangerous"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("неразделяемый"),
                mainItems = listOf(
                    CardContentItem("гнаться за чем-то, кем-то"),
                ),
                examples = listOf(
                    CardContentItem("Не гонись за автобусом, это опасно"),
                ),
            ),
        )

    private suspend fun createCard128() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("inseparable"),
                mainItems = listOf(
                    CardContentItem(
                        value = "run into [somebody]",
                        valueVoicing = "run into somebody",
                    ),
                    CardContentItem(
                        value = "run across [somebody]",
                        valueVoicing = "run across somebody",
                    ),
                ),
                examples = listOf(
                    CardContentItem("I ran into my school buddy at the market"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("неразделяемый"),
                mainItems = listOf(
                    CardContentItem("случайно наткнуться на кого-то"),
                ),
                examples = listOf(
                    CardContentItem("Я случайно встретил школьного приятеля на рынке"),
                ),
            ),
        )

    private suspend fun createCard129() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("intransitive"),
                mainItems = listOf(
                    CardContentItem("run off"),
                ),
                examples = listOf(
                    CardContentItem("This party is boring, I'm going to run off"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("непереходный"),
                mainItems = listOf(
                    CardContentItem("сбежать, убежать откуда-то"),
                ),
                examples = listOf(
                    CardContentItem("Эта вечеринка скучная, я собираюсь сбежать"),
                ),
            ),
        )

    private suspend fun createCard130() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("inseparable"),
                mainItems = listOf(
                    CardContentItem(
                        value = "run on [something]",
                        valueVoicing = "run on something",
                    ),
                ),
                examples = listOf(
                    CardContentItem("My car runs on gas"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("неразделяемый"),
                mainItems = listOf(
                    CardContentItem(
                        value = "работать на чем-то",
                        description = "об источнике энергии",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Моя машина работает на бензине"),
                ),
            ),
        )

    private suspend fun createCard131() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("inseparable"),
                mainItems = listOf(
                    CardContentItem(
                        value = "run out of [something]",
                        valueVoicing = "run out of something",
                    ),
                ),
                examples = listOf(
                    CardContentItem("We ran out of toilet paper"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("неразделяемый"),
                mainItems = listOf(
                    CardContentItem("что-то заканчивается"),
                ),
                examples = listOf(
                    CardContentItem("У нас закончилась туалетная бумага"),
                ),
            ),
        )

    private suspend fun createCard132() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("separable"),
                mainItems = listOf(
                    CardContentItem(
                        value = "run [somebody or something] over",
                        valueVoicing = "run somebody (or something) over",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Oh, no! I ran over a fox!"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("разделяемый"),
                mainItems = listOf(
                    CardContentItem("переехать кого-то (что-то)"),
                ),
                examples = listOf(
                    CardContentItem("О, нет! Я переехал лису!"),
                ),
            ),
        )

    private suspend fun createCard133() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("inseparable"),
                mainItems = listOf(
                    CardContentItem(
                        value = "run over [something]",
                        valueVoicing = "run over something",
                    ),
                    CardContentItem(
                        value = "run through [something]",
                        valueVoicing = "run through something",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Let's run over our speech together"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("неразделяемый"),
                mainItems = listOf(
                    CardContentItem(
                        value = "порепетировать, повторить",
                        description = "обычно о тексте",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Давай повторим нашу речь вместе"),
                ),
            ),
        )

    private suspend fun createCard134() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("intransitive"),
                mainItems = listOf(
                    CardContentItem(
                        value = "screw up",
                    ),
                    CardContentItem(
                        value = "mess up",
                    ),
                ),
                examples = listOf(
                    CardContentItem("The date was terrible, I screwed up"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("непереходный"),
                mainItems = listOf(
                    CardContentItem(
                        value = "облажаться",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Свидание было ужасным, я облажался"),
                ),
            ),
        )

    private suspend fun createCard135() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("separable"),
                mainItems = listOf(
                    CardContentItem(
                        value = "screw [something] up",
                        valueVoicing = "screw something up",
                    ),
                    CardContentItem(
                        value = "mess [something] up",
                        valueVoicing = "mess something up",
                    ),
                ),
                examples = listOf(
                    CardContentItem("The show went well, but we screwed up the last scene"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("разделяемый"),
                mainItems = listOf(
                    CardContentItem(
                        value = "испортить, запороть, закосячить что-то",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Шоу прошло хорошо, но мы запороли последнюю сцену"),
                ),
            ),
        )

    private suspend fun createCard136() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("intransitive"),
                mainItems = listOf(
                    CardContentItem(
                        value = "show up",
                    ),
                ),
                examples = listOf(
                    CardContentItem("I waited for my friend but he didn't show up"),
                    CardContentItem("You can't just show up here at 6 a.m.!"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("непереходный"),
                mainItems = listOf(
                    CardContentItem(
                        value = "прийти",
                        description = "когда ждут",
                    ),
                    CardContentItem(
                        value = "заявиться",
                        description = "когда не ждут",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Я ждал друга, но он не пришел"),
                    CardContentItem("Ты не можешь так просто заявиться сюда в 6 утра!"),
                ),
            ),
        )

    private suspend fun createCard137() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("intransitive"),
                mainItems = listOf(
                    CardContentItem(
                        value = "slow down",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Slow down, you're speaking foo fast"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("непереходный"),
                mainItems = listOf(
                    CardContentItem(
                        value = "замедляться",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Сбавь скорость, ты говоришь слишком быстро"),
                ),
            ),
        )

    private suspend fun createCard138() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("separable"),
                mainItems = listOf(
                    CardContentItem(
                        value = "slow [something] down",
                        valueVoicing = "slow something down",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Slow down the car"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("разделяемый"),
                mainItems = listOf(
                    CardContentItem(
                        value = "замедлять",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Снизьте скорость машины"),
                ),
            ),
        )

    private suspend fun createCard139() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("intransitive"),
                mainItems = listOf(
                    CardContentItem(
                        value = "speed up",
                    ),
                ),
                examples = listOf(
                    CardContentItem("The car speeded up"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("непереходный"),
                mainItems = listOf(
                    CardContentItem(
                        value = "ускоряться",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Машина прибавила скорости"),
                ),
            ),
        )

    private suspend fun createCard140() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("separable"),
                mainItems = listOf(
                    CardContentItem(
                        value = "speed [something] up",
                        valueVoicing = "speed something up",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Can you speed up the train?"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("разделяемый"),
                mainItems = listOf(
                    CardContentItem(
                        value = "ускорять",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Вы можете сделать так, чтобы поезд ехал быстрее? (ускорить поезд)"),
                ),
            ),
        )

    private suspend fun createCard141() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("separable"),
                mainItems = listOf(
                    CardContentItem(
                        value = "switch  on/off",
                        valueVoicing = "switch something on or off",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Switch the lights on"),
                    CardContentItem("Switch the coffee machine off, please"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("разделяемый"),
                mainItems = listOf(
                    CardContentItem(
                        value = "включать/выключать что-то",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Включите свет"),
                    CardContentItem("Выключите кофеварку, пожалуйста"),
                ),
            ),
        )

    private suspend fun createCard142() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("inseparable"),
                mainItems = listOf(
                    CardContentItem(
                        value = "take after [somebody]",
                        valueVoicing = "take after somebody",
                    ),
                ),
                examples = listOf(
                    CardContentItem("She takes after her mother"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("неразделяемый"),
                mainItems = listOf(
                    CardContentItem(
                        value = "быть похожим на кого-то",
                        description = "обычно о родителях",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Она вся в мать (похожа на нее)"),
                ),
            ),
        )

    private suspend fun createCard143() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("separable"),
                mainItems = listOf(
                    CardContentItem(
                        value = "take [something] apart",
                        valueVoicing = "take something apart",
                    ),
                ),
                examples = listOf(
                    CardContentItem("I took my laptop apart"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("разделяемый"),
                mainItems = listOf(
                    CardContentItem(
                        value = "разбирать что-то на части",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Я разобрал свой ноутбук"),
                ),
            ),
        )

    private suspend fun createCard144() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("separable"),
                mainItems = listOf(
                    CardContentItem(
                        value = "take [somebody or something] away",
                        valueVoicing = "take somebody or something away",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Take him away!"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("разделяемый"),
                mainItems = listOf(
                    CardContentItem(
                        value = "удалить, убрать что-то, кого-то",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Уведите его!"),
                ),
            ),
        )

    private suspend fun createCard145() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("intransitive"),
                mainItems = listOf(
                    CardContentItem(
                        value = "take [something] back",
                        valueVoicing = "take something back",
                    ),
                ),
                examples = listOf(
                    CardContentItem("You can't take your words back"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("непереходный"),
                mainItems = listOf(
                    CardContentItem(
                        value = "вернуть что-то, забрать",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Ты не можешь взять свои слова обратно"),
                ),
            ),
        )

    private suspend fun createCard146() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("separable (always)"),
                mainItems = listOf(
                    CardContentItem(
                        value = "take [somebody] for [somebody]",
                        valueVoicing = "take somebody for somebody",
                    ),
                ),
                examples = listOf(
                    CardContentItem("I took you for your sister"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("всегда разделяемый"),
                mainItems = listOf(
                    CardContentItem(
                        value = "принимать кого-то за кого-то другого",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Я принял тебя за твою сестру"),
                ),
            ),
        )

    private suspend fun createCard147() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("intransitive"),
                mainItems = listOf(
                    CardContentItem(
                        value = "take off",
                    ),
                ),
                examples = listOf(
                    CardContentItem("The plane took off"),
                    CardContentItem("Our business took off"),
                    CardContentItem("He saw the cops and took off"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("непереходный"),
                mainItems = listOf(
                    CardContentItem(
                        value = "взлететь",
                        description = "буквально или о быстром прогрессе в деле",
                    ),
                    CardContentItem(
                        value = "быстро уйти, убежать, \"сорваться\" куда-то",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Самолет взлетел"),
                    CardContentItem("Наш бизнес \"взлетел\""),
                    CardContentItem("Он увидел копов и убежал"),
                ),
            ),
        )

    private suspend fun createCard148() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("separable"),
                mainItems = listOf(
                    CardContentItem(
                        value = "take [something] off",
                        valueVoicing = "take something off",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Take your glasses off"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("разделяемый"),
                mainItems = listOf(
                    CardContentItem(
                        value = "снять что-то",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Снимите очки"),
                ),
            ),
        )

    private suspend fun createCard149() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("separable (always)"),
                mainItems = listOf(
                    CardContentItem(
                        value = "take [somebody] out",
                        valueVoicing = "take somebody out",
                    ),
                ),
                examples = listOf(
                    CardContentItem("I took her out to a restaurant"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("всегда разделяемый"),
                mainItems = listOf(
                    CardContentItem(
                        value = "сводить куда-то кого-то",
                        description = "например, на свидание",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Я сводил ее в ресторан"),
                ),
            ),
        )

    private suspend fun createCard150() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("separable"),
                mainItems = listOf(
                    CardContentItem(
                        value = "take [a pet] out",
                        valueVoicing = "take a pet out",
                    ),
                ),
                examples = listOf(
                    CardContentItem("It's your turn to take the dog out"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("разделяемый"),
                mainItems = listOf(
                    CardContentItem(
                        value = "выгулять домашнее животное",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Твоя очередь выгуливать собаку"),
                ),
            ),
        )

    private suspend fun createCard151() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("separable"),
                mainItems = listOf(
                    CardContentItem(
                        value = "take up",
                    ),
                ),
                examples = listOf(
                    CardContentItem("The piano took up a lot of space"),
                    CardContentItem("Reading takes up much time"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("разделяемый"),
                mainItems = listOf(
                    CardContentItem(
                        value = "занимать место или время",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Пианино заняло много места"),
                    CardContentItem("Чтение занимает много времени"),
                ),
            ),
        )

    private suspend fun createCard152() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("separable"),
                mainItems = listOf(
                    CardContentItem(
                        value = "take up [something]",
                        valueVoicing = "take up something",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Jane took up yoga"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("разделяемый"),
                mainItems = listOf(
                    CardContentItem(
                        value = "начать чем-то заниматься",
                        description = "например, новое хобби",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Джейн начала заниматься йогой"),
                ),
            ),
        )

    private suspend fun createCard153() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("separable"),
                mainItems = listOf(
                    CardContentItem(
                        value = "try [something] on",
                        valueVoicing = "try something on",
                    ),
                ),
                examples = listOf(
                    CardContentItem("May I try on these shoes?"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("разделяемый"),
                mainItems = listOf(
                    CardContentItem(
                        value = "примерить что-то",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Можно я примерю эти туфли?"),
                ),
            ),
        )

    private suspend fun createCard154() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("intransitive or separable"),
                mainItems = listOf(
                    CardContentItem(
                        value = "turn [something] around",
                        valueVoicing = "turn something around",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Don't turn around"),
                    CardContentItem("Turn the camera around"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("разделяемый или непереходный"),
                mainItems = listOf(
                    CardContentItem(
                        value = "разворачивать (-ся)",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Не оборачивайся"),
                    CardContentItem("Разверните камеру"),
                ),
            ),
        )

    private suspend fun createCard155() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("intransitive or separable"),
                mainItems = listOf(
                    CardContentItem(
                        value = "turn [something] away",
                        valueVoicing = "turn (something) away",
                    ),
                ),
                examples = listOf(
                    CardContentItem("She turned away in fear"),
                    CardContentItem("Turn the flashlight away"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("разделяемый или непереходный"),
                mainItems = listOf(
                    CardContentItem(
                        value = "отвернуть (-ся)",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Она отвернулась в страхе"),
                    CardContentItem("Уберите фонарик (поверните в др. сторону)"),
                ),
            ),
        )

    private suspend fun createCard156() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("separable"),
                mainItems = listOf(
                    CardContentItem(
                        value = "turn [something] down",
                        valueVoicing = "turn something down",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Turn the music down"),
                    CardContentItem("You turned down a good job offer"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("разделяемый"),
                mainItems = listOf(
                    CardContentItem(
                        value = "делать тише",
                    ),
                    CardContentItem(
                        value = "отказывать, отклонять предложение",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Сделайте музыку потише"),
                    CardContentItem("Вы отклонили хорошее предложение работы"),
                ),
            ),
        )

    private suspend fun createCard157() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("intransitive"),
                mainItems = listOf(
                    CardContentItem(
                        value = "turn in",
                    ),
                ),
                examples = listOf(
                    CardContentItem("I'm so tired, I'm gonna turn in"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("непереходный"),
                mainItems = listOf(
                    CardContentItem(
                        value = "завалиться спать",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Я так устал, пойду завалюсь спать"),
                ),
            ),
        )

    private suspend fun createCard158() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("separable"),
                mainItems = listOf(
                    CardContentItem(
                        value = "turn in [something]",
                        valueVoicing = "turn in something",
                    ),
                    CardContentItem(
                        value = "hand in [something]",
                        valueVoicing = "hand in something",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Turn in your essays by Tuesday"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("разделяемый"),
                mainItems = listOf(
                    CardContentItem(
                        value = "сдать работу",
                        description = "например, в школе",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Сдайте свои сочинения до вторника"),
                ),
            ),
        )

    private suspend fun createCard159() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("separable"),
                mainItems = listOf(
                    CardContentItem(
                        value = "turn [somebody] in",
                        valueVoicing = "turn somebody in",
                    ),
                ),
                examples = listOf(
                    CardContentItem("My best friend turned me in to the police"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("разделяемый"),
                mainItems = listOf(
                    CardContentItem(
                        value = "сдать, заложить кого-то",
                        description = "например, сдать полиции",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Мой лучший друг сдал меня полиции"),
                ),
            ),
        )

    private suspend fun createCard160() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("inseparable"),
                mainItems = listOf(
                    CardContentItem(
                        value = "turn into [somebody or something]",
                        valueVoicing = "turn into somebody or something",
                    ),
                ),
                examples = listOf(
                    CardContentItem("The frog turned into a beautiful princess"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("неразделяемый"),
                mainItems = listOf(
                    CardContentItem(
                        value = "превращаться во что-то, в кого-то",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Лягушка превратилась в красивую принцессу"),
                ),
            ),
        )

    private suspend fun createCard161() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("separable (always)"),
                mainItems = listOf(
                    CardContentItem(
                        value = "turn [something] into [something]",
                        valueVoicing = "turn something into something",
                    ),
                ),
                examples = listOf(
                    CardContentItem("He turned his hobby into work"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("всегда разделяемый"),
                mainItems = listOf(
                    CardContentItem(
                        value = "превращать что-то во что-то",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Он превратил свое хобби в работу"),
                ),
            ),
        )

    private suspend fun createCard162() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("separable"),
                mainItems = listOf(
                    CardContentItem(
                        value = "turn [something] on/off",
                        valueVoicing = "turn something on or off",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Turn the lights on"),
                    CardContentItem("Turn the coffee machine off, please"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("разделяемый"),
                mainItems = listOf(
                    CardContentItem(
                        value = "включать/выключать что-то",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Включите свет"),
                    CardContentItem("Выключите кофеварку, пожалуйста"),
                ),
            ),
        )

    private suspend fun createCard163() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("inseparable"),
                mainItems = listOf(
                    CardContentItem(
                        value = "turn out to be [somebody or something]",
                        valueVoicing = "turn out to be somebody or something",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Her husband turned out to be a criminal"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("неразделяемый"),
                mainItems = listOf(
                    CardContentItem(
                        value = "оказаться кем-то, чем-то",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Ее муж оказался преступником"),
                ),
            ),
        )

    private suspend fun createCard164() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("separable"),
                mainItems = listOf(
                    CardContentItem(
                        value = "turn [something] up",
                        valueVoicing = "turn something up",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Turn the radio up"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("разделяемый"),
                mainItems = listOf(
                    CardContentItem(
                        value = "делать громче",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Сделайте радио погромче"),
                ),
            ),
        )

    private suspend fun createCard165() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("inseparable"),
                mainItems = listOf(
                    CardContentItem(
                        value = "It turned out that...",
                    ),
                ),
                examples = listOf(
                    CardContentItem("It turned out that your plan was not so bad"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("неразделяемый"),
                mainItems = listOf(
                    CardContentItem(
                        value = "Оказалось, что...",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Оказалось, что твой план был не таким уж плохим"),
                ),
            ),
        )

    private suspend fun createCard166() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("intransitive or separable"),
                mainItems = listOf(
                    CardContentItem(
                        value = "wake [somebody] up",
                        valueVoicing = "wake somebody up",
                    ),
                ),
                examples = listOf(
                    CardContentItem("I wake up at 7 o'clock"),
                    CardContentItem("Wake me up in an hour"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("разделяемый или непереходный"),
                mainItems = listOf(
                    CardContentItem(
                        value = "проснуться, разбудить кого-то",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Я просыпаюсь в 7 часов"),
                    CardContentItem("Разбудите меня через час"),
                ),
            ),
        )

    private suspend fun createCard167() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("intransitive"),
                mainItems = listOf(
                    CardContentItem(
                        value = "warm up",
                    ),
                ),
                examples = listOf(
                    CardContentItem("You need to warm up before the game"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("непереходный"),
                mainItems = listOf(
                    CardContentItem(
                        value = "разогреться",
                        description = "сделать разминку",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Тебе нужно размяться перед игрой"),
                ),
            ),
        )

    private suspend fun createCard168() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("separable"),
                mainItems = listOf(
                    CardContentItem(
                        value = "warm [something] up",
                        valueVoicing = "warm something up",
                    ),
                ),
                examples = listOf(
                    CardContentItem("I warmed up a hamburger"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("разделяемый"),
                mainItems = listOf(
                    CardContentItem(
                        value = "разогреть что-то",
                        description = "обычно о еде",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Я разогрел гамбургер"),
                ),
            ),
        )

    private suspend fun createCard169() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("intransitive"),
                mainItems = listOf(
                    CardContentItem(
                        value = "work out",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Some athletes work out twice a day"),
                    CardContentItem("Your plan worked out very well"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("непереходный"),
                mainItems = listOf(
                    CardContentItem(
                        value = "заниматься спортом, тренироваться",
                    ),
                    CardContentItem(
                        value = "сработать, получиться",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Некоторые спортсмены тренируются дважды в день"),
                    CardContentItem("Твой план сработал очень хорошо"),
                ),
            ),
        )

    private suspend fun createCard170() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("separable"),
                mainItems = listOf(
                    CardContentItem(
                        value = "write something down",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Are you writing down what I am saying?"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("разделяемый"),
                mainItems = listOf(
                    CardContentItem(
                        value = "записывать что-то",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Вы записываете то, что я говорю?"),
                ),
            ),
        )

    private suspend fun createCard171() =
        createCard(
            engSide = CardSide(
                clarification = CardContentItem("separable"),
                mainItems = listOf(
                    CardContentItem(
                        value = "zoom [something] in/out",
                        valueVoicing = "zoom something in or out",
                    ),
                ),
                examples = listOf(
                    CardContentItem("I zoomed in the photo to see the faces"),
                    CardContentItem("The camera zoomed out and we saw a beautiful landscape"),
                ),
            ),
            rusSide = CardSide(
                clarification = CardContentItem("разделяемый"),
                mainItems = listOf(
                    CardContentItem(
                        value = "приближать/отдалять изображение",
                        description = "увеличивать/уменьшать",
                    ),
                ),
                examples = listOf(
                    CardContentItem("Я увеличил фото, чтобы увидеть лица"),
                    CardContentItem("Камера отъехала назад, и мы увидели прекрасный пейзаж"),
                ),
            ),
        )

    private suspend fun createCard(engSide: CardSide, rusSide: CardSide) =
        repository.createCard(
            Card(
                id = idCounter++,
                isLearnt = false,
                side = mapOf(
                    Language.RUSSIAN to rusSide,
                    Language.ENGLISH to engSide,
                ),
            ),
        )
}
