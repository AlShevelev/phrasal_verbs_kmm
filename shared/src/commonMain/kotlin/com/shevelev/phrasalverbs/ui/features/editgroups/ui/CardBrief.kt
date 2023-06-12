package com.shevelev.phrasalverbs.ui.features.editgroups.ui

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.shevelev.phrasalverbs.core.ui.theme.AnimationValues
import com.shevelev.phrasalverbs.core.ui.theme.ColorsGeneral
import com.shevelev.phrasalverbs.core.ui.theme.Dimens
import com.shevelev.phrasalverbs.domain.entities.Language
import com.shevelev.phrasalverbs.ui.features.editgroups.domain.entities.CardsListItem

@OptIn(ExperimentalMaterialApi::class)
@Composable
internal fun CardBrief(
    item: CardsListItem.CardItem,
    modifier: Modifier = Modifier,
) {
    DragTarget(
        dataToDrop = item.card,
    ) { contentModifier ->
        val startLanguage = Language.ENGLISH
        var language by remember { mutableStateOf(startLanguage) }

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
            modifier = contentModifier
                .height(CardListDimens.cardHeight)
                .graphicsLayer {
                    rotationY = rotation
                    cameraDistance = 8 * density
                },
            elevation = Dimens.elevation,
            shape = RoundedCornerShape(7.dp),
            border = BorderStroke(
                width = 1.dp,
                brush = SolidColor(ColorsGeneral.LightGray),
            ),
            onClick = {
                language = if (language == Language.RUSSIAN) {
                    Language.ENGLISH
                } else {
                    Language.RUSSIAN
                }
            },
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(all = Dimens.padding)
                    .graphicsLayer {
                        alpha = if (language == startLanguage) animateBack else animateFront
                        rotationY = if (language == startLanguage) 0f else 180f
                    },
            ) {
                val cardSide = item.card.side[language]
                cardSide?.let {
                    it.mainItems.forEachIndexed { index, text ->
                        Text(
                            text = text.value,
                            style = MaterialTheme.typography.body1,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.padding(
                                top = if (index == 0) 0.dp else Dimens.paddingSmall,
                            ),
                            fontWeight = FontWeight.Bold,
                        )
                    }
                }
            }
        }
    }
}
