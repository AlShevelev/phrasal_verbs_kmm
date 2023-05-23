package com.shevelev.phrasalverbs.android

import android.app.Application
import com.shevelev.phrasalverbs.ui.features.editgroups.di.EditGroupsKoinModule
import com.shevelev.phrasalverbs.ui.features.learning.di.LearningKoinModule
import com.shevelev.phrasalverbs.ui.features.mainmenu.di.MainMenuKoinModule
import com.shevelev.phrasalverbs.ui.features.settings.di.SettingsKoinModule
import com.shevelev.phrasalverbs.ui.navigation.di.NavigationKoinModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class PhrasalVerbsApp : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(if (BuildConfig.DEBUG) Level.ERROR else Level.NONE)
            androidContext(this@PhrasalVerbsApp)
            modules(
                EditGroupsKoinModule,
                LearningKoinModule,
                MainMenuKoinModule,
                NavigationKoinModule,
                SettingsKoinModule,
            )
        }
    }
}
