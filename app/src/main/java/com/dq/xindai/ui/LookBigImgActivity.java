package com.dq.xindai.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.dq.xindai.R;
import com.dq.xindai.base.BaseActivity;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 看大图
 * Created by jingang on 2019/1/18.
 */

public class LookBigImgActivity extends BaseActivity {
    @Bind(R.id.vpLookBigImg)
    ViewPager viewPager;

    ArrayList<String> images = new ArrayList<>();
    int position = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBaseContentView(R.layout.activity_lookbigimg);
        ButterKnife.bind(this);
        setIvBack();

        images = getIntent().getStringArrayListExtra("bigimgs");
        viewPager.setAdapter(new ImageAdapter());
        viewPager.setCurrentItem(position);
    }

    class ImageAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return images.size();
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view == object;
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            ImageView imageView = new ImageView(LookBigImgActivity.this);
//            PhotoView photoView = new PhotoView(ImageLookActivity.this);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

            Glide
                    .with(LookBigImgActivity.this)
                    .load("https://www.dequantouzi.com"+images.get(position))
                    .into(imageView);

//            ImageUtils.loadImage(ImageLookActivity.this, images.get(position), R.mipmap.icon_default, imageView);
            container.addView(imageView);
            return imageView;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
//            super.destroyItem(container, position, object);
            container.removeView((ImageView) object);
        }
    }
}
