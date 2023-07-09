package com.shevelev.phrasalverbs.android

import android.app.Application
import com.shevelev.phrasalverbs.data.di.AppStorageDataKoinModule
import com.shevelev.phrasalverbs.data.di.DatabaseDriverKoinModuleAndroid
import com.shevelev.phrasalverbs.data.di.KeyValueStorageKoinModule
import com.shevelev.phrasalverbs.domain.di.DomainKoinModule
import com.shevelev.phrasalverbs.ui.features.editgroups.di.EditGroupsFeatureKoinModule
import com.shevelev.phrasalverbs.ui.features.mainmenu.di.MainMenuFeatureKoinModule
import com.shevelev.phrasalverbs.ui.features.selectgroup.di.SelectGroupKoinModule
import com.shevelev.phrasalverbs.ui.features.settings.di.SettingsFeatureKoinModule
import com.shevelev.phrasalverbs.ui.features.watchallcards.di.WatchAllCardsFeatureKoinModule
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
                AppStorageDataKoinModule,
                DatabaseDriverKoinModuleAndroid,
                KeyValueStorageKoinModule,

                DomainKoinModule,

                NavigationKoinModule,
                EditGroupsFeatureKoinModule,
                MainMenuFeatureKoinModule,
                SettingsFeatureKoinModule,
                WatchAllCardsFeatureKoinModule,
                SelectGroupKoinModule,
            )
        }
    }
}
