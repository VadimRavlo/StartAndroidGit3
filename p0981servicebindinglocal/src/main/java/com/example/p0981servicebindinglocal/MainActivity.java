package com.example.p0981servicebindinglocal;

import android.content.Intent;
import android.content.ServiceConnection;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.tv_interval) TextView tvInterval;
    boolean bound = false;
    MainServiceConnection serviceConnection;
    Intent intent;
    MainService service;
    long interval;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        intent = new Intent(this, MainService.class);

        serviceConnection = new MainServiceConnection(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        bindService(intent, serviceConnection, 0);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(!bound) return;
        unbindService(serviceConnection);
        bound = false;
    }

    public void onClickButton(View v){
        switch (v.getId()){
            case R.id.btn_start:
                startService(intent);
                break;
            case R.id.btn_up:
                if(!bound) return;
                interval = service.upInterval(500);
                tvInterval.setText("interval = " + interval);
                break;
            case R.id.btn_down:
                if(!bound) return;
                interval = service.downInterval(500);
                tvInterval.setText("interval = " + interval);
                break;
        }
    }
}
