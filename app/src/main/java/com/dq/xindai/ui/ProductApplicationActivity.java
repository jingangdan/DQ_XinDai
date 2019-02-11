package com.dq.xindai.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.dq.xindai.R;
import com.dq.xindai.base.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 产品申请表
 * Created by jingang on 2018/6/24.
 */

public class ProductApplicationActivity extends BaseActivity {
    @Bind(R.id.linPAMarriage)
    LinearLayout linPAMarriage;
    @Bind(R.id.linPAContact)
    LinearLayout linPAContact;
    @Bind(R.id.butLoanDetail)
    Button butLoanDetail;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBaseContentView(R.layout.activity_product_application);
        ButterKnife.bind(this);
        setTvTitle("产品申请表");
        setIvBack();
    }

    @OnClick({R.id.linPAMarriage, R.id.linPAContact, R.id.butLoanDetail})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.linPAMarriage:
                break;
            case R.id.linPAContact:
                goToActivity(ContactActivity.class);
                break;
            case R.id.butLoanDetail:
                break;
        }
    }
}
