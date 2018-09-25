package com.arjun.deeper.views.home;

import android.os.Handler;

import com.arjun.deeper.baseclasses.BasePresenter;

public class PresenterHome extends BasePresenter<InterfaceHome.IActivity> implements InterfaceHome.IPresenter {

    /**
     * Some older devices needs a small delay between UI widget updates
     * and a change of the status and navigation bar.
     */
    private static final int UI_ANIMATION_DELAY = 300;
    private final Handler mHideHandler = new Handler();

    private final Runnable hidePart1Runnable = new Runnable() {
        @Override
        public void run() {
            hide();
        }
    };

    private final Runnable hidePart2Runnable = new Runnable() {
        @Override
        public void run() {
            // Delayed removal of status and navigation bar
            view.hideStatusBar();
        }
    };

    private final Runnable showRunnable = new Runnable() {
        @Override
        public void run() {
            // Delayed display of UI elements
            view.showActionBar();
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

    private void hide() {

        view.hideActionBar();
        mHideHandler.removeCallbacks(showRunnable);
        mHideHandler.postDelayed(hidePart2Runnable, UI_ANIMATION_DELAY);
    }

    /**
     * Schedules a call to hide() in delay milliseconds, canceling any
     * previously scheduled calls.
     */
    private void delayedHide() {
        mHideHandler.removeCallbacks(hidePart1Runnable);
        mHideHandler.postDelayed(hidePart1Runnable, 200);
    }
}
