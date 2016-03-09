package com.example.p0961servicebackbroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.tv_task1) TextView tvTask1;
    @Bind(R.id.tv_task2) TextView tvTask2;
    @Bind(R.id.tv_task3) TextView tvTask3;
    BroadcastReceiver broadcastReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        tvTask1.setText("Task1");
        tvTask2.setText("Task2");
        tvTask3.setText("Task3");

        broadcastReceiver = new MainBroadcastReceiver(this);

        IntentFilter intentFilter = new IntentFilter(Constants.BROADCAST_ACTION);

        registerReceiver(broadcastReceiver, intentFilter);
    }

    public void onClickStart(View v){
        startMyService(7, Constants.TASK1_CODE);
        startMyService(4, Constants.TASK2_CODE);
        startMyService(5, Constants.TASK3_CODE);
    }

    void startMyService(int paramTime, int paramTask){
        Intent intent = new Intent(this, MainService.class).putExtra(Constants.PARAM_TIME, paramTime)
                .putExtra(Constants.PARAM_TASK, paramTask);
        startService(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(broadcastReceiver);
    }
}
