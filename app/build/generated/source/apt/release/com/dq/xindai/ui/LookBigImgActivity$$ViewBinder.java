// Generated code from Butter Knife. Do not modify!
package com.dq.xindai.ui;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class LookBigImgActivity$$ViewBinder<T extends com.dq.xindai.ui.LookBigImgActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131755240, "field 'viewPager'");
    target.viewPager = finder.castView(view, 2131755240, "field 'viewPager'");
  }

  @Override public void unbind(T target) {
    target.viewPager = null;
  }
}
