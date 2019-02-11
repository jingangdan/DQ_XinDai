package com.dq.xindai.utils;


//package com.dq.yanglao.utils;
//import android.app.Activity;
//
//
//import com.dq.yanglao.view.MyProgressDialog;
//import com.google.gson.Gson;
//
//import org.xutils.common.Callback;
//import org.xutils.http.RequestParams;
//import org.xutils.http.app.ResponseParser;
//import org.xutils.http.request.UriRequest;
//import org.xutils.x;
//
//import java.lang.reflect.Type;
//import java.util.Map;
//
///**
// * @Title 封装xUtils网络请求
// * @Authour jingang
// * @Time 2016年7月27日 下午3:25:21
// */
//public class HttpxUtils {
//    private static MyProgressDialog myProgressDialog;
//
//    /**
//     * 发送get请求
//     *
//     * @param <T>
//     */
//    public static <T> Callback.Cancelable Get(Activity activity, String url, Map<String, String> map, final Callback.CommonCallback<String> callback) {
//        showDialog(activity);
//        RequestParams params = new RequestParams(url);
//        if (null != map) {
//            for (Map.Entry<String, String> entry : map.entrySet()) {
//                params.addQueryStringParameter(entry.getKey(), entry.getValue());
//            }
//        }
//        Callback.Cancelable cancelable = x.http().get(params, new Callback.CommonCallback<String>() {
//            @Override
//            public void onSuccess(String result) {
//                dismissDialog();
//                callback.onSuccess(result);
//            }
//
//            @Override
//            public void onError(Throwable ex, boolean isOnCallback) {
//                dismissDialog();
//                callback.onError(ex, isOnCallback);
//            }
//
//            @Override
//            public void onCancelled(CancelledException cex) {
//                dismissDialog();
//                callback.onCancelled(cex);
//            }
//
//            @Override
//            public void onFinished() {
//                dismissDialog();
//                callback.onFinished();
//            }
//        });
//        return cancelable;
//    }
//
//    /**
//     * 发送post请求
//     *
//     * @param <T>
//     */
//    public static <T> Callback.Cancelable Post(Activity activity, String url, Map<String, Object> map, final Callback.CommonCallback<String> callback) {
//        showDialog(activity);
//        RequestParams params = new RequestParams(url);
//        if (null != map) {
//            for (Map.Entry<String, Object> entry : map.entrySet()) {
//                params.addParameter(entry.getKey(), entry.getValue());
//            }
//        }
//        Callback.Cancelable cancelable = x.http().post(params, new Callback.CommonCallback<String>() {
//            @Override
//            public void onSuccess(String result) {
//                dismissDialog();
//                callback.onSuccess(result);
//            }
//
//            @Override
//            public void onError(Throwable ex, boolean isOnCallback) {
//                dismissDialog();
//                callback.onError(ex, isOnCallback);
//            }
//
//            @Override
//            public void onCancelled(CancelledException cex) {
//                dismissDialog();
//                callback.onCancelled(cex);
//            }
//
//            @Override
//            public void onFinished() {
//                dismissDialog();
//                callback.onFinished();
//            }
//        });
//        return cancelable;
//    }
//
//    /**
//     * 上传文件
//     *
//     * @param <T>
//     */
//    public static <T> Callback.Cancelable UpLoadFile(Activity activity, String url, Map<String, Object> map, final Callback.CommonCallback<String> callback) {
//        showDialog(activity);
//        RequestParams params = new RequestParams(url);
//        if (null != map) {
//            for (Map.Entry<String, Object> entry : map.entrySet()) {
//                params.addParameter(entry.getKey(), entry.getValue());
//            }
//        }
//        params.setMultipart(true);
//        Callback.Cancelable cancelable = x.http().get(params, new Callback.CommonCallback<String>() {
//            @Override
//            public void onSuccess(String result) {
//                dismissDialog();
//                callback.onSuccess(result);
//            }
//
//            @Override
//            public void onError(Throwable ex, boolean isOnCallback) {
//                dismissDialog();
//                callback.onError(ex, isOnCallback);
//            }
//
//            @Override
//            public void onCancelled(CancelledException cex) {
//                dismissDialog();
//                callback.onCancelled(cex);
//            }
//
//            @Override
//            public void onFinished() {
//                dismissDialog();
//                callback.onFinished();
//            }
//        });
//        return cancelable;
//    }
//
//    /**
//     * 下载文件
//     *
//     * @param <T>
//     */
//    public static <T> Callback.Cancelable DownLoadFile(Activity activity, String url, String filepath, final Callback.CommonCallback<String> callback) {
//        showDialog(activity);
//        RequestParams params = new RequestParams(url);
//        // 设置断点续传
//        params.setAutoResume(true);
//        params.setSaveFilePath(filepath);
//        Callback.Cancelable cancelable = x.http().get(params, new Callback.CommonCallback<String>() {
//            @Override
//            public void onSuccess(String result) {
//                dismissDialog();
//                callback.onSuccess(result);
//            }
//
//            @Override
//            public void onError(Throwable ex, boolean isOnCallback) {
//                dismissDialog();
//                callback.onError(ex, isOnCallback);
//            }
//
//            @Override
//            public void onCancelled(CancelledException cex) {
//                dismissDialog();
//                callback.onCancelled(cex);
//            }
//
//            @Override
//            public void onFinished() {
//                dismissDialog();
//                callback.onFinished();
//            }
//        });
//        return cancelable;
//    }
//
//    public class JsonResponseParser implements ResponseParser {
//        // 检查服务器返回的响应头信息
//        @Override
//        public void checkResponse(UriRequest request) throws Throwable {
//        }
//
//
//        /**
//         * 转换result为resultType类型的对象
//         *
//         * @param resultType  返回值类型(可能带有泛型信息)
//         * @param resultClass 返回值类型
//         * @param result      字符串数据
//         * @return
//         * @throws Throwable
//         */
//        @Override
//        public Object parse(Type resultType, Class<?> resultClass, String result) throws Throwable {
//            return new Gson().fromJson(result, resultClass);
//        }
//    }
//
//    /*开始dialog*/
//    public static void showDialog(Activity activity) {
//        if (myProgressDialog != null) {
//            myProgressDialog.show();
//        } else {
//            myProgressDialog = new MyProgressDialog(activity);
//            myProgressDialog.show();
//        }
//    }
//
//    /*结束dialog*/
//    public static void dismissDialog() {
//        if (myProgressDialog != null) {
//            myProgressDialog.dismiss();
//            myProgressDialog = null;
//        }
//    }
//}


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.dq.xindai.R;
import com.dq.xindai.base.BaseApplication;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.BuildConfig;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.http.app.ResponseParser;
import org.xutils.http.request.UriRequest;
import org.xutils.x;

