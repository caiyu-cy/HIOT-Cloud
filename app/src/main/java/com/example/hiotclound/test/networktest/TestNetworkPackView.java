package com.example.hiotclound.test.networktest;

/**
 * 网络封装测试MVP架构view层接口
 */
public interface TestNetworkPackView {
    /**
     * 显示token
     * @param token
     */
    void showToken(String token);

    /**
     * 显示信息
     * @param message
     */
    void showMessage(String message);
}
