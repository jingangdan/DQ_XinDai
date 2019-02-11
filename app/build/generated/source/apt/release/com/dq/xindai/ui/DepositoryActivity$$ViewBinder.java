// Generated code from Butter Knife. Do not modify!
package com.dq.xindai.ui;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class DepositoryActivity$$ViewBinder<T extends com.dq.xindai.ui.DepositoryActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131755176, "field 'tvDepositoryCustody'");
    target.tvDepositoryCustody = finder.castView(view, 2131755176, "field 'tvDepositoryCustody'");
    view = finder.findRequiredView(source, 2131755177, "field 'tvDepositoryAccount'");
    target.tvDepositoryAccount = finder.castView(view, 2131755177, "field 'tvDepositoryAccount'");
    view = finder.findRequiredView(source, 2131755178, "field 'tvDepositoryTrueName'");
    target.tvDepositoryTrueName = finder.castView(view, 2131755178, "field 'tvDepositoryTrueName'");
    view = finder.findRequiredView(source, 2131755179, "field 'tvDepositoryIdcard'");
    target.tvDepositoryIdcard = finder.castView(view, 2131755179, "field 'tvDepositoryIdcard'");
    view = finder.findRequiredView(source, 2131755180, "field 'tvDepositoryDepType'");
    target.tvDepositoryDepType = finder.castView(view, 2131755180, "field 'tvDepositoryDepType'");
    view = finder.findRequiredView(source, 2131755182, "field 'tvDepositoryBankCard'");
    target.tvDepositoryBankCard = finder.castView(view, 2131755182, "field 'tvDepositoryBankCard'");
    view = finder.findRequiredView(source, 2131755181, "field 'linDepositoryBank' and method 'onViewClicked'");
    target.linDepositoryBank = finder.castView(view, 2131755181, "field 'linDepositoryBank'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onViewClicked(p0);
        }
      });
    view = finder.findRequiredView(source, 2131755183, "field 'linDepositoryPwd' and method 'onViewClicked'");
    target.linDepositoryPwd = finder.castView(view, 2131755183, "field 'linDepositoryPwd'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onViewClicked(p0);
        }
      });
    view = finder.findRequiredView(source, 2131755185, "field 'tvDepositoryMobile'");
    target.tvDepositoryMobile = finder.castView(view, 2131755185, "field 'tvDepositoryMobile'");
    view = finder.findRequiredView(source, 2131755184, "field 'linDepositoryMoblie' and method 'onViewClicked'");
    target.linDepositoryMoblie = finder.castView(view, 2131755184, "field 'linDepositoryMoblie'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onViewClicked(p0);
        }
      });
    view = finder.findRequiredView(source, 2131755187, "field 'tvDepositoryQianyue'");
    target.tvDepositoryQianyue = finder.castView(view, 2131755187, "field 'tvDepositoryQianyue'");
    view = finder.findRequiredView(source, 2131755186, "field 'linDepositoryQianyue' and method 'onViewClicked'");
    target.linDepositoryQianyue = finder.castView(view, 2131755186, "field 'linDepositoryQianyue'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onViewClicked(p0);
        }
      });
    view = finder.findRequiredView(source, 2131755188, "field 'butDepositoryCancel' and method 'onViewClicked'");
    target.butDepositoryCancel = finder.castView(view, 2131755188, "field 'butDepositoryCancel'");
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
    target.tvDepositoryCustody = null;
    target.tvDepositoryAccount = null;
    target.tvDepositoryTrueName = null;
    target.tvDepositoryIdcard = null;
    target.tvDepositoryDepType = null;
    target.tvDepositoryBankCard = null;
    target.linDepositoryBank = null;
    target.linDepositoryPwd = null;
    target.tvDepositoryMobile = null;
    target.linDepositoryMoblie = null;
    target.tvDepositoryQianyue = null;
    target.linDepositoryQianyue = null;
    target.butDepositoryCancel = null;
  }
}
