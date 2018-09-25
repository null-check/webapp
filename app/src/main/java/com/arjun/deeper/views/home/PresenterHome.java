package com.arjun.deeper.views.home;

import android.os.Handler;

import com.arjun.deeper.baseclasses.BasePresenter;

public class PresenterHome extends BasePresenter<InterfaceHome.IActivity> implements InterfaceHome.IPresenter {

    private final Handler hideHandler = new Handler();
    private final Runnable hideRunnable = new Runnable() {
        @Override
        public void run() {
            // Delayed removal of status and navigation bar
            view.hideStatusBar();
        }
    };

    public PresenterHome(InterfaceHome.IActivity view) {
        super(view);
    }

    @Override
    public void onResume() {
        super.onResume();
        delayedHide();
    }

    /**
     * Schedules a call to hide() in delay milliseconds, canceling any
     * previously scheduled calls.
     */
    private void delayedHide() {

        // Some older devices needs a small delay between UI widget updates and a change of the status and navigation bar.
        int UI_ANIMATION_DELAY = 300;

        hideHandler.removeCallbacks(hideRunnable);
        hideHandler.postDelayed(hideRunnable, UI_ANIMATION_DELAY);
    }
}
