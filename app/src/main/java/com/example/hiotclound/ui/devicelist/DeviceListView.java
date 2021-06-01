package com.example.hiotclound.ui.devicelist;

import com.example.hiotclound.data.bean.DeviceBean;
import com.example.hiotclound.ui.base.BaseView;

import java.util.List;

/**
 * 设备列表view层接口
 */
interface DeviceListView extends BaseView {
    /**
     * 显示设备列表
     *
     * @param deviceList
     */
    void shoeDeviceList(List<DeviceBean> deviceList);
}
