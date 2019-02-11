package com.dq.xindai.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;

import com.dq.xindai.R;
import com.dq.xindai.adapter.MoneyRechargeAdapter;
import com.dq.xindai.base.BaseActivity;
import com.dq.xindai.bean.RecordData;
import com.dq.xindai.bean.ResultBase;
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
 * 记录（充值/提现）
 * Created by jingang on 2018/12/26.
 */

public class MoneyRecordActivity extends BaseActivity {
    @Bind(R.id.lRrcyclerView)
    LRecyclerView lRrcyclerView;

    private String type;
    private int tradeId;

    private LRecyclerViewAdapter lRecyclerViewAdapter;
    private MoneyRechargeAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBaseContentView(R.layout.layout_lrecyclerview);
        ButterKnife.bind(this);

        type = getIntent().getStringExtra("type");
        tradeId = getIntent().getIntExtra("tradeId", 1);

        setIvBack();

        setAdapter();
        if (type.equals("1")) {
            //充值记录
            setTvTitle("充值记录");
            getWalletRechargeRecord(page, pagesize, getUserToken(), HttpPath.WALLET_RECHARGE_RECORD);
        } else if (type.equals("2")) {
            //提现记录
            setTvTitle("提现记录");
            getWalletRechargeRecord(page, pagesize, getUserToken(), HttpPath.WALLET_WITHDRAW_RECORD);
        }
    }

    public void setAdapter() {
        mAdapter = new MoneyRechargeAdapter(this);
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
                if (type.equals("1")) {
                    getWalletRechargeRecord(page, pagesize, getUserToken(), HttpPath.WALLET_RECHARGE_RECORD);
                } else if (type.equals("2")) {
                    getWalletRechargeRecord(page, pagesize, getUserToken(), HttpPath.WALLET_WITHDRAW_RECORD);
                }
            }
        });
        lRrcyclerView.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                page++;
                if (type.equals("1")) {
                    getWalletRechargeRecord(page, pagesize, getUserToken(), HttpPath.WALLET_RECHARGE_RECORD);
                } else if (type.equals("2")) {
                    getWalletRechargeRecord(page, pagesize, getUserToken(), HttpPath.WALLET_WITHDRAW_RECORD);
                }
            }
        });
    }

    /**
     * 充值、提现记录前加密
     *
     * @param token
     * @param page
     * @param pagesize
     */
    public void getWalletRechargeRecord(int page, int pagesize, String token, String path) {
        String PATH_RSA = "page=" + page + "&pagesize=" + pagesize + "&token=" + token;
        Log.e("ssssss", "充值记录参数 = " + PATH_RSA);
        try {
            PrivateKey privateKey = RSAUtils.loadPrivateKey(RSAUtils.PRIVATE_KEY);
            byte[] encryptByte = RSAUtils.encryptDataPrivate(PATH_RSA.getBytes(), privateKey);
            xUtilsWalletRechargeRecord(Base64Utils.encode(encryptByte).toString(), path);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 充值记录
     *
     * @param sign
     */
    public void xUtilsWalletRechargeRecord(String sign, String path) {
        Log.e("ssssss", "充值记录接口 = " + path + "sign=" + sign);
        HashMap<String, String> map = new HashMap<>();
        map.put("sign", sign);
        HttpxUtils.Get(this,
                path,
                map, new Callback.CommonCallback<String>() {
                    @Override
                    public void onSuccess(String result) {
                        ResultBase resultBase = GsonUtil.gsonIntance().gsonToBean(result, ResultBase.class);
                        if (resultBase.getStatus() == 1) {
                            if (page == 1) {
                                mAdapter.clear();
                            }
                            RecordData data = GsonUtil.gsonIntance().gsonToBean(result, RecordData.class);
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
