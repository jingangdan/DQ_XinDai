package com.dq.xindai.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dq.xindai.R;
import com.dq.xindai.adapter.SimpleFragmentPagerAdapter;
import com.dq.xindai.base.BaseFragment;
import com.dq.xindai.view.NoScrollViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 流程
 * Created by jingang on 2018/6/5.
 */

public class FlowFragment extends BaseFragment implements ViewPager.OnPageChangeListener {

    @Bind(R.id.tv_fm_top_title)
    TextView tvFmTopTitle;
    @Bind(R.id.tl_flow)
    TabLayout tlFlow;
    @Bind(R.id.nvp_flow)
    NoScrollViewPager nvpFlow;

    private String[] titles = new String[]{"综合", "公司"};
    private List<Fragment> fragments = new ArrayList<>();
    private SimpleFragmentPagerAdapter sfpAdapter;
    private int page = 0;

    private FlowChildFragment flowChildFragment;
    private String type;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fm_flow, null);
        ButterKnife.bind(this, view);
        tvFmTopTitle.setText("流程");

        setFragment(page);
        return view;
    }

    public void setFragment(int page) {
        for (int i = 0; i < titles.length; i++) {
            if (i == 0) {
                type = "综合";
            }
            if (i == 1) {
                type = "公司";
            }
            flowChildFragment = new FlowChildFragment();
            Bundle bundle = new Bundle();
            bundle.putString("type", type);
            flowChildFragment.setArguments(bundle);
            fragments.add(flowChildFragment);
        }
        sfpAdapter = new SimpleFragmentPagerAdapter(getActivity().getSupportFragmentManager(), getActivity(), fragments, titles);
        nvpFlow.setAdapter(sfpAdapter);

        nvpFlow.setCurrentItem(page);
        nvpFlow.setOffscreenPageLimit(titles.length);


        nvpFlow.setCurrentItem(0);

        nvpFlow.addOnPageChangeListener(this);
        tlFlow.setupWithViewPager(nvpFlow);


        setupTabIcons();

    }

    private void setupTabIcons() {
        tlFlow.getTabAt(0).setCustomView(getTabView(0));
        tlFlow.getTabAt(1).setCustomView(getTabView(1));
    }


    /*自定义tablayout显示方式*/
    public View getTabView(int position) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.item_tab, null);
        TextView txt_title = (TextView) view.findViewById(R.id.txt_title);
        txt_title.setText(titles[position]);
        ImageView img_title = (ImageView) view.findViewById(R.id.img_title);
        img_title.setImageResource(R.drawable.selector_tab);
        return view;
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
