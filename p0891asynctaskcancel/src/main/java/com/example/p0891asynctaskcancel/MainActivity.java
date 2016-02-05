package com.example.p0891asynctaskcancel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    MyTask myTask;
    TextView tvInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvInfo = (TextView) findViewById(R.id.tv_info);
    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.btn_start:
                myTask = new MyTask();
                myTask.link(this);
                myTask.execute();
                break;
            case R.id.btn_cancel:
                cancelTask();
                break;
            default:
                break;
        }
    }

    void cancelTask(){
        if (myTask == null) return;
        Log.d(MyTask.LOG_TAG, "cancel result: " + myTask.cancel(true));
    }
}
