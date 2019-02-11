// Generated code from Butter Knife. Do not modify!
package com.dq.xindai.ui;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class MemberActivity$$ViewBinder<T extends com.dq.xindai.ui.MemberActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131755252, "field 'ivMemberHead' and method 'onViewClicked'");
    target.ivMemberHead = finder.castView(view, 2131755252, "field 'ivMemberHead'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onViewClicked();
        }
      });
    view = finder.findRequiredView(source, 2131755253, "field 'etMemberName'");
    target.etMemberName = finder.castView(view, 2131755253, "field 'etMemberName'");
    view = finder.findRequiredView(source, 2131755254, "field 'etMemberMobile'");
    target.etMemberMobile = finder.castView(view, 2131755254, "field 'etMemberMobile'");
  }

  @Override public void unbind(T target) {
    target.ivMemberHead = null;
    target.etMemberName = null;
    target.etMemberMobile = null;
  }
}
