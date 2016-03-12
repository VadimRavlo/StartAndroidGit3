package com.example.p0972servicebindserver;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by administrator on 18.08.2016.
 */
public class MainService extends Service {

    static String LOG_TAG = "myLogs";

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(LOG_TAG, "MainService onCreate");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d(LOG_TAG, "MainService onBind");
        return new Binder();
    }

    @Override
    public void onRebind(Intent intent) {
        super.onRebind(intent);
        Log.d(LOG_TAG, "MainService onRebind");
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d(LOG_TAG, "MainService onUnbind");
        return true;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, "MainService onDestroy");
    }
}
