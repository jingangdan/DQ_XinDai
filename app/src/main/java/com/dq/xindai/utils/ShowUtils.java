package com.dq.xindai.utils;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;


/**
 * Created by Cool on 2017/12/20.
 */

public class ShowUtils {
    /**
     * @param context:
     * @param title:标题
     * @param message:提示内容
     * @param listener:事件回调
     */
    public static void showDialog(Context context, String title, String message,String ok, final OnDialogListener listener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setCancelable(false);
        builder.setTitle(title)
                .setMessage(message)
                .setPositiveButton(ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        listener.confirm();
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        listener.cancel();
                    }
                });
        builder.create().show();
    }

    /**
     *
     * @param context:
     * @param title:标题
     * @param message:提示内容
     * @param listener:事件回调
     * @param ok    :确定
     * @param center:中间
     */
    public static void showDialogThree(Context context, String title, String message,String ok,String center, final OnDialogThreeListener listener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setCancelable(false);
        builder.setTitle(title)
                .setMessage(message)
                .setPositiveButton(ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                        listener.confirm();
                    }
                })
                .setNeutralButton(center, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        listener.center();
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                        listener.cancel();
                    }
                });
        builder.create().show();
    }

    /**
     * dialog点击事件回调
     */
    public interface OnDialogListener {
        void confirm();

        void cancel();
    }

    /**
     * 图片选择--相册-相机
     */
    public interface OnDialogImageSelecterListener {
        void selecter();

        void camera();
    }
    /**
     * dialog点击事件回调--三选项dialog
     */
    public interface OnDialogThreeListener {
        void confirm();

        void center();

        void cancel();
    }
}
