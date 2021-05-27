package com.example.hiotclound.ui.mine;

import com.example.hiotclound.test.networktest.UserBean;
import com.example.hiotclound.ui.base.BaseView;

/**
 * 用户中心View层接口
 */
public interface MineView extends BaseView {
    /**
     * 刷新用户信息
     *
     * @param userBean
     */
    void refreshUserInfo(UserBean userBean);

    void refreshUserHead(String url);
}
