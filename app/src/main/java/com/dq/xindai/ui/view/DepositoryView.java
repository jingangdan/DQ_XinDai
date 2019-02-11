package com.dq.xindai.ui.view;

/**
 * 存管信息操作结果
 * Created by jingang on 2019/1/15.
 */

public interface DepositoryView {
    /*存管信息*/
    void getSuccess(String result);

    /*网页跳转*/
    void sendSuccess(String result);

    void sendError(String error);
}
