package com.sample_package_name.sample_application_name;

import android.app.Application;
import android.content.Context;

import com.facebook.stetho.Stetho;

public class MyApplication extends Application {

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

    public static Context getContext() {
        return applicationContext;
    }
}
