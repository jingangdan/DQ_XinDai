package com.dq.xindai.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.dq.xindai.R;
import com.dq.xindai.base.BaseActivity;
import com.dq.xindai.bean.ResultBase;
import com.dq.xindai.bean.SearchDetailsData;
import com.dq.xindai.openssl.Base64Utils;
import com.dq.xindai.openssl.RSAUtils;
import com.dq.xindai.utils.DateUtils;
import com.dq.xindai.utils.GsonUtil;
import com.dq.xindai.utils.HttpPath;
import com.dq.xindai.utils.HttpxUtils;

import org.xutils.common.Callback;

import java.security.PrivateKey;
import java.util.HashMap;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 流程-详情（业务员、客服、考察员、）
 * Created by jingang on 2018/6/28.
 */

public class FlowDetailActivity extends BaseActivity {
    @Bind(R.id.tv_sd_serial)
    TextView tvSdSerial;
    @Bind(R.id.tv_sd_date_update)
    TextView tvSdDateUpdate;
    @Bind(R.id.tv_sd_member_name)
    TextView tvSdMemberName;
    @Bind(R.id.tv_sd_category_name)
    TextView tvSdCategoryName;
    @Bind(R.id.tv_sd_is_aency)
    TextView tvSdIsAency;
    @Bind(R.id.tv_sd_aency_name)
    TextView tvSdAencyName;
    @Bind(R.id.tv_sd_money)
    TextView tvSdMoney;
    @Bind(R.id.tv_sd_term_type)
    TextView tvSdTermType;
    @Bind(R.id.tv_sd_repayment_name)
    TextView tvSdRepaymentName;
    @Bind(R.id.tv_sd_rate)
    TextView tvSdRate;
    @Bind(R.id.tv_sd_service_name)
    TextView tvSdServiceName;
    @Bind(R.id.tv_sd_insure_start)
    TextView tvSdInsureStart;
    @Bind(R.id.tv_sd_insure_end)
    TextView tvSdInsureEnd;
    @Bind(R.id.tv_sd_insure_complete)
    TextView tvSdInsureComplete;
    @Bind(R.id.tv_sd_status)
    TextView tvSdStatus;
    @Bind(R.id.tv_sd_fail_type)
    TextView tvSdFailType;
    @Bind(R.id.tv_sd_date_fail)
    TextView tvSdDateFail;
    @Bind(R.id.tv_sd_load_money)
    TextView tvSdLoadMoney;
    @Bind(R.id.tv_sd_load_count)
    TextView tvSdLoadCount;
    @Bind(R.id.tv_sd_repay_money)
    TextView tvSdRepayMoney;
    @Bind(R.id.tv_sd_repay_free)
    TextView tvSdRepayFree;
    @Bind(R.id.tv_sd_overdue_money)
    TextView tvSdOverdueMoney;
    @Bind(R.id.butSearchCancel)
    Button butSearchCancel;
    private int tradeId;
    @Bind(R.id.butReturnBill)
    Button butReturnBill;

    PrivateKey privateKey;
    byte[] encryptByte;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBaseContentView(R.layout.activity_transaction_detail);
        ButterKnife.bind(this);
        setTvTitle("流程详情");
        setIvBack();

