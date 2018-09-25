package com.arjun.deeper;

import android.app.Application;
import android.content.Context;

import com.facebook.stetho.Stetho;

public class DeeperApplication extends Application {

    private static Context applicationContext;

    public void onCreate() {
        super.onCreate();
        init();
        initialiseDebugComponents();
    }

    private void init() {
        applicationContext = getApplicationContext();
    }

    private void initialiseDebugComponents() {
        if (BuildConfig.DEBUG) {
            Stetho.initializeWithDefaults(this);
        }
    }
}
