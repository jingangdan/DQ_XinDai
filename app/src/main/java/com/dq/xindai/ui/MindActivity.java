package com.dq.xindai.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Spinner;

import com.dq.xindai.R;
import com.dq.xindai.base.BaseActivity;
import com.dq.xindai.bean.WebData;
import com.dq.xindai.bean.ResultBase;
import com.dq.xindai.openssl.Base64Utils;
import com.dq.xindai.openssl.RSAUtils;
import com.dq.xindai.utils.DataCode;
import com.dq.xindai.utils.GsonUtil;
import com.dq.xindai.utils.HttpPath;
import com.dq.xindai.utils.HttpxUtils;
import com.dq.xindai.utils.IntentWebUtils;

import org.xutils.common.Callback;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.PrivateKey;
import java.util.Arrays;
import java.util.HashMap;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 开通存管
 * Created by jingang on 2018/12/19.
 */

public class MindActivity extends BaseActivity {
    @Bind(R.id.spinner_mind)
    Spinner spinner_mind;
    @Bind(R.id.etMindPhone)
    EditText etMindPhone;
    @Bind(R.id.etMindName)
    EditText etMindName;
    @Bind(R.id.ivMindNameClear)
    ImageView ivMindNameClear;
    @Bind(R.id.etMindCode)
    EditText etMindCode;
    @Bind(R.id.ivMindCodeClear)
    ImageView ivMindCodeClear;
    @Bind(R.id.etMindCard)
    EditText etMindCard;
    @Bind(R.id.ivMindCardClear)
    ImageView ivMindCardClear;
    @Bind(R.id.butMind)
    Button butMind;
    @Bind(R.id.fl_mind)
    FrameLayout flMind;

    private TextWatcher phone_watcher, name_watcher, code_watcher, card_watcher;
    private String phone, name, code, card;
    private boolean isClick = true;
    private String form;
    private int style_id;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBaseContentView(R.layout.activity_mind);
        ButterKnife.bind(this);
        setTvTitle("开通存管");
        setIvBack();

        setSpinner();

