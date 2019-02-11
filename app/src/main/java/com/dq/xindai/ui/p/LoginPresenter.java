package com.dq.xindai.ui.p;

import android.app.Activity;
import android.util.Log;

import com.dq.xindai.bean.ResultBase;
import com.dq.xindai.openssl.Base64Utils;
import com.dq.xindai.openssl.RSAUtils;
import com.dq.xindai.ui.view.LoginView;
import com.dq.xindai.utils.GsonUtil;
import com.dq.xindai.utils.HttpPath;
import com.dq.xindai.utils.HttpxUtils;

import org.xutils.common.Callback;

import java.security.PrivateKey;
import java.util.HashMap;

/**
 * 登录、注册、忘记密码p
 * Created by jingang on 2018/12/18.
 */

public class LoginPresenter {
    private Activity activity;
    private LoginView loginView;

    public LoginPresenter(Activity activity, LoginView loginView) {
        this.activity = activity;
        this.loginView = loginView;
    }

    /**
     * 登录前加密
     *
     * @param phone
     * @param pwd
     * @param token
     */
    public void postLogin(String phone, String pwd, String token) {
        String PATH_RSA = "mobile=" + phone + "&password=" + pwd + "&token=" + token;
        Log.e("ssssss", "登录参数 = " + PATH_RSA);
        try {
            PrivateKey privateKey = RSAUtils.loadPrivateKey(RSAUtils.PRIVATE_KEY);
            byte[] encryptByte = RSAUtils.encryptDataPrivate(PATH_RSA.getBytes(), privateKey);
            xUtilsLogin(Base64Utils.encode(encryptByte).toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 登录
     *
     * @param sign
     */
    public void xUtilsLogin(String sign) {
        Log.e("ssssss", "登录接口 = " + HttpPath.LOGIN + "sign=" + sign);
        HashMap<String, Object> map = new HashMap<>();
        map.put("sign", sign);
        HttpxUtils.Post(activity,
                HttpPath.LOGIN,
                map, new Callback.CommonCallback<String>() {
                    @Override
                    public void onSuccess(String result) {
                        dealWithLogin(result);
                    }

                    @Override
                    public void onError(Throwable ex, boolean isOnCallback) {
                        loginView.loginError("失败，请检查网络");
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
     * 注册前加密
     *
     * @param source      来源：4安卓、5苹果
     * @param mobile
     * @param password
     * @param mobile_code 短信验证码
     */
    public void postRes(int source, String mobile, String password, String mobile_code, String token) {
        String PATH_RSA = "source=" + source + "&mobile=" + mobile + "&password=" + password + "&mobile_code=" + mobile_code + "&token=" + token;
        Log.e("ssssss", "注册参数 = " + PATH_RSA);
        try {
            PrivateKey privateKey = RSAUtils.loadPrivateKey(RSAUtils.PRIVATE_KEY);
            byte[] encryptByte = RSAUtils.encryptDataPrivate(PATH_RSA.getBytes(), privateKey);
            xUtilsRes(Base64Utils.encode(encryptByte).toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 注册
     *
     * @param sign
     */
    public void xUtilsRes(String sign) {
        Log.e("ssssss", "注册接口 = " + HttpPath.RES + "sign=" + sign);
        HashMap<String, Object> map = new HashMap<>();
        map.put("sign", sign);
        HttpxUtils.Post(activity,
                HttpPath.RES,
                map, new Callback.CommonCallback<String>() {
                    @Override
                    public void onSuccess(String result) {
                        dealWithLogin(result);
                    }

                    @Override
                    public void onError(Throwable ex, boolean isOnCallback) {
                        loginView.loginError("失败，请检查网络");
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
     * 找回密码前加密
     *
     * @param mobile
     * @param mobile_code
     * @param password
     * @param token
     */
    public void postRePwd(String mobile, String mobile_code, String password, String token) {
        String PATH_RSA = "mobile=" + mobile + "&mobile_code=" + mobile_code + "&password=" + password + "&token=" + token;
        Log.e("ssssss", "找回密码参数 = " + PATH_RSA);
        try {
            PrivateKey privateKey = RSAUtils.loadPrivateKey(RSAUtils.PRIVATE_KEY);
            byte[] encryptByte = RSAUtils.encryptDataPrivate(PATH_RSA.getBytes(), privateKey);
            xUtilsRePwd(Base64Utils.encode(encryptByte).toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 找回密码
     *
     * @param sign
     */
    public void xUtilsRePwd(String sign) {
        Log.e("ssssss", "找回密码接口 = " + HttpPath.REPWD + "sign=" + sign);
        HashMap<String, Object> map = new HashMap<>();
        map.put("sign", sign);
        HttpxUtils.Post(activity,
                HttpPath.REPWD,
                map, new Callback.CommonCallback<String>() {
                    @Override
                    public void onSuccess(String result) {
                        dealWithLogin(result);
                    }

                    @Override
                    public void onError(Throwable ex, boolean isOnCallback) {
                        loginView.loginError("失败，请检查网络");
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
     * 短信验证码前加密
     *
     * @param mobile
     * @param key    短信类型：register/repwd
     * @param token
     */
    public void getSendMobile(String mobile, String key, String token) {
        String PATH_RSA = "mobile=" + mobile + "&key=" + key + "&token=" + token;
        Log.e("ssssss", "短信验证码参数 = " + PATH_RSA);
        try {
            PrivateKey privateKey = RSAUtils.loadPrivateKey(RSAUtils.PRIVATE_KEY);
            byte[] encryptByte = RSAUtils.encryptDataPrivate(PATH_RSA.getBytes(), privateKey);
            xUtilsSendMobile(Base64Utils.encode(encryptByte).toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 短信验证码
     *
     * @param sign
     */
    public void xUtilsSendMobile(String sign) {
        Log.e("ssssss", "短信验证码接口 = " + HttpPath.SENDMOBILE + "sign=" + sign);
        HashMap<String, Object> map = new HashMap<>();
        map.put("sign", sign);
        HttpxUtils.Post(activity,
                HttpPath.SENDMOBILE,
                map, new Callback.CommonCallback<String>() {
                    @Override
                    public void onSuccess(String result) {
                        ResultBase resultBase = GsonUtil.gsonIntance().gsonToBean(result,ResultBase.class);
                        if (resultBase.getStatus() == 1) {
                            loginView.sendverify(resultBase.getInfo());
                        } else {
                            loginView.loginError(resultBase.getInfo());
                        }
                    }

                    @Override
                    public void onError(Throwable ex, boolean isOnCallback) {
                        loginView.loginError("失败，请检查网络");
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
     * 接口请求后的操作
     *
     * @param result
     */
    public void dealWithLogin(String result) {
        Log.e("ssssss", "登录返回 = " + result);
        ResultBase resultBase = GsonUtil.gsonIntance().gsonToBean(result, ResultBase.class);
        if (resultBase.getStatus() == 1) {
            loginView.loginSuccess(result);
        } else {
            loginView.loginError(resultBase.getInfo());
        }
    }
}
