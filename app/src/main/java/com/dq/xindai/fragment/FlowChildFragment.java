package com.dq.xindai.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dq.xindai.R;
import com.dq.xindai.adapter.FlowAdapter;
import com.dq.xindai.base.LazyBaseFragment;
import com.dq.xindai.bean.TestBean;
import com.dq.xindai.ui.FlowDetailActivity;
import com.dq.xindai.ui.LoanDetailsActivity;
import com.github.jdsjlzx.interfaces.OnItemClickListener;
import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 流程（综合、公司）
 * Created by jingang on 2018/6/22.
 */
public class FlowChildFragment extends LazyBaseFragment {    @Bind(R.id.lRrcyclerView)
    LRecyclerView lRrcyclerView;
    private String type;
    private LRecyclerViewAdapter lRecyclerViewAdapter;
    private FlowAdapter mAdapter;
    private List<TestBean.DateBean> dateList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_lrecyclerview, null);

        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            if (getArguments() != null) {
                if (getActivity() != null) {
                    type = getArguments().getString("type");

                    setAdapter();
                    initDate();
                }
            }
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        if (getUserVisibleHint()) {
            setAdapter();
            initDate();
        }
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

        lRrcyclerView.refreshComplete(dateList.size());
       // mAdapter.addAll(dateList);


    }

    public void setAdapter() {
        mAdapter = new FlowAdapter(getActivity());
        lRrcyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        lRecyclerViewAdapter = new LRecyclerViewAdapter(mAdapter);
        lRrcyclerView.setAdapter(lRecyclerViewAdapter);
        lRecyclerViewAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                startActivity(new Intent(getActivity(), FlowDetailActivity.class));
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
