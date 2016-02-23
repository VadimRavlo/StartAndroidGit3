package ua.com.wadyan.p0931servicestop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickStart(View v){
        startService(new Intent(this, MainService.class).putExtra("time", 7));
        startService(new Intent(this, MainService.class).putExtra("time", 2));
        startService(new Intent(this, MainService.class).putExtra("time", 4));
    }
}
