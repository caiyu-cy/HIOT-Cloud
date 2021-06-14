/**
 * Copyright (C) 2015 Fernando Cejas Open Source Project
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.hiotclound.injection.component;


import com.example.hiotclound.injection.PerActivity;
import com.example.hiotclound.injection.module.ActivityModule;
import com.example.hiotclound.test.mvptest.TsetMVPActivity;
import com.example.hiotclound.test.networktest.TestNetworkPackActivity;
import com.example.hiotclound.ui.datastreamhistory.LineChartActivity;
import com.example.hiotclound.ui.devicedetail.DeviceDetailActivity;
import com.example.hiotclound.ui.devicelist.DeviceListFragment;
import com.example.hiotclound.ui.login.LoginActivity;
import com.example.hiotclound.ui.main.MainActivity;
import com.example.hiotclound.ui.main.SplashActivity;
import com.example.hiotclound.ui.mine.MineFragment;
import com.example.hiotclound.ui.register.RegisterActivity;
import com.example.hiotclound.ui.scan.ScanActivity;

import dagger.Component;

/**
 * A base component upon which fragment's components may depend.
 * Activity-level components should extend this component.
 * <p>
 * Subtypes of ActivityComponent should be decorated with annotation:
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity mainActivity);

    void  inject(TsetMVPActivity tsetMVPActivity);

    void  inject(TestNetworkPackActivity activity);

    void inject(LoginActivity activity);

    void inject(SplashActivity activity);

    void inject(RegisterActivity activity);

    void inject(ScanActivity activity);

    void inject(DeviceDetailActivity activity);

    void inject(LineChartActivity activity);

    void inject(MineFragment fragment);

    void inject(DeviceListFragment fragment);
    @Component.Builder
    interface ActivityComponentBuilder {

        ActivityComponent build();

        ActivityComponentBuilder applicationComponent(ApplicationComponent applicationComponent);

        ActivityComponentBuilder activityModule(ActivityModule activityModule);


    }
}
