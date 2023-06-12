package com.shevelev.phrasalverbs.ui.features.watchallcards.ui

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
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

@OptIn(ExperimentalMaterialApi::class)
@Composable
internal fun CardFull(
    modifier: Modifier = Modifier,
    card: Card,
    isRussianSideDefault: Boolean,
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
        CardSide(
            side = card.side[language]!!,
            modifier = Modifier
                .fillMaxSize()
                .graphicsLayer {
                    alpha = if (language == startLanguage) animateBack else animateFront
                    rotationY = if (language == startLanguage) 0f else 180f
                },
        )
    }
}

@Composable
private fun CardSide(
    side: CardSide,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .padding(all = Dimens.padding),
    ) {
        Clarification(
            item = side.clarification,
        )

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
