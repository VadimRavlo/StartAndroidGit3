package com.example.p0981servicebindinglocal;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by administrator on 20.08.2016.
 */
public class MainService extends Service {

    MainBinder iBinder = new MainBinder(this);

    Timer timer;
    TimerTask timerTask;
    long interval = 1000;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(Constants.LOG_TAG, "MainService onCreate");
        timer = new Timer();
        schedule();
    }

    void schedule(){
        if(timerTask != null) timerTask.cancel();
        if(interval > 0){
            timerTask = new TimerTask() {
                @Override
                public void run() {
                    Log.d(Constants.LOG_TAG, "run");
                }
            };
            timer.schedule(timerTask, 1000, interval);
        }
    }

    long upInterval(long gap){
        interval += gap;
        schedule();
        return interval;
    }

    long downInterval(long gap){
        interval -= gap;
        if (interval < 0)
            interval = 0;
        schedule();
        return interval;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d(Constants.LOG_TAG, "MainService onBind");
        return iBinder;
    }
}
