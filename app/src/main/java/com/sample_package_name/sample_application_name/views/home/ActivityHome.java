package com.sample_package_name.sample_application_name.views.home;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;

import com.sample_package_name.sample_application_name.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ActivityHome extends AppCompatActivity implements InterfaceHome.IActivity {

    @BindView(R.id.root_view)
    protected ViewGroup rootView;

    private PresenterHome presenterHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        presenterHome = new PresenterHome(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenterHome.onResume();
    }

    @SuppressLint("InlinedApi")
    @Override
    public void hideStatusBar() {

        // Note that some of these constants are new as of API 16 (Jelly Bean)
        // and API 19 (KitKat). It is safe to use them, as they are inlined
        // at compile-time and do nothing on earlier devices.
        rootView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
    }
}
