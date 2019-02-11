// Generated code from Butter Knife. Do not modify!
package com.dq.xindai.ui;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class ProductApplicationActivity$$ViewBinder<T extends com.dq.xindai.ui.ProductApplicationActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131755204, "field 'linPAMarriage' and method 'onViewClicked'");
    target.linPAMarriage = finder.castView(view, 2131755204, "field 'linPAMarriage'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onViewClicked(p0);
        }
      });
    view = finder.findRequiredView(source, 2131755205, "field 'linPAContact' and method 'onViewClicked'");
    target.linPAContact = finder.castView(view, 2131755205, "field 'linPAContact'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onViewClicked(p0);
        }
      });
    view = finder.findRequiredView(source, 2131755175, "field 'butLoanDetail' and method 'onViewClicked'");
    target.butLoanDetail = finder.castView(view, 2131755175, "field 'butLoanDetail'");
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
    target.linPAMarriage = null;
    target.linPAContact = null;
    target.butLoanDetail = null;
  }
}
