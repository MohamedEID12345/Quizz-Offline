package com.simple.examapp;

import android.app.Activity;
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
import java.util.ArrayList;
public class SectionsGVAdapter extends ArrayAdapter<SectionsModel>{
    private Context context;
    public SectionsGVAdapter(@NonNull Context context, ArrayList<SectionsModel> courseModelArrayList) {
        super(context, 0, courseModelArrayList);
        this.context=context;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listitemView = convertView;
        if (listitemView == null) {
            // Layout Inflater inflates each item to be displayed in GridView.
            listitemView = LayoutInflater.from(getContext()).inflate(R.layout.card_item, parent, false);
        }

        SectionsModel courseModel = getItem(position);
        TextView courseTV = listitemView.findViewById(R.id.idTVCourse);
        ImageView courseIV = listitemView.findViewById(R.id.idIVcourse);

        courseTV.setText(courseModel.getCourse_name());
        courseIV.setImageResource(courseModel.getImgid());

        listitemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
                if(position==0){
                    Intent intent= new Intent(context, AzharPageFilter.class);
                    context.startActivity(intent);
                }
                if(position==2){
                    Intent intent= new Intent(context, LibraryActivity.class);
                    context.startActivity(intent);
                }
                if(position==4){
                    Intent intent= new Intent(context, GalleryActivity.class);
                    context.startActivity(intent);
                }


            }


        });
        return listitemView;

    }

}
