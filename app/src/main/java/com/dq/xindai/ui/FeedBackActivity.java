package com.dq.xindai.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.dq.xindai.R;
import com.dq.xindai.base.BaseActivity;
import com.jingang.album.Action;
import com.jingang.album.Album;
import com.jingang.album.AlbumFile;
import com.jingang.album.api.widget.Widget;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 我的-意见反馈
 * Created by jingang on 2018/6/28.
 */
public class FeedBackActivity extends BaseActivity {
    @Bind(R.id.gridView)
    GridView gridView;

    private ArrayList<AlbumFile> mAlbumFiles = new ArrayList<>();
    private GridViewAdapter gridViewAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBaseContentView(R.layout.activity_feedback);
        ButterKnife.bind(this);
        setTvTitle("意见反馈");
        setIvBack();

        initGridView();
    }

    //初始化展示上传图片的GridView
    private void initGridView() {
        gridViewAdapter = new GridViewAdapter(this, mAlbumFiles);
        gridView.setAdapter(gridViewAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                if (position == parent.getChildCount() - 1) {
                    //如果“增加按钮形状的”图片的位置是最后一张，且添加了的图片的数量不超过9张，才能点击
                    if (mAlbumFiles.size() == 9) {
                        //最多添加9张图片 查看
                        previewAlbum(position);
                    } else {
                        //添加凭证图片
                        selectAlbum();
                    }
                } else {
                    previewAlbum(position);
                }
            }
        });
    }

    /**
     * 选择图片（手机本地图库）
     */
    private void selectAlbum() {
        Album.album(this)
                .multipleChoice()
                .columnCount(2)
                .selectCount(9)
                .camera(true)
                .cameraVideoQuality(1)
                .cameraVideoLimitDuration(Integer.MAX_VALUE)
                .cameraVideoLimitBytes(Integer.MAX_VALUE)
                .checkedList(mAlbumFiles)
                .widget(
                        Widget.newDarkBuilder(this)
                                .build()
                )
                .onResult(new Action<ArrayList<AlbumFile>>() {
                    @Override
                    public void onAction(@NonNull ArrayList<AlbumFile> result) {
                        mAlbumFiles = result;
                        isImg();

                    }
                })
                .onCancel(new Action<String>() {
                    @Override
                    public void onAction(@NonNull String result) {
                        showMessage("Canceled");
                        isImg();
                    }
                })
                .start();
    }

    /**
     * 显示图片
     */
    private void previewAlbum(int position) {
        if (mAlbumFiles == null || mAlbumFiles.size() == 0) {
            showMessage("Please select, first.");
        } else {
            Album.galleryAlbum(this)
                    .checkable(true)
                    .checkedList(mAlbumFiles)
                    .currentPosition(position)
                    .widget(
                            Widget.newDarkBuilder(this)
                                    .build()
                    )
                    .onResult(new Action<ArrayList<AlbumFile>>() {
                        @Override
                        public void onAction(@NonNull ArrayList<AlbumFile> result) {
                            mAlbumFiles = result;
                            isImg();
                        }
                    })
                    .start();
        }
    }

    public void isImg() {
        if (mAlbumFiles != null) {
            gridViewAdapter.notifyDataSetChanged(mAlbumFiles);
        }

    }

    public class GridViewAdapter extends BaseAdapter {
        private Context mContext;
        private List<AlbumFile> mAlbumFiles;

        private LayoutInflater inflater;

        public GridViewAdapter(Context mContext, List<AlbumFile> mAlbumFiles) {
            this.mContext = mContext;
            this.mAlbumFiles = mAlbumFiles;
            inflater = LayoutInflater.from(mContext);
        }

        public void notifyDataSetChanged(List<AlbumFile> imagePathList) {
            this.mAlbumFiles = imagePathList;
            super.notifyDataSetChanged();
        }

        @Override
        public int getCount() {
            int count = mAlbumFiles == null ? 1 : mAlbumFiles.size() + 1;
            if (count > 9) {
                return mAlbumFiles.size();
            } else {
                return count;
            }
        }

        @Override
        public Object getItem(int position) {
            return mAlbumFiles.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @SuppressLint("ViewHolder")
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = inflater.inflate(R.layout.item_content_image, parent, false);
            ImageView iv = (ImageView) convertView.findViewById(R.id.iv_album_content_image);
            if (position < mAlbumFiles.size()) {
                //代表+号之前的需要正常显示图片
                Album.getAlbumConfig().
                        getAlbumLoader().
                        load(iv, mAlbumFiles.get(position));
            } else {
                iv.setImageResource(R.mipmap.ic_camera);//最后一个显示加号图片
            }
            return convertView;
        }
    }
}
