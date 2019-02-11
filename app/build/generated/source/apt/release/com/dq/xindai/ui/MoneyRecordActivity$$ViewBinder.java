// Generated code from Butter Knife. Do not modify!
package com.dq.xindai.ui;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class MoneyRecordActivity$$ViewBinder<T extends com.dq.xindai.ui.MoneyRecordActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131755445, "field 'lRrcyclerView'");
    target.lRrcyclerView = finder.castView(view, 2131755445, "field 'lRrcyclerView'");
  }

  @Override public void unbind(T target) {
    target.lRrcyclerView = null;
  }
}
