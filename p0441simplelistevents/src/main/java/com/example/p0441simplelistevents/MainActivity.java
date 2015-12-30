package com.example.p0441simplelistevents;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener,
        AdapterView.OnItemSelectedListener, AbsListView.OnScrollListener{

    final String LOG_TAG = "myLogs";

    ListView lvMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvMain = (ListView) findViewById(R.id.lv_main);

        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(this,
                R.array.names, android.R.layout.simple_list_item_1);
        lvMain.setAdapter(arrayAdapter);

        lvMain.setOnItemClickListener(this);
        lvMain.setOnItemSelectedListener(this);
        lvMain.setOnScrollListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        Log.d(LOG_TAG, "itemClick: position = " + position + ", id = " + id);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
        Log.d(LOG_TAG, "itemSelected: position = " + position + ", id = " + id);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        Log.d(LOG_TAG, "itemSelected: nothing");
    }

    @Override
    public void onScrollStateChanged(AbsListView absListView, int i) {
        Log.d(LOG_TAG, "scrollState = " + i);
    }

    @Override
    public void onScroll(AbsListView absListView, int i, int i1, int i2) {
//        Log.d(LOG_TAG, "scroll: firstVisibleItem = " + i + ", visibleItemCount " + i1
//              + ", totalItemCount " + i2);
    }
}
