package com.example.hiotclound.ui.devicelist;

import com.example.hiotclound.data.DataManager;
import com.example.hiotclound.data.bean.DeviceBean;
import com.example.hiotclound.test.networktest.ResultBase;
import com.example.hiotclound.ui.base.BasePresenter;
import com.example.hiotclound.utils.Constans;

import java.util.List;

import javax.inject.Inject;

/**
 * 设备列表presenter层类
 */
class DeviceListPresenter extends BasePresenter<DeviceListView> {
    @Inject
    DataManager dataManager;

    @Inject
    public DeviceListPresenter() {
    }

    /**
     * 加载设备列表
     */
    public void loadDeviceList() {
        subscribe(dataManager.listBindedDevice(Constans.DEVICE_STATUS_BINDED), new RequestCallback<ResultBase<List<DeviceBean>>>() {
            @Override
            public void onNext(ResultBase<List<DeviceBean>> listResultBase) {
                super.onNext(listResultBase);
                List<DeviceBean> deviceList = listResultBase.getData();
                getView().shoeDeviceList(deviceList);
            }
        });
    }
}
