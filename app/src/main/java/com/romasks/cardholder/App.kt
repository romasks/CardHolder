package com.romasks.cardholder

import android.app.Application
import com.romasks.cardholder.navigation.navModule
import com.romasks.cardholder.view.di.uiModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this

        startKoin {
            androidContext(this@App)
            modules(
                listOf(
                    navModule,
                    uiModule
                )
            )
        }
    }

    companion object {
        internal lateinit var INSTANCE: App
            private set
    }
}