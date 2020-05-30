package com.sample_package_name.sample_application_name.views.home

import android.os.Handler
import com.sample_package_name.sample_application_name.baseclasses.BasePresenter
import com.sample_package_name.sample_application_name.views.home.InterfaceHome.IActivity
import com.sample_package_name.sample_application_name.views.home.InterfaceHome.IPresenter

class PresenterHome(view: IActivity) : BasePresenter<IActivity?>(view), IPresenter {

    private val hideHandler = Handler()

    private val hideRunnable = Runnable {
        // Delayed removal of status and navigation bar
        view.hideStatusBar()
    }

    override fun onResume() {
        super.onResume()
        delayedHide()
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