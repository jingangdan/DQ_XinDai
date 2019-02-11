package com.dq.xindai.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;

import com.dq.xindai.R;
import com.dq.xindai.base.BaseActivity;
import com.dq.xindai.utils.DataCode;

import butterknife.Bind;
import butterknife.ButterKnife;

public class WebActivity extends BaseActivity {
    @Bind(R.id.wv)
    WebView webview;
    private String url, form;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        ButterKnife.bind(this);

        url = getIntent().getStringExtra("url");
        form = getIntent().getStringExtra("form");

        setWebview();
    }

    private void setWebview() {
        WebSettings webSettings = webview.getSettings();
        webSettings.setBuiltInZoomControls(true);
        webSettings.setSupportZoom(true);
        //与js交互必须设置
        webSettings.setJavaScriptEnabled(true);
        webview.loadData(form +
                "<script>document.getElementById('myform').submit();</script>", "text/html;charset=utf-8", "utf-8");
        webview.addJavascriptInterface(WebActivity.this, "android");
    }

    @JavascriptInterface
    public void jsCallAndroid() {
        Toast.makeText(this, "Js调用Android方法", Toast.LENGTH_SHORT).show();
    }

    @JavascriptInterface
    public void jsCallAndroidArgs(String args) {
        Toast.makeText(this, args, Toast.LENGTH_SHORT).show();
        webview.setVisibility(webview.getVisibility() == View.VISIBLE ? View.VISIBLE : View.GONE);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK){
            Log.e("ssssss","返回");
            setResult(DataCode.WEB);
        }
        return super.onKeyDown(keyCode, event);
    }
}
