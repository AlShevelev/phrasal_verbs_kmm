package com.shevelev.phrasalverbs.android

import android.app.Application
import com.shevelev.phrasalverbs.di.SharedKoinModule
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
            modules(SharedKoinModule)
        }
    }
}
