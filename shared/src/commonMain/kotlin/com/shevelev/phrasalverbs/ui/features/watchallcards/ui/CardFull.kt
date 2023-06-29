package com.shevelev.phrasalverbs.ui.features.watchallcards.ui

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.shevelev.phrasalverbs.core.ui.theme.AnimationValues
import com.shevelev.phrasalverbs.core.ui.theme.Dimens
import com.shevelev.phrasalverbs.domain.entities.Card
import com.shevelev.phrasalverbs.domain.entities.CardContentItem
import com.shevelev.phrasalverbs.domain.entities.CardSide
import com.shevelev.phrasalverbs.domain.entities.Language
import com.shevelev.phrasalverbs.resources.MR
import dev.icerock.moko.resources.compose.painterResource

@OptIn(ExperimentalMaterialApi::class)
@Composable
internal fun CardFull(
    modifier: Modifier = Modifier,
    card: Card,
    isInLearningMode: Boolean,
    isRussianSideDefault: Boolean,
    onLearntClick: () -> Unit,
) {
    val startLanguage = if (isRussianSideDefault) Language.RUSSIAN else Language.ENGLISH
    var language by remember { mutableStateOf(startLanguage) }
    var initialLanguage by remember { mutableStateOf(startLanguage) }

    if (startLanguage != initialLanguage) {
        initialLanguage = startLanguage
        language = startLanguage
    }

    val rotation by animateFloatAsState(
        targetValue = if (language != startLanguage) 180f else 0f,
        animationSpec = tween(AnimationValues.CARD_ROTATION),
    )

    val animateFront by animateFloatAsState(
        targetValue = if (language != startLanguage) 1f else 0f,
        animationSpec = tween(
            durationMillis = AnimationValues.CARD_ROTATION,
            easing = AnimationValues.slowOutFastInEasing,
        ),
    )

    val animateBack by animateFloatAsState(
        targetValue = if (language == startLanguage) 1f else 0f,
        animationSpec = tween(
            durationMillis = AnimationValues.CARD_ROTATION,
            easing = AnimationValues.slowOutFastInEasing,
        ),
    )

    Card(
        modifier = modifier
            .height(250.dp)
            .fillMaxWidth()
            .graphicsLayer {
                rotationY = rotation
                cameraDistance = 8 * density
            },
        elevation = Dimens.elevation,
        shape = RoundedCornerShape(15.dp),
        onClick = {
            language = if (language == Language.RUSSIAN) {
                Language.ENGLISH
            } else {
                Language.RUSSIAN
            }
        },
    ) {
        var isLearnt by remember { mutableStateOf(card.isLearnt) }

        CardSide(
            side = card.side[language]!!,
            isLearnt = isLearnt,
            isInLearningMode = isInLearningMode,
            modifier = Modifier
                .fillMaxSize()
                .graphicsLayer {
                    alpha = if (language == startLanguage) animateBack else animateFront
                    rotationY = if (language == startLanguage) 0f else 180f
                },
            onLearntClick = {
                isLearnt = !isLearnt
                onLearntClick()
            },
        )
    }
}

@Composable
private fun CardSide(
    side: CardSide,
    isLearnt: Boolean,
    isInLearningMode: Boolean,
    modifier: Modifier = Modifier,
    onLearntClick: () -> Unit,
) {
    val topPadding = if (isInLearningMode) {
        0.dp
    } else {
        Dimens.padding
    }
    Column(
        modifier = modifier
            .padding(
                start = Dimens.padding,
                end = Dimens.padding,
                top = topPadding,
                bottom = Dimens.padding,
            ),

    ) {
        if (isInLearningMode) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth(),
            ) {
                Clarification(
                    item = side.clarification,
                )

                val icon = if (isLearnt) {
                    MR.images.star_fill
                } else {
                    MR.images.star_empty
                }
                IconButton(
                    modifier = Modifier.offset(
                        x = Dimens.padding,
                        y = 0.dp,
                    ),
                    onClick = onLearntClick,
                ) {
                    Icon(
                        painter = painterResource(icon),
                        contentDescription = null,
                        modifier = Modifier.size(Dimens.iconButtonSize),
                    )
                }
            }
        } else {
            Clarification(
                item = side.clarification,
            )
        }

        Spacer(
            modifier = Modifier.weight(1f),
        )

        MainItems(
            items = side.mainItems,
        )

        Spacer(
            modifier = Modifier.weight(1f),
        )

        Examples(
            items = side.examples,
        )
    }
}

@Composable
private fun Clarification(
    item: CardContentItem?,
    modifier: Modifier = Modifier,
) {
    Text(
        text = item?.value ?: " ",
        modifier = modifier,
        style = MaterialTheme.typography.body1,
        fontStyle = FontStyle.Italic,
    )
}

@Composable
private fun MainItems(
    items: List<CardContentItem>,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        items.forEachIndexed { index, item ->
            Text(
                text = item.value,
                style = MaterialTheme.typography.h4,
                modifier = Modifier
                    .padding(top = if (index > 0) Dimens.paddingSmall else 0.dp),
                textAlign = TextAlign.Center,
            )

            item.description?.let {
                Text(
                    text = it,
                    style = MaterialTheme.typography.subtitle1,
                    modifier = Modifier,
                )
            }
        }
    }
}

@Composable
private fun Examples(
    items: List<CardContentItem>,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        items.forEachIndexed { index, item ->
            Text(
                text = item.value,
                style = MaterialTheme.typography.subtitle2,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(top = if (index > 0) Dimens.paddingSmall else 0.dp),
            )
        }
    }
}
