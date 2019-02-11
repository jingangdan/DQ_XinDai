package com.dq.xindai.fragment.p;

import android.app.Activity;
import android.util.Log;

import com.dq.xindai.bean.RemData;
import com.dq.xindai.bean.ResultBase;
import com.dq.xindai.fragment.view.MeFView;
import com.dq.xindai.openssl.Base64Utils;
import com.dq.xindai.openssl.RSAUtils;
import com.dq.xindai.utils.GsonUtil;
import com.dq.xindai.utils.HttpPath;
import com.dq.xindai.utils.HttpxUtils;

import org.xutils.common.Callback;

import java.security.PrivateKey;
import java.util.HashMap;

/**
 * Created by jingang on 2018/12/24.
 */

public class MePresenter {
    private Activity activity;
    private MeFView meFView;

    public MePresenter(Activity activity, MeFView meFView) {
        this.activity = activity;
        this.meFView = meFView;
    }

    /**
     * 用户基础信息
     *
     * @param token
     */
    public void postRemDetailed(String token) {
        String PATH_RSA = "token=" + token;
        Log.e("ssssss", "用户基础信息参数 = " + PATH_RSA);
        try {
            PrivateKey privateKey = RSAUtils.loadPrivateKey(RSAUtils.PRIVATE_KEY);
            byte[] encryptByte = RSAUtils.encryptDataPrivate(PATH_RSA.getBytes(), privateKey);
            xUtilsRemDetailed(Base64Utils.encode(encryptByte).toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void xUtilsRemDetailed(String sign) {
        Log.e("ssssss", "用户基础信息接口 = " + HttpPath.MEM_DETAILED + "sign=" + sign);
        HashMap<String, Object> map = new HashMap<>();
        map.put("sign", sign);
        HttpxUtils.Post(activity,
                HttpPath.MEM_DETAILED,
                map, new Callback.CommonCallback<String>() {
                    @Override
                    public void onSuccess(String result) {
                        dealWithGetRemDetailed(result);
                    }

                    @Override
                    public void onError(Throwable ex, boolean isOnCallback) {
                        meFView.Error("失败，请检查网络");
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
     * 可用余额前加密
     *
     * @param token
     */
    public void getWalletBalance(String token) {
        String PATH_RSA = "token=" + token;
        Log.e("ssssss", "可用余额参数 = " + PATH_RSA);
        try {
            PrivateKey privateKey = RSAUtils.loadPrivateKey(RSAUtils.PRIVATE_KEY);
            byte[] encryptByte = RSAUtils.encryptDataPrivate(PATH_RSA.getBytes(), privateKey);
            xUtilsWalletBalance(Base64Utils.encode(encryptByte).toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 可用余额
     *
     * @param sign
     */
    public void xUtilsWalletBalance(String sign) {
        Log.e("ssssss", "可用余额接口 = " + HttpPath.WALLET_BALANCE + "sign=" + sign);
        HashMap<String, Object> map = new HashMap<>();
        map.put("sign", sign);
        HttpxUtils.Post(activity,
                HttpPath.WALLET_BALANCE,
                map, new Callback.CommonCallback<String>() {
                    @Override
                    public void onSuccess(String result) {
                        dealWithGetRemDetailed(result);
                    }

                    @Override
                    public void onError(Throwable ex, boolean isOnCallback) {
                        meFView.Error("失败，请检查网络");
                    }

                    @Override
                    public void onCancelled(CancelledException cex) {

                    }

                    @Override
                    public void onFinished() {

                    }
                });
    }

    public void dealWithGetRemDetailed(String result) {
        Log.e("ssssss", "用户基础信息返回 = " + result);
        ResultBase resultBase = GsonUtil.gsonIntance().gsonToBean(result, ResultBase.class);
        if (resultBase.getStatus() == 1) {
            meFView.Success(result);
        } else {
            meFView.Error(resultBase.getInfo());
        }
    }
}