        initWatcher();
        etMindPhone.addTextChangedListener(phone_watcher);
        etMindName.addTextChangedListener(name_watcher);
        etMindCode.addTextChangedListener(code_watcher);
        etMindCard.addTextChangedListener(card_watcher);
        flMind.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                hideKeyboard();
                return true;
            }
        });

    }

    @OnClick({R.id.ivMindNameClear, R.id.ivMindCodeClear, R.id.ivMindCardClear, R.id.butMind})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ivMindNameClear:
                etMindName.setText("");
                etMindCode.setText("");
                etMindCard.setText("");
                break;
            case R.id.ivMindCodeClear:
                etMindCode.setText("");
                etMindCard.setText("");
                break;
            case R.id.ivMindCardClear:
                etMindCard.setText("");
                break;
            case R.id.butMind:
                phone = etMindPhone.getText().toString().trim();
                name = etMindName.getText().toString().trim();
                code = etMindCode.getText().toString().trim();
                card = etMindCard.getText().toString().trim();
                if (style_id == 0) {
                    showMessage("请选择身份类型");
                    return;
                }
                if (TextUtils.isEmpty(name)) {
                    showMessage("请输入姓名");
                    return;
                }
                if (TextUtils.isEmpty(code)) {
                    showMessage("请输入证件号");
                    return;
                }
                if (TextUtils.isEmpty(card)) {
                    showMessage("请输入银行卡号");
                    return;
                }
                if (isClick) {
                    isClick = false;
                    //6017002290027204980
                    getAuth(style_id, name, code, card, getUserToken());
                    // getAuth(style_id, name, "371324199202133518", "6017002290027204980", getUserToken());
                }
                break;
        }
    }

    public void setSpinner() {
        String[] ctype = new String[]{"请选择身份类型", "个人", "商户", "企业", "公务员"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ctype);  //创建一个数组适配器
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);     //设置下拉列表框的下拉选项样式

        spinner_mind.setAdapter(adapter);

        spinner_mind.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                style_id = i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    /**
     * 开通存管（网页跳转）前加密
     *
     * @param style_id
     * @param true_name
     * @param idcard
     * @param bank_card
     * @param token
     */
    public void getAuth(int style_id, String true_name, String idcard, String bank_card, String token) {

        String PATH_RSA = null;
        try {
            //汉字转码
            PATH_RSA = "style_id=" + style_id + "&true_name=" + URLEncoder.encode(true_name, "utf-8") + "&idcard=" + idcard + "&bank_card=" + bank_card + "&token=" + token;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        Log.e("ssssss", "开通存管参数=" + PATH_RSA);

        String str = PATH_RSA.substring(0, 117);
        String str1 = PATH_RSA.substring(117, PATH_RSA.length());
        Log.e("ssssss", "str=" + str);
        Log.e("ssssss", "str1=" + str1);
        try {
            PrivateKey privateKey = RSAUtils.loadPrivateKey(RSAUtils.PRIVATE_KEY);
            byte[] encryptByte = RSAUtils.encryptDataPrivate(str.getBytes(), privateKey);
            byte[] encryptByte2 = RSAUtils.encryptDataPrivate(str1.getBytes(), privateKey);

            byte[] bytes = Arrays.copyOf(encryptByte, encryptByte.length + encryptByte2.length);
            System.arraycopy(encryptByte2, 0, bytes, encryptByte.length, encryptByte2.length);

            xUtilsAuthBindCustody(Base64Utils.encode(bytes).toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 开通存管
     *
     * @param sign
     */
    public void xUtilsAuthBindCustody(String sign) {
        Log.e("ssssss", "开通存管接口 = " + HttpPath.AUTH_AUTH + "sign=" + sign);
        HashMap<String, Object> map = new HashMap<>();
        map.put("sign", sign);
        HttpxUtils.Post(this,
                HttpPath.AUTH_AUTH,
                map, new Callback.CommonCallback<String>() {
                    @Override
                    public void onSuccess(String result) {
                        isClick = true;
                        Log.e("ssssss", result);
                        ResultBase resultBase = GsonUtil.gsonIntance().gsonToBean(result, ResultBase.class);
                        if (resultBase.getStatus() == 1) {
                            IntentWebUtils.setIntentWeb(result, MindActivity.this, DataCode.MIND);
                        } else {
                            showMessage(resultBase.getInfo());
                        }
                    }

                    @Override
                    public void onError(Throwable ex, boolean isOnCallback) {
                        isClick = true;
                        Log.e("ssssss", "失败，请检查网络！" + ex);
                        showMessage("失败，请检查网络");
                    }

                    @Override
                    public void onCancelled(CancelledException cex) {
                        isClick = true;
                    }

                    @Override
                    public void onFinished() {
                        isClick = true;
                    }
                });
    }

    /**
     * 手机号，密码输入控件公用这一个watcher
     */
    private void initWatcher() {
        name_watcher = new TextWatcher() {
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @SuppressLint("WrongConstant")
            public void afterTextChanged(Editable s) {
                etMindCode.setText("");
                etMindCard.setText("");
                if (s.toString().length() > 0) {
                    ivMindNameClear.setVisibility(View.VISIBLE);
                } else {
                    ivMindNameClear.setVisibility(View.INVISIBLE);
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
                etMindCard.setText("");
                if (s.toString().length() > 0) {
                    ivMindCodeClear.setVisibility(View.VISIBLE);
                } else {
                    ivMindCodeClear.setVisibility(View.INVISIBLE);
                }
            }
        };
        card_watcher = new TextWatcher() {
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @SuppressLint("WrongConstant")
            public void afterTextChanged(Editable s) {
                if (s.toString().length() > 0) {
                    ivMindCardClear.setVisibility(View.VISIBLE);
                } else {
                    ivMindCardClear.setVisibility(View.INVISIBLE);
                }
            }
        };
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
}
