package com.dq.xindai.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dq.xindai.R;
import com.dq.xindai.adapter.SimpleFragmentPagerAdapter;
import com.dq.xindai.base.BaseFragment;
import com.dq.xindai.view.NoScrollViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 首页
 * Created by jingang on 2018/6/5.
 */

public class HomeFragment2 extends BaseFragment implements ViewPager.OnPageChangeListener {
    @Bind(R.id.tabLayout)
    TabLayout tabLayout;
    @Bind(R.id.noScrollViewPage)
    NoScrollViewPager noScrollViewPage;

    private String[] titles = new String[]{"贷款", "理财"};
    private List<Fragment> fragments = new ArrayList<>();
    private SimpleFragmentPagerAdapter sfpAdapter;
    private int page = 0;

    private HomeChildFragment homeForumFragment;
    private String type;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fm_home2, null);
        ButterKnife.bind(this, view);

        setFragment(page);

        return view;
    }

    public void setFragment(int page) {
        for (int i = 0; i < titles.length; i++) {
            if (i == 0) {
                type = "贷款";
            }
            if (i == 1) {
                type = "理财";
            }
            homeForumFragment = new HomeChildFragment();
            Bundle bundle = new Bundle();
            bundle.putString("type", type);
            homeForumFragment.setArguments(bundle);
            fragments.add(homeForumFragment);
        }
        sfpAdapter = new SimpleFragmentPagerAdapter(getActivity().getSupportFragmentManager(), getActivity(), fragments, titles);
        noScrollViewPage.setAdapter(sfpAdapter);

        noScrollViewPage.setCurrentItem(page);
        noScrollViewPage.setOffscreenPageLimit(titles.length);

       // noScrollViewPage.setOnPageChangeListener(this);
        noScrollViewPage.addOnPageChangeListener(this);
        tabLayout.setupWithViewPager(noScrollViewPage);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
