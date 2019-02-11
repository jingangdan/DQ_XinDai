// Generated code from Butter Knife. Do not modify!
package com.dq.xindai.ui;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class LoginActivity$$ViewBinder<T extends com.dq.xindai.ui.LoginActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131755232, "field 'etLoginPhone'");
    target.etLoginPhone = finder.castView(view, 2131755232, "field 'etLoginPhone'");
    view = finder.findRequiredView(source, 2131755233, "field 'ivLoginPhoneClear' and method 'onViewClicked'");
    target.ivLoginPhoneClear = finder.castView(view, 2131755233, "field 'ivLoginPhoneClear'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onViewClicked(p0);
        }
      });
    view = finder.findRequiredView(source, 2131755234, "field 'etLoginPwd'");
    target.etLoginPwd = finder.castView(view, 2131755234, "field 'etLoginPwd'");
    view = finder.findRequiredView(source, 2131755235, "field 'ivLoginPwdClear' and method 'onViewClicked'");
    target.ivLoginPwdClear = finder.castView(view, 2131755235, "field 'ivLoginPwdClear'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onViewClicked(p0);
        }
      });
    view = finder.findRequiredView(source, 2131755236, "field 'ivLoginPwdEye' and method 'onViewClicked'");
    target.ivLoginPwdEye = finder.castView(view, 2131755236, "field 'ivLoginPwdEye'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onViewClicked(p0);
        }
      });
    view = finder.findRequiredView(source, 2131755237, "field 'tvLoginRes' and method 'onViewClicked'");
    target.tvLoginRes = finder.castView(view, 2131755237, "field 'tvLoginRes'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onViewClicked(p0);
        }
      });
    view = finder.findRequiredView(source, 2131755238, "field 'tvLoginForget' and method 'onViewClicked'");
    target.tvLoginForget = finder.castView(view, 2131755238, "field 'tvLoginForget'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onViewClicked(p0);
        }
      });
    view = finder.findRequiredView(source, 2131755239, "field 'butLogin' and method 'onViewClicked'");
    target.butLogin = finder.castView(view, 2131755239, "field 'butLogin'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onViewClicked(p0);
        }
      });
    view = finder.findRequiredView(source, 2131755230, "field 'flLogin'");
    target.flLogin = finder.castView(view, 2131755230, "field 'flLogin'");
  }

  @Override public void unbind(T target) {
    target.etLoginPhone = null;
    target.ivLoginPhoneClear = null;
    target.etLoginPwd = null;
    target.ivLoginPwdClear = null;
    target.ivLoginPwdEye = null;
    target.tvLoginRes = null;
    target.tvLoginForget = null;
    target.butLogin = null;
    target.flLogin = null;
  }
}
