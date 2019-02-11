package com.dq.xindai.fragment;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dq.xindai.R;
import com.dq.xindai.adapter.LoanRepayAdapter;
import com.dq.xindai.base.BaseFragment;
import com.dq.xindai.bean.FinanceDetailData;
import com.github.jdsjlzx.interfaces.OnRefreshListener;
import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 借款详情（还款计划）
 * Created by jingang on 2019/1/7.
 */

public class LoanRepayFragment extends BaseFragment {
    @Bind(R.id.lRrcyclerView)
    LRecyclerView lRrcyclerView;
    private View view;

    ArrayList<? extends FinanceDetailData.DataBean.BorrowBean.RepaylistBean> lists = new ArrayList<>();
    private LoanRepayAdapter mAdapter;
    private LRecyclerViewAdapter lRecyclerViewAdapter;

    @SuppressWarnings("unchecked")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.layout_lrecyclerview, null);
        ButterKnife.bind(this, view);

        setAdapter();

        if (lists.size() > 0) {
            lRrcyclerView.refreshComplete(lists.size());
            mAdapter.addAll((Collection<FinanceDetailData.DataBean.BorrowBean.RepaylistBean>) lists);
        }

        return view;
    }

    public static LoanRepayFragment newInstance(List<FinanceDetailData.DataBean.BorrowBean.RepaylistBean> list) {
        LoanRepayFragment fragment = new LoanRepayFragment();
        Bundle args = new Bundle();
        args.putParcelableArrayList("", (ArrayList<? extends Parcelable>) list);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            lists = getArguments().getParcelableArrayList("");
        }
    }

    @SuppressWarnings("unchecked")
    public void setAdapter() {
        mAdapter = new LoanRepayAdapter(getActivity());
        lRrcyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        lRecyclerViewAdapter = new LRecyclerViewAdapter(mAdapter);
        lRrcyclerView.setAdapter(lRecyclerViewAdapter);

        lRrcyclerView.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh() {
                mAdapter.clear();
                lRrcyclerView.refreshComplete(lists.size());
                mAdapter.addAll((Collection<FinanceDetailData.DataBean.BorrowBean.RepaylistBean>) lists);
            }
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
