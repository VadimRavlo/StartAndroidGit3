package com.example.p0951servicebackpendingintent;

import android.app.PendingIntent;
import android.content.Intent;
import android.util.Log;

import java.util.concurrent.TimeUnit;

/**
 * Created by administrator on 16.08.2016.
 */
public class MyRun implements Runnable {
    MainService mainService;
    int time;
    int startId;
    PendingIntent pendingIntent;

    public MyRun(MainService mainService, int time, int startId, PendingIntent pendingIntent) {
        this.mainService = mainService;
        this.time = time;
        this.startId = startId;
        this.pendingIntent = pendingIntent;
        Log.d(MainActivity.LOG_TAG, "MyRun#" + startId + " create");
    }

    @Override
    public void run() {
        Log.d(MainActivity.LOG_TAG, "MyRun#" + startId + " start, time = " + time);
        try {
            pendingIntent.send(MainActivity.STATUS_START);
            TimeUnit.SECONDS.sleep(time);
            Intent intent = new Intent().putExtra(MainActivity.PARAM_RESULT, time*100);
            pendingIntent.send(mainService, MainActivity.STATUS_FINISH, intent);
        } catch (PendingIntent.CanceledException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        stop();
    }

    void stop(){
        Log.d(MainActivity.LOG_TAG, "MyRun#" + startId + " end, stopSelfResult(" + startId + ") = "
                + mainService.stopSelfResult(startId));
    }
}
