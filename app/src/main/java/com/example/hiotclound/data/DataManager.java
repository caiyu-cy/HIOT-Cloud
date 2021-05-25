package com.example.hiotclound.data;

import com.example.hiotclound.test.networktest.LoginResultDTO;
import com.example.hiotclound.test.networktest.ResultBase;
import com.example.hiotclound.test.networktest.UserBean;
import com.example.hiotclound.utils.Constants;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * 网络请求封装
 */

public class DataManager {

    private NetworkService service;
    @Inject
    public DataManager(NetworkService service){

        this.service = service;
    }

    /**
     * 登录
     * @param userName
     * @param password
     * @return
     */
    public Observable<ResultBase<LoginResultDTO>> login(String userName, String password){

        return service.login(userName, password, Constants.LOGIN_CODE_APP);

    }

    /**
     * 获取用户信息
     * @param authorization
     * @return
     */

    public Observable<ResultBase<UserBean>> getUserInfo(String authorization){
        return service.getUserInfo(authorization);

    }

    /**
     * 修改邮箱
     * @param authorization
     * @param email
     * @return
     */

    public Observable<ResultBase<String>> updateEmail(String authorization, String email){
        return service.updateEmail(authorization,email);

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
}
