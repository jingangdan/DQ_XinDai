// Generated code from Butter Knife. Do not modify!
package com.dq.xindai.ui;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class WebActivity$$ViewBinder<T extends com.dq.xindai.ui.WebActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131755323, "field 'webview'");
    target.webview = finder.castView(view, 2131755323, "field 'webview'");
  }

  @Override public void unbind(T target) {
    target.webview = null;
  }
}
