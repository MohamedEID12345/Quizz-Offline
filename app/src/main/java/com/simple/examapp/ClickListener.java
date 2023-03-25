package com.simple.examapp;

import android.view.View;
import android.widget.AdapterView;

public interface ClickListener {
    public void itemClicked(AdapterView<?> parent, View view, int position, long id);
}
