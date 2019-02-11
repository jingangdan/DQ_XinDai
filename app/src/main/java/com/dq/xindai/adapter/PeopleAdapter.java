package com.dq.xindai.adapter;

import android.content.Context;

import com.dq.xindai.R;
import com.dq.xindai.base.BaseAdapter;
import com.dq.xindai.base.ViewHolder;
import com.dq.xindai.bean.TestBean;

/**
 * 我的-人员管理（适配器）
 * Created by jingang on 2018/6/28.
 */
public class PeopleAdapter extends BaseAdapter<TestBean.DateBean> {
    public PeopleAdapter(Context context) {
        super(context);
    }

    @Override
    public int getLayoutId() {
        return R.layout.item_people;
    }

    @Override
    public void onBindItemHolder(ViewHolder holder, int position) {

    }
}