import java.io.InputStream;
import java.lang.reflect.Type;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Map;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/**
 * @Title 封装xUtils网络请求
 * @Authour jingang
 * @Time 2016年7月27日 下午3:25:21
 */
public class HttpxUtils {
    /**
     * 发送get请求
     *
     * @param <T>
     */
//    public static <T> Callback.Cancelable Get(String url, Map<String, String> map, final Callback.CommonCallback<String> callback) {
//        RequestParams params = new RequestParams(url);
//        if (null != map) {
//            for (Map.Entry<String, String> entry : map.entrySet()) {
//                params.addQueryStringParameter(entry.getKey(), entry.getValue());
//            }
//        }
//        Callback.Cancelable cancelable = x.http().get(params, callback);
//        return cancelable;
//    }
    public static <T> Callback.Cancelable Get(String url, Map<String, String> map, final Callback.CommonCallback<String> callback) {
        Log.d("Http==Get=", "url=" + url);
        Log.d("Http==Get=", "map=" + (map == null ? "" : map.toString()));
        RequestParams params = new RequestParams(url);
        if (null != map) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                params.addQueryStringParameter(entry.getKey(), entry.getValue());
            }
        }
        Callback.Cancelable cancelable = x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
//                if (isUserError(null,result)){
//                    onFinished();
//                    return;
//                }
                callback.onSuccess(result);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                callback.onError(ex, isOnCallback);
            }

            @Override
            public void onCancelled(CancelledException cex) {
                callback.onCancelled(cex);
            }

            @Override
            public void onFinished() {
                callback.onFinished();
            }
        });
        return cancelable;
    }

    public static <T> Callback.Cancelable Get(final Activity activity, String url, Map<String, String> map, final Callback.CommonCallback<String> callback) {
        Log.d("Http==Get=", "url=" + url);
        Log.d("Http==Get=", "map=" + (map == null ? "" : map.toString()));
        final MyProgressDialog myProgressDialog = new MyProgressDialog(activity);
        try {
            myProgressDialog.show();
        } catch (Exception e) {
        }
        RequestParams params = new RequestParams(url);
        if (null != map) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                params.addQueryStringParameter(entry.getKey(), entry.getValue());
            }
        }
        Callback.Cancelable cancelable = x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
