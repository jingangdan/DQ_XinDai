package com.dq.xindai.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dq.xindai.Interface.OnItemClickListener;
import com.dq.xindai.R;
import com.dq.xindai.base.BaseAdapter;
import com.dq.xindai.base.BaseRecyclerViewHolder;
import com.dq.xindai.base.ViewHolder;
import com.dq.xindai.bean.SearchIndexData;
import com.dq.xindai.bean.TestBean;
import com.dq.xindai.utils.DateUtils;

/**
 * 流程（适配器）
 * Created by jingang on 2018/6/6.
 */

public class FlowAdapter extends BaseAdapter<SearchIndexData.DataBean> {
    TextView tvSerial, tvDateCreate, tvCategoryName, tvIsRevoke, tvRepaymentName, tvRate, tvMoney, tvInterest, itemTvSIStatus;
    ImageView img;

    public FlowAdapter(Context context) {
        super(context);
    }

    @Override
    public int getLayoutId() {
        return R.layout.item_flow;
    }

    @SuppressLint({"DefaultLocale", "SetTextI18n"})
    @Override
    public void onBindItemHolder(ViewHolder holder, int position) {
        tvSerial = holder.getView(R.id.itemTvSISerial);
        tvDateCreate = holder.getView(R.id.itemTvSIDataCreated);
        tvCategoryName = holder.getView(R.id.itemTvSICategoryName);
        tvIsRevoke = holder.getView(R.id.itemTvSIIsRevoke);
        tvRepaymentName = holder.getView(R.id.itemTvSIRepaymentName);
        tvRate = holder.getView(R.id.itemTvSIRate);
        tvMoney = holder.getView(R.id.itemTvSIMoney);
        tvInterest = holder.getView(R.id.itemTvSIInterest);
        img = holder.getView(R.id.itemIvSI);

        itemTvSIStatus = holder.getView(R.id.itemTvSIStatus);

        tvSerial.setText(mDataList.get(position).getSerial());
        tvDateCreate.setText(DateUtils.timesOne(mDataList.get(position).getDate_created() + ""));
        tvCategoryName.setText(mDataList.get(position).getCategory_name());
        int revoke = mDataList.get(position).getBorrow().getIs_revoke();
        if (revoke == 0) {
            tvIsRevoke.setText("否");
        } else if (revoke == 1) {
            tvIsRevoke.setText("是");
        }
        tvRepaymentName.setText(mDataList.get(position).getCategory_name());
        tvRate.setText(mDataList.get(position).getBorrow().getRate() + "%");
        tvMoney.setText(mDataList.get(position).getMoney() + "");
        tvInterest.setText(String.format("%.2f", ((mDataList.get(position).getBorrow_moeny()) - (mDataList.get(position).getMoney()))));

        //状态
        int status = mDataList.get(position).getStatusX();
        if (status == 0) {
            itemTvSIStatus.setText("未支付");
        } else if (status == 1) {
            itemTvSIStatus.setText("进行中");
        } else if (status == 2) {
            itemTvSIStatus.setText("回收中");
        } else if (status == 3) {
            itemTvSIStatus.setText("已完成");
        } else if (status == 4) {
            itemTvSIStatus.setText("放款中");
        } else if (status == 5) {
            itemTvSIStatus.setText("流标");
        } else if (status == 6) {
            itemTvSIStatus.setText("已撤销");
        }
    }

}
