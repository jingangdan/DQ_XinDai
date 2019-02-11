package com.dq.xindai.utils;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.gyf.barlibrary.ImmersionBar;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by jingang on 2018/6/5.
 */

public class StatusUtils {
    /**
     *   * 修改状态栏为全透明
     *   *
     *   * @param activity
     *   
     */
    @TargetApi(19)
    public static void transparencyBar(Activity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = activity.getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window window = activity.getWindow();
            window.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
    }

    /**
     *   * 状态栏亮色模式，设置状态栏黑色文字、图标，
     *   * 适配4.4以上版本MIUIV、Flyme和6.0以上版本其他Android
     *   *
     *   * @param activity
     *   * @return 1:MIUUI 2:Flyme 3:android6.0
     *   
     */
    public static int StatusBarLightMode(Activity activity) {
        int result = 0;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            if (MIUISetStatusBarLightMode(activity, true)) {
                //小米
                result = 1;
            } else if (FlymeSetStatusBarLightMode(activity.getWindow(), true)) {
                //魅族
                result = 2;
            } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                //6.0以上
                activity.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
                result = 3;
            } else {
                //其他的都设置状态栏成半透明的,以下设置半透明是调用第三方的，根据个人需求更改
                ImmersionBar.with(activity).statusBarDarkFont(true, 0.5f).init();
            }
        }
        return result;
    }

    /**
     *   * 设置状态栏图标为深色和魅族特定的文字风格
     *   * 可以用来判断是否为Flyme用户
     *   *
     *   * @param window 需要设置的窗口
     *   * @param dark 是否把状态栏文字及图标颜色设置为深色
     *   * @return boolean 成功执行返回true
     *   
     */
    public static boolean FlymeSetStatusBarLightMode(Window window, boolean dark) {
        boolean result = false;
        if (window != null) {
            try {
                WindowManager.LayoutParams lp = window.getAttributes();
                Field darkFlag = WindowManager.LayoutParams.class
                        .getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
                Field meizuFlags = WindowManager.LayoutParams.class
                        .getDeclaredField("meizuFlags");
                darkFlag.setAccessible(true);
                meizuFlags.setAccessible(true);
                int bit = darkFlag.getInt(null);
                int value = meizuFlags.getInt(lp);
                if (dark) {
                    value |= bit;
                } else {
                    value &= ~bit;
                }
                meizuFlags.setInt(lp, value);
                window.setAttributes(lp);
                result = true;
            } catch (Exception e) {

            }
        }
        return result;
    }

    /**
     *   * 需要MIUIV6以上
     *   *
     *   * @param activity
     *   * @param dark  是否把状态栏文字及图标颜色设置为深色
     *   * @return boolean 成功执行返回true
     *   
     */
    @SuppressWarnings("unchecked")
    public static boolean MIUISetStatusBarLightMode(Activity activity, boolean dark) {
        boolean result = false;
        Window window = activity.getWindow();
        if (window != null) {
            Class clazz = window.getClass();
            try {
                int darkModeFlag = 0;
                Class<?> layoutParams = Class.forName("android.view.MiuiWindowManager$LayoutParams");
                Field field = layoutParams.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE");
                darkModeFlag = field.getInt(layoutParams);
                Method extraFlagField = clazz.getMethod("setExtraFlags", int.class, int.class);
                if (dark) {
                    extraFlagField.invoke(window, darkModeFlag, darkModeFlag);//状态栏透明且黑色字体
                } else {
                    extraFlagField.invoke(window, 0, darkModeFlag);//清除黑色字体
                }
                result = true;

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    //开发版 7.7.13 及以后版本采用了系统API，旧方法无效但不会报错，所以两个方式都要加上
                    if (dark) {
                        activity.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
                    } else {
                        activity.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_VISIBLE);
                    }
                }
            } catch (Exception e) {

            }
        }
        return result;
    }

    public Activity mActivity;
    //状态栏颜色
    private int mColor = -1;


    public StatusUtils(Activity mActivity) {
        this.mActivity = mActivity;
    }

    public static StatusUtils with(Activity activity) {
        return new StatusUtils(activity);
    }

    public int getColor() {
        return mColor;
    }

    public StatusUtils setColor(int color) {
        mColor = color;
        return this;
    }

    public void init(int statusHeight) {
        fullScreen(mActivity);
        if (mColor != -1) {
            //设置了状态栏颜色
            addStatusViewWithColor(mActivity, mColor,statusHeight);
        }
    }

    /**
     * 通过设置全屏，设置状态栏透明
     *
     * @param activity
     */
    private void fullScreen(Activity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                //5.x开始需要把颜色设置透明，否则导航栏会呈现系统默认的浅灰色
                Window window = activity.getWindow();
                View decorView = window.getDecorView();
                //两个 flag 要结合使用，表示让应用的主体内容占用系统状态栏的空间
                int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                decorView.setSystemUiVisibility(option);
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.setStatusBarColor(Color.TRANSPARENT);
                //导航栏颜色也可以正常设置
//                window.setNavigationBarColor(Color.TRANSPARENT);
            } else {
                Window window = activity.getWindow();
                WindowManager.LayoutParams attributes = window.getAttributes();
                int flagTranslucentStatus = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
                int flagTranslucentNavigation = WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION;
                attributes.flags |= flagTranslucentStatus;
//                attributes.flags |= flagTranslucentNavigation;
                window.setAttributes(attributes);
            }
        }
    }

    /**
     * 添加状态栏占位视图
     *
     * @param activity
     */
    @SuppressLint("WrongConstant")
    public void addStatusViewWithColor(Activity activity, int color, int statusHeight) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //设置 paddingTop
            ViewGroup rootView = (ViewGroup) mActivity.getWindow().getDecorView().findViewById(android.R.id.content);
            rootView.setPadding(0, statusHeight, 0, 0);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                //直接设置状态栏颜色
                activity.getWindow().setStatusBarColor(color);
            } else {
                //增加占位状态栏
                ViewGroup decorView = (ViewGroup) mActivity.getWindow().getDecorView();
                View statusBarView = new View(activity);
                ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                        statusHeight);
                statusBarView.setBackgroundColor(color);
                decorView.addView(statusBarView, lp);

            }
        }
    }
}
