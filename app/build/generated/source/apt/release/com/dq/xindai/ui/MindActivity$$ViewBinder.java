// Generated code from Butter Knife. Do not modify!
package com.dq.xindai.ui;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class MindActivity$$ViewBinder<T extends com.dq.xindai.ui.MindActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131755256, "field 'spinner_mind'");
    target.spinner_mind = finder.castView(view, 2131755256, "field 'spinner_mind'");
    view = finder.findRequiredView(source, 2131755257, "field 'etMindPhone'");
    target.etMindPhone = finder.castView(view, 2131755257, "field 'etMindPhone'");
    view = finder.findRequiredView(source, 2131755258, "field 'etMindName'");
    target.etMindName = finder.castView(view, 2131755258, "field 'etMindName'");
    view = finder.findRequiredView(source, 2131755259, "field 'ivMindNameClear' and method 'onViewClicked'");
    target.ivMindNameClear = finder.castView(view, 2131755259, "field 'ivMindNameClear'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onViewClicked(p0);
        }
      });
    view = finder.findRequiredView(source, 2131755260, "field 'etMindCode'");
    target.etMindCode = finder.castView(view, 2131755260, "field 'etMindCode'");
    view = finder.findRequiredView(source, 2131755261, "field 'ivMindCodeClear' and method 'onViewClicked'");
    target.ivMindCodeClear = finder.castView(view, 2131755261, "field 'ivMindCodeClear'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onViewClicked(p0);
        }
      });
    view = finder.findRequiredView(source, 2131755262, "field 'etMindCard'");
    target.etMindCard = finder.castView(view, 2131755262, "field 'etMindCard'");
    view = finder.findRequiredView(source, 2131755263, "field 'ivMindCardClear' and method 'onViewClicked'");
    target.ivMindCardClear = finder.castView(view, 2131755263, "field 'ivMindCardClear'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onViewClicked(p0);
        }
      });
    view = finder.findRequiredView(source, 2131755264, "field 'butMind' and method 'onViewClicked'");
    target.butMind = finder.castView(view, 2131755264, "field 'butMind'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onViewClicked(p0);
        }
      });
    view = finder.findRequiredView(source, 2131755255, "field 'flMind'");
    target.flMind = finder.castView(view, 2131755255, "field 'flMind'");
  }

  @Override public void unbind(T target) {
    target.spinner_mind = null;
    target.etMindPhone = null;
    target.etMindName = null;
    target.ivMindNameClear = null;
    target.etMindCode = null;
    target.ivMindCodeClear = null;
    target.etMindCard = null;
    target.ivMindCardClear = null;
    target.butMind = null;
    target.flMind = null;
  }
}
