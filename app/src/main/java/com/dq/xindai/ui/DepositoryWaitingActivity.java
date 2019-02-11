package com.dq.xindai.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.dq.xindai.R;
import com.dq.xindai.base.BaseActivity;

/**
 * 我的存管（审核等待中）
 * Created by jingang on 2019/1/12.
 */

public class DepositoryWaitingActivity extends BaseActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBaseContentView(R.layout.activity_depository_waiting);
        setTvTitle("我的存管账户");
        setIvBack();
    }
}
