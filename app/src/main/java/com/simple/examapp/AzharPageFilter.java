package com.simple.examapp;


import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.simple.examapp.e3dady.One;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class AzharPageFilter extends AppCompatActivity {
    ExpandableListView expandableListViewExample;
    ExpandableListAdapter expandableListAdapter;
    List<String> expandableTitleList;
    HashMap<String, List<String>> expandableDetailList;
   // private Context context;

//    public AzharPageFilter(@NonNull Context context){
//        this.context=context;
//    }
//
//    public AzharPageFilter() {
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_azhar_page_filter);
        expandableListViewExample = (ExpandableListView) findViewById(R.id.expandableListViewSample);
        expandableDetailList = ExpandableListDataItems.getData();
        expandableTitleList = new ArrayList<String>(expandableDetailList.keySet());
        expandableListAdapter = new CustomizedExpandableListAdapter(this, expandableTitleList, expandableDetailList);
        expandableListViewExample.setAdapter(expandableListAdapter);

        // This method is called when the group is expanded
        expandableListViewExample.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(getApplicationContext(), expandableTitleList.get(groupPosition) + " List Expanded.", Toast.LENGTH_SHORT).show();
            }
        });

        // This method is called when the group is collapsed
        expandableListViewExample.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(getApplicationContext(), expandableTitleList.get(groupPosition) + " List Collapsed.", Toast.LENGTH_SHORT).show();
            }
        });

        // This method is called when the child in any group is clicked
        // via a toast method, it is shown to display the selected child item as a sample
        // we may need to add further steps according to the requirements
        expandableListViewExample.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                //open activity
                if(groupPosition==0&&childPosition==0){
                    Intent intent = new Intent(AzharPageFilter.this, One.class);
                    startActivity(intent);
                    System.out.println("i am open anew activity");
                }
                //Toast
                Toast.makeText(getApplicationContext(), expandableTitleList.get(groupPosition)
                        + " -> "+childPosition
                        + expandableDetailList.get(
                        expandableTitleList.get(groupPosition)).get(
                        childPosition), Toast.LENGTH_SHORT
                ).show();

                return false;
            }
        });
    }
}