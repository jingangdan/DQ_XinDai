package com.dq.xindai.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dq.xindai.R;
import com.dq.xindai.base.BaseActivity;
import com.dq.xindai.bean.WebData;
import com.dq.xindai.bean.ResultBase;
import com.dq.xindai.openssl.Base64Utils;
import com.dq.xindai.openssl.RSAUtils;
import com.dq.xindai.utils.DataCode;
import com.dq.xindai.utils.GsonUtil;
import com.dq.xindai.utils.HttpPath;
import com.dq.xindai.utils.HttpxUtils;
import com.dq.xindai.utils.IntentWebUtils;

import org.xutils.common.Callback;

import java.security.PrivateKey;
import java.util.HashMap;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 充值/提现（金钱操作）
 * Created by jingang on 2018/12/26.
 */

public class MoneyOperationActivity extends BaseActivity {
    @Bind(R.id.tvMOName)
    TextView tvMOName;
    @Bind(R.id.etMoMoney)
    EditText etMoMoney;
    @Bind(R.id.tvMOCash)
    TextView tvMOCash;
    @Bind(R.id.butMO)
    Button butMO;
    @Bind(R.id.butMo1)
    Button butMo1;
    @Bind(R.id.butMo2)
    Button butMo2;
    @Bind(R.id.tvMoWayMode)
    TextView tvMoWayMode;
    @Bind(R.id.linMoWayMode)
    LinearLayout linMoWayMode;

    private String type;
    private String money;
    private double balance;

    private int way_mode = 1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBaseContentView(R.layout.activity_money_operation);
        ButterKnife.bind(this);

        type = getIntent().getStringExtra("type");
        balance = getIntent().getDoubleExtra("balance", 1);
        if (type.equals("1")) {
            //充值
            setTvTitle("充值");
            tvMOName.setText("充值金额");
            etMoMoney.setHint("请输入充值金额");
            tvMOCash.setVisibility(View.GONE);
            linMoWayMode.setVisibility(View.GONE);
        } else if (type.equals("2")) {
            //提现
            setTvTitle("提现");
            tvMOName.setText("提现金额");
            etMoMoney.setHint("请输入提现金额");
            tvMOCash.setVisibility(View.VISIBLE);
            tvMOCash.setText("可提现金额：" + balance + "元");
            linMoWayMode.setVisibility(View.VISIBLE);
        }
        setIvBack();
    }

    @SuppressLint("SetTextI18n")
    @OnClick({R.id.butMo1, R.id.butMo2, R.id.butMO})
    public void onViewClicked(View view) {
        money = etMoMoney.getText().toString().trim();
        switch (view.getId()) {
            case R.id.butMo1:
                way_mode = 1;
                butMo1.setBackgroundResource(R.drawable.kuang_but2);
                butMo2.setBackgroundResource(R.drawable.kuang_but3);
                tvMoWayMode.setText("T+0提现手续费：0.05% + 2元");
                break;
            case R.id.butMo2:
                way_mode = 2;
                butMo1.setBackgroundResource(R.drawable.kuang_but3);
                butMo2.setBackgroundResource(R.drawable.kuang_but2);
                tvMoWayMode.setText("T+1提现手续费：" + "免费");
                break;
            case R.id.butMO:
                if (TextUtils.isEmpty(money)) {
                    showMessage("请输入金额");
                    return;
                }
                if (type.equals("1")) {
                    getMemRecharge(money, getUserToken());
                } else if (type.equals("2")) {
                    if (Double.parseDouble(money) > balance) {
                        showMessage("余额不足");
                        return;
                    }
                    getMemWithDraw(money, way_mode, getUserToken());
                }
                break;
            default:
                break;
        }
    }

    /**
     * 充值前加密
     *
     * @param money
     * @param token
     */
    public void getMemRecharge(String money, String token) {
        String PATH_RSA = "money=" + money + "&token=" + token;
        Log.e("ssssss", "充值参数 = " + PATH_RSA);
        try {
            PrivateKey privateKey = RSAUtils.loadPrivateKey(RSAUtils.PRIVATE_KEY);
            byte[] encryptByte = RSAUtils.encryptDataPrivate(PATH_RSA.getBytes(), privateKey);
            xUtilsMemRecharge(Base64Utils.encode(encryptByte).toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 充值
     *
     * @param sign
     */
    public void xUtilsMemRecharge(String sign) {
        Log.e("ssssss", "充值接口 = " + HttpPath.MEM_RECHARGE + "sign=" + sign);
        HashMap<String, Object> map = new HashMap<>();
        map.put("sign", sign);
        HttpxUtils.Post(this,
                HttpPath.MEM_RECHARGE,
                map, new Callback.CommonCallback<String>() {
                    @Override
                    public void onSuccess(String result) {
                        Log.e("ssssss", result);
                        ResultBase resultBase = GsonUtil.gsonIntance().gsonToBean(result, ResultBase.class);
                        if (resultBase.getStatus() == 1) {
                            IntentWebUtils.setIntentWeb(result,MoneyOperationActivity.this,DataCode.RECHARGE);
                        } else {
                            showMessage(resultBase.getInfo());
                        }
                    }

                    @Override
                    public void onError(Throwable ex, boolean isOnCallback) {
                        showMessage("失败，请检查网络");
                    }

                    @Override
                    public void onCancelled(CancelledException cex) {

                    }

                    @Override
                    public void onFinished() {

                    }
                });
    }

    /**
     * 提现前加密
     *
     * @param money
     * @param way_mode
     * @param token
     */
    public void getMemWithDraw(String money, int way_mode, String token) {
        String PATH_RSA = "money=" + money + "&way_mode=" + way_mode + "&token=" + token;
        Log.e("ssssss", "提现参数 = " + PATH_RSA);
        try {
            PrivateKey privateKey = RSAUtils.loadPrivateKey(RSAUtils.PRIVATE_KEY);
            byte[] encryptByte = RSAUtils.encryptDataPrivate(PATH_RSA.getBytes(), privateKey);
            xUtilsMemWithDraw(Base64Utils.encode(encryptByte).toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 提现
     *
     * @param sign
     */
    public void xUtilsMemWithDraw(String sign) {
        Log.e("ssssss", "提现接口 = " + HttpPath.MEM_WITHDRAW + "sign=" + sign);
        HashMap<String, Object> map = new HashMap<>();
        map.put("sign", sign);
        HttpxUtils.Post(this,
                HttpPath.MEM_WITHDRAW,
                map, new Callback.CommonCallback<String>() {
                    @Override
                    public void onSuccess(String result) {
                        Log.e("ssssss", result);
                        ResultBase resultBase = GsonUtil.gsonIntance().gsonToBean(result, ResultBase.class);
                        if (resultBase.getStatus() == 1) {
                            IntentWebUtils.setIntentWeb(result,MoneyOperationActivity.this,DataCode.RECHARGE);
                        } else {
                            showMessage(resultBase.getInfo());
                        }
                    }

                    @Override
                    public void onError(Throwable ex, boolean isOnCallback) {
                        showMessage("失败，请检查网络");
                    }

                    @Override
                    public void onCancelled(CancelledException cex) {

                    }

                    @Override
                    public void onFinished() {

                    }
                });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == DataCode.RECHARGE || resultCode == DataCode.WEB) {
            this.finish();
            setResult(DataCode.RECHARGE);
        }
    }
}
