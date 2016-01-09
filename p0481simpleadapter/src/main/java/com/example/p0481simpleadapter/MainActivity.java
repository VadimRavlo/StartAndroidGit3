package com.example.p0481simpleadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    final String ATTRIBUTE_NAME_TEXT = "text";
    final String ATTRIBUTE_NAME_CHECKED = "checked";
    final String ATTRIBUTE_NAME_IMAGE = "image";

    ListView lvSimple;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] texts = {"sometext 1", "sometext 2", "sometext 3", "sometext 4", "sometext 5"};
        boolean[] checked = {true, false, false, true, false};
        int img = R.mipmap.ic_launcher;

        ArrayList<Map<String, Object>> mainList = new ArrayList<>(texts.length);

        fillMainList(mainList, texts, checked, img);

        String[] from = {ATTRIBUTE_NAME_TEXT, ATTRIBUTE_NAME_CHECKED, ATTRIBUTE_NAME_IMAGE, ATTRIBUTE_NAME_TEXT};
        int[] to = {R.id.text_view, R.id.check_box, R.id.image_view, R.id.check_box};

        SimpleAdapter adapter = new SimpleAdapter(this, mainList, R.layout.list_item, from, to);

        lvSimple = (ListView) findViewById(R.id.lv_simple);
        lvSimple.setAdapter(adapter);

    }

    void fillMainList(ArrayList<Map<String, Object>> mainList, String[] texts, boolean[] checked, int img){
        Map<String, Object> map;
        for (int i=0; i<texts.length; i++){
            map = new HashMap<>();
            map.put(ATTRIBUTE_NAME_TEXT, texts[i]);
            map.put(ATTRIBUTE_NAME_CHECKED, checked[i]);
            map.put(ATTRIBUTE_NAME_IMAGE, img);
            mainList.add(map);
        }
    }
}
