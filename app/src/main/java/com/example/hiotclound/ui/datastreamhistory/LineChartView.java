package com.example.hiotclound.ui.datastreamhistory;

import com.example.hiotclound.data.bean.UpDataStreamSwitchBean;
import com.example.hiotclound.ui.base.BaseView;

import java.util.List;

/**
 * 通道历史数据view层接口
 */
interface LineChartView extends BaseView {
    /**
     * 把返回的通道历史数据显示到图表中
     *
     * @param dataList
     */
    void showDataHistory(List<UpDataStreamSwitchBean> dataList);
}
