// Generated code from Butter Knife. Do not modify!
package com.dq.xindai.fragment;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class FlowFragment$$ViewBinder<T extends com.dq.xindai.fragment.FlowFragment> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131755391, "field 'tvFmTopTitle'");
    target.tvFmTopTitle = finder.castView(view, 2131755391, "field 'tvFmTopTitle'");
    view = finder.findRequiredView(source, 2131755374, "field 'tlFlow'");
    target.tlFlow = finder.castView(view, 2131755374, "field 'tlFlow'");
    view = finder.findRequiredView(source, 2131755375, "field 'nvpFlow'");
    target.nvpFlow = finder.castView(view, 2131755375, "field 'nvpFlow'");
  }

  @Override public void unbind(T target) {
    target.tvFmTopTitle = null;
    target.tlFlow = null;
    target.nvpFlow = null;
  }
}
