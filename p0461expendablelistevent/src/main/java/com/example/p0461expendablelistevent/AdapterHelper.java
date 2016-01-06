package com.example.p0461expendablelistevent;

import android.content.Context;
import android.widget.SimpleExpandableListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by administrator on 10.08.2016.
 */

public class AdapterHelper {
    final private String ATTR_GROUP_NAME = "groupName";
    final private String ATTR_PHONE_NAME = "phoneName";

    private String[] groups = {"HTC", "Samsung", "LG"};
    private String[] phonesHTC = {"Desire 620G Dual Sim", "One M9", "One M8", "HTC 10"};
    private String[] phonesSamsung = {"Galaxy S7", "Galaxy S7 Edge", "Note 3", "Galaxy S6",
            "Galaxy S6 Edge", "Note 2"};
    private String[] phonesLG = {"G5", "G4 DualSim", "Nexus 5X", "V10"};

    private ArrayList<Map<String, String>> groupList;
    private ArrayList<Map<String, String>> childItemListTmp;
    private ArrayList<ArrayList<Map<String, String>>> childList;
    private Map<String, String> attributesMap;

    private Context context;

    AdapterHelper(Context context){
        this.context = context;
    }

    private SimpleExpandableListAdapter adapter;

    void setAdapter(SimpleExpandableListAdapter adapter) {
        this.adapter = adapter;
    }

    SimpleExpandableListAdapter getAdapter(){
        groupList = new ArrayList<>();
        fillGroupList();

        String groupFrom[] = {ATTR_GROUP_NAME};
        int groupTo[] = {android.R.id.text1};

        childList = new ArrayList<>();
        fillItemOfChildList(phonesHTC);
        fillItemOfChildList(phonesSamsung);
        fillItemOfChildList(phonesLG);

        String childFrom[] = {ATTR_PHONE_NAME};
        int childTo[] = {android.R.id.text1};

        adapter = new SimpleExpandableListAdapter(context,
                groupList, android.R.layout.simple_expandable_list_item_1, groupFrom, groupTo,
                childList, android.R.layout.simple_list_item_1, childFrom, childTo);

        return adapter;
    }

    void fillGroupList() {
        for (String group : groups) {
            attributesMap = new HashMap<>();
            attributesMap.put(ATTR_GROUP_NAME, group);
            groupList.add(attributesMap);
        }
    }

    void fillItemOfChildList(String[] phonesBrand){
        childItemListTmp = new ArrayList<>();
        for(String phone: phonesBrand){
            attributesMap = new HashMap<>();
            attributesMap.put(ATTR_PHONE_NAME, phone);
            childItemListTmp.add(attributesMap);
        }
        childList.add(childItemListTmp);
    }

    String getGroupText(int groupPos){
        return ((Map<String, String>)(adapter.getGroup(groupPos))).get(ATTR_GROUP_NAME);
    }

    String getChildText(int groupPos, int childPos){
        return ((Map<String, String>)(adapter.getChild(groupPos, childPos))).get(ATTR_PHONE_NAME);
    }
    String getGroupChildText(int groupPos, int childPos){
        return getGroupText(groupPos) + " " + getChildText(groupPos, childPos);
    }



}
