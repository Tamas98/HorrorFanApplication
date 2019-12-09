package com.example.horrorfan.application

import android.app.Application
import timber.log.Timber

class HorrorApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())
    }
}