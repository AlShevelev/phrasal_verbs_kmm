package com.shevelev.phrasalverbs.android

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.shevelev.phrasalverbs.MainView
import com.shevelev.phrasalverbs.ui.compositionlocal.PlatformInfo

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MainView(
                platformInfo = PlatformInfo(
                    versionName = BuildConfig.VERSION_NAME,
                    versionCode = BuildConfig.VERSION_CODE.toString(),
                ),
            )
        }
    }
}
