package com.dq.xindai.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.TextView;

import com.dq.xindai.R;
import com.dq.xindai.base.BaseAdapter;
import com.dq.xindai.base.ViewHolder;
import com.dq.xindai.bean.FinanceDetailData;
import com.dq.xindai.utils.DateUtils;

/**
 * 借款详情（投资记录）适配器
 * Created by asus on 2019/1/7.
 */

public class LoanRecordAdapter extends BaseAdapter<FinanceDetailData.DataBean.BorrowBean.LoadlistBean> {
    private TextView tvNum, tvSerial, tvName, tvTime, tvMoney, tvLx, tvStatus;

    public LoanRecordAdapter(Context context) {
        super(context);
    }

    @Override
    public int getLayoutId() {
        return R.layout.item_loan_record;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindItemHolder(ViewHolder holder, int position) {
        tvNum = holder.getView(R.id.item_tv_lr_num);
        tvSerial = holder.getView(R.id.item_tv_lr_serial);
        tvName = holder.getView(R.id.item_tv_lr_member_name);
        tvTime = holder.getView(R.id.item_tv_lr_time);
        tvMoney = holder.getView(R.id.item_tv_lr_money);
        tvLx = holder.getView(R.id.item_tv_lr_lx);
        tvStatus = holder.getView(R.id.item_tv_lr_status);

        tvNum.setText(position + 1 + "");
        tvSerial.setText(mDataList.get(position).getSerial());
        tvName.setText(mDataList.get(position).getMember_name());
        tvTime.setText(DateUtils.timesOne(mDataList.get(position).getDate_created() + ""));
        tvMoney.setText(mDataList.get(position).getMoney() + "元");
        tvLx.setText(mDataList.get(position).getLx() + "元");
        int status = mDataList.get(position).getStatusX();
        if (status == 1) {
            tvStatus.setText("投资中");
        } else if (status == 2) {
            tvStatus.setText("投资成功");
        }
        //tvStatus.setText(mDataList.get(position).getStatusX() + "");
    }
}
