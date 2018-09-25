package com.sample_package_name.sample_application_name.views.home;

import com.sample_package_name.sample_application_name.baseclasses.IBasePresenter;
import com.sample_package_name.sample_application_name.baseclasses.IBaseView;

public interface InterfaceHome {

    interface IActivity extends IBaseView {

        void hideStatusBar();
    }

    interface IPresenter extends IBasePresenter<IActivity> {

    }
}
