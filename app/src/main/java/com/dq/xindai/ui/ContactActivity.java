package com.dq.xindai.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.dq.xindai.R;
import com.dq.xindai.base.BaseActivity;

/**
 * 联系人信息
 * Created by jingang on 2018/6/25.
 */

public class ContactActivity extends BaseActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBaseContentView(R.layout.activity_contact);
        setTvTitle("联系人信息");
        setIvBack();
    }
}
