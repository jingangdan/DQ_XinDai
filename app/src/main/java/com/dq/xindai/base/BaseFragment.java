package com.dq.xindai.base;

import android.support.v4.app.Fragment;

import com.dq.xindai.utils.ToastUtils;

/**
 * @describe：
 * @author：jingang
 * @createdate：2018/03/22
 */

public class BaseFragment extends Fragment {

    public void showMessage(String message) {
        ToastUtils.getInstance(getActivity()).showMessage(message);
    }
}
