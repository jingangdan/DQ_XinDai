package com.dq.xindai.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by jingang on 2016/11/2.
 * 店铺 TabLayout
 */

public class SimpleFragmentPagerAdapter extends FragmentPagerAdapter {
    private Context mContext;
    private List<Fragment> fragments;
    private String[] titles;

    public SimpleFragmentPagerAdapter(FragmentManager fm, Context mContext, List<Fragment> fragments, String[] titles) {
        super(fm);
        this.mContext = mContext;
        this.fragments = fragments;
        this.titles = titles;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }


    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }

    @Override
    public long getItemId(int position) {
        super.getItemId(position);
        if (fragments != null) {
            if (position < fragments.size()) {
                return fragments.get(position).hashCode();       //important
            }
        }

        System.out.println("position = "+position );
        return super.getItemId(position);
    }
}
