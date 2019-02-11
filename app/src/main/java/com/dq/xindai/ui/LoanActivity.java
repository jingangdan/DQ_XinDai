package com.dq.xindai.ui;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.dq.xindai.R;
import com.dq.xindai.adapter.SimpleFragmentPagerAdapter;
import com.dq.xindai.base.BaseActivity;
import com.dq.xindai.bean.FinanceDetailData;
import com.dq.xindai.bean.WebData;
import com.dq.xindai.bean.ResultBase;
import com.dq.xindai.fragment.LoanDetailFragmentTest;
import com.dq.xindai.fragment.LoanRecordFragment;
import com.dq.xindai.fragment.LoanRepayFragment;
import com.dq.xindai.openssl.Base64Utils;
import com.dq.xindai.openssl.RSAUtils;
import com.dq.xindai.utils.DataCode;
import com.dq.xindai.utils.DensityUtil;
import com.dq.xindai.utils.GsonUtil;
import com.dq.xindai.utils.HttpPath;
import com.dq.xindai.utils.HttpxUtils;
import com.dq.xindai.view.NoScrollViewPager;

import org.xutils.common.Callback;

import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 首页-借款详情
 * Created by jingang on 2019/1/7.
 */

public class LoanActivity extends BaseActivity implements ViewPager.OnPageChangeListener {
    @Bind(R.id.tl_loan)
    TabLayout tlLoan;
    @Bind(R.id.nvp_loan)
    NoScrollViewPager nvpLoan;

    private int id;

    private String[] titles = new String[]{"借款详情", "投资记录", "还款计划"};
    private List<Fragment> fragments = new ArrayList<>();

    private SimpleFragmentPagerAdapter sfpAdapter;

