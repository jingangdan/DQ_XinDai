package com.dq.xindai.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.CountDownTimer;
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
import com.dq.xindai.ui.p.LoginPresenter;
import com.dq.xindai.ui.view.LoginView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 注册
 * Created by jingang on 2018/12/18.
 */

public class ResActivity extends BaseActivity implements LoginView {
    @Bind(R.id.etResPhone)
    EditText etResPhone;
    @Bind(R.id.ivResPhoneClear)
    ImageView ivResPhoneClear;
    @Bind(R.id.etResCode)
    EditText etResCode;
    @Bind(R.id.ivResCodeClear)
    ImageView ivResCodeClear;
    @Bind(R.id.tvResVerify)
    TextView tvResVerify;
    @Bind(R.id.etResPwd)
    EditText etResPwd;
    @Bind(R.id.ivResPwdClear)
    ImageView ivResPwdClear;
    @Bind(R.id.ivResPwdEye)
    ImageView ivResPwdEye;
    @Bind(R.id.etResPwd2)
    EditText etResPwd2;
    @Bind(R.id.ivResPwdClear2)
    ImageView ivResPwdClear2;
    @Bind(R.id.ivResPwdEye2)
    ImageView ivResPwdEye2;
    @Bind(R.id.butRes)
    Button butRes;
    @Bind(R.id.butMind)
    Button butMind;
    @Bind(R.id.fl_res)
    FrameLayout flRes;

    private String mobile, code, pwd, pwd2;
    private String type;//1 注册 2 忘记密码
    private TextWatcher phone_watcher, code_watcher, pwd_watcher, pwd2_watcher;

    private boolean isClick = true;
    private LoginPresenter loginPresenter;

    //倒计时
    CountdownThread countdownThread;
    boolean isRun = false;//倒计时线程是否运行

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBaseContentView(R.layout.activity_res);
        ButterKnife.bind(this);

        type = getIntent().getStringExtra("type");
        if (type.equals("1")) {
            setTvTitle("注册");
            butRes.setText("注册");
            butMind.setVisibility(View.VISIBLE);
        } else if (type.equals("2")) {
            setTvTitle("忘记密码");
            butRes.setText("确定");
            butMind.setVisibility(View.GONE);
        }
        setIvBack();

        loginPresenter = new LoginPresenter(this, this);

