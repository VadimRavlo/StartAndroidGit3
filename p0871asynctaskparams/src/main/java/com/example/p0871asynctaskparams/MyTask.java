package com.example.p0871asynctaskparams;

import android.os.AsyncTask;
import android.util.Log;

import java.util.concurrent.TimeUnit;

/**
 * Created by administrator on 12.08.2016.
 */

public class MyTask extends AsyncTask<String, Integer, Void> {

    static final String LOG_TAG = "myLogs";

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        Log.d(LOG_TAG, "- Begin background thread -");
    }

    @Override
    protected Void doInBackground(String... strings) {
        try {
            int count = 0;
            for (String url : strings) {
                downloadFile(url);
                publishProgress(++count);
            }
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        Log.d(LOG_TAG, "Downloaded " + values[0] + " files");
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        Log.d(LOG_TAG, "- End background thread -");
    }

    private void downloadFile(String url) throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
    }
}
