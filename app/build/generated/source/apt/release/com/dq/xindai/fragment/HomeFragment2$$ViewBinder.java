// Generated code from Butter Knife. Do not modify!
package com.dq.xindai.fragment;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class HomeFragment2$$ViewBinder<T extends com.dq.xindai.fragment.HomeFragment2> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131755227, "field 'tabLayout'");
    target.tabLayout = finder.castView(view, 2131755227, "field 'tabLayout'");
    view = finder.findRequiredView(source, 2131755376, "field 'noScrollViewPage'");
    target.noScrollViewPage = finder.castView(view, 2131755376, "field 'noScrollViewPage'");
  }

  @Override public void unbind(T target) {
    target.tabLayout = null;
    target.noScrollViewPage = null;
  }
}
