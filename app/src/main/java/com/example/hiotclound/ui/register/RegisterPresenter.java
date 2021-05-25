package com.example.hiotclound.ui.register;

import android.text.TextUtils;

import com.example.hiotclound.data.DataManager;
import com.example.hiotclound.test.networktest.LoginResultDTO;
import com.example.hiotclound.test.networktest.ResultBase;
import com.example.hiotclound.test.networktest.UserBean;
import com.example.hiotclound.ui.base.BasePresenter;
import com.example.hiotclound.utils.Constans;

import javax.inject.Inject;

/**
 * 注册模块present类
 */
class RegisterPresenter extends BasePresenter<RegisterView> {
    @Inject
    DataManager dataManager;

    @Inject
    public RegisterPresenter() {

    }

    /**
     * 注册
     */
    public void register(String userName, String password, String email) {
        subscribe(dataManager.register(userName, password, email), new RequestCallback<ResultBase<UserBean>>() {
            @Override
            public void onNext(ResultBase<UserBean> resultBase) {


                if (resultBase.getStatus() == Constans.MSG_STATUS_SUCCESS) {
                    //如果注册成功，吐司注册成功
                    if (resultBase != null && resultBase.getData() != null) {
                        //弹出登录成功
                        getView().showMessage("注册成功");

                        //自动登录，跳转到主界面
                        getView().registerSucc(email, password);
                    }
                } else {
                    //如果注册失败，吐司服务端返回的错误信息
                    if (resultBase != null && !TextUtils.isEmpty(resultBase.getMsg())) {
                        getView().showMessage(resultBase.getMsg());
                    }
                }

            }

            @Override
            public void onError(Throwable e) {
                super.onError(e);
                //吐司连接失败
                getView().showMessage("当前网络无法访问，请稍后再试");
            }
        });
    }

    /**
     * 登录
     *
     * @param email
     * @param password
     */
    public void login(String email, String password) {

        subscribe(dataManager.login(email, password), new RequestCallback<ResultBase<LoginResultDTO>>() {
            @Override
            public void onNext(ResultBase<LoginResultDTO> resultBase) {
                if (resultBase.getStatus() == Constans.MSG_STATUS_SUCCESS) {
                    //如果登录身份正确
                    if (resultBase != null && resultBase.getData() != null) {
                        //弹出登录成功
                        // getView().showMessage("登录成功");

                        //跳转到主界面
                        getView().loginSucc();
                    }
                } else {
                    //如果登录身份错误，弹出服务端返回的错误信息
                    if (resultBase != null && !TextUtils.isEmpty(resultBase.getMsg())) {
                        getView().showMessage(resultBase.getMsg());
                    }
                }
            }

            @Override
            public void onError(Throwable e) {
                super.onError(e);
                getView().showMessage("当前网络无法访问，请稍后再试");
            }
        });
    }
}
