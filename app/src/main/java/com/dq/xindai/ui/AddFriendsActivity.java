package com.dq.xindai.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.LinearLayout;

import com.dq.xindai.R;
import com.dq.xindai.base.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 我的-关注（好友、粉丝、关注）-添加好友
 * Created by jingang on 2018/6/8.
 */

public class AddFriendsActivity extends BaseActivity {
    @Bind(R.id.linAddFriendsMenu1)
    LinearLayout linAddFriendsMenu1;
    @Bind(R.id.linAddFriendsMenu2)
    LinearLayout linAddFriendsMenu2;
    @Bind(R.id.linAddFriendsMenu3)
    LinearLayout linAddFriendsMenu3;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBaseContentView(R.layout.activity_add_friends);
        ButterKnife.bind(this);
        setTvTitle("添加好友");
        setIvBack();
    }

    @OnClick({R.id.linAddFriendsMenu1, R.id.linAddFriendsMenu2, R.id.linAddFriendsMenu3})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.linAddFriendsMenu1:
                break;
            case R.id.linAddFriendsMenu2:
                break;
            case R.id.linAddFriendsMenu3:
                break;
        }
    }
}
