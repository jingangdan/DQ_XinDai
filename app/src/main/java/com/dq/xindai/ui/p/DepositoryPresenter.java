package com.dq.xindai.ui.p;

import android.app.Activity;
import android.util.Log;

import com.dq.xindai.bean.ResultBase;
import com.dq.xindai.openssl.Base64Utils;
import com.dq.xindai.openssl.RSAUtils;
import com.dq.xindai.ui.view.DepositoryView;
import com.dq.xindai.utils.GsonUtil;
import com.dq.xindai.utils.HttpPath;
import com.dq.xindai.utils.HttpxUtils;

import org.xutils.common.Callback;

import java.security.PrivateKey;
import java.util.HashMap;

/**
 * 存管信息操作
 * Created by jingang on 2019/1/15.
 */

public class DepositoryPresenter {
    private Activity activity;
    private DepositoryView view;

    public DepositoryPresenter(Activity activity, DepositoryView view) {
        this.activity = activity;
        this.view = view;
    }

    /**
     * 存管信息前加密
     *
     * @param token
     */
    public void getCustodyIndex(String token) {
        String PATH_RSA = "token=" + token;
        Log.e("ssssss", "存管信息参数 = " + PATH_RSA);
        try {
            PrivateKey privateKey = RSAUtils.loadPrivateKey(RSAUtils.PRIVATE_KEY);
            byte[] encryptByte = RSAUtils.encryptDataPrivate(PATH_RSA.getBytes(), privateKey);
            xUtilsCustodyIndex(Base64Utils.encode(encryptByte).toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 存管信息
     *
     * @param sign
     */
    public void xUtilsCustodyIndex(String sign) {
        Log.e("ssssss", "存管信息接口 = " + HttpPath.CUSTODY_INDEX + "sign=" + sign);
        HashMap<String, Object> map = new HashMap<>();
        map.put("sign", sign);
        HttpxUtils.Post(activity,
                HttpPath.CUSTODY_INDEX,
                map, new Callback.CommonCallback<String>() {
                    @Override
                    public void onSuccess(String result) {
                        Log.e("ssssss", result);
                        dealWithIndex(result);
                    }

                    @Override
                    public void onError(Throwable ex, boolean isOnCallback) {
                        Log.e("ssssss", "失败，请检查网络" + ex);
                        view.sendError("失败，请检查网络" + ex);
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
     * 重置预留手机号前加密
     *
     * @param token
     */
    public void postCustodyReSetMobile(String token) {
        String PATH_RSA = "token=" + token;
        Log.e("ssssss", "重置预留手机号参数 = " + PATH_RSA);
        try {
            PrivateKey privateKey = RSAUtils.loadPrivateKey(RSAUtils.PRIVATE_KEY);
            byte[] encryptByte = RSAUtils.encryptDataPrivate(PATH_RSA.getBytes(), privateKey);
            xUtilsCustodyReSetMobile(Base64Utils.encode(encryptByte).toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 重置预留手机号
     *
     * @param sign
     */
    public void xUtilsCustodyReSetMobile(String sign) {
        Log.e("ssssss", "重置预留手机号接口 = " + HttpPath.CUSTODY_RESETMOBILE + "sign=" + sign);
        HashMap<String, Object> map = new HashMap<>();
        map.put("sign", sign);
        HttpxUtils.Post(activity,
                HttpPath.CUSTODY_RESETMOBILE,
                map, new Callback.CommonCallback<String>() {
                    @Override
                    public void onSuccess(String result) {
                        Log.e("ssssss", result);
                        dealWithWeb(result);
                    }

                    @Override
                    public void onError(Throwable ex, boolean isOnCallback) {
                        Log.e("ssssss", "失败，请检查网络" + ex);
                        view.sendError("失败，请检查网络" + ex);
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
     * 注销存管前加密
     *
     * @param token
     */
    public void postCustodyCancelLation(String password, String token) {
        String PATH_RSA = "password" + password + "&token=" + token;
        Log.e("ssssss", "注销存管参数 = " + PATH_RSA);
        try {
            PrivateKey privateKey = RSAUtils.loadPrivateKey(RSAUtils.PRIVATE_KEY);
            byte[] encryptByte = RSAUtils.encryptDataPrivate(PATH_RSA.getBytes(), privateKey);
            xUtilsCustodyCancelLation(Base64Utils.encode(encryptByte).toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 注销存管
     *
     * @param sign
     */
    public void xUtilsCustodyCancelLation(String sign) {
        Log.e("ssssss", "注销存管接口 = " + HttpPath.CUSTODY_CANCELLATION + "sign=" + sign);
        HashMap<String, Object> map = new HashMap<>();
        map.put("sign", sign);
        HttpxUtils.Post(activity,
                HttpPath.CUSTODY_CANCELLATION,
                map, new Callback.CommonCallback<String>() {
                    @Override
                    public void onSuccess(String result) {
                        Log.e("ssssss", result);
                        //dealWithWeb(result);
                    }

                    @Override
                    public void onError(Throwable ex, boolean isOnCallback) {
                        Log.e("ssssss", "失败，请检查网络" + ex);
                        view.sendError("失败，请检查网络" + ex);
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
     * 修改支付密码前加密
     *
     * @param token
     */
    public void postCustodyPwd(String token) {
        String PATH_RSA = "token=" + token;
        Log.e("ssssss", "修改支付密码参数 = " + PATH_RSA);
        try {
            PrivateKey privateKey = RSAUtils.loadPrivateKey(RSAUtils.PRIVATE_KEY);
            byte[] encryptByte = RSAUtils.encryptDataPrivate(PATH_RSA.getBytes(), privateKey);
            xUtilsCustodyPwd(Base64Utils.encode(encryptByte).toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 修改支付密码
     *
     * @param sign
     */
    public void xUtilsCustodyPwd(String sign) {
        Log.e("ssssss", "修改支付密码接口 = " + HttpPath.CUSTODY_PASSWORD + "sign=" + sign);
        HashMap<String, Object> map = new HashMap<>();
        map.put("sign", sign);
        HttpxUtils.Post(activity,
                HttpPath.CUSTODY_PASSWORD,
                map, new Callback.CommonCallback<String>() {
                    @Override
                    public void onSuccess(String result) {
                        Log.e("ssssss", result);
                        dealWithWeb(result);
                    }

                    @Override
                    public void onError(Throwable ex, boolean isOnCallback) {
                        Log.e("ssssss", "失败，请检查网络" + ex);
                        view.sendError("失败，请检查网络" + ex);
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
     * 手续费签约前加密
     *
     * @param token
     */
    public void postCustodyQianYue(String token) {
        String PATH_RSA = "token=" + token;
        Log.e("ssssss", "手续费签约参数 = " + PATH_RSA);
        try {
            PrivateKey privateKey = RSAUtils.loadPrivateKey(RSAUtils.PRIVATE_KEY);
            byte[] encryptByte = RSAUtils.encryptDataPrivate(PATH_RSA.getBytes(), privateKey);
            xUtilsCustodyQianYue(Base64Utils.encode(encryptByte).toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 手续费签约
     *
     * @param sign
     */
    public void xUtilsCustodyQianYue(String sign) {
        Log.e("ssssss", "手续费签约接口 = " + HttpPath.CUSTODY_QIANYUE + "sign=" + sign);
        HashMap<String, Object> map = new HashMap<>();
        map.put("sign", sign);
        HttpxUtils.Post(activity,
                HttpPath.CUSTODY_QIANYUE,
                map, new Callback.CommonCallback<String>() {
                    @Override
                    public void onSuccess(String result) {
                        Log.e("ssssss", result);
                        dealWithWeb(result);
                    }

                    @Override
                    public void onError(Throwable ex, boolean isOnCallback) {
                        Log.e("ssssss", "失败，请检查网络" + ex);
                        view.sendError("失败，请检查网络" + ex);
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
     * 绑定银行卡前加密
     *
     * @param token
     */
    public void postCustodyBank(String token) {
        String PATH_RSA = "token=" + token;
        Log.e("ssssss", "绑定银行卡参数 = " + PATH_RSA);
        try {
            PrivateKey privateKey = RSAUtils.loadPrivateKey(RSAUtils.PRIVATE_KEY);
            byte[] encryptByte = RSAUtils.encryptDataPrivate(PATH_RSA.getBytes(), privateKey);
            xUtilsCustodyBank(Base64Utils.encode(encryptByte).toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 绑定银行卡
     *
     * @param sign
     */
    public void xUtilsCustodyBank(String sign) {
        Log.e("ssssss", "绑定银行卡接口 = " + HttpPath.CUSTODY_BANK + "sign=" + sign);
        HashMap<String, Object> map = new HashMap<>();
        map.put("sign", sign);
        HttpxUtils.Post(activity,
                HttpPath.CUSTODY_BANK,
                map, new Callback.CommonCallback<String>() {
                    @Override
                    public void onSuccess(String result) {
                        Log.e("ssssss", result);
                        dealWithWeb(result);
                    }

                    @Override
                    public void onError(Throwable ex, boolean isOnCallback) {
                        Log.e("ssssss", "失败，请检查网络" + ex);
                        view.sendError("失败，请检查网络" + ex);
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
     * 解绑银行卡前加密
     *
     * @param token
     */
    public void postCustodyUnBank(String token) {
        String PATH_RSA = "token=" + token;
        Log.e("ssssss", "解绑银行卡参数 = " + PATH_RSA);
        try {
            PrivateKey privateKey = RSAUtils.loadPrivateKey(RSAUtils.PRIVATE_KEY);
            byte[] encryptByte = RSAUtils.encryptDataPrivate(PATH_RSA.getBytes(), privateKey);
            xUtilsCustodyUnBank(Base64Utils.encode(encryptByte).toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 解绑银行卡
     *
     * @param sign
     */
    public void xUtilsCustodyUnBank(String sign) {
        Log.e("ssssss", "解绑银行卡接口 = " + HttpPath.CUSTODY_UNBANK + "sign=" + sign);
        HashMap<String, Object> map = new HashMap<>();
        map.put("sign", sign);
        HttpxUtils.Post(activity,
                HttpPath.CUSTODY_UNBANK,
                map, new Callback.CommonCallback<String>() {
                    @Override
                    public void onSuccess(String result) {
                        Log.e("ssssss", result);
                        dealWithWeb(result);
                    }

                    @Override
                    public void onError(Throwable ex, boolean isOnCallback) {
                        Log.e("ssssss", "失败，请检查网络" + ex);
                        view.sendError("失败，请检查网络" + ex);
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
     * 存管信息接口请求后的操作
     *
     * @param result
     */
    public void dealWithIndex(String result) {
        ResultBase resultBase = GsonUtil.gsonIntance().gsonToBean(result, ResultBase.class);
        if (resultBase.getStatus() == 1) {
            view.getSuccess(result);
        } else {
            view.sendError(resultBase.getInfo());
        }
    }

    /**
     * 网页跳转接口请求后操作
     *
     * @param result
     */
    public void dealWithWeb(String result) {
        ResultBase resultBase = GsonUtil.gsonIntance().gsonToBean(result, ResultBase.class);
        if (resultBase.getStatus() == 1) {
            view.sendSuccess(result);
        } else {
            view.sendError(resultBase.getInfo());
        }
    }


}
