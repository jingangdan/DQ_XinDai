package com.dq.xindai.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dq.xindai.R;
import com.dq.xindai.base.BaseActivity;
import com.dq.xindai.fragment.FlowFragment;
import com.dq.xindai.fragment.HomeFragment;
import com.dq.xindai.fragment.HomeFragment2;
import com.dq.xindai.fragment.MeFragment;
import com.dq.xindai.utils.ScreenManagerUtils;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {
    @Bind(R.id.main_fl_content)
    FrameLayout mainFlContent;
    @Bind(R.id.main_iv_1)
    ImageView mainIv1;
    @Bind(R.id.main_tv_1)
    TextView mainTv1;
    @Bind(R.id.main_ll_1)
    LinearLayout mainLl1;
    @Bind(R.id.main_iv_2)
    ImageView mainIv2;
    @Bind(R.id.main_tv_2)
    TextView mainTv2;
    @Bind(R.id.main_ll_2)
    LinearLayout mainLl2;
    @Bind(R.id.main_iv_3)
    ImageView mainIv3;
    @Bind(R.id.main_ll_3)
    LinearLayout mainLl3;
    @Bind(R.id.main_ll_bottom)
    LinearLayout mainLlBottom;
    @Bind(R.id.main_tv_3)
    TextView mainTv3;

    private HomeFragment homeFragment;
    private FlowFragment officeFragment;
    private MeFragment meFragment;
    private Fragment[] fragments;

    private int index = 0;//点击的页卡索引
    private int currentTabIndex = 0;//当前的页卡索引
    private long exitTime = 0;//记录上次点击返回按钮的时间

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initData();
    }

    public void initData() {
        homeFragment = new HomeFragment();
        officeFragment = new FlowFragment();
        meFragment = new MeFragment();
        fragments = new Fragment[]{homeFragment, officeFragment, meFragment};
        setBottomColor();
        getSupportFragmentManager().beginTransaction().add(R.id.main_fl_content, fragments[index]).show(fragments[index]).commit();
    }

    /**
     * 控制fragment的变化
     */
    public void fragmentControl() {
        if (currentTabIndex != index) {
            removeBottomColor();
            setBottomColor();

            FragmentTransaction trx = getSupportFragmentManager().beginTransaction();
            trx.hide(fragments[currentTabIndex]);
            if (!fragments[index].isAdded()) {
                trx.add(R.id.main_fl_content, fragments[index]);
            }
            trx.show(fragments[index]).commit();
            currentTabIndex = index;
        }
    }

    /**
     * 设置底部栏按钮变色
     */
    private void setBottomColor() {
        switch (index) {
            case 0:
                mainIv1.setImageResource(R.mipmap.ic_home001);
                mainTv1.setTextColor(ContextCompat.getColor(this,R.color.tv_color1));
                break;
            case 1:
                mainIv2.setImageResource(R.mipmap.ic_flow001);
                mainTv2.setTextColor(ContextCompat.getColor(this,R.color.tv_color1));
                break;
            case 2:
                mainIv3.setImageResource(R.mipmap.ic_me001);
                mainTv3.setTextColor(ContextCompat.getColor(this,R.color.tv_color1));
                break;
        }
    }

    /**
     * 清除底部栏颜色
     */
    private void removeBottomColor() {
        switch (currentTabIndex) {
            case 0:
                mainIv1.setImageResource(R.mipmap.ic_home002);
                mainTv1.setTextColor(ContextCompat.getColor(this,R.color.tv_color2));
                break;
            case 1:
                mainIv2.setImageResource(R.mipmap.ic_flow002);
                mainTv2.setTextColor(ContextCompat.getColor(this,R.color.tv_color2));
                break;
            case 2:
                mainIv3.setImageResource(R.mipmap.ic_me002);
                mainTv3.setTextColor(ContextCompat.getColor(this,R.color.tv_color2));
                break;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            if ((System.currentTimeMillis() - exitTime) > 2000) {
                showMessage("再按一次退出程序");
                exitTime = System.currentTimeMillis();
            } else {
                ScreenManagerUtils.getInstance().finishAllActivityAndClose();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @OnClick({R.id.main_ll_1, R.id.main_ll_2, R.id.main_ll_3})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.main_ll_1:
                //首页
                index = 0;
                fragmentControl();
                break;
            case R.id.main_ll_2:
                //流程
                index = 1;
                fragmentControl();
                break;
            case R.id.main_ll_3:
                //个人
                index = 2;
                fragmentControl();
                break;
        }
    }
}
