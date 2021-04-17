package com.example.hiotclound.injection.component;

import android.app.Application;
import android.content.Context;

import com.example.hiotclound.App;
import com.example.hiotclound.injection.ApplicationContext;
import com.example.hiotclound.injection.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * A component whose lifetime is the life of the application.
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(App application);

    @ApplicationContext
    Context context();

    Application application();


    @Component.Builder
    interface ApplicationModuleBuilder {
        ApplicationComponent build();

        ApplicationModuleBuilder applicationModule(ApplicationModule applicationModule);
    }
}
