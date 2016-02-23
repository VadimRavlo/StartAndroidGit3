package ua.com.wadyan.p0931servicestop;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by administrator on 15.08.2016.
 */

public class MainService extends Service {

    static final String LOG_TAG = "myLogs";
    ExecutorService executorService;
    Object  someRes;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(LOG_TAG, "MainService onCreate");
        executorService = Executors.newFixedThreadPool(3);
        someRes = new Object();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(LOG_TAG, "MainService onStartCommand");
        int time = intent.getIntExtra("time", 1);
        MyRun myRun = new MyRun(this, time, startId);
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
        Log.d(LOG_TAG, "MainService onDestroy");
        someRes = null;
    }
}
