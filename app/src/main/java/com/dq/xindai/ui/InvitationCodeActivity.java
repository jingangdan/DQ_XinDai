package com.dq.xindai.ui;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.dq.xindai.R;
import com.dq.xindai.base.BaseActivity;
import com.dq.xindai.utils.QRCodeUtil;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 我的-- 邀请码
 * Created by jingang on 2018/12/25.
 */

public class InvitationCodeActivity extends BaseActivity {
    @Bind(R.id.ivInvitation)
    ImageView ivInvitation;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBaseContentView(R.layout.activity_invitationcode);
        ButterKnife.bind(this);
        setTvTitle("邀请码");
        setIvBack();

        Bitmap mBitmap = QRCodeUtil.createQRCodeBitmap("牛了！", 480, 480);
        ivInvitation.setImageBitmap(mBitmap);

    }

}
