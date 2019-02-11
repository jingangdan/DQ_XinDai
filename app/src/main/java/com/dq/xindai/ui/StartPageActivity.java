package com.dq.xindai.ui;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.dq.xindai.R;
import com.dq.xindai.base.BaseActivity;
import com.dq.xindai.utils.StatusUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 引导页
 * Created by jingang on 2018/6/7.
 */
public class StartPageActivity extends BaseActivity implements ViewPager.OnPageChangeListener {

    @Bind(R.id.guide_vp)
    ViewPager vp;
    @Bind(R.id.guide_ib_start)
    Button ib_start;
    @Bind(R.id.but_start)
    Button but_start;
    @Bind(R.id.rel_start)
    FrameLayout relStart;

    private int[] imageIdArray;//图片资源的数组
    private List<View> viewList;//图片资源的集合

    private ViewPagerAdapter vpAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBaseContentView(R.layout.activity_start_page);
        ButterKnife.bind(this);

        StatusUtils.transparencyBar(this); //设置状态栏全透明
        StatusUtils.with(this).init(BaseActivity.getStatusBarHeight(this));

        //加载ViewPager
        initViewPager();
    }

    /**
     * 加载图片ViewPager 此处同样可以加载布局ViewPager
     */
    private void initViewPager() {
        // 初始化底部小圆点
        //initDots();

        imageIdArray = new int[]{R.mipmap.ic_startpage1, R.mipmap.ic_startpage2, R.mipmap.ic_startpage3};

        viewList = new ArrayList<>();

        // 为引导图片提供布局参数
        LinearLayout.LayoutParams mParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);

        // 初始化引导图片列表
        for (int i = 0; i < imageIdArray.length; i++) {
            ImageView iv = new ImageView(this);
            iv.setLayoutParams(mParams);
            iv.setScaleType(ImageView.ScaleType.CENTER_CROP);
            iv.setImageResource(imageIdArray[i]);
            viewList.add(iv);
        }

        // 初始化Adapter
        vpAdapter = new ViewPagerAdapter(viewList);
        vp.setAdapter(vpAdapter);
        // 绑定回调
        // vp.setOnPageChangeListener(this);
        vp.addOnPageChangeListener(this);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    /**
     * 滑动后的监听
     *
     * @param position
     */
    @Override
    public void onPageSelected(int position) {

        //判断是否是最后一页，若是则显示按钮
        if (position == imageIdArray.length - 1) {
            ib_start.setVisibility(View.VISIBLE);

            but_start.setVisibility(View.GONE);

        } else {
            ib_start.setVisibility(View.GONE);
            but_start.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @OnClick({R.id.guide_ib_start, R.id.but_start})
    public void onClick(View view) {
        SharedPreferences.Editor editor = getSharedPreferences("config",0).edit();
        editor.putBoolean("first",true);
        editor.commit();
        switch (view.getId()) {
            case R.id.guide_ib_start:
                goToActivity(LoginActivity.class);
                finish();
                break;
            case R.id.but_start:
                goToActivity(LoginActivity.class);
                finish();
                break;
        }
    }

    public class ViewPagerAdapter extends PagerAdapter {
        //界面列表
        private List<View> views;

        public ViewPagerAdapter(List<View> views) {
            this.views = views;
        }

        //删除界面
        @Override
        public void destroyItem(ViewGroup arg0, int arg1, Object arg2) {
            ((ViewPager) arg0).removeView(views.get(arg1));
        }

        @Override
        public void finishUpdate(ViewGroup arg0) {
        }

        //获得当前界面数量
        @Override
        public int getCount() {
            if (views != null) {
                return views.size();
            }
            return 0;
        }

        //初始化arg1位置的界面
        @Override
        public Object instantiateItem(ViewGroup arg0, int arg1) {
            ((ViewPager) arg0).addView(views.get(arg1), 0);
            return views.get(arg1);
        }

        //判断是否由对象生成界面
        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return (arg0 == arg1);
        }

        @Override
        public void restoreState(Parcelable arg0, ClassLoader arg1) {

        }

        @Override
        public Parcelable saveState() {
            return null;
        }

        @Override
        public void startUpdate(ViewGroup arg0) {

        }

    }


}
