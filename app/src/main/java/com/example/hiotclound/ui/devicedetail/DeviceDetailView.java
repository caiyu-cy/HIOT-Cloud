package com.example.hiotclound.ui.devicedetail;

import com.example.hiotclound.data.bean.DeviceDetailBean;
import com.example.hiotclound.ui.base.BaseView;

/**
 * 登录详情view层接口
 */
interface DeviceDetailView extends BaseView {
    /**
     * 根据设备详情内容显示到界面
     *
     * @param data
     */
    void setDeviceDetail(DeviceDetailBean data);
}
