package com.example.hiotclound;

import androidx.multidex.MultiDexApplication;

import com.example.hiotclound.injection.component.ApplicationComponent;
import com.example.hiotclound.injection.component.DaggerApplicationComponent;
import com.example.hiotclound.injection.module.ApplicationModule;

/**
 * 所有程序的入口
 */

public class App extends MultiDexApplication {

    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        initializeInjector();
    }

    private void initializeInjector() {
        component = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
        component.inject(this);
    }

    public ApplicationComponent component() {
        return component;
    }

}

