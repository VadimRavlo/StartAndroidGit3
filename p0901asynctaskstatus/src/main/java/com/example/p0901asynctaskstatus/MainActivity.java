package com.example.p0901asynctaskstatus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

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
                startTask();
                break;
            case R.id.btn_status:
                showStatus();
                break;
            default:
                break;
        }
    }

    void startTask(){
        myTask = new MyTask();
        myTask.link(this);
        myTask.execute();
        myTask.cancel(false);
    }

    void showStatus(){
        if (myTask != null){
            if (myTask.isCancelled())
                Toast.makeText(this, "CANCELLED", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(this, myTask.getStatus().toString(), Toast.LENGTH_SHORT).show();

        }
    }
}
