// Generated code from Butter Knife. Do not modify!
package com.dq.xindai.ui;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class LoanActivity$$ViewBinder<T extends com.dq.xindai.ui.LoanActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131755225, "field 'tlLoan'");
    target.tlLoan = finder.castView(view, 2131755225, "field 'tlLoan'");
    view = finder.findRequiredView(source, 2131755226, "field 'nvpLoan'");
    target.nvpLoan = finder.castView(view, 2131755226, "field 'nvpLoan'");
  }

  @Override public void unbind(T target) {
    target.tlLoan = null;
    target.nvpLoan = null;
  }
}
