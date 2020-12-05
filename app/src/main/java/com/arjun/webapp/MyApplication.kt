package com.arjun.webapp

import android.app.Application
import android.content.Context

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
            // Initialise debug tools here
        }
    }

    companion object {
        var context: Context? = null
            private set
    }
}