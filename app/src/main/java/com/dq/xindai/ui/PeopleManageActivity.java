package com.dq.xindai.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.dq.xindai.R;
import com.dq.xindai.adapter.PeopleAdapter;
import com.dq.xindai.base.BaseActivity;
import com.dq.xindai.bean.TestBean;
import com.github.jdsjlzx.interfaces.OnItemClickListener;
import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * 我的-人员管理
 * Created by jingang on 2018/6/28.
 */

public class PeopleManageActivity extends BaseActivity {
    @Bind(R.id.me_civ_img)
    CircleImageView meCivImg;
    @Bind(R.id.lrv_people_manage)
    LRecyclerView lrvPeopleManage;

    private PeopleAdapter mAdapter;
    private List<TestBean.DateBean> dateList;
    private LRecyclerViewAdapter lRecyclerViewAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBaseContentView(R.layout.activity_people_manage);
        ButterKnife.bind(this);
        setTvTitle("人员管理");
        setIvBack();
        getIvRight().setImageResource(R.mipmap.ic_launcher);
        getIvRight().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToActivity(AddPeopleActivity.class);
            }
        });
        setAdapter();
        initDate();
    }

    public void initDate() {

        dateList = new ArrayList<>();
        dateList.add(new TestBean.DateBean("aaa", "aaa"));
        dateList.add(new TestBean.DateBean("aaa", "aaa"));
        dateList.add(new TestBean.DateBean("aaa", "aaa"));
        dateList.add(new TestBean.DateBean("aaa", "aaa"));
        dateList.add(new TestBean.DateBean("aaa", "aaa"));
        dateList.add(new TestBean.DateBean("aaa", "aaa"));
        dateList.add(new TestBean.DateBean("aaa", "aaa"));
        dateList.add(new TestBean.DateBean("aaa", "aaa"));
        dateList.add(new TestBean.DateBean("aaa", "aaa"));

        lrvPeopleManage.refreshComplete(dateList.size());
        mAdapter.addAll(dateList);

    }

    public void setAdapter() {
        mAdapter = new PeopleAdapter(this);
        lrvPeopleManage.setLayoutManager(new LinearLayoutManager(this));
        lRecyclerViewAdapter = new LRecyclerViewAdapter(mAdapter);
        lrvPeopleManage.setAdapter(lRecyclerViewAdapter);
        lRecyclerViewAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
            }
        });
    }


}
