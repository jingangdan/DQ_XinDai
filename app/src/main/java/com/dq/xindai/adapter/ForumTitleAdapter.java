package com.dq.xindai.adapter;

import android.content.Context;

import com.dq.xindai.R;
import com.dq.xindai.base.BaseAdapter;
import com.dq.xindai.base.ViewHolder;
import com.dq.xindai.bean.TestBean;

/**
 * 我的-帖子相关（收藏、我的帖子、草稿）适配器
 * Created by jingang on 2018/6/8.
 */

public class ForumTitleAdapter extends BaseAdapter<TestBean.DateBean> {
    public ForumTitleAdapter(Context context) {
        super(context);
    }

    @Override
    public int getLayoutId() {
        return R.layout.item_forum_title;
    }

    @Override
    public void onBindItemHolder(ViewHolder holder, int position) {

    }
}
