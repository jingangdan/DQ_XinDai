package com.dq.xindai.ui;

import android.content.SharedPreferences;
import android.os.Bundle;

import com.dq.xindai.R;
import com.dq.xindai.base.BaseActivity;
import com.dq.xindai.ui.start.GuideActivity;
import com.dq.xindai.utils.StatusUtils;

/**
 * 启动页
 * Created by jingang on 2016/10/17.
 */
public class StartActivity extends BaseActivity {
    private SharedPreferences sharedPreferences;
    private boolean user = false;//判断用户是否为首次进入

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBaseContentView(R.layout.activity_start);

        StatusUtils.transparencyBar(this); //设置状态栏全透明
        StatusUtils.with(this).init(BaseActivity.getStatusBarHeight(this));

        sharedPreferences = getSharedPreferences("config", 0);
        user = sharedPreferences.getBoolean("first", false);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (user) {
                    if (getUserToken().equals("1") || getUserToken().equals("")) {
                        goToActivity(LoginActivity.class);
                    } else {
                        goToActivity(MainActivity.class);
                    }

                } else {
                    goToActivity(GuideActivity.class);
                    //goToActivity(StartPageActivity.class);
                }
                finish();
            }
        }).start();
    }
}