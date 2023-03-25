package com.simple.examapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;

public class HomePage extends AppCompatActivity{
    GridView coursesGV;
    Context context;
    SectionsGVAdapter sectionsGVAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);

        coursesGV = findViewById(R.id.idGVcourses);
        final ArrayList<SectionsModel> courseModelArrayList = new ArrayList<SectionsModel>();

        courseModelArrayList.add(new SectionsModel("أزهر", R.drawable.alazhr));
        courseModelArrayList.add(new SectionsModel("عام", R.drawable.wezara));
        courseModelArrayList.add(new SectionsModel("مكتبة", R.drawable.library));
        courseModelArrayList.add(new SectionsModel("معلومات", R.drawable.info));
        courseModelArrayList.add(new SectionsModel("المعرض", R.drawable.galleryys));
        //courseModelArrayList.add(new SectionsModel("DSA", R.drawable.ic_gfglogo));

        SectionsGVAdapter adapter = new SectionsGVAdapter(this, courseModelArrayList);
        coursesGV.setAdapter(adapter);
        //open Activity

    }

}