        initWatcher();
        etResPhone.addTextChangedListener(phone_watcher);
        etResCode.addTextChangedListener(code_watcher);
        etResPwd.addTextChangedListener(pwd_watcher);
        etResPwd2.addTextChangedListener(pwd2_watcher);
        flRes.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                hideKeyboard();
                return true;
            }
        });
    }

    @OnClick({R.id.ivResPhoneClear, R.id.ivResCodeClear, R.id.tvResVerify, R.id.ivResPwdClear, R.id.ivResPwdEye, R.id.ivResPwdClear2, R.id.ivResPwdEye2, R.id.butRes, R.id.butMind})
    public void onViewClicked(View view) {
        mobile = etResPhone.getText().toString().trim();
        code = etResCode.getText().toString().trim();
        pwd = etResPwd.getText().toString().trim();
        pwd2 = etResPwd2.getText().toString().trim();
        switch (view.getId()) {
            case R.id.ivResPhoneClear:
                etResPhone.setText("");
                etResCode.setText("");
                etResPwd.setText("");
                etResPwd2.setText("");
                break;
            case R.id.ivResCodeClear:
                etResCode.setText("");
                break;
            case R.id.tvResVerify:
                if (isMobile(mobile)) {
                    if (isRun) {
                        return;
                    } else {
                        countdownThread = new CountdownThread(60000, 1000);// 构造CountDownTimer对象
                        countdownThread.start();
                        isRun = true;
                        if (type.equals("1")) {
                            //注册
                            loginPresenter.getSendMobile(mobile, "register", getUserToken());
                        } else if (type.equals("2")) {
                            //找回密码
                            loginPresenter.getSendMobile(mobile, "repwd", getUserToken());
                        }
                    }
                } else {
                    showMessage("请输入正确的手机号！");
                }
                break;
            case R.id.ivResPwdClear:
                etResPwd.setText("");
                etResPwd2.setText("");
                break;
            case R.id.ivResPwdEye:
                if (!TextUtils.isEmpty(pwd)) {
                    if (etResPwd.getInputType() == (InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD)) {
                        ivResPwdEye.setImageResource(R.mipmap.ic_eye_open);
                        etResPwd.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_NORMAL);
                    } else {
                        ivResPwdEye.setImageResource(R.mipmap.ic_eye_close);
                        etResPwd.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    }
                    etResPwd.setSelection(etResPwd.getText().toString().length());
                } else {
                    showMessage("请输入");
                }
                break;
            case R.id.ivResPwdClear2:
                etResPwd2.setText("");
                break;
            case R.id.ivResPwdEye2:
                if (!TextUtils.isEmpty(pwd2)) {
                    if (etResPwd2.getInputType() == (InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD)) {
                        ivResPwdEye2.setImageResource(R.mipmap.ic_eye_open);
                        etResPwd2.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_NORMAL);
                    } else {
                        ivResPwdEye2.setImageResource(R.mipmap.ic_eye_close);
                        etResPwd2.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    }
                    etResPwd2.setSelection(etResPwd2.getText().toString().length());
                } else {
                    showMessage("请输入");
                }
                break;
            case R.id.butRes:
                if (TextUtils.isEmpty(mobile)) {
                    showMessage("请输入手机号");
                    return;
                }
                if (TextUtils.isEmpty(code)) {
                    showMessage("请输入验证码");
                    return;
                }
                if (TextUtils.isEmpty(pwd)) {
                    showMessage("请输入密码");
                    return;
                }
                if (TextUtils.isEmpty(pwd2)) {
                    showMessage("请确认密码");
                    return;
                }
                if (!pwd.equals(pwd2)) {
                    showMessage("两次输入密码不一致");
                    return;
                }
                if (isClick) {
                    if (type.equals("1")) {
                        //注册
                        isClick = false;
                        loginPresenter.postRes(4, mobile, pwd, code, getUserToken());
                    } else if (type.equals("2")) {
                        //找回密码
                        isClick = false;
                        loginPresenter.postRePwd(mobile, code, pwd, getUserToken());
                    }
                }
                break;
            case R.id.butMind:
                goToActivity(MindActivity.class);
                break;
            default:
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
                etResPwd.setText("");
                etResCode.setText("");
                etResPwd2.setText("");
                if (s.toString().length() > 0) {
                    ivResPhoneClear.setVisibility(View.VISIBLE);
                } else {
                    ivResPhoneClear.setVisibility(View.INVISIBLE);
                }
            }
        };

        code_watcher = new TextWatcher() {
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @SuppressLint("WrongConstant")
            public void afterTextChanged(Editable s) {
                etResPwd.setText("");
                etResPwd2.setText("");
                if (s.toString().length() > 0) {
                    ivResCodeClear.setVisibility(View.VISIBLE);
                } else {
                    ivResCodeClear.setVisibility(View.INVISIBLE);
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
                etResPwd2.setText("");
                if (s.toString().length() > 0) {
                    ivResPwdClear.setVisibility(View.VISIBLE);
                } else {
                    ivResPwdClear.setVisibility(View.INVISIBLE);
                }
            }
        };
        pwd2_watcher = new TextWatcher() {
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @SuppressLint("WrongConstant")
            public void afterTextChanged(Editable s) {
                if (s.toString().length() > 0) {
                    ivResPwdClear2.setVisibility(View.VISIBLE);
                } else {
                    ivResPwdClear2.setVisibility(View.INVISIBLE);
                }
            }
        };
    }

    @Override
    public void loginSuccess(String result) {
        isClick = true;
        showMessage(result);
        this.finish();
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

    /*强制关闭软键盘*/
    private void hideKeyboard() {
        @SuppressLint("WrongConstant") InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm.isActive() && getCurrentFocus() != null) {
            if (getCurrentFocus().getWindowToken() != null) {
                imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
            }
        }
    }

    class CountdownThread extends CountDownTimer {
        public CountdownThread(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
            // TODO Auto-generated constructor stub
        }

        @Override
        public void onTick(long millisUntilFinished) {
//            hms = formatter.format(millisUntilFinished);//转化成  "00:00:00"的格式
            tvResVerify.setText((millisUntilFinished / 1000) + "");
            //tvResVerify.setBackgroundResource(R.drawable.btn_gray);
        }

        @Override
        public void onFinish() {
            // TODO Auto-generated method stub
            //倒计时结束时触发
            tvResVerify.setText("获取验证码");
            //tvResVerify.setBackgroundResource(R.drawable.btn_blue);
            isRun = false;
        }
    }

    /**
     * 手机号验证
     *
     * @param str
     * @return 验证通过返回true
     */
    public static boolean isMobile(String str) {
        Pattern p = null;
        Matcher m = null;
        boolean b = false;
        p = Pattern.compile("^[1][3,4,5,7,8][0-9]{9}$"); // 验证手机号
        m = p.matcher(str);
        b = m.matches();
        return b;
    }
}
