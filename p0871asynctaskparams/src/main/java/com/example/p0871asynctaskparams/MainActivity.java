package com.example.p0871asynctaskparams;

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
        myTask = new MyTask();
        myTask.execute("file_path_1", "file_path_2", "file_path_3", "file_path_4");
        Log.d(MyTask.LOG_TAG, "--- Finish main thread ---");
    }
}
