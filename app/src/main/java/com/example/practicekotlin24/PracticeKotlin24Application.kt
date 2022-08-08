package com.example.practicekotlin24

import android.app.Application
import com.example.practicekotlin24.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class PracticeKotlin24Application: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@PracticeKotlin24Application)
            modules(appModule)
        }
    }


}