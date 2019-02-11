// Generated code from Butter Knife. Do not modify!
package com.dq.xindai.ui;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class InvitationCodeActivity$$ViewBinder<T extends com.dq.xindai.ui.InvitationCodeActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131755213, "field 'ivInvitation'");
    target.ivInvitation = finder.castView(view, 2131755213, "field 'ivInvitation'");
  }

  @Override public void unbind(T target) {
    target.ivInvitation = null;
  }
}
