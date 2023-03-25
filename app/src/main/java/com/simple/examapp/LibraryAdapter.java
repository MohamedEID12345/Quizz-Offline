package com.simple.examapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.simple.examapp.db.Model.LibraryModel;

import java.util.ArrayList;

public class LibraryAdapter extends ArrayAdapter<LibraryModel> {
    private Context context;
    String Bookname1="a.pdf";
    String Bookname2="b.pdf";
    String Bookname3="c.pdf";
    String Bookname4="d.pdf";
    public LibraryAdapter(@NonNull Context context, ArrayList<LibraryModel> courseModelArrayList) {
        super(context, 0, courseModelArrayList);
        this.context=context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listitemView = convertView;
        if (listitemView == null) {
            // Layout Inflater inflates each item to be displayed in GridView.
            listitemView = LayoutInflater.from(getContext()).inflate(R.layout.card_item, parent, false);
        }

        LibraryModel courseModel = getItem(position);
        TextView courseTV = listitemView.findViewById(R.id.idTVCourse);
        ImageView courseIV = listitemView.findViewById(R.id.idIVcourse);

        courseTV.setText(courseModel.getCourse_name());
        courseIV.setImageResource(courseModel.getImgid());

        listitemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(position==0){
                    Intent intent= new Intent(context, BookActivity.class);
                    intent.putExtra("book", Bookname1);
                    context.startActivity(intent);
                }
                if(position==1){
                    Intent intent= new Intent(context, BookActivity.class);
                    intent.putExtra("book", Bookname2);
                    context.startActivity(intent);
                }
                if(position==2){
                    Intent intent= new Intent(context, BookActivity.class);
                    intent.putExtra("book", Bookname3);
                    context.startActivity(intent);
                }
                if(position==3){
                    Intent intent= new Intent(context, BookActivity.class);
                    intent.putExtra("book", Bookname4);
                    context.startActivity(intent);
                }


            }


        });

        return listitemView;
    }
}
