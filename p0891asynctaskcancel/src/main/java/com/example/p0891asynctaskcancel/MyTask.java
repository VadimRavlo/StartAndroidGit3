package com.example.p0891asynctaskcancel;

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
        Log.d(LOG_TAG, "- Begin background thread -");
        activity.tvInfo.setText("- Begin background thread -");
    }

    @Override
    protected Void doInBackground(Void... voids) {
        try {
            for (int i = 0; i < 5; i++) {
                TimeUnit.SECONDS.sleep(1);
//                if(isCancelled()) return null;
                Log.d(LOG_TAG, "isCanceled: " + isCancelled());
            }
        } catch (InterruptedException e){
            Log.d(LOG_TAG, "Interrupted");
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        Log.d(LOG_TAG, "- End background thread -");
        activity.tvInfo.setText("- End background thread -");
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
        Log.d(LOG_TAG, "- Cancel background thread -");
        activity.tvInfo.setText("- Cancel background thread -");
    }
}
