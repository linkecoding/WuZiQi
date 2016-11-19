package com.codekong.wuzilianzhu.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.codekong.wuzilianzhu.R;
import com.codekong.wuzilianzhu.config.AppConfig;
import com.codekong.wuzilianzhu.util.Utils;
import com.xiaomi.mistatistic.sdk.MiStatInterface;

import cn.sharesdk.framework.ShareSDK;

public class WelcomeActivity extends BaseActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        initUI();

        ShareSDK.initSDK(this, AppConfig.SHARE_APP_KEY);
    }

    /**
     * 初始化控件
     */
    private void initUI() {
        //开始游戏按钮
        Button startGameBtn = (Button) findViewById(R.id.id_start_game);
        startGameBtn.setOnClickListener(this);

        //游戏规则按钮
        Button gameRuleBtn = (Button) findViewById(R.id.id_game_rule);
        gameRuleBtn.setOnClickListener(this);
        //分享游戏按钮
        Button shareGameBtn = (Button) findViewById(R.id.id_share_game);
        shareGameBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.id_start_game:
                startGame();
                break;
            case R.id.id_game_rule:
                Utils.showGameRule(this, v);
                break;
            case R.id.id_share_game:
                Utils.showShare(this);
            default:
                break;
        }
    }

    /**
     * 开始游戏
     */
    private void startGame() {
        Intent startGameIntent = new Intent(this, WuZiQiActivity.class);
        startActivity(startGameIntent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        MiStatInterface.recordPageStart(WelcomeActivity.this, "welcome page");
    }

    @Override
    protected void onPause() {
        super.onPause();
        MiStatInterface.recordPageEnd();
    }
}
