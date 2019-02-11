package com.dq.xindai.ui.view;

/**
 * 登录接口
 * Created by jingang on 2018/12/18.
 */

public interface LoginView {
    void loginSuccess(String result);

    void sendverify(String result);

    void sendError(String result);

    void loginError(String error);
}
