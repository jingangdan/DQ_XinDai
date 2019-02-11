// Generated code from Butter Knife. Do not modify!
package com.dq.xindai.fragment;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class MeFragment$$ViewBinder<T extends com.dq.xindai.fragment.MeFragment> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131755379, "field 'tvMeName'");
    target.tvMeName = finder.castView(view, 2131755379, "field 'tvMeName'");
    view = finder.findRequiredView(source, 2131755380, "field 'tvMeMoblie'");
    target.tvMeMoblie = finder.castView(view, 2131755380, "field 'tvMeMoblie'");
    view = finder.findRequiredView(source, 2131755273, "field 'meCivImg' and method 'onClick'");
    target.meCivImg = finder.castView(view, 2131755273, "field 'meCivImg'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onClick(p0);
        }
      });
    view = finder.findRequiredView(source, 2131755378, "field 'linMeTop'");
    target.linMeTop = finder.castView(view, 2131755378, "field 'linMeTop'");
    view = finder.findRequiredView(source, 2131755381, "field 'linMeMenu1' and method 'onClick'");
    target.linMeMenu1 = finder.castView(view, 2131755381, "field 'linMeMenu1'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onClick(p0);
        }
      });
    view = finder.findRequiredView(source, 2131755382, "field 'linMeMenu2' and method 'onClick'");
    target.linMeMenu2 = finder.castView(view, 2131755382, "field 'linMeMenu2'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onClick(p0);
        }
      });
    view = finder.findRequiredView(source, 2131755383, "field 'linMeMenu3' and method 'onClick'");
    target.linMeMenu3 = finder.castView(view, 2131755383, "field 'linMeMenu3'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onClick(p0);
        }
      });
    view = finder.findRequiredView(source, 2131755384, "field 'linMeMenu4' and method 'onClick'");
    target.linMeMenu4 = finder.castView(view, 2131755384, "field 'linMeMenu4'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onClick(p0);
        }
      });
    view = finder.findRequiredView(source, 2131755385, "field 'linMeMenu5' and method 'onClick'");
    target.linMeMenu5 = finder.castView(view, 2131755385, "field 'linMeMenu5'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onClick(p0);
        }
      });
    view = finder.findRequiredView(source, 2131755386, "field 'linMeMenu6' and method 'onClick'");
    target.linMeMenu6 = finder.castView(view, 2131755386, "field 'linMeMenu6'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onClick(p0);
        }
      });
    view = finder.findRequiredView(source, 2131755387, "field 'linMeMenu7' and method 'onClick'");
    target.linMeMenu7 = finder.castView(view, 2131755387, "field 'linMeMenu7'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onClick(p0);
        }
      });
    view = finder.findRequiredView(source, 2131755377, "field 'butMe' and method 'onClick'");
    target.butMe = finder.castView(view, 2131755377, "field 'butMe'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onClick(p0);
        }
      });
  }

  @Override public void unbind(T target) {
    target.tvMeName = null;
    target.tvMeMoblie = null;
    target.meCivImg = null;
    target.linMeTop = null;
    target.linMeMenu1 = null;
    target.linMeMenu2 = null;
    target.linMeMenu3 = null;
    target.linMeMenu4 = null;
    target.linMeMenu5 = null;
    target.linMeMenu6 = null;
    target.linMeMenu7 = null;
    target.butMe = null;
  }
}
