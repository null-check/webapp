package com.arjun.deeper.views.home;

import com.arjun.deeper.baseclasses.IBasePresenter;
import com.arjun.deeper.baseclasses.IBaseView;

public interface InterfaceHome {

    interface IActivity extends IBaseView {

        void hideStatusBar();

        void hideActionBar();

        void showActionBar();
    }

    interface IPresenter extends IBasePresenter<IActivity> {

    }
}
