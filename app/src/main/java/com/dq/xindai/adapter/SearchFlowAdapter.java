package com.dq.xindai.adapter;

import android.content.Context;
import android.widget.TextView;

import com.dq.xindai.R;
import com.dq.xindai.base.BaseAdapter;
import com.dq.xindai.base.ViewHolder;
import com.dq.xindai.bean.ReturnBillData;
import com.dq.xindai.bean.SearchFlowData;
import com.dq.xindai.utils.DateUtils;

import java.util.List;

/**
 * 回款账单
 * Created by jingang on 2018/12/27.
 */

public class SearchFlowAdapter extends BaseAdapter<SearchFlowData.DataBean.ListBean> {
    public SearchFlowAdapter(Context context) {
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

        tvRemarks.setText(mDataList.get(position).getDescription());
        tvComplete.setText(DateUtils.timesOne(mDataList.get(position).getDate_created()+""));
        tvMoney.setText("" + mDataList.get(position).getBalance());

    }
}
