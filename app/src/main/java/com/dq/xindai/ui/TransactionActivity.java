package com.dq.xindai.ui;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.dq.xindai.R;
import com.dq.xindai.adapter.FlowAdapter;
import com.dq.xindai.base.BaseActivity;
import com.dq.xindai.base.BaseAdapter;
import com.dq.xindai.base.ViewHolder;
import com.dq.xindai.bean.ResultBase;
import com.dq.xindai.bean.SearchIndexData;
import com.dq.xindai.bean.TestBean;
import com.dq.xindai.bean.TransactionStatusData;
import com.dq.xindai.openssl.Base64Utils;
import com.dq.xindai.openssl.RSAUtils;
import com.dq.xindai.utils.GsonUtil;
import com.dq.xindai.utils.HttpPath;
import com.dq.xindai.utils.HttpxUtils;
import com.github.jdsjlzx.interfaces.OnItemClickListener;
import com.github.jdsjlzx.interfaces.OnLoadMoreListener;
import com.github.jdsjlzx.interfaces.OnRefreshListener;
import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;

import org.xutils.common.Callback;

import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 我的-- 投资交易查询
 * Created by jingang on 2018/12/26.
 */

public class TransactionActivity extends BaseActivity {
    @Bind(R.id.butData)
    Button butData;
    @Bind(R.id.butStatus)
    Button butStatus;
    @Bind(R.id.lRrcyclerView)
    LRecyclerView lRrcyclerView;

    private LRecyclerViewAdapter lRecyclerViewAdapter;
    private FlowAdapter mAdapter;

    //    状态 开始时间 结束时间
    private String status, startdata, enddata;

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBaseContentView(R.layout.activity_transaction);
        ButterKnife.bind(this);
        setTvTitle("交易查询");
        setIvBack();

        setAdapter();
        getTransaction(status, startdata, enddata, page, pagesize, getUserToken());
    }

    @OnClick({R.id.butData, R.id.butStatus})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.butData:
                showPopData();
                break;