//                if (isUserError(activity,result))
//                    return;
                callback.onSuccess(result);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                callback.onError(ex, isOnCallback);
            }

            @Override
            public void onCancelled(CancelledException cex) {
                callback.onCancelled(cex);
            }

            @Override
            public void onFinished() {
                if (myProgressDialog != null && myProgressDialog.isShowing()) {
                    myProgressDialog.dismiss();
                }
                callback.onFinished();
            }
        });
        return cancelable;
    }

    /**
     * 发送post请求
     *
     * @param <T>
     */
    public static <T> Callback.Cancelable Post(final Activity activity, String url, Map<String, Object> map, final Callback.CommonCallback<String> callback) {
        Log.d("Http==Post=", "url=" + url);
        Log.d("Http==Post=", "map=" + (map == null ? "" : map.toString()));
        final MyProgressDialog myProgressDialog = new MyProgressDialog(activity);
        try {
            myProgressDialog.show();
        } catch (Exception e) {
        }
        RequestParams params = new RequestParams(url);
        if (null != map) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                params.addParameter(entry.getKey(), entry.getValue());
            }
        }

        /** 判断https证书是否成功验证 */
        SSLContext sslContext = getSSLContext(BaseApplication.getInstance());
        if (null == sslContext) {
            if (BuildConfig.DEBUG)
                System.out.println("Error:Can't Get SSLContext!");
            return null;
        }
        params.setSslSocketFactory(sslContext.getSocketFactory()); //绑定SSL证书(https请求

        Callback.Cancelable cancelable = x.http().post(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
//                if (isUserError(activity,result)){
//                    return;
//                }
                callback.onSuccess(result);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                callback.onError(ex, isOnCallback);
            }

            @Override
            public void onCancelled(CancelledException cex) {
                callback.onCancelled(cex);
            }

            @Override
            public void onFinished() {
                if (myProgressDialog != null && myProgressDialog.isShowing()) {
                    myProgressDialog.dismiss();
                }
                callback.onFinished();
            }
        });
        return cancelable;
    }

    /**
     * 上传文件
     *
     * @param <T>
     */
    public static <T> Callback.Cancelable UpLoadFile(Activity activity, String url, Map<String, Object> map, final Callback.CommonCallback<String> callback) {
        Log.d("Http==UpLoadFile=", "url=" + url);
        final MyProgressDialog myProgressDialog = new MyProgressDialog(activity);
        try {
            myProgressDialog.show();
        } catch (Exception e) {
        }
        RequestParams params = new RequestParams(url);
        if (null != map) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                params.addParameter(entry.getKey(), entry.getValue());
            }
        }
        params.setMultipart(true);
        Callback.Cancelable cancelable = x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                callback.onSuccess(result);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                callback.onError(ex, isOnCallback);
            }

            @Override
            public void onCancelled(CancelledException cex) {
                callback.onCancelled(cex);
            }

            @Override
            public void onFinished() {
                if (myProgressDialog != null && myProgressDialog.isShowing()) {
                    myProgressDialog.dismiss();
                }
                callback.onFinished();
            }
        });
        return cancelable;
    }

    /**
     * 下载文件
     *
     * @param <T>
     */
    public static <T> Callback.Cancelable DownLoadFile(Activity activity, String url, String filepath, final Callback.CommonCallback<String> callback) {
        final MyProgressDialog myProgressDialog = new MyProgressDialog(activity);
        try {
            myProgressDialog.show();
        } catch (Exception e) {
        }
        RequestParams params = new RequestParams(url);
        // 设置断点续传
        params.setAutoResume(true);
        params.setSaveFilePath(filepath);
        Callback.Cancelable cancelable = x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                callback.onSuccess(result);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                callback.onError(ex, isOnCallback);
            }

            @Override
            public void onCancelled(CancelledException cex) {
                callback.onCancelled(cex);
            }

            @Override
            public void onFinished() {
                if (myProgressDialog != null && myProgressDialog.isShowing()) {
                    myProgressDialog.dismiss();
                }
                callback.onFinished();
            }
        });
        return cancelable;
    }

    public class JsonResponseParser implements ResponseParser {
        // 检查服务器返回的响应头信息
        @Override
        public void checkResponse(UriRequest request) throws Throwable {
        }


        /**
         * 转换result为resultType类型的对象
         *
         * @param resultType  返回值类型(可能带有泛型信息)
         * @param resultClass 返回值类型
         * @param result      字符串数据
         * @return
         * @throws Throwable
         */
        @Override
        public Object parse(Type resultType, Class<?> resultClass, String result) throws Throwable {
            return new Gson().fromJson(result, resultClass);
        }
    }

    static JSONObject jsonObject;
    static Intent intent = new Intent();
    /**
     *
     * @param string
     */
