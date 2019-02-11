// Generated code from Butter Knife. Do not modify!
package com.dq.xindai.ui;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class SearchActivity$$ViewBinder<T extends com.dq.xindai.ui.SearchActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131755289, "field 'etSearchKeywords'");
    target.etSearchKeywords = finder.castView(view, 2131755289, "field 'etSearchKeywords'");
    view = finder.findRequiredView(source, 2131755290, "field 'ivSearch' and method 'onViewClicked'");
    target.ivSearch = finder.castView(view, 2131755290, "field 'ivSearch'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onViewClicked(p0);
        }
      });
    view = finder.findRequiredView(source, 2131755291, "field 'lvSearch'");
    target.lvSearch = finder.castView(view, 2131755291, "field 'lvSearch'");
    view = finder.findRequiredView(source, 2131755292, "field 'butClearHistory' and method 'onViewClicked'");
    target.butClearHistory = finder.castView(view, 2131755292, "field 'butClearHistory'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onViewClicked(p0);
        }
      });
    view = finder.findRequiredView(source, 2131755288, "field 'linKeywords'");
    target.linKeywords = finder.castView(view, 2131755288, "field 'linKeywords'");
  }

  @Override public void unbind(T target) {
    target.etSearchKeywords = null;
    target.ivSearch = null;
    target.lvSearch = null;
    target.butClearHistory = null;
    target.linKeywords = null;
  }
}
