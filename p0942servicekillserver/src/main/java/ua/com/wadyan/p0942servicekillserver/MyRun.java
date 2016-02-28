package ua.com.wadyan.p0942servicekillserver;

import android.util.Log;

import java.util.concurrent.TimeUnit;

/**
 * Created by administrator on 15.08.2016.
 */

public class MyRun implements Runnable {
    int startId;
    MainService service;

    public MyRun(MainService service, int startId) {
        this.startId = startId;
        this.service = service;
        Log.d(MainService.LOG_TAG, "MyRun#" + startId + " create");
    }

    @Override
    public void run() {
        Log.d(MainService.LOG_TAG, "MyRun#" + startId + " start");
        try {
            TimeUnit.SECONDS.sleep(15);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        stop();
    }

    void stop(){
        Log.d(MainService.LOG_TAG, "MyRun#" + startId + " end, stopSelfResult(" + startId + ") = "
                + service.stopSelfResult(startId));
    }
}
