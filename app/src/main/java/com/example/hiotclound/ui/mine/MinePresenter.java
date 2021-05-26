package com.example.hiotclound.ui.mine;

import com.example.hiotclound.data.DataManager;
import com.example.hiotclound.test.networktest.ResultBase;
import com.example.hiotclound.test.networktest.UserBean;
import com.example.hiotclound.ui.base.BasePresenter;
import com.example.hiotclound.utils.Constans;

import javax.inject.Inject;

/**
 * 用户中心presenter类
 */
public class MinePresenter extends BasePresenter<MineView> {

    @Inject
    DataManager dataManager;

    @Inject
    public MinePresenter() {
    }

    /**
     * 加载用户信息
     */
    public void loadUserInfo() {

        subscribe(dataManager.getUserInfo(), new RequestCallback<ResultBase<UserBean>>() {
            @Override
            public void onNext(ResultBase<UserBean> resultBase) {
                if (resultBase == null) {
                    getView().showMessage("服务器开小差了，请稍后再试");
                    return;
                }
                if (resultBase.getStatus() != Constans.MSG_STATUS_SUCCESS) {
                    getView().showMessage(resultBase.getMsg());
                }
                if (resultBase.getData() == null) {
                    getView().showMessage("服务器开小差了，请稍后再试");
                    return;
                }
                UserBean userBean = resultBase.getData();
                getView().refreshUserInfo(userBean);
            }
        });
    }
}
