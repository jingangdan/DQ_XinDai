// Generated code from Butter Knife. Do not modify!
package com.dq.xindai.ui;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class TransactionActivity$$ViewBinder<T extends com.dq.xindai.ui.TransactionActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131755293, "field 'butData' and method 'onViewClicked'");
    target.butData = finder.castView(view, 2131755293, "field 'butData'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onViewClicked(p0);
        }
      });
    view = finder.findRequiredView(source, 2131755294, "field 'butStatus' and method 'onViewClicked'");
    target.butStatus = finder.castView(view, 2131755294, "field 'butStatus'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onViewClicked(p0);
        }
      });
    view = finder.findRequiredView(source, 2131755445, "field 'lRrcyclerView'");
    target.lRrcyclerView = finder.castView(view, 2131755445, "field 'lRrcyclerView'");
  }

  @Override public void unbind(T target) {
    target.butData = null;
    target.butStatus = null;
    target.lRrcyclerView = null;
  }
}
