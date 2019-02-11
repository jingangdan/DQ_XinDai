package com.dq.xindai.ui;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dq.xindai.R;
import com.dq.xindai.base.BaseActivity;
import com.dq.xindai.bean.CustodyIndexData;
import com.dq.xindai.bean.ResultBase;
import com.dq.xindai.bean.WebData;
import com.dq.xindai.openssl.Base64Utils;
import com.dq.xindai.openssl.RSAUtils;
import com.dq.xindai.ui.p.DepositoryPresenter;
import com.dq.xindai.ui.view.DepositoryView;
import com.dq.xindai.utils.DataCode;
import com.dq.xindai.utils.DensityUtil;
import com.dq.xindai.utils.GsonUtil;
import com.dq.xindai.utils.HttpPath;
import com.dq.xindai.utils.HttpxUtils;
import com.dq.xindai.utils.IntentWebUtils;

import org.xutils.common.Callback;

import java.security.PrivateKey;
import java.util.HashMap;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 我的-存管信息
 * Created by jingang on 2019/1/12.
 */

public class DepositoryActivity extends BaseActivity implements DepositoryView {
    @Bind(R.id.tv_depository_custody)
    TextView tvDepositoryCustody;
    @Bind(R.id.tv_depository_account)
    TextView tvDepositoryAccount;
    @Bind(R.id.tv_depository_true_name)
    TextView tvDepositoryTrueName;
    @Bind(R.id.tv_depository_idcard)
    TextView tvDepositoryIdcard;
    @Bind(R.id.tv_depository_dep_type)
    TextView tvDepositoryDepType;
    @Bind(R.id.tv_depository_bank_card)
    TextView tvDepositoryBankCard;
    @Bind(R.id.lin_depository_bank)
    LinearLayout linDepositoryBank;
    @Bind(R.id.lin_depository_pwd)
    LinearLayout linDepositoryPwd;
    @Bind(R.id.tv_depository_mobile)
    TextView tvDepositoryMobile;
    @Bind(R.id.lin_depository_moblie)
    LinearLayout linDepositoryMoblie;
    @Bind(R.id.tv_depository_qianyue)
    TextView tvDepositoryQianyue;
    @Bind(R.id.lin_depository_qianyue)
    LinearLayout linDepositoryQianyue;
    @Bind(R.id.butDepositoryCancel)
    Button butDepositoryCancel;

    private DepositoryPresenter mPresenter;
    private String bankCard;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBaseContentView(R.layout.activity_depository);
        ButterKnife.bind(this);
        setTvTitle("我的存管账户");
        setIvBack();
        mPresenter = new DepositoryPresenter(this, this);
        mPresenter.getCustodyIndex(getUserToken());
    }

    @OnClick({R.id.lin_depository_bank, R.id.lin_depository_pwd, R.id.lin_depository_moblie, R.id.lin_depository_qianyue, R.id.butDepositoryCancel})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.lin_depository_bank:
                //银行卡
                if (TextUtils.isEmpty(bankCard)) {
                    mPresenter.postCustodyBank(getUserToken());
                } else {
                    mPresenter.postCustodyUnBank(getUserToken());
                }
                break;
            case R.id.lin_depository_pwd:
                //修改支付密码
                mPresenter.postCustodyPwd(getUserToken());
                break;
            case R.id.lin_depository_moblie:
                //更换预留手机号
                mPresenter.postCustodyReSetMobile(getUserToken());
                break;
            case R.id.lin_depository_qianyue:
                //签约
                mPresenter.postCustodyQianYue(getUserToken());
                break;
            case R.id.butDepositoryCancel:
                //注销存管账户
                setDialog();
                break;
        }
    }

    /**
     * 更新UI
     *
     * @param result
     */
    public void setUI(String result) {
        CustodyIndexData data = GsonUtil.gsonIntance().gsonToBean(result, CustodyIndexData.class);
        tvDepositoryCustody.setText(data.getData().getCustody().getCustody_id());
        tvDepositoryAccount.setText(data.getData().getCustody().getAccount_id());
        tvDepositoryTrueName.setText(data.getData().getCustody().getTrue_name());
        tvDepositoryIdcard.setText(data.getData().getCustody().getIdcard());
        int dep_type = data.getData().getCustody().getDep_type();
        if (dep_type == 0) {
            tvDepositoryDepType.setText("投资人");
        } else {
            tvDepositoryDepType.setText("借款人");
        }
        bankCard = data.getData().getCustody().getBank_card();
        tvDepositoryBankCard.setText(bankCard);
        tvDepositoryMobile.setText(data.getData().getCustody().getMobile());
        if (data.getData().getQianyue().size() > 0) {
            tvDepositoryQianyue.setText("已签约");
        } else {
            tvDepositoryQianyue.setText("未签约");
        }
    }

    /**
     *
     */
    public void setDialog() {
        final Dialog bottomDialog = new Dialog(this, R.style.BottomDialog);
        View views = LayoutInflater.from(this).inflate(R.layout.dialog_depository, null);
        bottomDialog.setContentView(views);
        ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) views.getLayoutParams();
        params.width = getResources().getDisplayMetrics().widthPixels - DensityUtil.dp2px(this, 100f);
        params.bottomMargin = DensityUtil.dp2px(this, 100f);
        views.setLayoutParams(params);
        bottomDialog.getWindow().setGravity(Gravity.CENTER);
        bottomDialog.getWindow().setWindowAnimations(R.style.BottomDialog_Animation);
        bottomDialog.show();

        final EditText editText = (EditText) views.findViewById(R.id.editDialog);
        Button butNo = (Button) views.findViewById(R.id.butDialogNo);
        Button butYes = (Button) views.findViewById(R.id.butDialogYes);

        butYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(editText.getText().toString().trim())) {
                    showMessage("请输入您的支付密码");
                    return;
                }
                mPresenter.postCustodyCancelLation(editText.getText().toString().trim(), getUserToken());
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

    @Override
    public void getSuccess(String result) {
        //获取数据
        setUI(result);
    }

    @Override
    public void sendSuccess(String result) {
        //网页跳转
        IntentWebUtils.setIntentWeb(result, this, DataCode.CUSTODY_MOBILE);
    }

    @Override
    public void sendError(String error) {
        showMessage(error);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == DataCode.CUSTODY_MOBILE || resultCode == DataCode.WEB) {
            mPresenter.getCustodyIndex(getUserToken());
        }
    }
}
