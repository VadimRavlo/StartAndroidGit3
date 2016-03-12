package com.example.p0971servicebindclient;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    boolean bound = false;
    MainServiceConnection serviceConnection;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intent = new Intent("ua.com.wadyan.p0972servicebindserver.MainService");

        serviceConnection = new MainServiceConnection(this);
    }

    public void onClickStart(View v){
        startService(intent);
    }

    public void onClickStop(View v){
        stopService(intent);
    }

    public void onClickBind(View v){
        bindService(intent, serviceConnection, 0);
    }

    public void onClickUnbind(View v){
        if (!bound) return;
        unbindService(serviceConnection);
        bound = false;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        onClickUnbind(null);
    }
}
