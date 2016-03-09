package com.example.p0961servicebackbroadcast;

import android.content.Intent;
import android.util.Log;

import java.util.concurrent.TimeUnit;

/**
 * Created by administrator on 17.08.2016.
 */
public class MyRun implements Runnable {

    MainService service;
    int time;
    int startId;
    int task;

    public MyRun(MainService service, int time, int startId,  int task) {
        this.service = service;
        this.time = time;
        this.startId = startId;
        this.task = task;
        Log.d(Constants.LOG_TAG, "MyRun#" + startId + " create");
    }

    @Override
    public void run() {
        Intent intent = new Intent(Constants.BROADCAST_ACTION);
        Log.d(Constants.LOG_TAG, "MyRun#" + startId + " start, time = " + time);
        try{
            intent.putExtra(Constants.PARAM_TASK, task);
            intent.putExtra(Constants.PARAM_STATUS, Constants.STATUS_START);
            service.sendBroadcast(intent);

            TimeUnit.SECONDS.sleep(time);

            intent.putExtra(Constants.PARAM_STATUS, Constants.STATUS_FINISH);
            intent.putExtra(Constants.PARAM_RESULT, time * 100);
            service.sendBroadcast(intent);

        } catch (InterruptedException e){
            e.printStackTrace();
        }
        stop();
    }

    void stop(){
        Log.d(Constants.LOG_TAG, "MyRun#" + startId + " end, stopSelfResult(" + startId + ") = "
                + service.stopSelfResult(startId));
    }
}
