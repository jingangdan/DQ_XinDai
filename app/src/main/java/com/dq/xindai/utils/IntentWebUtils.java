package com.dq.xindai.utils;

import android.app.Activity;
import android.content.Intent;

import com.dq.xindai.bean.WebData;
import com.dq.xindai.ui.WebActivity;

/**
 * Created by jingang on 2019/1/15.
 */

public class IntentWebUtils {
    public static String  form;

    /*跳转web*/
    public static void setIntentWeb(String result, Activity activity,int code) {
        WebData data = GsonUtil.gsonIntance().gsonToBean(result, WebData.class);

        form = "<form id=\"myform\" style=\"display:none\" action=\"" + data.getData().getUrl() + "\"method=\"post\">\n" +
                "  <input type=\"text\" name=\"merchantNo\" value=\"" + data.getData().getSign().getMerchantNo() + "\"/>\n" +
                "  <input type=\"text\" name=\"merOrderNo\" value=\"" + data.getData().getSign().getMerOrderNo() + "\"/>\n" +
                "  <input type=\"text\" name=\"jsonEnc\" value=\"" + data.getData().getSign().getJsonEnc() + "\"/>\n" +
                "  <input type=\"text\" name=\"keyEnc\" value=\"" + data.getData().getSign().getKeyEnc() + "\"/>\n" +
                "  <input type=\"text\" name=\"sign\" value=\"" + data.getData().getSign().getSign() + "\"/>\n" +
                "</form>";

        Intent intent = new Intent(activity, WebActivity.class);
        intent.putExtra("url", data.getData().getUrl());
        intent.putExtra("form", form);
        activity.startActivityForResult(intent,code);
    }
}
