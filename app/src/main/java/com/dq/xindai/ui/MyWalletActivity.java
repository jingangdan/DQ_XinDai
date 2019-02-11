package com.dq.xindai.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dq.xindai.R;
import com.dq.xindai.base.BaseActivity;
import com.dq.xindai.bean.BalanceData;
import com.dq.xindai.fragment.p.MePresenter;
import com.dq.xindai.fragment.view.MeFView;
import com.dq.xindai.utils.DataCode;
import com.dq.xindai.utils.GsonUtil;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 我的-- 我的钱包
 * Created by jingang on 2018/12/25.
 */

public class MyWalletActivity extends BaseActivity implements MeFView {
    @Bind(R.id.tvMeWalletBalance)
    TextView tvMeWalletBalance;
    @Bind(R.id.linMeWalletMenu1)
    LinearLayout linMeWalletMenu1;
    @Bind(R.id.linMeWalletMenu2)
    LinearLayout linMeWalletMenu2;
    @Bind(R.id.linMeWalletMenu3)
    LinearLayout linMeWalletMenu3;
    @Bind(R.id.linMeWalletMenu4)
    LinearLayout linMeWalletMenu4;

    private double balance;

    private MePresenter mePresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBaseContentView(R.layout.activity_wallet);
        ButterKnife.bind(this);
        setTvTitle("我的钱包");
        setIvBack();

        mePresenter = new MePresenter(this, this);

        mePresenter.getWalletBalance(getUserToken());
    }

    @OnClick({R.id.linMeWalletMenu1, R.id.linMeWalletMenu2, R.id.linMeWalletMenu3, R.id.linMeWalletMenu4})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.linMeWalletMenu1:
                //充值
                setIntent1("1");
                break;
            case R.id.linMeWalletMenu2:
                //提现
                setIntent1("2");
                break;
            case R.id.linMeWalletMenu3:
                //充值记录
                setIntent2("1");
                break;
            case R.id.linMeWalletMenu4:
                //提现记录
                setIntent2("2");
                break;
        }
    }

    /**
     * 跳转到MoneyOperationActivity
     *
     * @param type
     */
    public void setIntent1(String type) {
        startActivityForResult(new Intent(this, MoneyOperationActivity.class)
                        .putExtra("type", type)
                        .putExtra("balance", balance),
                DataCode.WALLET);
    }

    /**
     * 跳转到MoneyRecordActivity
     *
     * @param type
     */
    public void setIntent2(String type) {
        startActivity(new Intent(this, MoneyRecordActivity.class)
                .putExtra("type", type));
    }

    @Override
    public void Success(String result) {
        BalanceData data = GsonUtil.gsonIntance().gsonToBean(result, BalanceData.class);

        tvMeWalletBalance.setText(data.getData().getBalance() + "");
    }

    @Override
    public void sendError(String result) {
        showMessage(result);
    }

    @Override
    public void Error(String error) {
        showMessage(error);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == DataCode.WALLET || resultCode == DataCode.RECHARGE) {
            //刷新数据（余额）
            mePresenter.getWalletBalance(getUserToken());
        }
    }
}
