package com.example.hiotclound.test.networktest;

import android.text.TextUtils;
import android.widget.Toast;

import com.example.hiotclound.data.DataManager;
import com.example.hiotclound.ui.base.BasePresenter;

import javax.inject.Inject;

public class TestNetworkPresenter extends BasePresenter<TestNetworkPackActivity> {

    @Inject
    DataManager dataManager;

    @Inject
    public TestNetworkPresenter() {
    }

    public void login(String userName, String password) {
        subscribe(dataManager.login(userName, password), new RequestCallback<ResultBase<LoginResultDTO>>() {
            @Override
            public void onNext(ResultBase<LoginResultDTO> resultBase) {

                if (resultBase != null && resultBase.getData() != null) {
                    getView().showToken(resultBase.data.getTokenValue());

                } else if (resultBase != null && !TextUtils.isEmpty(resultBase.getMsg())) {
                    getView().showMessage(resultBase.getMsg());


                }

            }
        });
    }

    /**
     * 获取用户信息
     * @param authorization
     */
    public void getUserInfo(String authorization){
        subscribe(dataManager.getUserInfo(authorization), new RequestCallback<ResultBase<UserBean>>() {
            @Override
            public void onNext(ResultBase<UserBean> resultBase) {
                if (resultBase != null && resultBase.getData() != null){
                    UserBean userBean = resultBase.getData();
                    String str = String.format("用户：%s,email：%s",
                            userBean.getUsername(), userBean.getEmail());
                    getView().showMessage(str);
                }else if (resultBase != null && !TextUtils.isEmpty(resultBase.getMsg())){
                    getView().showMessage(resultBase.getMsg());
                }
            }
        });

    }


    /**
     * 修改邮箱
     * @param authorization
     * @param email
     */
    public void updateEmail(String authorization, String email){
        subscribe(dataManager.updateEmail(authorization, email), new RequestCallback<ResultBase<String>>() {
            @Override
            public void onNext(ResultBase<String> resultBase) {
                if (resultBase != null && !TextUtils.isEmpty(resultBase.getData())) {
                    String newEmail = resultBase.getData();
                    getView().showMessage("修改成功，新邮箱:" + newEmail);


                }
                if(resultBase != null && !TextUtils.isEmpty(resultBase.getMsg())){
                    getView().showMessage(resultBase.getMsg());

                }

            }
        });

    }


    /**
     * 注册
     * @param userName
     * @param password
     * @param email
     */
    public void register(String userName, String password, String email){
        subscribe(dataManager.register(userName, password, email), new RequestCallback<ResultBase<UserBean>>() {
            @Override
            public void onNext(ResultBase<UserBean> resultBase) {
                if (resultBase != null && resultBase.getData() != null){
                    UserBean newUserBen = resultBase.getData();
                    String userStr = String.format("username:%s, email:%s",newUserBen.getUsername(), newUserBen.getEmail());
                    getView().showMessage(userStr);
                }
                if (resultBase != null && !TextUtils.isEmpty(resultBase.getMsg())){
                    getView().showMessage( resultBase.getMsg());
                }

            }
        });
    }
}