        tradeId = getIntent().getIntExtra("tradeId", 1);
        getSearchDetails(tradeId + "", getUserToken());

    }

    @OnClick({R.id.butSearchCancel, R.id.butReturnBill})
    public void onViewClicked(View v) {
        switch (v.getId()) {
            case R.id.butSearchCancel:
                // postSearchCancel(tradeId + "", getUserToken());
                break;
            case R.id.butReturnBill:
                startActivity(new Intent(this, SearchFlowActivity.class)
                        .putExtra("tradeId", tradeId));
                break;
            default:
                break;
        }

    }

    /**
     * 交易详情前加密
     *
     * @param id
     * @param token
     */
    public void getSearchDetails(String id, String token) {
        String PATH_RSA = "id=" + id + "&token=" + token;
        Log.e("ssssss", "交易详情参数 = " + PATH_RSA);
        try {
            privateKey = RSAUtils.loadPrivateKey(RSAUtils.PRIVATE_KEY);
            encryptByte = RSAUtils.encryptDataPrivate(PATH_RSA.getBytes(), privateKey);
            xUtilsSearchDetails(Base64Utils.encode(encryptByte).toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 交易详情
     *
     * @param sign
     */
    public void xUtilsSearchDetails(String sign) {
        Log.e("ssssss", "交易详情接口 = " + HttpPath.SEARCH_DETAILS + "sign=" + sign);
        HashMap<String, String> map = new HashMap<>();
        map.put("sign", sign);
        HttpxUtils.Get(this,
                HttpPath.SEARCH_DETAILS,
                map, new Callback.CommonCallback<String>() {
                    @Override
                    public void onSuccess(String result) {
                        Log.e("ssssss", result);
                        ResultBase resultBase = GsonUtil.gsonIntance().gsonToBean(result, ResultBase.class);
                        if (resultBase.getStatus() == 1) {
                            setUi(result);
                        } else {
                            showMessage(resultBase.getInfo());
                        }
                    }

                    @Override
                    public void onError(Throwable ex, boolean isOnCallback) {
                        Log.e("ssssss", "失败，请检查网络！" + ex);
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
     * 撤销投资前加密
     *
     * @param id
     * @param token
     */
    public void postSearchCancel(String id, String token) {
        String PATH_RSA = "id=" + id + "&token=" + token;
        Log.e("ssssss", "撤销投资参数 = " + PATH_RSA);
        try {
            privateKey = RSAUtils.loadPrivateKey(RSAUtils.PRIVATE_KEY);
            encryptByte = RSAUtils.encryptDataPrivate(PATH_RSA.getBytes(), privateKey);
            xUtilsSearchCancel(Base64Utils.encode(encryptByte).toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 撤销投资
     *
     * @param sign
     */
    public void xUtilsSearchCancel(String sign) {
        Log.e("ssssss", "撤销投资接口 = " + HttpPath.SEARCH_DETAILS + "sign=" + sign);
        HashMap<String, String> map = new HashMap<>();
        map.put("sign", sign);
        HttpxUtils.Get(this,
                HttpPath.SEARCH_DETAILS,
                map, new Callback.CommonCallback<String>() {
                    @Override
                    public void onSuccess(String result) {
                        Log.e("ssssss", result);
//                        ResultBase resultBase = GsonUtil.gsonIntance().gsonToBean(result, ResultBase.class);
//                        if (resultBase.getStatus() == 1) {
//                            setUi(result);
//                        } else {
//                            showMessage(resultBase.getInfo());
//                        }
                    }

                    @Override
                    public void onError(Throwable ex, boolean isOnCallback) {
                        Log.e("ssssss", "失败，请检查网络！" + ex);
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
     * 更新UI
     *
     * @param result
     */

    private int aency, term, status, fail_type;//是否代办 期限 是否流标 操作方式

    @SuppressLint("SetTextI18n")
    public void setUi(String result) {
        SearchDetailsData data = GsonUtil.gsonIntance().gsonToBean(result, SearchDetailsData.class);
        if (!data.getData().equals("[]")) {
            tvSdSerial.setText(data.getData().getSerial());
            tvSdDateUpdate.setText(DateUtils.timesOne(data.getData().getDate_update() + ""));
            tvSdMemberName.setText(data.getData().getMember_name());
            tvSdCategoryName.setText(data.getData().getCategory_name());

            /*是否代办*/
            aency = data.getData().getIs_aency();
            if (aency == 0) {
                tvSdIsAency.setText("否");
            } else if (aency == 1) {
                tvSdIsAency.setText("是");
            }
            tvSdAencyName.setText(data.getData().getAency_name());
            tvSdMoney.setText(data.getData().getMoney() + "");

            /*期限*/
            term = data.getData().getTerm_type();
            if (term == 0) {
                tvSdTermType.setText(data.getData().getTerm() + "个月");
            } else {
                tvSdTermType.setText(data.getData().getTerm() + "天");
            }
            tvSdRepaymentName.setText(data.getData().getRepayment_name());
            tvSdRate.setText(data.getData().getRate() + "%");
            tvSdServiceName.setText(data.getData().getService_name());
            tvSdInsureStart.setText(DateUtils.timesOne(data.getData().getInsure_start() + ""));
            tvSdInsureEnd.setText(DateUtils.timesOne(data.getData().getInsure_end() + ""));
            tvSdInsureComplete.setText(DateUtils.timesOne(data.getData().getInsure_complete() + ""));

            /*是否流标 操作方式*/
            status = data.getData().getStatusX();
            fail_type = data.getData().getFail_type();
            if (status == 8) {
                tvSdStatus.setText("是");
                if (fail_type == 0) {
                    tvSdFailType.setText("到期自动流标");
                } else {
                    tvSdFailType.setText("手动");
                }
            } else {
                tvSdStatus.setText("否");
                tvSdFailType.setText("无");
            }
            tvSdDateFail.setText(DateUtils.timesOne(data.getData().getDate_fail() + ""));
            tvSdLoadMoney.setText(data.getData().getLoad_money() + "");
            tvSdLoadCount.setText(data.getData().getLoad_count() + "人");
            tvSdRepayMoney.setText(data.getData().getRepay_money() + "");
            tvSdRepayFree.setText(data.getData().getRepay_free() + "");
            tvSdOverdueMoney.setText(data.getData().getOverdue_money() + "(" + data.getData().getOverdue_count() + "次)");
        }
    }
}
