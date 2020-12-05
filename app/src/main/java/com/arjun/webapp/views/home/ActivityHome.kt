package com.arjun.webapp.views.home

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.TextUtils
import android.view.View
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.arjun.webapp.R
import com.arjun.webapp.views.home.InterfaceHome.IActivity
import kotlinx.android.synthetic.main.activity_main.*

class ActivityHome : AppCompatActivity(), IActivity {

    private var presenterHome: PresenterHome = PresenterHome(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupWebView()
        presenterHome.onCreate(Bundle())
    }

    fun setupWebView() {
        web_view.webViewClient = MyBrowser()
        web_view.settings.javaScriptEnabled = true
//        web_view.settings.allowContentAccess = true
//        web_view.settings.allowFileAccess = true
        web_view.settings.domStorageEnabled = true
//        web_view.settings.setAppCacheEnabled(true)
    }

    override fun onResume() {
        super.onResume()
        presenterHome.onResume()
    }

    override fun loadUrl(url: String) {
        web_view.loadUrl(url)
    }

    private class MyBrowser : WebViewClient() {

        override fun shouldOverrideUrlLoading(view: WebView, request: WebResourceRequest?): Boolean {
            if (request != null && request.url != null && !TextUtils.isEmpty(request.url.host) ) {
                if (!request.url.host!!.contains(HOST)) {
                    Handler(Looper.getMainLooper()).post { Toast.makeText(view.context, "External link not supported", Toast.LENGTH_LONG).show() }
                    return true
                }
            }
            return super.shouldOverrideUrlLoading(view, request)
        }
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