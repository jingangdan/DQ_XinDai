// Generated code from Butter Knife. Do not modify!
package com.dq.xindai.ui;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class StartPageActivity$$ViewBinder<T extends com.dq.xindai.ui.StartPageActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131755208, "field 'vp'");
    target.vp = finder.castView(view, 2131755208, "field 'vp'");
    view = finder.findRequiredView(source, 2131755209, "field 'ib_start' and method 'onClick'");
    target.ib_start = finder.castView(view, 2131755209, "field 'ib_start'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onClick(p0);
        }
      });
    view = finder.findRequiredView(source, 2131755210, "field 'but_start' and method 'onClick'");
    target.but_start = finder.castView(view, 2131755210, "field 'but_start'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onClick(p0);
        }
      });
    view = finder.findRequiredView(source, 2131755207, "field 'relStart'");
    target.relStart = finder.castView(view, 2131755207, "field 'relStart'");
  }

  @Override public void unbind(T target) {
    target.vp = null;
    target.ib_start = null;
    target.but_start = null;
    target.relStart = null;
  }
}
