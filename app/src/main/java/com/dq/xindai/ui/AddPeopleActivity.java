package com.dq.xindai.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.dq.xindai.R;
import com.dq.xindai.base.BaseActivity;

/**
 * 我的-人员管理-添加人员
 * Created by jingang on 2018/6/29.
 */

public class AddPeopleActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBaseContentView(R.layout.activity_add_people);
        setTvTitle("添加人员");
        setIvBack();
    }
}
