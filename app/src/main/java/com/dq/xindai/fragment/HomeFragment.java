package com.dq.xindai.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
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
import com.dq.xindai.base.BaseFragment;
import com.dq.xindai.bean.IndexData;
import com.dq.xindai.bean.ResultBase;
import com.dq.xindai.openssl.Base64Utils;
import com.dq.xindai.openssl.RSAUtils;
import com.dq.xindai.ui.LoanActivity;
import com.dq.xindai.utils.GsonUtil;
import com.dq.xindai.utils.HttpPath;
import com.dq.xindai.utils.HttpxUtils;
import com.dq.xindai.view.rollpagerview.ImageLoopAdapter;
import com.dq.xindai.view.rollpagerview.RollPagerView;
import com.github.jdsjlzx.interfaces.OnItemClickListener;
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
 * 首页
 * Created by jingang on 2018/12/31.
 */

public class HomeFragment extends BaseFragment {
    @Bind(R.id.lRrcyclerView)
    LRecyclerView lRrcyclerView;

    private LRecyclerViewAdapter lRecyclerViewAdapter;
    private LoanAdapter mAdapter;
    private List<IndexData.DataBean> dateList = new ArrayList<>();

    private View headView;
    private RollPagerView rollPagerView;

    private int pagesize = 0;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fm_home, null);
        ButterKnife.bind(this, view);

        setAdapter();
        initDate();
        getIndex(BaseApplication.getInstance().getUserToken());
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    public void initDate() {
        //banner
        DisplayMetrics dm = getActivity().getResources().getDisplayMetrics();
        int width = dm.widthPixels;
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) rollPagerView.getLayoutParams();
        params.height = width / 3;//宽高比 1:3
        rollPagerView.setLayoutParams(params);

        rollPagerView.setAnimationDurtion(500);
        //rollPagerView.setTest();

        rollPagerView.setAdapter(new ImageLoopAdapter(rollPagerView, getContext()));
        rollPagerView.setOnItemClickListener(new OnClickListeners() {
            @Override
            public void onItemClick(int position) {
                // showMessage("aaaaaa = " + position);
               // startActivity(new Intent(getActivity(), WebActivity.class));
            }
        });

        lRrcyclerView.refreshComplete(dateList.size());
        mAdapter.addAll(dateList);
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
                if(dateList.size()>0){
                    startActivity(new Intent(getActivity(), LoanActivity.class)
                            .putExtra("id",dateList.get(position).getId()));
                }
            }
        });
        setHeadView();

        lRrcyclerView.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh() {
                getIndex(BaseApplication.getInstance().getUserToken());
            }
        });
//        lRrcyclerView.setOnLoadMoreListener(new OnLoadMoreListener() {
//            @Override
//            public void onLoadMore() {
//                getIndex(BaseApplication.getInstance().getUserToken());
//            }
//        });
    }

    /**
     * @param token
     */
    public void getIndex(String token) {
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
        HashMap<String, String> map = new HashMap<>();
        map.put("sign", sign);
        HttpxUtils.Get(getActivity(),
                HttpPath.INDEX,
                map, new Callback.CommonCallback<String>() {
                    @Override
                    public void onSuccess(String result) {
                        Log.e("ssssss", result);
                        ResultBase resultBase = GsonUtil.gsonIntance().gsonToBean(result, ResultBase.class);
                        if (resultBase.getStatus() == 1) {
                            mAdapter.clear();
                            IndexData data = GsonUtil.gsonIntance().gsonToBean(result, IndexData.class);
                            dateList.clear();
                            dateList.addAll(data.getData());
                            pagesize = data.getData().size();
                            lRrcyclerView.refreshComplete(pagesize);
                            mAdapter.addAll(data.getData());
                        } else {
                            showMessage(resultBase.getInfo());
                        }
                    }

                    @Override
                    public void onError(Throwable ex, boolean isOnCallback) {
                        Log.e("ssssss", "失败，请检查网络" + ex);
                    }

                    @Override
                    public void onCancelled(CancelledException cex) {
                        lRrcyclerView.refreshComplete(pagesize);
                    }

                    @Override
                    public void onFinished() {
                        lRrcyclerView.refreshComplete(pagesize);
                    }
                });
    }
}