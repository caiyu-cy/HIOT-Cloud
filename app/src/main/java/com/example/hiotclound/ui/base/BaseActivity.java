package com.example.hiotclound.ui.base;

import android.app.Application;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.hiotclound.App;
import com.example.hiotclound.injection.component.ActivityComponent;
import com.example.hiotclound.injection.component.ApplicationComponent;
import com.example.hiotclound.injection.component.DaggerActivityComponent;
import com.example.hiotclound.injection.module.ActivityModule;

/**
 * MVP架构Activity基类
 */
public abstract class BaseActivity<V extends BaseView , P extends BasePresenter<V>> extends AppCompatActivity implements BaseView {
     private P presenter;

    /**
     * 活动注入器
     */
    private ActivityComponent mActivityComponent;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        injectIndependies();
        presenter = createPresenter();
        if (presenter != null){
            presenter.setView((V)this);


        }

    }

    public abstract P createPresenter();


    public abstract void injectIndependies();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.destroy();
    }

    @Override
    protected void onStop() {

        super.onStop();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }



    public ActivityComponent getActivityComponent() {
        if (null == mActivityComponent) {
            mActivityComponent = DaggerActivityComponent.builder()
                    .activityModule(getActivityModule())
                    .applicationComponent(getApplicationComponent())
                    .build();
        }
        return mActivityComponent;
    }

    public ApplicationComponent getApplicationComponent() {

        Application application = getApplication();
        App app = (App) application;
        return app.component();
    }

    /**
     * Get an Activity module for dependency injection.
     */
    protected ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
