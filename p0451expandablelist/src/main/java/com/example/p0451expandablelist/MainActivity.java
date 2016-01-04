package com.example.p0451expandablelist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;
import android.widget.SimpleExpandableListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    String[] groups = {"HTC", "Samsung", "LG"};
    String[] phonesHTC = {"Desire 620G Dual Sim", "One M9", "One M8", "HTC 10"};
    String[] phonesSamsung = {"Galaxy S7", "Galaxy S7 Edge", "Note 3", "Galaxy S6",
            "Galaxy S6 Edge", "Note 2"};
    String[] phonesLG = {"G5", "G4 DualSim", "Nexus 5X", "V10"};

    //List для кожної групи
    ArrayList<Map<String, String>> groupList;
    //List елементів в групі
    ArrayList<Map<String, String>> itemListTmp;
    //List груп не знаю для чого
    ArrayList<ArrayList<Map<String, String>>> completeList;
    //Список атрибутів групи або елемента
    Map<String, String> attributeMapTmp;
    ExpandableListView elvMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        groupList = new ArrayList<>();
        itemListTmp = new ArrayList<>();
        completeList = new ArrayList<>();

        int i=0;
        for (String group: groups){
            attributeMapTmp = new HashMap<>();
            attributeMapTmp.put("groupName", group);
            attributeMapTmp.put("groupSecondAttribute", "Some_second_attribute " + i);
            attributeMapTmp.put("groupThirdAttribute", "Some_third_attribute " + i);
            i++;
            groupList.add(attributeMapTmp);
        }

        String groupFrom[] = {"groupName", "groupSecondAttribute", "groupThirdAttribute"};
        int groupTo[] = {R.id.expandable_tv_main, R.id.expandable_tv_second, R.id.expandable_tv_third};

        fillCompleteListByListOfElement(phonesHTC);
        fillCompleteListByListOfElement(phonesSamsung);
        fillCompleteListByListOfElement(phonesLG);

        String childFrom[] = {"phoneName", "phonePrice"};
        int childTo[] = {R.id.tv_child_main, R.id.tv_child_second};

        SimpleExpandableListAdapter adapter = new SimpleExpandableListAdapter(this,
                groupList, R.layout.my_expandable_list_item, groupFrom, groupTo,
                completeList, R.layout.my_expandable_list_child, childFrom, childTo);
        elvMain = (ExpandableListView) findViewById(R.id.elv_main);
        elvMain.setAdapter(adapter);
    }

    void fillCompleteListByListOfElement(String[] phonesBrandArray) {
        itemListTmp = new ArrayList<>();
        int i=1000;
        for (String phone : phonesBrandArray) {
            attributeMapTmp = new HashMap<>();
            attributeMapTmp.put("phoneName", phone);
            attributeMapTmp.put("phonePrice", i + " $");
            i+=1000;
            itemListTmp.add(attributeMapTmp);
        }
        completeList.add(itemListTmp);
    }

}
