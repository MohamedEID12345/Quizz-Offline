package com.simple.examapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

import com.simple.examapp.db.Model.LibraryModel;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;

public class LibraryActivity extends AppCompatActivity {
    int url1 = R.drawable.b1;
    int url2 = R.drawable.b2;
    int url3 = R.drawable.b3;
    int url4 = R.drawable.b4;
    GridView coursesGV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        coursesGV = findViewById(R.id.idGVcourses);
        ArrayList<LibraryModel> courseModelArrayList = new ArrayList<LibraryModel>();

        courseModelArrayList.add(new LibraryModel("DSA", R.drawable.b1));
        courseModelArrayList.add(new LibraryModel("JAVA", R.drawable.b2));
        courseModelArrayList.add(new LibraryModel("C++", R.drawable.b3));
        courseModelArrayList.add(new LibraryModel("Python", R.drawable.b4));

        LibraryAdapter adapter = new LibraryAdapter(this, courseModelArrayList);
        coursesGV.setAdapter(adapter);
        //carousel
        // we are creating array list for storing our image urls.
        ArrayList<SliderData> sliderDataArrayList = new ArrayList<>();

        // initializing the slider view.
        SliderView sliderView = findViewById(R.id.slider);

        // adding the urls inside array list
        sliderDataArrayList.add(new SliderData(url1,"DSA BOOK"));
        sliderDataArrayList.add(new SliderData(url2,"JAVA"));
        sliderDataArrayList.add(new SliderData(url3,"C++"));
        sliderDataArrayList.add(new SliderData(url4,"PYTHON"));

        // passing this array list inside our adapter class.
        SliderAdapter adapters = new SliderAdapter(this, sliderDataArrayList);

        // below method is used to set auto cycle direction in left to
        // right direction you can change according to requirement.
        sliderView.setAutoCycleDirection(SliderView.LAYOUT_DIRECTION_LTR);

        // below method is used to
        // setadapter to sliderview.
        sliderView.setSliderAdapter(adapters);

        // below method is use to set
        // scroll time in seconds.
        sliderView.setScrollTimeInSec(3);

        // to set it scrollable automatically
        // we use below method.
        sliderView.setAutoCycle(true);

        // to start autocycle below method is used.
        sliderView.startAutoCycle();
    }
}