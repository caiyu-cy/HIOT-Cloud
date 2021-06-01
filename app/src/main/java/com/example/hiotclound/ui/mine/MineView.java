package com.example.hiotclound.ui.mine;

import com.example.hiotclound.data.bean.UserBean;
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

    /**
     * 重新登录的处理
     */
    void tokenOut();
}
