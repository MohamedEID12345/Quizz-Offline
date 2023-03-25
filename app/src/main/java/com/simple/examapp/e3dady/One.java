package com.simple.examapp.e3dady;



import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.simple.examapp.QuizActivity;
import com.simple.examapp.R;
import com.simple.examapp.db.Model.QuizModel;

public class One extends AppCompatActivity {

    CardView cardView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);
        cardView = (CardView) findViewById(R.id.cv_shmla1);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentLvl1 = new Intent(One.this, QuizActivity.class);
                intentLvl1.putExtra("Lvl", QuizModel.E3dady_1_Shmla_1);
                startActivity(intentLvl1);
                finish();
            }
        });
    }
    }
