package com.example.p0981servicebindinglocal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;

/**
 * Created by administrator on 20.08.2016.
 */
public class MainServiceConnection implements ServiceConnection {

    MainActivity activity;

    public MainServiceConnection(MainActivity activity) {
        this.activity = activity;
    }

    @Override
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Log.d(Constants.LOG_TAG, "MainServiceConnection onServiceConnected");
        activity.service = ((MainBinder) iBinder).getService();
        activity.bound = true;
    }

    @Override
    public void onServiceDisconnected(ComponentName componentName) {
        Log.d(Constants.LOG_TAG, "MainServiceConnection onServiceDisconnected");
        activity.bound = false;
    }
}
