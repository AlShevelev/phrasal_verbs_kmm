package com.shevelev.phrasalverbs.data.di

import com.shevelev.phrasalverbs.domain.di.DomainKoinModule
import com.shevelev.phrasalverbs.ui.features.editgroups.di.EditGroupsFeatureKoinModule
import com.shevelev.phrasalverbs.ui.features.mainmenu.di.MainMenuFeatureKoinModule
import com.shevelev.phrasalverbs.ui.features.selectgroup.di.SelectGroupKoinModule
import com.shevelev.phrasalverbs.ui.features.settings.di.SettingsFeatureKoinModule
import com.shevelev.phrasalverbs.ui.features.watchallcards.di.WatchAllCardsFeatureKoinModule
import com.shevelev.phrasalverbs.ui.navigation.di.NavigationKoinModule
import org.koin.core.context.startKoin

fun initKoin() {
    startKoin {
        modules(
            AppStorageDataKoinModule,
            DatabaseDriverKoinModuleIos,
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