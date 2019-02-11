package com.dq.xindai.adapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.dq.xindai.R;
import com.dq.xindai.base.BaseAdapter;
import com.dq.xindai.base.ViewHolder;
import com.dq.xindai.bean.FinanceDetailData;

/**
 * 借款详情适配器
 * Created by jingang on 2019/1/7.
 */

public class LoanDetailAdapter extends BaseAdapter<FinanceDetailData.DataBean.ProfileBean.FilesBean> {
    private TextView tvFileName, tvStatus;
    private ImageView ivFilePath;
    private int status;

    public LoanDetailAdapter(Context context) {
        super(context);
    }

    @Override
    public int getLayoutId() {
        return R.layout.item_loan_detail;
    }

    @Override
    public void onBindItemHolder(ViewHolder holder, int position) {
        tvFileName = holder.getView(R.id.item_tv_ld_file_name);
        tvStatus = holder.getView(R.id.item_tv_ld_status);
        ivFilePath = holder.getView(R.id.item_iv_ld_file_path);

        tvFileName.setText(mDataList.get(position).getFile_name());
        status = mDataList.get(position).getStatusX();
        if (status == 1) {
            tvStatus.setText("审核通过");
        } else {
            tvStatus.setText("正在审核中或审核未通过");
        }
        //tvStatus.setText(mDataList.get(position).getStatusX() + "");
//        Glide
//                .with(mContext).load("https://www.dequantouzi.com/data/attachment/image/20181218/09/1060c86687515b2792de806134d2edf8tmp.jpg")
//                .into(ivFilePath);

        Glide.with(mContext)
                .load("https://www.dequantouzi.com" + mDataList.get(position).getTmpimg())
                .diskCacheStrategy(DiskCacheStrategy.RESULT)
                .into(ivFilePath);
    }
}