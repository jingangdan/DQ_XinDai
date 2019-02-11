package com.dq.xindai.base;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import com.dq.xindai.bean.UserInfoData;
import com.dq.xindai.utils.GsonUtil;
import com.jingang.album.Album;
import com.jingang.album.AlbumConfig;

import org.xutils.BuildConfig;
import org.xutils.x;

import java.util.HashMap;
import java.util.Locale;

/**
 * 程序Application
 * Created by jingang on 2018/6/6.
 */

public class BaseApplication extends Application {
    private static BaseApplication instance;
    private UserInfoData user = null;
    private static int mActivityCount;
    public static boolean isRun = true;//app是否正在运行，前台true,后台false

    // ApplicationLike tinkerApplicationLike;
    @Override
    public void onCreate() {
        super.onCreate();
        if (instance == null) {
            x.Ext.init(this);
            x.Ext.setDebug(BuildConfig.DEBUG);

            instance = this;
            Album.initialize(AlbumConfig.newBuilder(this)
                    .setAlbumLoader(new MediaLoader())
                    .setLocale(Locale.getDefault())
                    .build()
            );
        }

        getUserInfo();
//        JPushInterface.setDebugMode(true);
//        JPushInterface.init(this);
//        MobSDK.init(this);
        getRunStatus();
        // initTinkerPatch();
    }

//    /**
//     * 我们需要确保至少对主进程跟patch进程初始化 TinkerPatch
//     */
//
//    private void initTinkerPatch() {
//        // 我们可以从这里获得Tinker加载过程的信息
//        if (BuildConfig.TINKER_ENABLE) {
//            tinkerApplicationLike = TinkerPatchApplicationLike.getTinkerPatchApplicationLike();
//            // 初始化TinkerPatch SDK
//            TinkerPatch.init(
//                    tinkerApplicationLike
////                new TinkerPatch.Builder(tinkerApplicationLike)
////                    .requestLoader(new OkHttp3Loader())
////                    .build()
//            )
//                    .reflectPatchLibrary()
//                    .setPatchRollbackOnScreenOff(true)
//                    .setPatchRestartOnSrceenOff(true)
////                    .setFetchPatchIntervalByHours(3)
////                    .fetchPatchUpdateAndPollWithInterval()
//                    .fetchPatchUpdate(true)
//                    .setPatchResultCallback(new ResultCallBack() {
//                        @Override
//                        public void onPatchResult(PatchResult patchResult) {
//                            Log.e("ffffffffff","11=" + patchResult.patchVersion);
//                            Log.e("ffffffffff","22=" + patchResult.isSuccess);
//                            Log.e("ffffffffff","33=" + patchResult.toString());
//                        }
//                    })
//                    .fetchDynamicConfig(new ConfigRequestCallback() {
//                        @Override
//                        public void onSuccess(HashMap<String, String> hashMap) {
//                            Log.e("ffffffffff","aa=" + hashMap.toString());
//                        }
//                        @Override
//                        public void onFail(Exception e) {
//                            Log.e("ffffffffff","bb=" + e.toString());
//                        }
//                    }, false);
//            ;
//            // 获取当前的补丁版本
////            Log.d(TAG, "Current patch version is " + TinkerPatch.with().getPatchVersion());
//
//            // fetchPatchUpdateAndPollWithInterval 与 fetchPatchUpdate(false)
//            // 不同的是，会通过handler的方式去轮询
////            TinkerPatch.with().fetchPatchUpdateAndPollWithInterval();
//            //强制检查更新
//
////            TinkerPatch.with();
//        }
//    }

    public static BaseApplication getInstance() {
        return instance;
    }

    public String getUserToken() {
        if (user == null)
            return "1";
        return user.getData().getToken();
    }

    public String getUserUid() {
        if (user == null)
            return "";
        return String.valueOf(user.getData().getUid());
    }

    public String getUserName() {
        if (user == null)
            return "未登录";
        return user.getData().getUser_name();
    }

//    public String getHeadImage(){
//        if (user == null)
//            return "未登录";
//        return user.getData().getHeadimg();
//    }

    /**
     * 保存用户信息至本地
     *
     * @param string
     */
    public void saveUserInfo(String string) {
        SharedPreferences.Editor editor = getSharedPreferences("userinfo", Context.MODE_PRIVATE).edit();
        editor.putString("user", string);
        editor.apply();
        getUserInfo();
    }

    /**
     * 获取本地缓存的用户信息
     *
     * @return
     */
    public void getUserInfo() {
        SharedPreferences preferences = getSharedPreferences("userinfo", Context.MODE_PRIVATE);
        String result = preferences.getString("user", null);
        if (result == null) {
            user = null;
        } else {
            user = GsonUtil.gsonIntance().gsonToBean(result, UserInfoData.class);
        }
    }

    public UserInfoData getUser() {
        return user;
    }

    /**
     * 获取app的运行状态
     */
    public void getRunStatus() {
        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
            }

            @Override
            public void onActivityStarted(Activity activity) {
                mActivityCount++;
                if (mActivityCount == 1) {
                    isRun = true;
                }
            }

            @Override
            public void onActivityResumed(Activity activity) {
            }

            @Override
            public void onActivityPaused(Activity activity) {
            }

            @Override
            public void onActivityStopped(Activity activity) {
                mActivityCount--;
                if (mActivityCount == 0) {
                    isRun = false;
                }
            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
            }

            @Override
            public void onActivityDestroyed(Activity activity) {
            }
        });
    }
}
