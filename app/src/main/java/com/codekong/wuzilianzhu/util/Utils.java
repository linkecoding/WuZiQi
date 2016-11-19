package com.codekong.wuzilianzhu.util;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

import com.codekong.wuzilianzhu.R;
import com.codekong.wuziqi.view.WuziqiPanel;

/**
 * Created by szh on 2016/11/19.
 * 工具类
 */

public class Utils {
    public static void shouGameOverDialog(Context context, final WuziqiPanel wuziqiPanel, int resId) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(R.string.str_game_over);
        builder.setMessage(resId);
        builder.setPositiveButton(R.string.str_restart_game, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                wuziqiPanel.restart();
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.create().show();
    }
}
