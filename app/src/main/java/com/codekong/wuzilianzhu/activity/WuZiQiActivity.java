package com.codekong.wuzilianzhu.activity;

import android.os.Bundle;
import android.widget.TextView;

import com.codekong.wuzilianzhu.R;
import com.codekong.wuzilianzhu.util.Utils;
import com.codekong.wuziqi.view.WuziqiPanel;
import com.xiaomi.mistatistic.sdk.MiStatInterface;

public class WuZiQiActivity extends BaseActivity implements WuziqiPanel.OnGameOverListener {

    private WuziqiPanel wuziqiPanel;
    private TextView firstPieceTv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wuziqi);

        initUI();
        initData();
    }

    /**
     * 初始化数据
     */
    private void initData() {
        //根据随机数设置谁是先下子的一方
        boolean isWhiteFirst = Math.random() > 0.5;
        wuziqiPanel.setFirstPiece(isWhiteFirst);

        if (isWhiteFirst){
            firstPieceTv.setText(getResources().getText(R.string.str_white_piece));
        }else{
            firstPieceTv.setText(getResources().getText(R.string.str_black_piece));
        }
    }

    /**
     * 初始化控件
     */
    private void initUI() {
        wuziqiPanel = (WuziqiPanel) findViewById(R.id.id_wuziqi_panel);
        wuziqiPanel.setOnGameOverListener(this);

        firstPieceTv = (TextView) findViewById(R.id.id_first_piece);
    }

    @Override
    public void gameOver(boolean isWhiterWinner) {
        if (isWhiterWinner){
            Utils.shouGameOverDialog(this, wuziqiPanel, R.string.str_white_piece_victory);
        }else {
            Utils.shouGameOverDialog(this, wuziqiPanel, R.string.str_black_piece_victory);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        MiStatInterface.recordPageStart(WuZiQiActivity.this, "wuziqi page");
    }

    @Override
    protected void onPause() {
        super.onPause();
        MiStatInterface.recordPageEnd();
    }
}
