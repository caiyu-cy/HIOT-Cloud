package com.example.hiotclound.ui.register;

import com.example.hiotclound.ui.base.BaseView;

/**
 * 注册模块view层接口
 */
interface RegisterView extends BaseView {

    /**
     * 注册成功后的处理
     *
     * @param userName
     * @param password
     */
    void registerSucc(String userName, String password);

    /**
     * 自动登录后的处理
     */
    void loginSucc();
}
