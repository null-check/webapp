package com.arjun.webapp.views.home

import android.os.Bundle
import android.os.Handler
import com.arjun.webapp.baseclasses.BasePresenter
import com.arjun.webapp.views.home.InterfaceHome.IActivity
import com.arjun.webapp.views.home.InterfaceHome.IPresenter

const val START_URL = "http://myworkspace.ind.in"
const val HOST = "myworkspace.ind.in"

class PresenterHome(view: IActivity) : BasePresenter<IActivity>(view), IPresenter {

    private val hideHandler = Handler()

    private val hideRunnable = Runnable {
        // Delayed removal of status and navigation bar
        view.hideStatusBar()
    }

    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)
        this.view.loadUrl(START_URL)
    }

    override fun onResume() {
        super.onResume()
//        delayedHide()
    }

    /**
     * Schedules a call to hide() in delay milliseconds, canceling any
     * previously scheduled calls.
     */
    private fun delayedHide() {
        // Some older devices needs a small delay between UI widget updates and a change of the status and navigation bar.
        val UI_ANIMATION_DELAY = 300
        hideHandler.removeCallbacks(hideRunnable)
        hideHandler.postDelayed(hideRunnable, UI_ANIMATION_DELAY.toLong())
    }
}