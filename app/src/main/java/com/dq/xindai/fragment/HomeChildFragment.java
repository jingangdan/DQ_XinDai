package com.dq.xindai.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.dq.xindai.Interface.OnClickListeners;
import com.dq.xindai.R;
import com.dq.xindai.adapter.LoanAdapter;
import com.dq.xindai.base.BaseApplication;
import com.dq.xindai.base.LazyBaseFragment;
import com.dq.xindai.bean.TestBean;
import com.dq.xindai.openssl.Base64Utils;
import com.dq.xindai.openssl.RSAUtils;
import com.dq.xindai.ui.LoanDetailsActivity;
import com.dq.xindai.utils.HttpPath;
import com.dq.xindai.utils.HttpxUtils;
import com.dq.xindai.view.rollpagerview.ImageLoopAdapter;
import com.dq.xindai.view.rollpagerview.RollPagerView;
import com.github.jdsjlzx.interfaces.OnItemClickListener;
import com.github.jdsjlzx.interfaces.OnLoadMoreListener;
import com.github.jdsjlzx.interfaces.OnRefreshListener;
import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;

import org.xutils.common.Callback;

import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 首页（贷款、理财）
 * Created by jingang on 2018/6/7.
 */

public class HomeChildFragment extends LazyBaseFragment implements OnRefreshListener, OnLoadMoreListener {
    @Bind(R.id.lRrcyclerView)
    LRecyclerView lRrcyclerView;

    private LRecyclerViewAdapter lRecyclerViewAdapter;
    private LoanAdapter mAdapter;
    private List<TestBean.DateBean> dateList;

    private String type;

    private View headView;

    private RollPagerView rollPagerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_lrecyclerview, null);
        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            if (getArguments() != null) {
                if (getActivity() != null) {
                    type = getArguments().getString("type");
                    setAdapter();
                    initDate();

                    getIndex(BaseApplication.getInstance().getUserToken());
                }
            }
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        if (getUserVisibleHint()) {
            setAdapter();
            initDate();
            getIndex(BaseApplication.getInstance().getUserToken());
        }
    }

    public void initDate() {
        lRrcyclerView.setOnRefreshListener(this);
        lRrcyclerView.setOnLoadMoreListener(this);

        //banner
        DisplayMetrics dm = getActivity().getResources().getDisplayMetrics();
        int width = dm.widthPixels;
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) rollPagerView.getLayoutParams();
        params.height = width / 3;//宽高比 1:3
        rollPagerView.setLayoutParams(params);

        rollPagerView.setAnimationDurtion(500);
       // rollPagerView.setTest();

        rollPagerView.setAdapter(new ImageLoopAdapter(rollPagerView, getContext()));
        rollPagerView.setOnItemClickListener(new OnClickListeners() {
            @Override
            public void onItemClick(int position) {
                showMessage("aaaaaa = " + position);
            }
        });

        dateList = new ArrayList<>();
        dateList.add(new TestBean.DateBean("aaa", "aaa"));
        dateList.add(new TestBean.DateBean("aaa", "aaa"));
        dateList.add(new TestBean.DateBean("aaa", "aaa"));
        dateList.add(new TestBean.DateBean("aaa", "aaa"));
        dateList.add(new TestBean.DateBean("aaa", "aaa"));

        lRrcyclerView.refreshComplete(dateList.size());
        //mAdapter.addAll(dateList);
    }

    public void setHeadView() {
        headView = LayoutInflater.from(getActivity()).inflate(R.layout.include_lunbo, null);
        lRecyclerViewAdapter.addHeaderView(headView);
        rollPagerView = headView.findViewById(R.id.rollPagerView);
    }

    public void setAdapter() {
        mAdapter = new LoanAdapter(getActivity());
        lRrcyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        lRecyclerViewAdapter = new LRecyclerViewAdapter(mAdapter);
        lRrcyclerView.setAdapter(lRecyclerViewAdapter);
        lRecyclerViewAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                startActivity(new Intent(getActivity(), LoanDetailsActivity.class));
            }
        });
        setHeadView();
    }

    /**
     *
     * @param token
     */
    public void getIndex(String token){
        String PATH_RSA = "token=" + token;
        Log.e("ssssss", "首页参数 = " + PATH_RSA);
        try {
            PrivateKey privateKey = RSAUtils.loadPrivateKey(RSAUtils.PRIVATE_KEY);
            byte[] encryptByte = RSAUtils.encryptDataPrivate(PATH_RSA.getBytes(), privateKey);
            xUtilsIndex(Base64Utils.encode(encryptByte).toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void xUtilsIndex(String sign) {
        Log.e("ssssss", "首页接口 = " + HttpPath.INDEX + "sign=" + sign);
        HashMap<String, Object> map = new HashMap<>();
        map.put("sign", sign);
        HttpxUtils.Post(getActivity(),
                HttpPath.INDEX,
                map, new Callback.CommonCallback<String>() {
                    @Override
                    public void onSuccess(String result) {
                        Log.e("ssssss",result);
                    }

                    @Override
                    public void onError(Throwable ex, boolean isOnCallback) {
                        Log.e("ssssss","失败，请检查网络"+ex);
                    }

                    @Override
                    public void onCancelled(CancelledException cex) {

                    }

                    @Override
                    public void onFinished() {

                    }
                });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void onRefresh() {

    }

    @Override
    public void onLoadMore() {

    }
}
