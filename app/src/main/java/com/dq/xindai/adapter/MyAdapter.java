package com.dq.xindai.adapter;

import android.content.Context;

import com.dq.xindai.R;
import com.dq.xindai.base.BaseAdapter;
import com.dq.xindai.base.ViewHolder;
import com.dq.xindai.bean.TestBean;

/**
 * 列表适配器
 * Created by jingang on 2018/6/8.
 */

public class MyAdapter extends BaseAdapter<TestBean.DateBean> {
    public MyAdapter(Context context) {
        super(context);
    }

    @Override
    public int getLayoutId() {
        return R.layout.item_lrecyclerview;
    }

    @Override
    public void onBindItemHolder(ViewHolder holder, int position) {

    }
}
