// Generated code from Butter Knife. Do not modify!
package com.dq.xindai.ui;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class FlowDetailActivity$$ViewBinder<T extends com.dq.xindai.ui.FlowDetailActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131755295, "field 'tvSdSerial'");
    target.tvSdSerial = finder.castView(view, 2131755295, "field 'tvSdSerial'");
    view = finder.findRequiredView(source, 2131755296, "field 'tvSdDateUpdate'");
    target.tvSdDateUpdate = finder.castView(view, 2131755296, "field 'tvSdDateUpdate'");
    view = finder.findRequiredView(source, 2131755297, "field 'tvSdMemberName'");
    target.tvSdMemberName = finder.castView(view, 2131755297, "field 'tvSdMemberName'");
    view = finder.findRequiredView(source, 2131755298, "field 'tvSdCategoryName'");
    target.tvSdCategoryName = finder.castView(view, 2131755298, "field 'tvSdCategoryName'");
    view = finder.findRequiredView(source, 2131755299, "field 'tvSdIsAency'");
    target.tvSdIsAency = finder.castView(view, 2131755299, "field 'tvSdIsAency'");
    view = finder.findRequiredView(source, 2131755300, "field 'tvSdAencyName'");
    target.tvSdAencyName = finder.castView(view, 2131755300, "field 'tvSdAencyName'");
    view = finder.findRequiredView(source, 2131755301, "field 'tvSdMoney'");
    target.tvSdMoney = finder.castView(view, 2131755301, "field 'tvSdMoney'");
    view = finder.findRequiredView(source, 2131755302, "field 'tvSdTermType'");
    target.tvSdTermType = finder.castView(view, 2131755302, "field 'tvSdTermType'");
    view = finder.findRequiredView(source, 2131755303, "field 'tvSdRepaymentName'");
    target.tvSdRepaymentName = finder.castView(view, 2131755303, "field 'tvSdRepaymentName'");
    view = finder.findRequiredView(source, 2131755304, "field 'tvSdRate'");
    target.tvSdRate = finder.castView(view, 2131755304, "field 'tvSdRate'");
    view = finder.findRequiredView(source, 2131755305, "field 'tvSdServiceName'");
    target.tvSdServiceName = finder.castView(view, 2131755305, "field 'tvSdServiceName'");
    view = finder.findRequiredView(source, 2131755306, "field 'tvSdInsureStart'");
    target.tvSdInsureStart = finder.castView(view, 2131755306, "field 'tvSdInsureStart'");
    view = finder.findRequiredView(source, 2131755307, "field 'tvSdInsureEnd'");
    target.tvSdInsureEnd = finder.castView(view, 2131755307, "field 'tvSdInsureEnd'");
    view = finder.findRequiredView(source, 2131755308, "field 'tvSdInsureComplete'");
    target.tvSdInsureComplete = finder.castView(view, 2131755308, "field 'tvSdInsureComplete'");
    view = finder.findRequiredView(source, 2131755309, "field 'tvSdStatus'");
    target.tvSdStatus = finder.castView(view, 2131755309, "field 'tvSdStatus'");
    view = finder.findRequiredView(source, 2131755310, "field 'tvSdFailType'");
    target.tvSdFailType = finder.castView(view, 2131755310, "field 'tvSdFailType'");
    view = finder.findRequiredView(source, 2131755311, "field 'tvSdDateFail'");
    target.tvSdDateFail = finder.castView(view, 2131755311, "field 'tvSdDateFail'");
    view = finder.findRequiredView(source, 2131755312, "field 'tvSdLoadMoney'");
    target.tvSdLoadMoney = finder.castView(view, 2131755312, "field 'tvSdLoadMoney'");
    view = finder.findRequiredView(source, 2131755313, "field 'tvSdLoadCount'");
    target.tvSdLoadCount = finder.castView(view, 2131755313, "field 'tvSdLoadCount'");
    view = finder.findRequiredView(source, 2131755314, "field 'tvSdRepayMoney'");
    target.tvSdRepayMoney = finder.castView(view, 2131755314, "field 'tvSdRepayMoney'");
    view = finder.findRequiredView(source, 2131755315, "field 'tvSdRepayFree'");
    target.tvSdRepayFree = finder.castView(view, 2131755315, "field 'tvSdRepayFree'");
    view = finder.findRequiredView(source, 2131755316, "field 'tvSdOverdueMoney'");
    target.tvSdOverdueMoney = finder.castView(view, 2131755316, "field 'tvSdOverdueMoney'");
    view = finder.findRequiredView(source, 2131755317, "field 'butSearchCancel' and method 'onViewClicked'");
    target.butSearchCancel = finder.castView(view, 2131755317, "field 'butSearchCancel'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onViewClicked(p0);
        }
      });
    view = finder.findRequiredView(source, 2131755206, "field 'butReturnBill' and method 'onViewClicked'");
    target.butReturnBill = finder.castView(view, 2131755206, "field 'butReturnBill'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onViewClicked(p0);
        }
      });
  }

  @Override public void unbind(T target) {
    target.tvSdSerial = null;
    target.tvSdDateUpdate = null;
    target.tvSdMemberName = null;
    target.tvSdCategoryName = null;
    target.tvSdIsAency = null;
    target.tvSdAencyName = null;
    target.tvSdMoney = null;
    target.tvSdTermType = null;
    target.tvSdRepaymentName = null;
    target.tvSdRate = null;
    target.tvSdServiceName = null;
    target.tvSdInsureStart = null;
    target.tvSdInsureEnd = null;
    target.tvSdInsureComplete = null;
    target.tvSdStatus = null;
    target.tvSdFailType = null;
    target.tvSdDateFail = null;
    target.tvSdLoadMoney = null;
    target.tvSdLoadCount = null;
    target.tvSdRepayMoney = null;
    target.tvSdRepayFree = null;
    target.tvSdOverdueMoney = null;
    target.butSearchCancel = null;
    target.butReturnBill = null;
  }
}
