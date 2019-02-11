// Generated code from Butter Knife. Do not modify!
package com.dq.xindai.ui;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class AddFriendsActivity$$ViewBinder<T extends com.dq.xindai.ui.AddFriendsActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131755171, "field 'linAddFriendsMenu1' and method 'onViewClicked'");
    target.linAddFriendsMenu1 = finder.castView(view, 2131755171, "field 'linAddFriendsMenu1'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onViewClicked(p0);
        }
      });
    view = finder.findRequiredView(source, 2131755172, "field 'linAddFriendsMenu2' and method 'onViewClicked'");
    target.linAddFriendsMenu2 = finder.castView(view, 2131755172, "field 'linAddFriendsMenu2'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onViewClicked(p0);
        }
      });
    view = finder.findRequiredView(source, 2131755173, "field 'linAddFriendsMenu3' and method 'onViewClicked'");
    target.linAddFriendsMenu3 = finder.castView(view, 2131755173, "field 'linAddFriendsMenu3'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onViewClicked(p0);
        }
      });
  }

  @Override public void unbind(T target) {
    target.linAddFriendsMenu1 = null;
    target.linAddFriendsMenu2 = null;
    target.linAddFriendsMenu3 = null;
  }
}
