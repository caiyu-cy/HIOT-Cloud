package com.example.hiotclound.ui.scan;

import com.example.hiotclound.data.DataManager;
import com.example.hiotclound.test.networktest.ResultBase;
import com.example.hiotclound.ui.base.BasePresenter;

import javax.inject.Inject;

class ScanPresenter extends BasePresenter<ScanView> {
    @Inject
    DataManager dataManager;

    @Inject
    public ScanPresenter() {
    }

    /**
     * 绑定设备
     *
     * @param deviceId
     */
    public void bindDevice(String deviceId) {
        subscribe(dataManager.bindDevice(deviceId), new RequestCallback<ResultBase>() {
            @Override
            public void onNext(ResultBase resultBase) {
                super.onNext(resultBase);
                getView().showMessage("绑定成功");
                getView().bindDeviceSucc();
            }
        });
    }
}
