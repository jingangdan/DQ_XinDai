package com.dq.xindai.adapter;

import android.content.Context;
import android.widget.TextView;

import com.dq.xindai.R;
import com.dq.xindai.base.BaseAdapter;
import com.dq.xindai.base.ViewHolder;
import com.dq.xindai.bean.RecordData;
import com.dq.xindai.utils.DateUtils;

/**
 * 充值记录、提现记录适配器
 * Created by jingang on 2018/12/29.
 */

public class MoneyRechargeAdapter extends BaseAdapter<RecordData.DataBean.ListBean> {
    public MoneyRechargeAdapter(Context context) {
        super(context);
    }

    @Override
    public int getLayoutId() {
        return R.layout.item_record;
    }

    @Override
    public void onBindItemHolder(ViewHolder holder, int position) {
        TextView tvRemarks = holder.getView(R.id.itemTvRecordRemarks);
        TextView tvComplete = holder.getView(R.id.itemTvRecordComplete);
        TextView tvMoney = holder.getView(R.id.itemTvRecordMoney);

        tvRemarks.setText(mDataList.get(position).getRemarks());
        tvComplete.setText(DateUtils.timesOne(mDataList.get(position).getDate_created() + ""));
        tvMoney.setText(mDataList.get(position).getMoney());
    }
}
