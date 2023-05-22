package com.shevelev.phrasalverbs

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.shevelev.phrasalverbs.resources.MR
import com.shevelev.phrasalverbs.utils.koin.getKoin
import com.shevelev.phrasalverbs.utils.resource.toLocString
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class)
@Composable
fun App() {
    MaterialTheme {
        val defaultGreeting = MR.strings.greeting_default.toLocString()
        var greetingText by remember { mutableStateOf(defaultGreeting) }
        var showImage by remember { mutableStateOf(false) }

        val viewModel = getKoin<AppViewModel>()

        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Button(onClick = {
                greetingText = MR.strings.greeting_platform.toLocString(viewModel.getPlatformName())
                showImage = !showImage
            }) {
                Text(greetingText)
            }
            AnimatedVisibility(showImage) {
                Image(
                    painterResource("compose-multiplatform.xml"),
                    null,
                )
            }
        }
    }
}
