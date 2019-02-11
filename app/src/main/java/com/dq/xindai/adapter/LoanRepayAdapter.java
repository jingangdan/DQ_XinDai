package com.dq.xindai.adapter;

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

public class LoanRepayAdapter extends BaseAdapter<FinanceDetailData.DataBean.BorrowBean.RepaylistBean> {
    private TextView tvPeriod, tvPrincipal, tvFree, tvMoney, tvTime, tvStatus;

    public LoanRepayAdapter(Context context) {
        super(context);
    }

    @Override
    public int getLayoutId() {
        return R.layout.item_loan_repay;
    }

    @Override
    public void onBindItemHolder(ViewHolder holder, int position) {
        tvPeriod = holder.getView(R.id.item_tv_lr_period);
        tvPrincipal = holder.getView(R.id.item_tv_lr_principal);
        tvFree = holder.getView(R.id.item_tv_lr_borrow_free);
        tvMoney = holder.getView(R.id.item_tv_lr_money);
        tvTime = holder.getView(R.id.item_tv_lr_date_repay);
        tvStatus = holder.getView(R.id.item_tv_lr_status);

        tvPeriod.setText("第" + mDataList.get(position).getPeriod() + "期");
        tvPrincipal.setText(mDataList.get(position).getPrincipal() + "");
        tvFree.setText(mDataList.get(position).getBorrow_free() + "");
        tvMoney.setText(mDataList.get(position).getMoney() + "");
        tvTime.setText(DateUtils.timesOne(mDataList.get(position).getDate_repay() + ""));

        int status = mDataList.get(position).getStatusX();
        if (status > 0) {
            tvStatus.setText("已还");
        } else {
            tvStatus.setText("未还");
        }
        // tvStatus.setText(mDataList.get(position).getStatusX() + "");
    }
}
