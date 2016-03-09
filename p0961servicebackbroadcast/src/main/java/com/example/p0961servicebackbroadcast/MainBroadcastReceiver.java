package com.example.p0961servicebackbroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by administrator on 17.08.2016.
 */
public class MainBroadcastReceiver extends BroadcastReceiver {

    MainActivity activity;

    public MainBroadcastReceiver(MainActivity activity) {
        this.activity = activity;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        int task = intent.getIntExtra(Constants.PARAM_TASK, 0);
        int status = intent.getIntExtra(Constants.PARAM_STATUS, 0);

        Log.d(Constants.LOG_TAG, "onReceive: task = " + task + " , status = " + status);

        if(status == Constants.STATUS_START){
            switch (task){
                case Constants.TASK1_CODE:
                    activity.tvTask1.setText("Task1 start");
                    break;
                case Constants.TASK2_CODE:
                    activity.tvTask2.setText("Task2 start");
                    break;
                case Constants.TASK3_CODE:
                    activity.tvTask3.setText("Task3 start");
                    break;
            }
        }

        if(status == Constants.STATUS_FINISH){
            int result = intent.getIntExtra(Constants.PARAM_RESULT, 0);
            switch (task){
                case Constants.TASK1_CODE:
                    activity.tvTask1.setText("Task1 finish, result = " + result);
                    break;
                case Constants.TASK2_CODE:
                    activity.tvTask2.setText("Task2 finish, result = " + result);
                    break;
                case Constants.TASK3_CODE:
                    activity.tvTask3.setText("Task3 finish, result = " + result);
                    break;
            }
        }
    }
}
