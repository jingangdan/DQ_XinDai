package com.dq.xindai.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;

import com.dq.xindai.R;
import com.dq.xindai.adapter.SearchFlowAdapter;
import com.dq.xindai.base.BaseActivity;
import com.dq.xindai.bean.ResultBase;
import com.dq.xindai.bean.SearchFlowData;
import com.dq.xindai.openssl.Base64Utils;
import com.dq.xindai.openssl.RSAUtils;
import com.dq.xindai.utils.GsonUtil;
import com.dq.xindai.utils.HttpPath;
import com.dq.xindai.utils.HttpxUtils;
import com.github.jdsjlzx.interfaces.OnLoadMoreListener;
import com.github.jdsjlzx.interfaces.OnRefreshListener;
import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;

import org.xutils.common.Callback;

import java.security.PrivateKey;
import java.util.HashMap;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 回款账单
 * Created by jingang on 2018/12/29.
 */

public class SearchFlowActivity extends BaseActivity {
    @Bind(R.id.lRrcyclerView)
    LRecyclerView lRrcyclerView;

    private int tradeId;
    private LRecyclerViewAdapter lRecyclerViewAdapter;
    private SearchFlowAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBaseContentView(R.layout.layout_lrecyclerview);
        ButterKnife.bind(this);
        setTvTitle("回款账单");
        setIvBack();

        tradeId = getIntent().getIntExtra("tradeId", 1);
        setAdapter();
        getSearchFlow(tradeId + "", page, pagesize, getUserToken());

    }

    /**
     * 适配器
     */
    public void setAdapter() {
        mAdapter = new SearchFlowAdapter(this);
        lRrcyclerView.setLayoutManager(new LinearLayoutManager(this));
        lRecyclerViewAdapter = new LRecyclerViewAdapter(mAdapter);
        lRrcyclerView.setAdapter(lRecyclerViewAdapter);
//        lRecyclerViewAdapter.setOnItemClickListener(new OnItemClickListener() {
//            @Override
//            public void onItemClick(View view, int position) {
//                startActivity(new Intent(this, FlowDetailActivity.class));
//            }
//        });

        lRrcyclerView.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh() {
                page = 1;
                getSearchFlow(tradeId + "", page, pagesize, getUserToken());
            }
        });
        lRrcyclerView.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                page++;
                getSearchFlow(tradeId + "", page, pagesize, getUserToken());
            }
        });
    }

    /**
     * 回款账单前加密
     *
     * @param trade_id
     * @param page
     * @param pagesize
     * @param token
     */
    public void getSearchFlow(String trade_id, int page, int pagesize, String token) {
        String PATH_RSA = "trade_id=" + trade_id + "&page=" + page + "&pagesize=" + pagesize + "&token=" + token;
        Log.e("ssssss", "回款账单参数 = " + PATH_RSA);
        try {
            PrivateKey privateKey = RSAUtils.loadPrivateKey(RSAUtils.PRIVATE_KEY);
            byte[] encryptByte = RSAUtils.encryptDataPrivate(PATH_RSA.getBytes(), privateKey);
            xUtilsSearchFlow(Base64Utils.encode(encryptByte).toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 回款账单
     *
     * @param sign
     */
    public void xUtilsSearchFlow(String sign) {
        Log.e("ssssss", "回款账单接口 = " + HttpPath.SEARCH_FLOW + "sign=" + sign);
        HashMap<String, String> map = new HashMap<>();
        map.put("sign", sign);
        HttpxUtils.Get(this,
                HttpPath.SEARCH_FLOW,
                map, new Callback.CommonCallback<String>() {
                    @Override
                    public void onSuccess(String result) {
                        ResultBase resultBase = GsonUtil.gsonIntance().gsonToBean(result, ResultBase.class);
                        if (resultBase.getStatus() == 1) {
                            if (page == 1) {
                                mAdapter.clear();
                            }
                            SearchFlowData data = GsonUtil.gsonIntance().gsonToBean(result, SearchFlowData.class);
                            mAdapter.addAll(data.getData().getList());
                            if (data.getData().getList().size() < pagesize) {
                                lRrcyclerView.setNoMore(true);
                            }
                        } else {
                            showMessage(resultBase.getInfo());
                        }

                    }

                    @Override
                    public void onError(Throwable ex, boolean isOnCallback) {
                        showMessage("失败，请检查网络");
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
