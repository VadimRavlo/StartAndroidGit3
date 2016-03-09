package com.example.p0961servicebackbroadcast;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by administrator on 17.08.2016.
 */
public class MainService extends Service {

    ExecutorService executorService;

    @Override
    public void onCreate() {
        super.onCreate();

        Log.d(Constants.LOG_TAG, "MainService onCreate");

        executorService = Executors.newFixedThreadPool(2);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(Constants.LOG_TAG, "MainService onStartCommand");

        int time = intent.getIntExtra(Constants.PARAM_TIME, 1);
        int task = intent.getIntExtra(Constants.PARAM_TASK, 0);

        MyRun myRun = new MyRun(this, time, startId, task);
        executorService.execute(myRun);

        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {

        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(Constants.LOG_TAG, "MainService onDestroy");

    }
}
