package com.dq.xindai.utils;

import android.app.Dialog;
import android.content.Context;

import com.dq.xindai.R;


/**
 * 等待框
 * Created by jingang on 2018/3/28.
 */

public class MyProgressDialog extends Dialog {
    public MyProgressDialog(Context context) {
        this(context, R.style.style_dialog);
    }

    public MyProgressDialog(Context context, int themeResId) {
        super(context, themeResId);
        setContentView(R.layout.dialog_progress);
        this.setCancelable(false);
        setCanceledOnTouchOutside(false);
    }
}
