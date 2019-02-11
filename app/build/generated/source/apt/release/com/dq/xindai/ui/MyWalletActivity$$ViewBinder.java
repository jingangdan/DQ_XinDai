// Generated code from Butter Knife. Do not modify!
package com.dq.xindai.ui;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class MyWalletActivity$$ViewBinder<T extends com.dq.xindai.ui.MyWalletActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131755318, "field 'tvMeWalletBalance'");
    target.tvMeWalletBalance = finder.castView(view, 2131755318, "field 'tvMeWalletBalance'");
    view = finder.findRequiredView(source, 2131755319, "field 'linMeWalletMenu1' and method 'onViewClicked'");
    target.linMeWalletMenu1 = finder.castView(view, 2131755319, "field 'linMeWalletMenu1'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onViewClicked(p0);
        }
      });
    view = finder.findRequiredView(source, 2131755320, "field 'linMeWalletMenu2' and method 'onViewClicked'");
    target.linMeWalletMenu2 = finder.castView(view, 2131755320, "field 'linMeWalletMenu2'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onViewClicked(p0);
        }
      });
    view = finder.findRequiredView(source, 2131755321, "field 'linMeWalletMenu3' and method 'onViewClicked'");
    target.linMeWalletMenu3 = finder.castView(view, 2131755321, "field 'linMeWalletMenu3'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onViewClicked(p0);
        }
      });
    view = finder.findRequiredView(source, 2131755322, "field 'linMeWalletMenu4' and method 'onViewClicked'");
    target.linMeWalletMenu4 = finder.castView(view, 2131755322, "field 'linMeWalletMenu4'");
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
    target.tvMeWalletBalance = null;
    target.linMeWalletMenu1 = null;
    target.linMeWalletMenu2 = null;
    target.linMeWalletMenu3 = null;
    target.linMeWalletMenu4 = null;
  }
}
