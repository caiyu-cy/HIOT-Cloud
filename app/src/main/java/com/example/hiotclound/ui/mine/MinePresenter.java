package com.example.hiotclound.ui.mine;

import com.example.hiotclound.data.DataManager;
import com.example.hiotclound.data.bean.UserBean;
import com.example.hiotclound.test.networktest.ResultBase;
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
                //如果Token失效
                if (resultBase.getStatus() == Constans.MSG_STATUS_TOKEN_OUT) {
                    getView().tokenOut();

                }
                if (resultBase.getStatus() != Constans.MSG_STATUS_SUCCESS) {
                    getView().showMessage(resultBase.getMsg());
                    return;
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

    /**
     * 上传用户头像
     *
     * @param filePath
     */
    public void uploadImage(String filePath) {
        subscribe(dataManager.uploadImge(filePath), new RequestCallback<ResultBase<String>>() {
            @Override
            public void onNext(ResultBase<String> resultBase) {

                if (resultBase == null) {
                    getView().showMessage("服务器开小差了，请稍后再试");
                    return;
                }
                //如果Token失效
                if (resultBase.getStatus() == Constans.MSG_STATUS_TOKEN_OUT) {
                    getView().tokenOut();

                }
                if (resultBase.getStatus() != Constans.MSG_STATUS_SUCCESS) {
                    getView().showMessage(resultBase.getMsg());
                    return;
                }

                //获取相对地址
                String url = resultBase.getData();
                //刷新用户头像
                getView().refreshUserHead(url);
            }

        });
    }

    /**
     * 注销
     */
    public void logout() {
        subscribe(dataManager.logout(), new RequestCallback<ResultBase>() {
            @Override
            public void onNext(ResultBase resultBase) {
                if (resultBase == null) {
                    getView().showMessage("服务器开小差了，请稍后再试");
                    return;
                }
                //如果Token失效
                if (resultBase.getStatus() == Constans.MSG_STATUS_TOKEN_OUT) {
                    getView().tokenOut();

                }
                if (resultBase.getStatus() != Constans.MSG_STATUS_SUCCESS) {
                    getView().showMessage(resultBase.getMsg());
                    return;
                }
                //如果返回成功，打开登录界面
                getView().tokenOut();
            }
        });
    }
}
