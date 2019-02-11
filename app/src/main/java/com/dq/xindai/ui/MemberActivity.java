package com.dq.xindai.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.EditText;
import android.widget.ImageView;

import com.dq.xindai.R;
import com.dq.xindai.base.BaseActivity;
import com.jingang.album.Action;
import com.jingang.album.Album;
import com.jingang.album.AlbumFile;
import com.jingang.album.api.widget.Widget;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 我的-个人信息
 * Created by jingang on 2018/6/28.
 */

public class MemberActivity extends BaseActivity {
    @Bind(R.id.ivMemberHead)
    ImageView ivMemberHead;
    @Bind(R.id.etMemberName)
    EditText etMemberName;
    @Bind(R.id.etMemberMobile)
    EditText etMemberMobile;

    private ArrayList<AlbumFile> mAlbumFiles;
    private String name, mobile;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBaseContentView(R.layout.activity_member);
        ButterKnife.bind(this);
        setTvTitle("个人信息");
        setIvBack();

        getIntents();
    }

    @OnClick(R.id.ivMemberHead)
    public void onViewClicked() {
        selectAlbum();
    }

    /**
     * 获取页面传值并更新UI
     */
    public void getIntents() {
        name = getIntent().getStringExtra("name");
        mobile = getIntent().getStringExtra("mobile");

        etMemberName.setText(name);
        etMemberMobile.setText(mobile);
    }

    /**
     * 选择图片（手机本地图库）
     */
    private void selectAlbum() {
        Album.album(this)
                .multipleChoice()
                .selectCount(1)
                .camera(true)
                .cameraVideoQuality(1)
                .cameraVideoLimitDuration(Integer.MAX_VALUE)
                .cameraVideoLimitBytes(Integer.MAX_VALUE)
                .checkedList(mAlbumFiles)
                .widget(
                        Widget.newDarkBuilder(this)
                                // .title(mToolbar.getTitle().toString())
                                .build()
                )
                .onResult(new Action<ArrayList<AlbumFile>>() {
                    @Override
                    public void onAction(@NonNull ArrayList<AlbumFile> result) {
                        mAlbumFiles = result;

                        Album.getAlbumConfig().
                                getAlbumLoader().
                                load(ivMemberHead, mAlbumFiles.get(0));
                        System.out.println("111 = " + mAlbumFiles.get(0).getPath());
                    }
                })
                .onCancel(new Action<String>() {
                    @Override
                    public void onAction(@NonNull String result) {
                        showMessage("Canceled");
                    }
                })
                .start();
    }


}
