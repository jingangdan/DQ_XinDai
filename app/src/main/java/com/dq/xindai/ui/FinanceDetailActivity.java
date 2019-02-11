package com.dq.xindai.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.TextView;

import com.dq.xindai.R;
import com.dq.xindai.base.BaseActivity;
import com.dq.xindai.bean.FinanceDetailData;
import com.dq.xindai.bean.ResultBase;
import com.dq.xindai.openssl.Base64Utils;
import com.dq.xindai.openssl.RSAUtils;
import com.dq.xindai.utils.GsonUtil;
import com.dq.xindai.utils.HttpPath;
import com.dq.xindai.utils.HttpxUtils;

import org.xutils.common.Callback;

import java.security.PrivateKey;
import java.util.HashMap;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 首页--借款详情
 * Created by jingang on 2018/12/31.
 */

public class FinanceDetailActivity extends BaseActivity{
    @Bind(R.id.tv_fd_name)
    TextView tvFdName;
    @Bind(R.id.tv_fd_idcard)
    TextView tvFdIdcard;
    @Bind(R.id.tv_fd_sex)
    TextView tvFdSex;
    @Bind(R.id.tv_fd_xl)
    TextView tvFdXl;
    @Bind(R.id.tv_fd_nx)
    TextView tvFdNx;
    @Bind(R.id.tv_fd_zw)
    TextView tvFdZw;
    @Bind(R.id.tv_fd_sr)
    TextView tvFdSr;
    @Bind(R.id.tv_fd_hy)
    TextView tvFdHy;
    @Bind(R.id.tv_fd_fc)
    TextView tvFdFc;
    @Bind(R.id.tv_fd_cl)
    TextView tvFdCl;
    @Bind(R.id.tv_fd_overdue_money)
    TextView tvFdOverdueMoney;
    private int id;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBaseContentView(R.layout.activity_finance_detail);
        ButterKnife.bind(this);
        setTvTitle("借款详情");
        setIvBack();

        id = getIntent().getIntExtra("id", 1);
        getFinanceDetail(id, getUserToken());
    }

    /**
     * 借款详情前加密
     *
     * @param id
     * @param token
     */
    public void getFinanceDetail(int id, String token) {
        String PATH_RSA = "id=" + id + "&token=" + token;
        Log.e("ssssss", "借款详情参数 = " + PATH_RSA);
        try {
            PrivateKey privateKey = RSAUtils.loadPrivateKey(RSAUtils.PRIVATE_KEY);
            byte[] encryptByte = RSAUtils.encryptDataPrivate(PATH_RSA.getBytes(), privateKey);
            xUtilsFinanceDetail(Base64Utils.encode(encryptByte).toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 借款详情
     *
     * @param sign
     */
    public void xUtilsFinanceDetail(String sign) {
        Log.e("ssssss", "借款详情接口 = " + HttpPath.FINANCE_DETAIL + "sign=" + sign);
        HashMap<String, String> map = new HashMap<>();
        map.put("sign", sign);
        HttpxUtils.Get(this,
                HttpPath.FINANCE_DETAIL,
                map, new Callback.CommonCallback<String>() {
                    @Override
                    public void onSuccess(String result) {
                        Log.e("ssssss", result);
                        ResultBase resultBase = GsonUtil.gsonIntance().gsonToBean(result, ResultBase.class);
                        if (resultBase.getStatus() == 1) {
                            setUI(result);
                        } else {
                            showMessage(resultBase.getInfo());
                        }
                    }

                    @Override
                    public void onError(Throwable ex, boolean isOnCallback) {
                        Log.e("ssssss", "失败，请检查网络" + ex);
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
    public void setUI(String result) {
        FinanceDetailData data = GsonUtil.gsonIntance().gsonToBean(result, FinanceDetailData.class);

        tvFdName.setText(data.getData().getMember().getName());
        tvFdIdcard.setText(data.getData().getMember().getIdcard());
        //性别
        tvFdSex.setText(data.getData().getMember().getSex() + "");

        //学历
        tvFdXl.setText(data.getData().getMember().getXl() + "");

        //工作年限
        tvFdNx.setText(data.getData().getMember().getNx() + "");

        tvFdZw.setText(data.getData().getMember().getZw());
        //月收入
        tvFdSr.setText(data.getData().getMember().getSr() + "");

        //婚姻
        tvFdHy.setText(data.getData().getMember().getHy() + "");

        tvFdFc.setText(data.getData().getMember().getFc());
        tvFdCl.setText(data.getData().getMember().getCl());
    }

}
