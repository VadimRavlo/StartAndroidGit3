package com.example.p0951servicebackpendingintent;

import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    static final String LOG_TAG = "myLogs";

    final int TASK1_CODE = 1;
    final int TASK2_CODE = 2;
    final int TASK3_CODE = 3;

    public static final int STATUS_START = 100;
    public static final int STATUS_FINISH = 200;

    public static final String PARAM_TIME = "time";
    public static final String PARAM_PINTENT = "pendingIntent";
    public static final String PARAM_RESULT = "result";

    TextView tvTask1;
    TextView tvTask2;
    TextView tvTask3;

    Intent intentEmpty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTask1 = (TextView) findViewById(R.id.tv_task_1);
        tvTask2 = (TextView) findViewById(R.id.tv_task_2);
        tvTask3 = (TextView) findViewById(R.id.tv_task_3);
        tvTask1.setText("Task1");
        tvTask2.setText("Task2");
        tvTask3.setText("Task3");
    }

    public void onClickStart(View v){
        intentEmpty = new Intent();
        runIntentAndService(TASK1_CODE, 7);
        runIntentAndService(TASK2_CODE, 4);
        runIntentAndService(TASK3_CODE, 6);
    }

    void runIntentAndService(int taskCode, int paramTime) {
        PendingIntent pendingIntent = createPendingResult(taskCode, intentEmpty, 0);
        Intent intent = new Intent(this, MainService.class).putExtra(PARAM_TIME, paramTime)
                .putExtra(PARAM_PINTENT, pendingIntent);
        startService(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d(LOG_TAG, "requestCode = " + requestCode + " , resultCode = " + resultCode);

        if (resultCode == STATUS_START){
            switch (requestCode){
                case TASK1_CODE:
                    tvTask1.setText("Task1 start");
                    break;
                case TASK2_CODE:
                    tvTask2.setText("Task2 start");
                    break;
                case TASK3_CODE:
                    tvTask3.setText("Task3 start");
                    break;
            }
        }

        if (resultCode == STATUS_FINISH){
            int result = data.getIntExtra(PARAM_RESULT, 0);
            switch (requestCode){
                case TASK1_CODE:
                    tvTask1.setText("Task1 finish, result = " + result);
                    break;
                case TASK2_CODE:
                    tvTask2.setText("Task2 finish, result = " + result);
                    break;
                case TASK3_CODE:
                    tvTask3.setText("Task3 finish, result = " + result);
                    break;
            }
        }
    }
}
