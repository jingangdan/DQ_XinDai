package com.dq.xindai.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dq.xindai.R;
import com.dq.xindai.adapter.LoanDetailAdapter;
import com.dq.xindai.base.BaseFragment;
import com.dq.xindai.bean.FinanceDetailData;
import com.dq.xindai.ui.LoanActivity;
import com.dq.xindai.ui.LoginActivity;
import com.dq.xindai.ui.LookBigImgActivity;
import com.github.jdsjlzx.interfaces.OnItemClickListener;
import com.github.jdsjlzx.interfaces.OnRefreshListener;
import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 借款详情（fragment）
 * Created by jingang on 2019/1/7.
 */

public class LoanDetailFragmentTest extends BaseFragment {
    @Bind(R.id.lRrcyclerView)
    LRecyclerView lRrcyclerView;

    private View view, headView;

    private LoanDetailAdapter mAdapter;
    private LRecyclerViewAdapter lRecyclerViewAdapter;

    private FinanceDetailData.DataBean dataBean;
    private List<FinanceDetailData.DataBean.ProfileBean.FilesBean> list = new ArrayList<>();

    private ArrayList<String> imgList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.layout_lrecyclerview, null);
        ButterKnife.bind(this, view);
        setAdapter();
        if (dataBean != null) {
            list.addAll(dataBean.getProfile().get(0).getFiles());
            lRrcyclerView.refreshComplete(list.size());
            mAdapter.addAll(list);

            setUI(dataBean);
        }
        return view;
    }

    public static LoanDetailFragmentTest newInstance(FinanceDetailData.DataBean memberBean) {
        LoanDetailFragmentTest fragment = new LoanDetailFragmentTest();
        Bundle args = new Bundle();
        args.putSerializable("", memberBean);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            dataBean = (FinanceDetailData.DataBean) getArguments().getSerializable("");
        }
    }

    @SuppressWarnings("unchecked")
    public void setAdapter() {
        mAdapter = new LoanDetailAdapter(getActivity());
        lRrcyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        lRecyclerViewAdapter = new LRecyclerViewAdapter(mAdapter);
        lRrcyclerView.setAdapter(lRecyclerViewAdapter);

        lRecyclerViewAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                if(imgList.size()>0){
                    startActivity(new Intent(getActivity(), LookBigImgActivity.class).putExtra("bigimgs",imgList));
                }
            }
        });

        lRrcyclerView.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh() {
                mAdapter.clear();
                lRrcyclerView.refreshComplete(list.size());
                mAdapter.addAll(list);
            }
        });

        setHeadView();
    }


    TextView tvFdName, tvFdIdcard, tvFdSex, tvFdXl, tvFdNx, tvFdZw, tvFdSr, tvFdHy, tvFdFc, tvFdCl,
            tvFdOverdueMoney, tvFdRepayMoney, tvFdOverDuePen, tvFdRepayPen;

    public void setHeadView() {
        headView = LayoutInflater.from(getActivity()).inflate(R.layout.activity_finance_detail, null);
        lRecyclerViewAdapter.addHeaderView(headView);
        tvFdName = headView.findViewById(R.id.tv_fd_name);
        tvFdIdcard = headView.findViewById(R.id.tv_fd_idcard);
        tvFdSex = headView.findViewById(R.id.tv_fd_sex);
        tvFdXl = headView.findViewById(R.id.tv_fd_xl);
        tvFdNx = headView.findViewById(R.id.tv_fd_nx);
        tvFdZw = headView.findViewById(R.id.tv_fd_zw);
        tvFdSr = headView.findViewById(R.id.tv_fd_sr);
        tvFdHy = headView.findViewById(R.id.tv_fd_hy);
        tvFdFc = headView.findViewById(R.id.tv_fd_fc);
        tvFdCl = headView.findViewById(R.id.tv_fd_cl);

        tvFdOverdueMoney = headView.findViewById(R.id.tv_fd_overdue_money);
        tvFdRepayMoney = headView.findViewById(R.id.tv_fd_repay_money);
        tvFdOverDuePen = headView.findViewById(R.id.tv_fd_overdue_pen);
        tvFdRepayPen = headView.findViewById(R.id.tv_fd_repay_pen);
    }

    /**
     * 更新UI
     *
     * @param dataBean
     */
    @SuppressLint("SetTextI18n")
    public void setUI(FinanceDetailData.DataBean dataBean) {
        FinanceDetailData.DataBean.MemberBean data = dataBean.getMember();

        tvFdName.setText(data.getName());
        tvFdIdcard.setText(data.getIdcard());
        //性别
        if (data.getSex() == 1) {
            tvFdSex.setText("男");
        } else if (data.getSex() == 2) {
            tvFdSex.setText("女");
        }
        //学历
        if (data.getXl() == 1) {
            tvFdXl.setText("小学");
        } else if (data.getXl() == 2) {
            tvFdXl.setText("初中");
        } else if (data.getXl() == 3) {
            tvFdXl.setText("高中");
        } else if (data.getXl() == 4) {
            tvFdXl.setText("大专");
        } else if (data.getXl() == 5) {
            tvFdXl.setText("本科及以上");
        }
        //工作年限
        if (data.getNx() == 1) {
            tvFdNx.setText("1年以内");
        } else if (data.getNx() == 2) {
            tvFdNx.setText("2-3年");
        } else if (data.getNx() == 3) {
            tvFdNx.setText("3-5年");
        } else if (data.getNx() == 4) {
            tvFdNx.setText("5-8年");
        } else if (data.getNx() == 5) {
            tvFdNx.setText("8年以上");
        }
        tvFdZw.setText(data.getZw());
        //月收入
        if (data.getSr() == 1) {
            tvFdSr.setText("2000以内");
        } else if (data.getSr() == 2) {
            tvFdSr.setText("2000-3000");
        } else if (data.getSr() == 3) {
            tvFdSr.setText("3000-5000");
        } else if (data.getSr() == 4) {
            tvFdSr.setText("5000-8000");
        } else if (data.getSr() == 5) {
            tvFdSr.setText("8000以上");
        }
        //婚姻
        if (data.getHy() == 1) {
            tvFdHy.setText("未婚");
        } else if (data.getHy() == 2) {
            tvFdHy.setText("已婚");
        } else if (data.getHy() == 3) {
            tvFdHy.setText("离异");
        } else if (data.getHy() == 4) {
            tvFdHy.setText("丧偶");
        }
        tvFdFc.setText(data.getFc());
        tvFdCl.setText(data.getCl());

        tvFdOverdueMoney.setText(dataBean.getBorrow().getOverdue_money() + "元");
        tvFdRepayMoney.setText(dataBean.getBorrow().getRepay_money() + "元");
        tvFdOverDuePen.setText(dataBean.getBorrow().getOverdue_pen() + "次");
        tvFdRepayPen.setText(dataBean.getBorrow().getRepay_pen() + "次");

        int size = dataBean.getProfile().get(0).getFiles().size();

        for (int i =0;i<size;i++){
            imgList.add(dataBean.getProfile().get(0).getFiles().get(i).getFile_path());
        }

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
