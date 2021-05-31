package com.example.hiotclound.ui.base;

/**
 * MVP架构视图层接口
 */
public interface BaseView {
    /**
     * @param message
     */
    void showMessage(String message);

    /**
     * token失效的处理
     */
    void tokenOut();
}
