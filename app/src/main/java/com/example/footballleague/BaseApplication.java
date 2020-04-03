package com.example.footballleague;

import android.app.Application;

import com.example.footballleague.di.components.AppComponent;
import com.example.footballleague.di.components.DaggerAppComponent;


import io.reactivex.plugins.RxJavaPlugins;


public class BaseApplication extends Application {

    private AppComponent appComponent;


    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.create();
      RxJavaPlugins.setErrorHandler(throwable -> {});

    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}