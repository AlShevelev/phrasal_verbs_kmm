package com.shevelev.phrasalverbs.ui.features.watchallcards.ui

import androidx.compose.animation.core.CubicBezierEasing
import androidx.compose.animation.core.Easing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
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
import com.shevelev.phrasalverbs.core.ui.theme.AnimationTime
import com.shevelev.phrasalverbs.core.ui.theme.Dimens
import com.shevelev.phrasalverbs.domain.entities.Card
import com.shevelev.phrasalverbs.domain.entities.CardContentItem
import com.shevelev.phrasalverbs.domain.entities.CardSide
import com.shevelev.phrasalverbs.domain.entities.Language

@Composable
internal fun CardFull(
    modifier: Modifier = Modifier,
    card: Card,
    isRussianSideDefault: Boolean,
) {
    val startLanguage = if (isRussianSideDefault) Language.RUSSIAN else Language.ENGLISH
    var language by remember { mutableStateOf(startLanguage) }

    // This easing speeds up quickly and slows down gradually
    val slowOutFastInEasing: Easing = CubicBezierEasing(1.0f, 0.2f, 0f, 0.4f)

    val rotation by animateFloatAsState(
        targetValue = if (language != startLanguage) 180f else 0f,
        animationSpec = tween(AnimationTime.CARD_ROTATION),
    )

    val animateFront by animateFloatAsState(
        targetValue = if (language != startLanguage) 1f else 0f,
        animationSpec = tween(AnimationTime.CARD_ROTATION, easing = slowOutFastInEasing),
    )

    val animateBack by animateFloatAsState(
        targetValue = if (language == startLanguage) 1f else 0f,
        animationSpec = tween(AnimationTime.CARD_ROTATION, easing = slowOutFastInEasing),
    )

    Card(
        modifier = modifier
            .height(250.dp)
            .fillMaxWidth()
            .graphicsLayer {
                rotationY = rotation
                cameraDistance = 8 * density
            }
            .clickable {
                language = if (language == Language.RUSSIAN) Language.ENGLISH else Language.RUSSIAN
            },
        elevation = Dimens.elevation,
        shape = RoundedCornerShape(15.dp),
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
            .padding(all = Dimens.margin),
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
                    .padding(top = if (index > 0) Dimens.marginSmall else 0.dp),
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
                    .padding(top = if (index > 0) Dimens.marginSmall else 0.dp),
            )
        }
    }
}
