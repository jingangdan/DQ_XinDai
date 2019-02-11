package com.dq.xindai.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.dq.xindai.R;
import com.dq.xindai.base.BaseActivity;

/**
 * 我的-关于
 * Created by jingang on 2018/6/28.
 */

public class AboutActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBaseContentView(R.layout.activity_about);
        setTvTitle("关于");
        setIvBack();
    }
}
