package com.example.p0911asynctaskrotate;

import android.os.AsyncTask;
import android.util.Log;

import java.util.concurrent.TimeUnit;

/**
 * Created by administrator on 12.08.2016.
 */

class MyTask extends AsyncTask<String, Integer, Void> {

    MainActivity activity;

    void link(MainActivity activity){
        this.activity = activity;
    }

    void unLink(){
        activity = null;
    }

    @Override
    protected Void doInBackground(String... strings) {
        try {
            for (int i = 1; i <= 10; i++) {
                TimeUnit.SECONDS.sleep(1);
                publishProgress(i);
                Log.d("qwe", "i = " + i + ". MyTask: " + this.hashCode()
                        + ", MainActivity: " + activity.hashCode());
            }
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        activity.textView.setText("i = " + values[0]);
    }
}
