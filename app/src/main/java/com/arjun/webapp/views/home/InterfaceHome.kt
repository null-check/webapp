package com.arjun.webapp.views.home

import com.arjun.webapp.baseclasses.IBasePresenter
import com.arjun.webapp.baseclasses.IBaseView

interface InterfaceHome {
    interface IActivity : IBaseView {
        fun hideStatusBar()
        fun loadUrl(url: String)
    }

    interface IPresenter : IBasePresenter<IActivity>
}