//            case R.id.butStatus:
//                if (pop == null) {
//                    showPopStatus();
//                } else {
//                    pop.showAsDropDown(butStatus);
//                }
//                break;
            default:
                break;
        }
    }

    /**
     * 数据显示
     */
    public void setAdapter() {
        mAdapter = new FlowAdapter(this);
        lRrcyclerView.setLayoutManager(new LinearLayoutManager(this));
        lRecyclerViewAdapter = new LRecyclerViewAdapter(mAdapter);
        lRrcyclerView.setAdapter(lRecyclerViewAdapter);
        lRecyclerViewAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                startActivity(new Intent(TransactionActivity.this, FlowDetailActivity.class)
                        .putExtra("tradeId", mAdapter.getDataList().get(position).getId()));
            }
        });

        lRrcyclerView.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh() {
                page = 1;
                getTransaction("0", "", "", page, pagesize, getUserToken());

            }
        });
        lRrcyclerView.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                page++;
                getTransaction("0", "", "", page, pagesize, getUserToken());
            }
        });
    }

    /**
     * 交易信息前加密
     *
     * @param token
     */
    public void getTransaction(String status, String startdata, String enddata, int page, int pagesize, String token) {
        String PATH_RSA = "status=" + status + "&startdata=" + startdata + "&enddata=" + enddata + "&page=" + page + "&pagesize=" + pagesize + "&token=" + token;
        Log.e("ssssss", "交易信息参数 = " + PATH_RSA);
        try {
            PrivateKey privateKey = RSAUtils.loadPrivateKey(RSAUtils.PRIVATE_KEY);
            byte[] encryptByte = RSAUtils.encryptDataPrivate(PATH_RSA.getBytes(), privateKey);
            xUtilsTransaction(Base64Utils.encode(encryptByte).toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 交易查询
     *
     * @param sign
     */
    public void xUtilsTransaction(String sign) {
        Log.e("ssssss", "交易查询接口 = " + HttpPath.SEARCH_INDEX + "sign=" + sign);
        HashMap<String, String> map = new HashMap<>();
        map.put("sign", sign);
        HttpxUtils.Get(this,
                HttpPath.SEARCH_INDEX,
                map, new Callback.CommonCallback<String>() {
                    @Override
                    public void onSuccess(String result) {
                        Log.e("ssssss", result);
                        if (page == 1) {
                            mAdapter.clear();
                        }
                        ResultBase resultBase = GsonUtil.gsonIntance().gsonToBean(result, ResultBase.class);
                        if (resultBase.getStatus() == 1) {
                            SearchIndexData data = GsonUtil.gsonIntance().gsonToBean(result, SearchIndexData.class);
                            mAdapter.addAll(data.getData());
                            if (data.getData().size() < pagesize) {
                                lRrcyclerView.setNoMore(true);
                            }
                        } else {
                            showMessage(resultBase.getInfo());
                        }

                    }

                    @Override
                    public void onError(Throwable ex, boolean isOnCallback) {
                        Log.e("ssssss", "失败，请检查网络！" + ex);
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


    LayoutInflater mLayoutInflater;
    View contentView;
    PopupWindow pop;

    private RelativeLayout relDialogData1, relDialogData2;
    private Button butDialogData;
    private TextView tvDialogData1, tvDialogData2;
    private LinearLayout linDialogData;

    /**
     * 根据日期查询
     */
    public void showPopData() {
        mLayoutInflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        contentView = mLayoutInflater.inflate(R.layout.dialog_data, null);
        pop = new PopupWindow(contentView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        pop.setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        // 指定 PopupWindow 的背景
        pop.setFocusable(true);
        //指定PopupWindow显示在你指定的view下
        pop.showAsDropDown(butStatus);

        tvDialogData1 = contentView.findViewById(R.id.tvDialogData1);
        tvDialogData2 = contentView.findViewById(R.id.tvDialogData2);
        linDialogData = contentView.findViewById(R.id.linDialogData);
        relDialogData1 = contentView.findViewById(R.id.relDialogData1);
        relDialogData1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //选择开始日期
                showDate(tvDialogData1, 1);
            }
        });
        relDialogData2 = contentView.findViewById(R.id.relDialogData2);
        relDialogData2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //选择结束时间
                showDate(tvDialogData2, 2);
            }
        });
        butDialogData = contentView.findViewById(R.id.butDialogData);
        butDialogData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //确定
                pop.dismiss();
                getTransaction(status, startdata, enddata, page, pagesize, getUserToken());
            }
        });
        linDialogData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //点击空白区域
                pop.dismiss();
            }
        });
    }


    private LinearLayout linDialogStatus;
    private LRecyclerView lRecyclerView_status;

    /**
     * 根据状态查询
     */
    public void showPopStatus() {
        mLayoutInflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        contentView = mLayoutInflater.inflate(R.layout.dialog_status, null);
        pop = new PopupWindow(contentView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        pop.setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        // 指定 PopupWindow 的背景
        pop.setFocusable(true);
        //指定PopupWindow显示在你指定的view下
        pop.showAsDropDown(butStatus);

        lRecyclerView_status = contentView.findViewById(R.id.lRrcyclerView);
        setStatusAdapter();
        initStatusData();

        linDialogStatus = contentView.findViewById(R.id.linDialogStatus);
        linDialogStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //点击空白区域
                pop.dismiss();
            }
        });
    }

    private List<TransactionStatusData> dateList;
    private StatusAdapter statusAdapter;

    public void initStatusData() {
        dateList = new ArrayList<>();
        dateList.add(new TransactionStatusData("0", "全部", false));
        dateList.add(new TransactionStatusData("1", "未支付", false));
        dateList.add(new TransactionStatusData("2", "进行中", false));
        dateList.add(new TransactionStatusData("3", "回收中", false));
        dateList.add(new TransactionStatusData("4", "已完成", false));
        dateList.add(new TransactionStatusData("5", "放款中", false));
        dateList.add(new TransactionStatusData("6", "流标", false));
        dateList.add(new TransactionStatusData("7", "已撤销", false));
        statusAdapter.addAll(dateList);
    }

    public void setStatusAdapter() {
        statusAdapter = new StatusAdapter(this);
        lRecyclerView_status.setLayoutManager(new LinearLayoutManager(this));
        lRecyclerViewAdapter = new LRecyclerViewAdapter(statusAdapter);
        lRecyclerView_status.setAdapter(lRecyclerViewAdapter);
        lRecyclerViewAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                status = dateList.get(position).getId();
                for (int i = 0; i < dateList.size(); i++) {
                    if (i == position) {
                        Log.e("ssssss", i + "");
                        dateList.get(i).setChange(true);
                    } else {
                        Log.e("ssssss", i + "");
                        dateList.get(i).setChange(false);
                    }
                }
                getTransaction(status, startdata, enddata, page, pagesize, getUserToken());

                statusAdapter.clear();
                statusAdapter.addAll(dateList);
                pop.dismiss();
            }
        });
    }


    private Calendar calendar;// 用来装日期的
    private DatePickerDialog dialog;

    /**
     * 日期选择器
     */
    @SuppressLint({"NewApi", "WrongConstant"})
    public void showDate(final TextView textView, final int type) {
        calendar = Calendar.getInstance();
        dialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {
                        textView.setText(year + "-" + monthOfYear + "-" + dayOfMonth);
                        if (type == 1) {
                            startdata = year + "-" + monthOfYear + "-" + dayOfMonth;
                        } else if (type == 2) {
                            enddata = year + "-" + monthOfYear + "-" + dayOfMonth;
                        }
                    }
                }, calendar.get(Calendar.YEAR), calendar
                .get(Calendar.MONTH), calendar
                .get(Calendar.DAY_OF_MONTH));
        dialog.show();
    }

    public class StatusAdapter extends BaseAdapter<TransactionStatusData> {
        public StatusAdapter(Context context) {
            super(context);
        }

        @Override
        public int getLayoutId() {
            return R.layout.item_status;
        }

        @Override
        public void onBindItemHolder(ViewHolder holder, int position) {
            TextView tvTitle = holder.getView(R.id.itemTvStatusTitle);
            ImageView ivCheck = holder.getView(R.id.itemIvStatusCheck);

            tvTitle.setText(mDataList.get(position).getTitle());
            if (mDataList.get(position).isChange()) {
                ivCheck.setVisibility(View.VISIBLE);
            } else {
                ivCheck.setVisibility(View.INVISIBLE);
            }

        }
    }

}
