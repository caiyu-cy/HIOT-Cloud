package com.example.hiotclound.ui.datastreamhistory;

import com.example.hiotclound.data.DataManager;
import com.example.hiotclound.data.bean.UpDataStreamSwitchBean;
import com.example.hiotclound.test.networktest.ResultBase;
import com.example.hiotclound.ui.base.BasePresenter;

import java.util.List;

import javax.inject.Inject;

/**
 * 通道历史数据presenter类
 */
class LineChartPresenter extends BasePresenter<LineChartView> {
    @Inject
    DataManager dataManager;

    @Inject
    public LineChartPresenter() {
    }

    /**
     * 加载通道历史数据
     *
     * @param upDataStreamId
     */
    public void loadUpDataStreamHistory(String upDataStreamId) {
        subscribe(dataManager.getUpDtaStreamHistory(upDataStreamId), new RequestCallback<ResultBase<List<UpDataStreamSwitchBean>>>() {
            @Override
            public void onNext(ResultBase<List<UpDataStreamSwitchBean>> resultBase) {
                super.onNext(resultBase);
                if (resultBase.getData() != null) {
                    getView().showDataHistory(resultBase.getData());
                }
            }
        });
    }
}
