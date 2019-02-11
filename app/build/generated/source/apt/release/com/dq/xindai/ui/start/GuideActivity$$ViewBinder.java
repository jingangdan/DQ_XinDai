// Generated code from Butter Knife. Do not modify!
package com.dq.xindai.ui.start;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class GuideActivity$$ViewBinder<T extends com.dq.xindai.ui.start.GuideActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131755208, "field 'mViewPager'");
    target.mViewPager = finder.castView(view, 2131755208, "field 'mViewPager'");
    view = finder.findRequiredView(source, 2131755209, "field 'guideIbStart' and method 'onClick'");
    target.guideIbStart = finder.castView(view, 2131755209, "field 'guideIbStart'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onClick(p0);
        }
      });
    view = finder.findRequiredView(source, 2131755210, "field 'butStart' and method 'onClick'");
    target.butStart = finder.castView(view, 2131755210, "field 'butStart'");
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
    view = finder.findRequiredView(source, 2131755211, "field 'llContainer'");
    target.llContainer = finder.castView(view, 2131755211, "field 'llContainer'");
    view = finder.findRequiredView(source, 2131755212, "field 'ivRedPoint'");
    target.ivRedPoint = finder.castView(view, 2131755212, "field 'ivRedPoint'");
  }

  @Override public void unbind(T target) {
    target.mViewPager = null;
    target.guideIbStart = null;
    target.butStart = null;
    target.relStart = null;
    target.llContainer = null;
    target.ivRedPoint = null;
  }
}
