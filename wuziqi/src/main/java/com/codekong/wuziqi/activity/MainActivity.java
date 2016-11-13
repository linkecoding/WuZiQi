package com.codekong.wuziqi.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.codekong.wuziqi.R;
import com.codekong.wuziqi.view.WuziqiPanel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WuziqiPanel panel = (WuziqiPanel) findViewById(R.id.id_wuziqi_panel);
        panel.setOnGameOverListener(new WuziqiPanel.OnGameOverListener() {
            @Override
            public void gameOver(boolean isWhiterWinner) {

            }
        });

    }
}
