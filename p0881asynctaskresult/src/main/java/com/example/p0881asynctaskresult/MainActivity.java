package com.example.p0881asynctaskresult;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

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
                Log.d(MyTask.LOG_TAG, "--- Begin method onClick, button START in main thread ---");
                myTask = new MyTask();
                myTask.execute();
                Log.d(MyTask.LOG_TAG, "--- End method onClick, button START in main thread ---");
                break;
            case R.id.btn_get:
                Log.d(MyTask.LOG_TAG, "--- Begin method onClick, button GET in main thread ---");
                showResult();
                Log.d(MyTask.LOG_TAG, "--- End method onClick, button GET in main thread ---");
                break;
            default:
                break;
        }
    }

    void showResult(){
        if (myTask == null) return;
        int result = -1;
        try {
            Log.d(MyTask.LOG_TAG, "Try to get result");
            result = myTask.get(1, TimeUnit.SECONDS);
            Log.d(MyTask.LOG_TAG, "get returns " + result);
            Toast.makeText(this, "get returns " + result, Toast.LENGTH_SHORT).show();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e){
            Log.d(MyTask.LOG_TAG, "get timeout, result = " + result);
            e.printStackTrace();
        }
    }
}
