package com.example.p0971servicebindclient;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import android.view.View;

/**
 * Created by administrator on 18.08.2016.
 */
public class MainServiceConnection implements ServiceConnection {

    MainActivity activity;

    public MainServiceConnection(MainActivity activity) {
        this.activity = activity;
    }

    @Override
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Log.d(Constants.LOG_TAG, "MainActivity -> MainServiceConnection onServiceConnected");
        activity.bound = true;
    }

    @Override
    public void onServiceDisconnected(ComponentName componentName) {
        Log.d(Constants.LOG_TAG, "MainActivity -> MainServiceConnection onServiceDisconnected");
        activity.bound = false;

    }
}
