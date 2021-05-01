package com.romasks.cardholder

import android.app.Application
import com.romasks.cardholder.data.di.repoModule
import com.romasks.cardholder.domain.di.domainModule
import com.romasks.cardholder.view.di.uiModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(
                listOf(
                    domainModule,
                    repoModule,
                    uiModule
                )
            )
        }
    }
}