//    private static boolean isUserError(Activity activity,String string){
//        try {
//            jsonObject = new JSONObject(string);
//            //非法用户
//            if (jsonObject.getInt("status") == 111){
//                BaseApplication.getInstance().saveUserInfo(null);
//                if (activity != null){
//                    intent.setClass(activity,LoginActivity.class);
//                    activity.startActivityForResult(intent,DataCode.LOGIN);
//                }
//                return true;
//            }
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//        return false;
//    }

    /**
     * 获取Https的证书
     *
     * @param context Activity（fragment）的上下文
     * @return SSL的上下文对象
     */
    private static SSLContext s_sSLContext;

    private static SSLContext getSSLContext(Context context) {

        CertificateFactory certificateFactory = null;
        InputStream inputStream = null;
        Certificate cer = null;
        KeyStore keystore = null;
        TrustManagerFactory trustManagerFactory = null;
        try {

            certificateFactory = CertificateFactory.getInstance("X.509");
//            inputStream = context.getAssets().open("dequantouzicom.cer");//这里导入SSL证书文件
            inputStream = context.getResources().openRawResource(R.raw.dequantouzicom);

            try {
                //读取证书
                cer = certificateFactory.generateCertificate(inputStream);

            } finally {
                inputStream.close();
            }

            //创建一个证书库，并将证书导入证书库
            keystore = KeyStore.getInstance(KeyStore.getDefaultType());
            keystore.load(null, null); //双向验证时使用
            keystore.setCertificateEntry("trust", cer);

            // 实例化信任库
            trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            // 初始化信任库
            trustManagerFactory.init(keystore);

            s_sSLContext = SSLContext.getInstance("TLS");
            //s_sSLContext.init(null, trustManagerFactory.getTrustManagers(), new SecureRandom());

            //信任所有证书 （官方不推荐使用）
            s_sSLContext.init(null, new TrustManager[]{new X509TrustManager() {

                @Override
                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }

                @Override
                public void checkServerTrusted(X509Certificate[] arg0, String arg1)
                        throws CertificateException {

                }

                @Override
                public void checkClientTrusted(X509Certificate[] arg0, String arg1)
                        throws CertificateException {

                }
            }}, new SecureRandom());

            return s_sSLContext;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}