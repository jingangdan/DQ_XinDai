// Generated code from Butter Knife. Do not modify!
package com.dq.xindai.fragment;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class LoanRecordFragment$$ViewBinder<T extends com.dq.xindai.fragment.LoanRecordFragment> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131755445, "field 'lRrcyclerView'");
    target.lRrcyclerView = finder.castView(view, 2131755445, "field 'lRrcyclerView'");
  }

  @Override public void unbind(T target) {
    target.lRrcyclerView = null;
  }
}
