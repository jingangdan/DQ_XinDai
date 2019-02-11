package com.dq.xindai.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dq.xindai.R;
import com.dq.xindai.base.BaseFragment;
import com.dq.xindai.bean.FinanceDetailData;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 借款详情（fragment）
 * Created by jingang on 2019/1/7.
 */

public class LoanDetailFragment extends BaseFragment {
    @Bind(R.id.tv_fd_name)
    TextView tvFdName;
    @Bind(R.id.tv_fd_idcard)
    TextView tvFdIdcard;
    @Bind(R.id.tv_fd_sex)
    TextView tvFdSex;
    @Bind(R.id.tv_fd_xl)
    TextView tvFdXl;
    @Bind(R.id.tv_fd_nx)
    TextView tvFdNx;
    @Bind(R.id.tv_fd_zw)
    TextView tvFdZw;
    @Bind(R.id.tv_fd_sr)
    TextView tvFdSr;
    @Bind(R.id.tv_fd_hy)
    TextView tvFdHy;
    @Bind(R.id.tv_fd_fc)
    TextView tvFdFc;
    @Bind(R.id.tv_fd_cl)
    TextView tvFdCl;
    @Bind(R.id.tv_fd_overdue_money)
    TextView tvFdOverdueMoney;

    FinanceDetailData.DataBean.MemberBean memberBeans;

    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_finance_detail, null);
        ButterKnife.bind(this, view);
        if (memberBeans != null) {
            setUI(memberBeans);
        }
        return view;
    }

    public static LoanDetailFragment newInstance(FinanceDetailData.DataBean.MemberBean memberBean) {
        LoanDetailFragment fragment = new LoanDetailFragment();
        Bundle args = new Bundle();
        args.putSerializable("", memberBean);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            memberBeans = (FinanceDetailData.DataBean.MemberBean) getArguments().getSerializable("");
        }
    }

    /**
     * 更新UI
     *
     * @param data
     */
    public void setUI(FinanceDetailData.DataBean.MemberBean data) {

        tvFdName.setText(data.getName());
        tvFdIdcard.setText(data.getIdcard());
        //性别
        tvFdSex.setText(data.getSex() + "");

        //学历
        tvFdXl.setText(data.getXl() + "");

        //工作年限
        tvFdNx.setText(data.getNx() + "");

        tvFdZw.setText(data.getZw());
        //月收入
        tvFdSr.setText(data.getSr() + "");

        //婚姻
        tvFdHy.setText(data.getHy() + "");

        tvFdFc.setText(data.getFc());
        tvFdCl.setText(data.getCl());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
