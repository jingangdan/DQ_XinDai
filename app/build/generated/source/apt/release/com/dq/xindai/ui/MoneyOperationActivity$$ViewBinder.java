// Generated code from Butter Knife. Do not modify!
package com.dq.xindai.ui;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class MoneyOperationActivity$$ViewBinder<T extends com.dq.xindai.ui.MoneyOperationActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131755265, "field 'tvMOName'");
    target.tvMOName = finder.castView(view, 2131755265, "field 'tvMOName'");
    view = finder.findRequiredView(source, 2131755266, "field 'etMoMoney'");
    target.etMoMoney = finder.castView(view, 2131755266, "field 'etMoMoney'");
    view = finder.findRequiredView(source, 2131755267, "field 'tvMOCash'");
    target.tvMOCash = finder.castView(view, 2131755267, "field 'tvMOCash'");
    view = finder.findRequiredView(source, 2131755272, "field 'butMO' and method 'onViewClicked'");
    target.butMO = finder.castView(view, 2131755272, "field 'butMO'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onViewClicked(p0);
        }
      });
    view = finder.findRequiredView(source, 2131755269, "field 'butMo1' and method 'onViewClicked'");
    target.butMo1 = finder.castView(view, 2131755269, "field 'butMo1'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onViewClicked(p0);
        }
      });
    view = finder.findRequiredView(source, 2131755270, "field 'butMo2' and method 'onViewClicked'");
    target.butMo2 = finder.castView(view, 2131755270, "field 'butMo2'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onViewClicked(p0);
        }
      });
    view = finder.findRequiredView(source, 2131755271, "field 'tvMoWayMode'");
    target.tvMoWayMode = finder.castView(view, 2131755271, "field 'tvMoWayMode'");
    view = finder.findRequiredView(source, 2131755268, "field 'linMoWayMode'");
    target.linMoWayMode = finder.castView(view, 2131755268, "field 'linMoWayMode'");
  }

  @Override public void unbind(T target) {
    target.tvMOName = null;
    target.etMoMoney = null;
    target.tvMOCash = null;
    target.butMO = null;
    target.butMo1 = null;
    target.butMo2 = null;
    target.tvMoWayMode = null;
    target.linMoWayMode = null;
  }
}
