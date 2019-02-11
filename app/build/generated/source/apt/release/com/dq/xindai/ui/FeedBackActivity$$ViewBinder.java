// Generated code from Butter Knife. Do not modify!
package com.dq.xindai.ui;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class FeedBackActivity$$ViewBinder<T extends com.dq.xindai.ui.FeedBackActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131755189, "field 'gridView'");
    target.gridView = finder.castView(view, 2131755189, "field 'gridView'");
  }

  @Override public void unbind(T target) {
    target.gridView = null;
  }
}
