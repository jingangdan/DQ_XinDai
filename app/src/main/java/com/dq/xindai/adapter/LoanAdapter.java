package com.dq.xindai.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.TextView;

import com.dq.xindai.R;
import com.dq.xindai.base.BaseAdapter;
import com.dq.xindai.base.ViewHolder;
import com.dq.xindai.bean.IndexData;
import com.dq.xindai.bean.TestBean;

/**
 * 首页-贷款（适配器）
 * Created by jingang on 2018/6/6.
 */

public class LoanAdapter extends BaseAdapter<IndexData.DataBean> {
    TextView tvSerial, tvProgress, tvPurposr, tvRate, tvMoney, tvTerm;

    public LoanAdapter(Context context) {
        super(context);
    }

    @Override
    public int getLayoutId() {
        return R.layout.item_home;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindItemHolder(ViewHolder holder, int position) {
        tvSerial = holder.getView(R.id.itemTvIndexSerial);
        tvProgress = holder.getView(R.id.itemTvIndexProgress);
        tvPurposr = holder.getView(R.id.itemTvIndexPurposr);
        tvRate = holder.getView(R.id.itemTvIndexRate);
        tvMoney = holder.getView(R.id.itemTvIndexMoney);
        tvTerm = holder.getView(R.id.itemTvIndexTerm);

        tvSerial.setText(mDataList.get(position).getTitle());
        tvProgress.setText(mDataList.get(position).getProgress() + "%");
        tvPurposr.setText(mDataList.get(position).getPurpose() + " | " + mDataList.get(position).getRepayment_name());
        tvRate.setText(mDataList.get(position).getRate() + "%");
        tvMoney.setText(mDataList.get(position).getMoney() + "元");
        tvTerm.setText(mDataList.get(position).getTerm() + "个月");
    }
}
