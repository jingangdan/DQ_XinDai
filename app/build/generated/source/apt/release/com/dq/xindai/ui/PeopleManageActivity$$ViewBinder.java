// Generated code from Butter Knife. Do not modify!
package com.dq.xindai.ui;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class PeopleManageActivity$$ViewBinder<T extends com.dq.xindai.ui.PeopleManageActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131755273, "field 'meCivImg'");
    target.meCivImg = finder.castView(view, 2131755273, "field 'meCivImg'");
    view = finder.findRequiredView(source, 2131755274, "field 'lrvPeopleManage'");
    target.lrvPeopleManage = finder.castView(view, 2131755274, "field 'lrvPeopleManage'");
  }

  @Override public void unbind(T target) {
    target.meCivImg = null;
    target.lrvPeopleManage = null;
  }
}
