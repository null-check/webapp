package com.arjun.deeper.baseclasses;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class BasePresenter<T> implements IBasePresenter<T> {

    protected T view;

    public BasePresenter(T view) {
        registerView(view);
        init();
    }

    @Override
    public void init() {

    }

    @Override
    public void onCreateView(Bundle bundle, T view, View fragmentContainer) {

    }

    @Override
    public void unpackBundle(Bundle bundle) {

    }

    @Override
    public void registerView(T view) {
        this.view = view;
    }

    @Override
    public void initializeViews() {

    }

    @Override
    public void onCreate(Bundle bundle) {

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onRestart() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {

    }

    @Override
    public void onPostCreate(Bundle savedInstanceState) {

    }

    @Override
    public void onNewIntent(Bundle extras) {

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

    }

    protected T getView() {
        if (view == null) {
            throw new NullPointerException("View should not be null");
        }
        return view;
    }
}
