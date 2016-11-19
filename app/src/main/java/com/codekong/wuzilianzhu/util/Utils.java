package com.codekong.wuzilianzhu.util;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;

import com.codekong.wuzilianzhu.R;
import com.codekong.wuzilianzhu.config.AppConfig;
import com.codekong.wuziqi.view.WuziqiPanel;

import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;

/**
 * Created by szh on 2016/11/19.
 * 工具类
 */

public class Utils {

    /**
     * 显示游戏结束对话框
     * @param context
     * @param wuziqiPanel
     * @param resId
     */
    public static void showGameOverDialog(Context context, final WuziqiPanel wuziqiPanel, int resId) {
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

    /**
     * 点击分享之后弹出对话框
     * @param context
     */
    public static void showShare(Context context) {
        ShareSDK.initSDK(context);
        OnekeyShare oks = new OnekeyShare();
        //关闭sso授权
        oks.disableSSOWhenAuthorize();

        // title标题，印象笔记、邮箱、信息、微信、人人网和QQ空间等使用
        oks.setTitle(context.getString(R.string.app_name));
        // titleUrl是标题的网络链接，QQ和QQ空间等使用
        oks.setTitleUrl(AppConfig.APP_DOWNLOAD_URL);
        // text是分享文本，所有平台都需要这个字段
        oks.setText(context.getString(R.string.str_share_text));
        // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
        //oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
        // url仅在微信（包括好友和朋友圈）中使用
        oks.setUrl(AppConfig.APP_DOWNLOAD_URL);
        // comment是我对这条分享的评论，仅在人人网和QQ空间使用
        oks.setComment(context.getString(R.string.str_share_text));
        // site是分享此内容的网站名称，仅在QQ空间使用
        oks.setSite(context.getString(R.string.app_name));
        // siteUrl是分享此内容的网站地址，仅在QQ空间使用
        oks.setSiteUrl(AppConfig.APP_DOWNLOAD_URL);

        // 启动分享GUI
        oks.show(context);
    }

    /**
     * 展示游戏规则对话框
     */
    public static void showGameRule(Context context, View v){
        Activity activity = (Activity) context;

        View popupView = activity.getLayoutInflater().inflate(R.layout.popupwindow_game_rule, null);
        PopupWindow mPopupWindow = new PopupWindow(popupView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, true);
        mPopupWindow.setTouchable(true);
        mPopupWindow.setOutsideTouchable(true);
        mPopupWindow.setBackgroundDrawable(new ColorDrawable(context.getResources().getColor(R.color.colorWhite)));
        mPopupWindow.showAsDropDown(v);
    }
}
