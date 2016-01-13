package com.example.p0491simpleadaptercustom1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    final String ATTRIBUTE_NAME_TEXT = "text";
    final String ATTRIBUTE_NAME_VALUE = "value";
    final String ATTRIBUTE_NAME_IMAGE = "image";

    final static int POSITIVE = android.R.drawable.arrow_up_float;
    final static int NEGATIVE = android.R.drawable.arrow_down_float;

    int[] values = {8, 4, -3, 2, -5, 0, 3, -6, 1, -1};

    ListView lvSimple;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Map<String, Object>> mainList = new ArrayList<>(values.length);
        Map<String, Object> attributeMapTmp;
        int img = 0;
        for (int i = 0; i < values.length; i++) {
            attributeMapTmp = new HashMap<>();
            attributeMapTmp.put(ATTRIBUTE_NAME_TEXT, "Day " + (i + 1));
            attributeMapTmp.put(ATTRIBUTE_NAME_VALUE, values[i]);
            if (values[i] == 0)
                img = 0;
            else img = (values[i]>0)? POSITIVE : NEGATIVE;
            attributeMapTmp.put(ATTRIBUTE_NAME_IMAGE, img);
            mainList.add(attributeMapTmp);
        }
        String[] from = {ATTRIBUTE_NAME_TEXT, ATTRIBUTE_NAME_VALUE, ATTRIBUTE_NAME_IMAGE};
        int[] to = {R.id.tv_text, R.id.tv_value, R.id.iv_main};

        MySimpleAdapter adapter = new MySimpleAdapter(this, mainList, R.layout.list_item, from, to);

        lvSimple = (ListView) findViewById(R.id.lv_simple);
        lvSimple.setAdapter(adapter);
    }
}
