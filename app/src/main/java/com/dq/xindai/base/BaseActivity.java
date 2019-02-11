package com.dq.xindai.base;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.dq.xindai.R;
import com.dq.xindai.ui.LoginActivity;
import com.dq.xindai.utils.DataCode;
import com.dq.xindai.utils.ScreenManagerUtils;
import com.dq.xindai.utils.ToastUtils;
import com.zhy.autolayout.AutoLayoutActivity;

import org.xutils.BuildConfig;
import org.xutils.x;


/**
 * 继承了Activity，实现Android6.0的运行时权限检测
 * 需要进行运行时权限检测的Activity可以继承这个类
 *
 * @describe：基础Activity
 * @author：jingang
 * @createdate：2018/03/22
 */

public abstract class BaseActivity extends AutoLayoutActivity {

    private ImageButton title_ibtn_back;//返回按钮
    private TextView title_tv_title;//标题
    private EditText title_et_search;//搜索框
    private TextView title_tv_right;//右侧文字
    private ImageButton title_ibtn_right;//右侧图片
    private FrameLayout base_fl_content;//内容布局
    private RelativeLayout rlTitle;//标题

    protected int page = 1;
    protected int pagesize = 10;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

//        x.Ext.init(this.getApplication());
//        x.Ext.setDebug(BuildConfig.DEBUG);

        ScreenManagerUtils.getInstance().addActivity(this);
        ScreenManagerUtils.setmCurrentActivity(this);
        initBaseView();


    }

    /**
     * 获取状态栏高度
     *
     * @param context context
     * @return 状态栏高度
     */
    public static int getStatusBarHeight(Context context) {
        // 获得状态栏高度
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        return context.getResources().getDimensionPixelSize(resourceId);
    }


    private void initBaseView() {
        title_ibtn_back = (ImageButton) findViewById(R.id.title_ibtn_back);
        title_tv_title = (TextView) findViewById(R.id.title_tv_title);
        title_et_search = (EditText) findViewById(R.id.title_et_search);
        title_tv_right = (TextView) findViewById(R.id.title_tv_right);
        title_ibtn_right = (ImageButton) findViewById(R.id.title_ibtn_right);
        base_fl_content = (FrameLayout) findViewById(R.id.base_fl_content);
        rlTitle = (RelativeLayout) findViewById(R.id.viewtitle_rl);
    }

    public void setBaseContentView(int layoutID) {
        View view = LayoutInflater.from(this).inflate(layoutID, null);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        view.setLayoutParams(layoutParams);
        base_fl_content.addView(view);
    }

    @SuppressLint("WrongConstant")
    public ImageButton getIvBack() {
        title_ibtn_back.setVisibility(View.VISIBLE);
        return title_ibtn_back;
    }

    public RelativeLayout getRlTitle() {
        return rlTitle;
    }

    @SuppressLint("WrongConstant")
    public void setIvBack() {
        title_ibtn_back.setVisibility(View.VISIBLE);
        title_ibtn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ScreenManagerUtils.getInstance().removeActivity(BaseActivity.this);
            }
        });

        //StatusUtils.with(this).setColor(Color.RED).init(getStatusBarHeight(this));
    }

    @SuppressLint("WrongConstant")
    public TextView getTvTitle() {
        title_tv_title.setVisibility(View.VISIBLE);
        return title_tv_title;
    }

    @SuppressLint("WrongConstant")
    public void setTvTitle(String title) {
        title_tv_title.setVisibility(View.VISIBLE);
        title_tv_title.setText(title != null ? title : "");
        //StatusUtils.addStatusViewWithColor(this, Color.RED, getStatusBarHeight(this));
        //StatusUtils.with(this).setColor(Color.RED).init(getStatusBarHeight(this));
    }

    @SuppressLint("WrongConstant")
    public EditText getEtSearch() {
        title_et_search.setVisibility(View.VISIBLE);
        return title_et_search;
    }

    @SuppressLint("WrongConstant")
    public TextView getTvRight() {
        title_tv_right.setVisibility(View.VISIBLE);
        return title_tv_right;
    }

    public ImageView getIvRight() {
        title_ibtn_right.setVisibility(View.VISIBLE);
        return title_ibtn_right;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            ScreenManagerUtils.getInstance().removeActivity(this);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    public void showMessage(String message) {
        ToastUtils.getInstance(BaseActivity.this).showMessage(message);
    }

    /**
     * 跳转到指定的activity
     *
     * @param clazz 目标activity
     */
    public void goToActivity(Class clazz) {
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
    }

    /**
     * 跳转到制定activity（带result）
     *
     * @param clazz
     * @param code
     */
    public void goToActivityForResult(Class clazz, int code) {
        Intent intent = new Intent(this, clazz);
        startActivityForResult(intent, code);
    }

    /**
     * 关闭当前页面
     */
    public void finishActivity() {
        ScreenManagerUtils.getInstance().removeActivity(BaseActivity.this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ToastUtils.getInstance(BaseActivity.this).toastCancel();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    /**
     * 获取token
     * @return
     */
    protected String getUserToken(){
        return BaseApplication.getInstance().getUserToken();
    }

    protected String getUserUid(){
        return BaseApplication.getInstance().getUserUid();
    }

    /**
     * 是否登陆
     * @return
     */
    protected boolean isLogin(){
        if ("1".equals(getUserToken())){
            Intent intent = new Intent(this,LoginActivity.class);
            startActivityForResult(intent, DataCode.LOGIN);
            return false;
        }else {
            return true;
        }
    }

}
