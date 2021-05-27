package com.example.hiotclound.data;

import com.example.hiotclound.test.networktest.LoginResultDTO;
import com.example.hiotclound.test.networktest.ResultBase;
import com.example.hiotclound.test.networktest.UserBean;
import com.example.hiotclound.utils.Constans;
import com.example.hiotclound.utils.Constants;

import java.io.File;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * 网络请求封装
 */

public class DataManager {

    private NetworkService service;


    SharedPreferencesHelper sharedPreferencesHelper;
    @Inject
    public DataManager(NetworkService service, SharedPreferencesHelper sharedPreferencesHelper) {

        this.service = service;

        this.sharedPreferencesHelper = sharedPreferencesHelper;
    }

    /**
     * 登录
     * @param userName
     * @param password
     * @return
     */
    public Observable<ResultBase<LoginResultDTO>> login(String userName, String password){

        return service.login(userName, password, Constants.LOGIN_CODE_APP)
                .doOnNext(new Consumer<ResultBase<LoginResultDTO>>() {
                    @Override
                    public void accept(ResultBase<LoginResultDTO> resultBase) throws Exception {
                        if (resultBase.getStatus() == Constans.MSG_STATUS_SUCCESS) {
                            if (resultBase != null && resultBase.getData() != null) {
                                sharedPreferencesHelper.setUserToken(resultBase.getData().getTokenValue());

                            }

                        }
                    }
                });


    }

    /**
     * 获取用户信息
     * @param
     * @return
     */

    public Observable<ResultBase<UserBean>> getUserInfo() {
        return service.getUserInfo(sharedPreferencesHelper.getUserToken());

    }

    /**
     * 修改邮箱
     * @param
     * @param email
     * @return
     */

    public Observable<ResultBase<String>> updateEmail(String email) {
        return service.updateEmail(sharedPreferencesHelper.getUserToken(), email);

    }

    /**
     * 注册
     * @param userName 用户名
     * @param password 密码
     * @param email   邮箱地址
     * @return
     */
    public Observable<ResultBase<UserBean>> register(String userName, String password, String email){
        UserBean userBean = new UserBean();
        userBean.setUsername(userName);
        userBean.setPassword(password);
        userBean.setEmail(email);
        userBean.setUserType(Constants.REGISTER_TYPE_NORMAL);
        return service.register(userBean);

    }

    /**
     * 上传头像
     *
     * @param filePath
     */
    public Observable<ResultBase<String>> uploadImge(String filePath) {
        File file = new File(filePath);
        RequestBody requestBody = RequestBody.create(MediaType.parse(Constans.MULTIPART_FORM_DATA), file);
        MultipartBody.Part multiparFile = MultipartBody.Part.createFormData("file", file.getName(), requestBody);
        return service.uploadImage(multiparFile, sharedPreferencesHelper.getUserToken());
    }
}
