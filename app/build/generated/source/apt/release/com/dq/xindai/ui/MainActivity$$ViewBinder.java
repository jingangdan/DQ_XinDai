// Generated code from Butter Knife. Do not modify!
package com.dq.xindai.ui;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class MainActivity$$ViewBinder<T extends com.dq.xindai.ui.MainActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131755241, "field 'mainFlContent'");
    target.mainFlContent = finder.castView(view, 2131755241, "field 'mainFlContent'");
    view = finder.findRequiredView(source, 2131755244, "field 'mainIv1'");
    target.mainIv1 = finder.castView(view, 2131755244, "field 'mainIv1'");
    view = finder.findRequiredView(source, 2131755245, "field 'mainTv1'");
    target.mainTv1 = finder.castView(view, 2131755245, "field 'mainTv1'");
    view = finder.findRequiredView(source, 2131755243, "field 'mainLl1' and method 'onViewClicked'");
    target.mainLl1 = finder.castView(view, 2131755243, "field 'mainLl1'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onViewClicked(p0);
        }
      });
    view = finder.findRequiredView(source, 2131755247, "field 'mainIv2'");
    target.mainIv2 = finder.castView(view, 2131755247, "field 'mainIv2'");
    view = finder.findRequiredView(source, 2131755248, "field 'mainTv2'");
    target.mainTv2 = finder.castView(view, 2131755248, "field 'mainTv2'");
    view = finder.findRequiredView(source, 2131755246, "field 'mainLl2' and method 'onViewClicked'");
    target.mainLl2 = finder.castView(view, 2131755246, "field 'mainLl2'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onViewClicked(p0);
        }
      });
    view = finder.findRequiredView(source, 2131755250, "field 'mainIv3'");
    target.mainIv3 = finder.castView(view, 2131755250, "field 'mainIv3'");
    view = finder.findRequiredView(source, 2131755249, "field 'mainLl3' and method 'onViewClicked'");
    target.mainLl3 = finder.castView(view, 2131755249, "field 'mainLl3'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onViewClicked(p0);
        }
      });
    view = finder.findRequiredView(source, 2131755242, "field 'mainLlBottom'");
    target.mainLlBottom = finder.castView(view, 2131755242, "field 'mainLlBottom'");
    view = finder.findRequiredView(source, 2131755251, "field 'mainTv3'");
    target.mainTv3 = finder.castView(view, 2131755251, "field 'mainTv3'");
  }

  @Override public void unbind(T target) {
    target.mainFlContent = null;
    target.mainIv1 = null;
    target.mainTv1 = null;
    target.mainLl1 = null;
    target.mainIv2 = null;
    target.mainTv2 = null;
    target.mainLl2 = null;
    target.mainIv3 = null;
    target.mainLl3 = null;
    target.mainLlBottom = null;
    target.mainTv3 = null;
  }
}
