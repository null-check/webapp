package com.sample_package_name.sample_application_name

import android.app.Application
import android.content.Context
import com.facebook.stetho.Stetho

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        init()
        initialiseDebugComponents()
    }

    private fun init() {
        context = applicationContext
    }

    private fun initialiseDebugComponents() {
        if (BuildConfig.DEBUG) {
            Stetho.initializeWithDefaults(this)
        }
    }

    companion object {
        var context: Context? = null
            private set
    }
}