package ua.com.wadyan.p0931servicestop;

import android.util.Log;

import java.util.concurrent.TimeUnit;

/**
 * Created by administrator on 15.08.2016.
 */

public class MyRun implements Runnable {

    MainService service;
    int time;
    int startId;

    public MyRun(MainService service, int time, int startId) {
        this.service = service;
        this.time = time;
        this.startId = startId;
        Log.d(MainService.LOG_TAG, "MyRun#" + startId + " create");
    }

    @Override
    public void run() {
        Log.d(MainService.LOG_TAG, "MyRun#" + startId + " start, time = " + time);
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            Log.d(MainService.LOG_TAG, "MyRun#" + startId + " someRes = " + service.someRes.getClass());
        } catch (NullPointerException e) {
            Log.d(MainService.LOG_TAG, "MyRun#" + startId + "error, null pointer");
        }
        stop();
    }

    void stop(){
        Log.d(MainService.LOG_TAG, "MyRun#" + startId + " end, stopSelfResult(" + startId + ")="
                + service.stopSelfResult(startId));
    }
}
