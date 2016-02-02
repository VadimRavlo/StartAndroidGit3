package com.example.p0881asynctaskresult;

import android.os.AsyncTask;
import android.util.Log;

import java.util.concurrent.TimeUnit;

/**
 * Created by administrator on 12.08.2016.
 */

public class MyTask extends AsyncTask<Void, Void, Integer> {

    static final String LOG_TAG = "myLogs";

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        Log.d(LOG_TAG, "- Begin background thread -");
    }

    @Override
    protected Integer doInBackground(Void... voids) {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 100500;
    }

    @Override
    protected void onPostExecute(Integer integer) {
        super.onPostExecute(integer);
        Log.d(LOG_TAG, "- End background thread. Result = " + integer + " -");
    }
}
