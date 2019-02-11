// Generated code from Butter Knife. Do not modify!
package com.dq.xindai.ui;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class LoanDetailsActivity$$ViewBinder<T extends com.dq.xindai.ui.LoanDetailsActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131755228, "field 'back' and method 'onClick'");
    target.back = finder.castView(view, 2131755228, "field 'back'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onClick(p0);
        }
      });
    view = finder.findRequiredView(source, 2131755229, "field 'lineChart'");
    target.lineChart = finder.castView(view, 2131755229, "field 'lineChart'");
    view = finder.findRequiredView(source, 2131755175, "field 'butLoanDetail' and method 'onClick'");
    target.butLoanDetail = finder.castView(view, 2131755175, "field 'butLoanDetail'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onClick(p0);
        }
      });
  }

  @Override public void unbind(T target) {
    target.back = null;
    target.lineChart = null;
    target.butLoanDetail = null;
  }
}
