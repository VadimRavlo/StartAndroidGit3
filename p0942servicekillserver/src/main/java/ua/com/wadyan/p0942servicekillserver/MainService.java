package ua.com.wadyan.p0942servicekillserver;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by administrator on 15.08.2016.
 */

public class MainService extends Service {

    static final String LOG_TAG = "myLogs";

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(LOG_TAG, "MainService onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(LOG_TAG, "MainService onStartCommand, intent extra name = " + intent.getStringExtra("name"));
        readFlags(flags);
        MyRun myRun = new MyRun(this, startId);
        new Thread(myRun).start();
        return START_NOT_STICKY;
    }

    void readFlags(int flags){
        if((flags) == 0)
            Log.d(LOG_TAG, "flag = 0");
        if((flags) == START_FLAG_REDELIVERY)
            Log.d(LOG_TAG, "START_FLAG_REDELIVERY");
        if((flags) == START_FLAG_RETRY)
            Log.d(LOG_TAG, "START_FLAG_RETRY");
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

    }
}
