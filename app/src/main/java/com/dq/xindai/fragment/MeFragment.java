package com.dq.xindai.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dq.xindai.R;
import com.dq.xindai.base.BaseApplication;
import com.dq.xindai.base.BaseFragment;
import com.dq.xindai.bean.RemData;
import com.dq.xindai.fragment.p.MePresenter;
import com.dq.xindai.fragment.view.MeFView;
import com.dq.xindai.ui.AboutActivity;
import com.dq.xindai.ui.DepositoryActivity;
import com.dq.xindai.ui.DepositoryWaitingActivity;
import com.dq.xindai.ui.FeedBackActivity;
import com.dq.xindai.ui.InvitationCodeActivity;
import com.dq.xindai.ui.LoginActivity;
import com.dq.xindai.ui.MemberActivity;
import com.dq.xindai.ui.MindActivity;
import com.dq.xindai.ui.MyWalletActivity;
import com.dq.xindai.ui.TransactionActivity;
import com.dq.xindai.utils.DataCode;
import com.dq.xindai.utils.GsonUtil;
import com.dq.xindai.utils.ScreenManagerUtils;
import com.dq.xindai.utils.ShowUtils;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * 首页（我的）
 * Created by jingang on 2018/6/5.
 */
public class MeFragment extends BaseFragment implements MeFView {
    @Bind(R.id.tvMeName)
    TextView tvMeName;
    @Bind(R.id.tvMeMoblie)
    TextView tvMeMoblie;
    @Bind(R.id.me_civ_img)
    CircleImageView meCivImg;
    @Bind(R.id.linMeTop)
    LinearLayout linMeTop;
    @Bind(R.id.linMeMenu1)
    LinearLayout linMeMenu1;
    @Bind(R.id.linMeMenu2)
    LinearLayout linMeMenu2;
    @Bind(R.id.linMeMenu3)
    LinearLayout linMeMenu3;
    @Bind(R.id.linMeMenu4)
    LinearLayout linMeMenu4;
    @Bind(R.id.linMeMenu5)
    LinearLayout linMeMenu5;
    @Bind(R.id.linMeMenu6)
    LinearLayout linMeMenu6;
    @Bind(R.id.linMeMenu7)
    LinearLayout linMeMenu7;
    @Bind(R.id.butMe)
    Button butMe;

    private MePresenter mePresenter;
    /*余额*/
    private double balance;
    private String name, mobile;

    /*存管状态 0未开通 2已开通 99正在审核中*/
    private int dep_status;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fm_me, null);
        ButterKnife.bind(this, view);
        mePresenter = new MePresenter(getActivity(), this);
        mePresenter.postRemDetailed(BaseApplication.getInstance().getUserToken());
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick({R.id.me_civ_img,
            R.id.linMeMenu1, R.id.linMeMenu2, R.id.linMeMenu3, R.id.linMeMenu4, R.id.linMeMenu5, R.id.linMeMenu6, R.id.linMeMenu7, R.id.butMe})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.me_civ_img:
                //个人信息
                startActivity(new Intent(getActivity(), MemberActivity.class)
                        .putExtra("name", name)
                        .putExtra("mobile", mobile));
                break;
            case R.id.linMeMenu1:
                //我的钱包
                //startActivity(new Intent(getActivity(), PeopleManageActivity.class));
                startActivity(new Intent(getActivity(), MyWalletActivity.class));
                break;
            case R.id.linMeMenu2:
                //存管操作
                if (dep_status == 0) {
                    //未开通
                    startActivity(new Intent(getActivity(), MindActivity.class));
                } else if (dep_status == 2) {
                    //已开通 显示存管信息
                    startActivity(new Intent(getActivity(), DepositoryActivity.class));
                } else if (dep_status == 99) {
                    //审核中
                    startActivity(new Intent(getActivity(),DepositoryWaitingActivity.class));
                }

                break;
            case R.id.linMeMenu3:
                //VIP客服
                break;
            case R.id.linMeMenu4:
                //交易查询
                startActivity(new Intent(getActivity(), TransactionActivity.class));
                break;
            case R.id.linMeMenu5:
                //关于
                startActivity(new Intent(getActivity(), AboutActivity.class));
                break;
            case R.id.linMeMenu6:
                //邀请码
                startActivity(new Intent(getActivity(), InvitationCodeActivity.class));
                break;
            case R.id.linMeMenu7:
                //意见反馈
                startActivity(new Intent(getActivity(), FeedBackActivity.class));
                break;
            case R.id.butMe:
                //退出
                ShowUtils.showDialog(getActivity(), "提示", "是否退出登陆", "退出", new ShowUtils.OnDialogListener() {
                    @Override
                    public void confirm() {
                        BaseApplication.getInstance().saveUserInfo(null);
                        refreshData();
                    }

                    @Override
                    public void cancel() {

                    }
                });

                break;
        }
    }

    /**
     * 刷新数据
     */
    public void refreshData() {
        if (BaseApplication.getInstance().getUserToken().equals("1")) {
            Intent intent = new Intent(getActivity(), LoginActivity.class);
            startActivityForResult(intent, DataCode.LOGIN);

            ScreenManagerUtils.getInstance().clearActivityStack();
            return;
        }
        mePresenter.postRemDetailed(BaseApplication.getInstance().getUserToken());
    }

    /**
     * 更新UI
     *
     * @param result
     */
    public void setUI(String result) {
        RemData remData = GsonUtil.gsonIntance().gsonToBean(result, RemData.class);
        balance = remData.getData().getBalance();
        dep_status = remData.getData().getDep_status();
        name = remData.getData().getUser_name();
        mobile = remData.getData().getMobile();
        tvMeName.setText(name);
        tvMeMoblie.setText(mobile);
    }

    @Override
    public void Success(String result) {
        setUI(result);
    }

    @Override
    public void sendError(String result) {
        showMessage(result);
    }

    @Override
    public void Error(String error) {
        showMessage(error);
    }
}