    private String form;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBaseContentView(R.layout.activity_loan);
        ButterKnife.bind(this);
        setTvTitle("借款详情");
        setIvBack();
        getTvRight().setText("投资");
        getTvRight().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setDialog();
            }
        });
        id = getIntent().getIntExtra("id", 1);

        getFinanceDetail(id, getUserToken());
    }

    /**
     * 借款详情前加密
     *
     * @param id
     * @param token
     */
    public void getFinanceDetail(int id, String token) {
        String PATH_RSA = "id=" + id + "&token=" + token;
        Log.e("ssssss", "借款详情参数 = " + PATH_RSA);
        try {
            PrivateKey privateKey = RSAUtils.loadPrivateKey(RSAUtils.PRIVATE_KEY);
            byte[] encryptByte = RSAUtils.encryptDataPrivate(PATH_RSA.getBytes(), privateKey);
            xUtilsFinanceDetail(Base64Utils.encode(encryptByte).toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 借款详情
     *
     * @param sign
     */
    public void xUtilsFinanceDetail(String sign) {
        Log.e("ssssss", "借款详情接口 = " + HttpPath.FINANCE_DETAIL + "sign=" + sign);
        HashMap<String, String> map = new HashMap<>();
        map.put("sign", sign);
        HttpxUtils.Get(this,
                HttpPath.FINANCE_DETAIL,
                map, new Callback.CommonCallback<String>() {
                    @Override
                    public void onSuccess(String result) {
                        Log.e("ssssss", result);
                        ResultBase resultBase = GsonUtil.gsonIntance().gsonToBean(result, ResultBase.class);
                        if (resultBase.getStatus() == 1) {
                            FinanceDetailData data = GsonUtil.gsonIntance().gsonToBean(result, FinanceDetailData.class);
                            setFragments(data.getData(),
                                    data.getData().getBorrow().getLoadlist(),
                                    data.getData().getBorrow().getRepaylist());
                        } else {
                            showMessage(resultBase.getInfo());
                        }
                    }

                    @Override
                    public void onError(Throwable ex, boolean isOnCallback) {
                        Log.e("ssssss", "失败，请检查网络" + ex);
                        showMessage("失败，请检查网络");
                    }

                    @Override
                    public void onCancelled(CancelledException cex) {
                    }

                    @Override
                    public void onFinished() {
                    }
                });
    }


    public void setFragments(FinanceDetailData.DataBean dataBean,
                             List<FinanceDetailData.DataBean.BorrowBean.LoadlistBean> loadlist,
                             List<FinanceDetailData.DataBean.BorrowBean.RepaylistBean> repaylist) {
        //fragments.add(LoanDetailFragment.newInstance(memberBean));

        fragments.add(LoanDetailFragmentTest.newInstance(dataBean));
        fragments.add(LoanRecordFragment.newInstance(loadlist));
        fragments.add(LoanRepayFragment.newInstance(repaylist));

        sfpAdapter = new SimpleFragmentPagerAdapter(getSupportFragmentManager(), this, fragments, titles);
        nvpLoan.setAdapter(sfpAdapter);

        nvpLoan.setCurrentItem(0);
        nvpLoan.setOffscreenPageLimit(titles.length);

        nvpLoan.addOnPageChangeListener(this);
        tlLoan.setupWithViewPager(nvpLoan);
    }

    /**
     * 我要投资dialog
     */
    public void setDialog() {
        final Dialog bottomDialog = new Dialog(this, R.style.BottomDialog);
        View views = LayoutInflater.from(this).inflate(R.layout.dialog_financing, null);
        bottomDialog.setContentView(views);
        ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) views.getLayoutParams();
        params.width = getResources().getDisplayMetrics().widthPixels - DensityUtil.dp2px(this, 100f);
        params.bottomMargin = DensityUtil.dp2px(this, 100f);
        views.setLayoutParams(params);
        bottomDialog.getWindow().setGravity(Gravity.CENTER);
        bottomDialog.getWindow().setWindowAnimations(R.style.BottomDialog_Animation);
        bottomDialog.show();

        final EditText editText = (EditText) views.findViewById(R.id.editDialogCall);
        Button butNo = (Button) views.findViewById(R.id.butDialogCallNo);
        Button butYes = (Button) views.findViewById(R.id.butDialogCallYes);

        butYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(editText.getText().toString().trim())) {
                    showMessage("请输入您要投资的金额");
                    return;
                }
                postFinancing(id, editText.getText().toString().trim(), getUserToken());
                bottomDialog.dismiss();
            }
        });

        butNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomDialog.dismiss();
            }
        });
    }

    /**
     * 投资前加密
     *
     * @param borrow_id
     * @param money
     * @param token
     */
    public void postFinancing(int borrow_id, String money, String token) {
        String PATH_RSA = "borrow_id=" + borrow_id + "&money=" + money + "&token=" + token;
        Log.e("ssssss", "投资参数 = " + PATH_RSA);
        try {
            PrivateKey privateKey = RSAUtils.loadPrivateKey(RSAUtils.PRIVATE_KEY);
            byte[] encryptByte = RSAUtils.encryptDataPrivate(PATH_RSA.getBytes(), privateKey);
            xUtilsFinancing(Base64Utils.encode(encryptByte).toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 投资
     *
     * @param sign
     */
    public void xUtilsFinancing(String sign) {
        Log.e("ssssss", "投资接口 = " + HttpPath.FINANCE_FINANCING + "sign=" + sign);
        HashMap<String, String> map = new HashMap<>();
        map.put("sign", sign);
        HttpxUtils.Get(this,
                HttpPath.FINANCE_FINANCING,
                map, new Callback.CommonCallback<String>() {
                    @Override
                    public void onSuccess(String result) {
                        Log.e("ssssss", result);
                        ResultBase resultBase = GsonUtil.gsonIntance().gsonToBean(result, ResultBase.class);
                        if (resultBase.getStatus() == 1) {
                            setIntentWeb(result);
                        } else {
                            showMessage(resultBase.getInfo());
                        }
                    }

                    @Override
                    public void onError(Throwable ex, boolean isOnCallback) {
                        Log.e("ssssss", "失败，请检查网络" + ex);
                        showMessage("失败，请检查网络");
                    }

                    @Override
                    public void onCancelled(CancelledException cex) {
                    }

                    @Override
                    public void onFinished() {
                    }
                });
    }

    /*跳转web*/
    public void setIntentWeb(String result) {
        WebData data = GsonUtil.gsonIntance().gsonToBean(result, WebData.class);

        form = "<form id=\"myform\" style=\"display:none\" action=\"" + data.getData().getUrl() + "\"method=\"post\">\n" +
                "  <input type=\"text\" name=\"merchantNo\" value=\"" + data.getData().getSign().getMerchantNo() + "\"/>\n" +
                "  <input type=\"text\" name=\"merOrderNo\" value=\"" + data.getData().getSign().getMerOrderNo() + "\"/>\n" +
                "  <input type=\"text\" name=\"jsonEnc\" value=\"" + data.getData().getSign().getJsonEnc() + "\"/>\n" +
                "  <input type=\"text\" name=\"keyEnc\" value=\"" + data.getData().getSign().getKeyEnc() + "\"/>\n" +
                "  <input type=\"text\" name=\"sign\" value=\"" + data.getData().getSign().getSign() + "\"/>\n" +
                "</form>";

        data.getData().getUrl();
        Intent intent = new Intent(this, WebActivity.class);
        intent.putExtra("url", data.getData().getUrl());
        intent.putExtra("form", form);
        startActivityForResult(intent, DataCode.RECHARGE);
    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
