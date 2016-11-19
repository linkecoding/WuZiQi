package com.codekong.wuzilianzhu.application;

import android.app.Application;
import android.util.Log;

import com.codekong.wuzilianzhu.config.AppConfig;
import com.xiaomi.mistatistic.sdk.MiStatInterface;
import com.xiaomi.mistatistic.sdk.URLStatsRecorder;
import com.xiaomi.mistatistic.sdk.controller.HttpEventFilter;
import com.xiaomi.mistatistic.sdk.data.HttpEvent;

/**
 * Created by szh on 2016/11/19.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Log.d("mitong", "onCreate: " + MiStatInterface.getDeviceID(this));
        MiStatInterface.initialize(this.getApplicationContext(), AppConfig.APP_ID, AppConfig.APP_KEY, AppConfig.APP_CHANNEL);

        MiStatInterface.setUploadPolicy(
                MiStatInterface.UPLOAD_POLICY_WHILE_INITIALIZE, 0);
        MiStatInterface.enableLog();

        // enable exception catcher.
        MiStatInterface.enableExceptionCatcher(true);

        // enable network monitor
        URLStatsRecorder.enableAutoRecord();
        URLStatsRecorder.setEventFilter(new HttpEventFilter() {

            @Override
            public HttpEvent onEvent(HttpEvent event) {
                return event;
            }
        });

        Log.d("MI_STAT", MiStatInterface.getDeviceID(this) + " is the device.");
    }
}
