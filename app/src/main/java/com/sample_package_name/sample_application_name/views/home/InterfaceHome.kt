package com.sample_package_name.sample_application_name.views.home

import com.sample_package_name.sample_application_name.baseclasses.IBasePresenter
import com.sample_package_name.sample_application_name.baseclasses.IBaseView

interface InterfaceHome {
    interface IActivity : IBaseView {
        fun hideStatusBar()
    }

    interface IPresenter : IBasePresenter<IActivity?>
}