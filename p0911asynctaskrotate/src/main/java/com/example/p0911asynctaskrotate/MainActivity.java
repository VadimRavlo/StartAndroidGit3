package com.example.p0911asynctaskrotate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    MyTask myTask;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("qwe", "create MainActivity: " + this.hashCode());

        textView = (TextView) findViewById(R.id.text_view);

        myTask = (MyTask) getLastCustomNonConfigurationInstance();
        if (myTask == null) {
            myTask = new MyTask();
            myTask.execute();
        }

        myTask.link(this);

        Log.d("qwe", "create MyTask: " + myTask.hashCode());
    }

    @Override
    public Object onRetainCustomNonConfigurationInstance() {
        myTask.unLink();
        return myTask;
    }
}
