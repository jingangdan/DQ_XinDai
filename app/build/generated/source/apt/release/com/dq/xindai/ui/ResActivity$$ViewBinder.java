// Generated code from Butter Knife. Do not modify!
package com.dq.xindai.ui;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class ResActivity$$ViewBinder<T extends com.dq.xindai.ui.ResActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131755276, "field 'etResPhone'");
    target.etResPhone = finder.castView(view, 2131755276, "field 'etResPhone'");
    view = finder.findRequiredView(source, 2131755277, "field 'ivResPhoneClear' and method 'onViewClicked'");
    target.ivResPhoneClear = finder.castView(view, 2131755277, "field 'ivResPhoneClear'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onViewClicked(p0);
        }
      });
    view = finder.findRequiredView(source, 2131755278, "field 'etResCode'");
    target.etResCode = finder.castView(view, 2131755278, "field 'etResCode'");
    view = finder.findRequiredView(source, 2131755279, "field 'ivResCodeClear' and method 'onViewClicked'");
    target.ivResCodeClear = finder.castView(view, 2131755279, "field 'ivResCodeClear'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onViewClicked(p0);
        }
      });
    view = finder.findRequiredView(source, 2131755280, "field 'tvResVerify' and method 'onViewClicked'");
    target.tvResVerify = finder.castView(view, 2131755280, "field 'tvResVerify'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onViewClicked(p0);
        }
      });
    view = finder.findRequiredView(source, 2131755281, "field 'etResPwd'");
    target.etResPwd = finder.castView(view, 2131755281, "field 'etResPwd'");
    view = finder.findRequiredView(source, 2131755282, "field 'ivResPwdClear' and method 'onViewClicked'");
    target.ivResPwdClear = finder.castView(view, 2131755282, "field 'ivResPwdClear'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onViewClicked(p0);
        }
      });
    view = finder.findRequiredView(source, 2131755283, "field 'ivResPwdEye' and method 'onViewClicked'");
    target.ivResPwdEye = finder.castView(view, 2131755283, "field 'ivResPwdEye'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onViewClicked(p0);
        }
      });
    view = finder.findRequiredView(source, 2131755284, "field 'etResPwd2'");
    target.etResPwd2 = finder.castView(view, 2131755284, "field 'etResPwd2'");
    view = finder.findRequiredView(source, 2131755285, "field 'ivResPwdClear2' and method 'onViewClicked'");
    target.ivResPwdClear2 = finder.castView(view, 2131755285, "field 'ivResPwdClear2'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onViewClicked(p0);
        }
      });
    view = finder.findRequiredView(source, 2131755286, "field 'ivResPwdEye2' and method 'onViewClicked'");
    target.ivResPwdEye2 = finder.castView(view, 2131755286, "field 'ivResPwdEye2'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onViewClicked(p0);
        }
      });
    view = finder.findRequiredView(source, 2131755287, "field 'butRes' and method 'onViewClicked'");
    target.butRes = finder.castView(view, 2131755287, "field 'butRes'");
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
    view = finder.findRequiredView(source, 2131755275, "field 'flRes'");
    target.flRes = finder.castView(view, 2131755275, "field 'flRes'");
  }

  @Override public void unbind(T target) {
    target.etResPhone = null;
    target.ivResPhoneClear = null;
    target.etResCode = null;
    target.ivResCodeClear = null;
    target.tvResVerify = null;
    target.etResPwd = null;
    target.ivResPwdClear = null;
    target.ivResPwdEye = null;
    target.etResPwd2 = null;
    target.ivResPwdClear2 = null;
    target.ivResPwdEye2 = null;
    target.butRes = null;
    target.butMind = null;
    target.flRes = null;
  }
}
