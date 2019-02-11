package com.dq.xindai.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.InputType;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.dq.xindai.R;
import com.dq.xindai.base.BaseActivity;
import com.dq.xindai.base.BaseApplication;
import com.dq.xindai.ui.p.LoginPresenter;
import com.dq.xindai.ui.view.LoginView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 登录
 * Created by jingang on 2018/6/28.
 */

public class LoginActivity extends BaseActivity implements LoginView {
    @Bind(R.id.etLoginPhone)
    EditText etLoginPhone;
    @Bind(R.id.ivLoginPhoneClear)
    ImageView ivLoginPhoneClear;
    @Bind(R.id.etLoginPwd)
    EditText etLoginPwd;
    @Bind(R.id.ivLoginPwdClear)
    ImageView ivLoginPwdClear;
    @Bind(R.id.ivLoginPwdEye)
    ImageView ivLoginPwdEye;
    @Bind(R.id.tvLoginRes)
    TextView tvLoginRes;
    @Bind(R.id.tvLoginForget)
    TextView tvLoginForget;
    @Bind(R.id.butLogin)
    Button butLogin;
    @Bind(R.id.fl_login)
    FrameLayout flLogin;

    private TextWatcher phone_watcher, pwd_watcher;
    private String phone, pwd;

    private LoginPresenter loginPresenter;
    private boolean isClick = true;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBaseContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        setTvTitle("登录");
        setIvBack();
        loginPresenter = new LoginPresenter(this, this);

        initWatcher();
        etLoginPhone.addTextChangedListener(phone_watcher);
        etLoginPwd.addTextChangedListener(pwd_watcher);
        flLogin.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                hideKeyboard();
                return true;
            }
        });

    }

    @OnClick({R.id.ivLoginPhoneClear, R.id.ivLoginPwdClear, R.id.ivLoginPwdEye, R.id.tvLoginRes, R.id.tvLoginForget, R.id.butLogin})
    public void onViewClicked(View view) {
        phone = etLoginPhone.getText().toString().trim();
        pwd = etLoginPwd.getText().toString().trim();
        switch (view.getId()) {
            case R.id.ivLoginPhoneClear:
                //清除用户输入。；
                etLoginPhone.setText("");
                etLoginPwd.setText("");
                break;
            case R.id.ivLoginPwdClear:
                etLoginPwd.setText("");
                break;
            case R.id.ivLoginPwdEye:
                if (!TextUtils.isEmpty(pwd)) {
                    if (etLoginPwd.getInputType() == (InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD)) {
                        ivLoginPwdEye.setImageResource(R.mipmap.ic_eye_open);
                        etLoginPwd.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_NORMAL);
                    } else {
                        ivLoginPwdEye.setImageResource(R.mipmap.ic_eye_close);
                        etLoginPwd.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    }
                    etLoginPwd.setSelection(etLoginPwd.getText().toString().length());
                } else {
                    showMessage("请输入");
                }
                break;
            case R.id.tvLoginRes:
                intent("1");
                break;
            case R.id.tvLoginForget:
                intent("2");
                break;
            case R.id.butLogin:

                if (TextUtils.isEmpty(phone)) {
                    showMessage("请输入账号");
                    return;
                }
                if (TextUtils.isEmpty(pwd)) {
                    showMessage("请输入密码");
                    return;
                }
                if (isClick) {
                    isClick = false;
                    loginPresenter.postLogin(etLoginPhone.getText().toString().trim(), etLoginPwd.getText().toString().trim(), getUserToken());
                }
                break;
        }
    }

    /**
     * 手机号，密码输入控件公用这一个watcher
     */
    private void initWatcher() {
        phone_watcher = new TextWatcher() {
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @SuppressLint("WrongConstant")
            public void afterTextChanged(Editable s) {
                etLoginPwd.setText("");
                if (s.toString().length() > 0) {
                    ivLoginPhoneClear.setVisibility(View.VISIBLE);
                } else {
                    ivLoginPhoneClear.setVisibility(View.INVISIBLE);
                }
            }
        };

        pwd_watcher = new TextWatcher() {
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @SuppressLint("WrongConstant")
            public void afterTextChanged(Editable s) {
                if (s.toString().length() > 0) {
                    ivLoginPwdClear.setVisibility(View.VISIBLE);
                } else {
                    ivLoginPwdClear.setVisibility(View.INVISIBLE);
                }
            }
        };
    }

    Intent intent = new Intent();

    /**
     * 跳转页面（1.注册 2.忘记密码）
     *
     * @param type
     */
    public void intent(String type) {
        intent.setClass(this, ResActivity.class);
        intent.putExtra("type", type);
        startActivity(intent);

    }

    @Override
    public void loginSuccess(String result) {
        BaseApplication.getInstance().saveUserInfo(result);

        isClick = true;
        goToActivity(MainActivity.class);
    }

    @Override
    public void sendverify(String result) {
        isClick = true;
        showMessage(result);
    }

    @Override
    public void sendError(String result) {
        isClick = true;
        showMessage(result);
    }

    @Override
    public void loginError(String error) {
        isClick = true;
        showMessage(error);
    }

    /**
     * 强制关闭软键盘
     */
    private void hideKeyboard() {
        @SuppressLint("WrongConstant") InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm.isActive() && getCurrentFocus() != null) {
            if (getCurrentFocus().getWindowToken() != null) {
                imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
            }
        }
    }

}
