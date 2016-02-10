package com.example.p0901asynctaskstatus;

import android.os.AsyncTask;
import android.util.Log;

import java.util.concurrent.TimeUnit;

/**
 * Created by administrator on 12.08.2016.
 */

public class MyTask extends AsyncTask<Void, Void, Void> {

    static final String LOG_TAG = "myLogs";
    MainActivity activity;

    void link(MainActivity activity){
        this.activity = activity;
    }


    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        Log.d(LOG_TAG, activity.getString(R.string.begin_bkgrd_thread));
        activity.tvInfo.setText(activity.getText(R.string.begin_bkgrd_thread));
    }

    @Override
    protected Void doInBackground(Void... voids) {
        try {
            for (int i = 0; i < 5; i++) {
                if(isCancelled()) return null;
                TimeUnit.SECONDS.sleep(1);
            }
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        Log.d(LOG_TAG, activity.getString(R.string.end_bkgrd_thread));
        activity.tvInfo.setText(activity.getText(R.string.end_bkgrd_thread));
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
        Log.d(LOG_TAG, activity.getString(R.string.cancel_bkgrd_thread));
    }
}
