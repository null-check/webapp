package com.sample_package_name.sample_application_name.views.home

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.sample_package_name.sample_application_name.R
import com.sample_package_name.sample_application_name.views.home.InterfaceHome.IActivity
import kotlinx.android.synthetic.main.activity_main.*

class ActivityHome : AppCompatActivity(), IActivity {

    private lateinit var presenterHome: PresenterHome

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenterHome = PresenterHome(this)
    }

    override fun onResume() {
        super.onResume()
        presenterHome.onResume()
    }

    @SuppressLint("InlinedApi")
    override fun hideStatusBar() {

        // Note that some of these constants are new as of API 16 (Jelly Bean)
        // and API 19 (KitKat). It is safe to use them, as they are inlined
        // at compile-time and do nothing on earlier devices.
        root_view.systemUiVisibility = (View.SYSTEM_UI_FLAG_LOW_PROFILE
                or View.SYSTEM_UI_FLAG_FULLSCREEN
                or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION)
    }
}