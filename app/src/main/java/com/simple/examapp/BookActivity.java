package com.simple.examapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.joanzapata.pdfview.PDFView;
import com.joanzapata.pdfview.listener.OnDrawListener;
import com.joanzapata.pdfview.listener.OnLoadCompleteListener;
import com.joanzapata.pdfview.listener.OnPageChangeListener;

public class BookActivity extends AppCompatActivity {
    private OnDrawListener onDrawListener;
    private boolean showButtonsDisabled;
    String bookname="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        Bundle extras = getIntent().getExtras();
        final PDFView pdfView =(PDFView)findViewById(R.id.pdfview);
        OnLoadCompleteListener onLoadCompleteListener = null;
        OnPageChangeListener onPageChangeListener = null;
        bookname=extras.getString("book");
        pdfView.fromAsset(bookname)
// .pages(0, 2, 1, 3, 3, 3)
                .defaultPage(1)
                .showMinimap(false)
                .enableSwipe(true)
                .onDraw(onDrawListener)
                .onLoad(onLoadCompleteListener)
                .onPageChange(onPageChangeListener)
                .load();
    }
}