package com.shevelev.phrasalverbs.ui.features.mainmenu.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.shevelev.phrasalverbs.core.resource.toLocString
import com.shevelev.phrasalverbs.resources.MR
import com.shevelev.phrasalverbs.ui.compositionlocal.LocalPlatform
import com.shevelev.phrasalverbs.ui.theme.ColorsTheme

@Composable
internal fun BottomBar() {
    BottomAppBar(
        backgroundColor = ColorsTheme.Background,
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            with(LocalPlatform.current) {
                Text(MR.strings.version.toLocString(versionName, versionCode))
            }
        }
    }
}
