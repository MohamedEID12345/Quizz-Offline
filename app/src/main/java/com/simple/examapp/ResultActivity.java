package com.simple.examapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.simple.examapp.db.Model.Constant;
import com.simple.examapp.e3dady.One;

public class ResultActivity extends AppCompatActivity {

    Button btPlayAgain,sign;
    TextView txtTotalQuesion,txtCoins,txtWrongQues,txtCorrectQues;
    private TimerDialog timerDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        btPlayAgain = findViewById(R.id.bt_PlayAgainR);
        sign = findViewById(R.id.sign);

        txtCoins = findViewById(R.id.txtScoreR);
        txtCorrectQues = findViewById(R.id.txtCorrectR);
        txtWrongQues = findViewById(R.id.txtWrongR);
        txtTotalQuesion = findViewById(R.id.txtTotalQuestionsR);
        timerDialog = new TimerDialog(this);


        Intent intent = getIntent();

        int totalQuestions = intent.getIntExtra(Constant.TOTAL_QUESTIONS,0);
       // int coins = intent.getIntExtra(Constant.SCORE,0);
        int correct = intent.getIntExtra(Constant.CORRECT,0);
        int wrong = intent.getIntExtra(Constant.WRONG,0);
        final String categoryValue = intent.getStringExtra("Lvl");

//
        double x=((double)correct/totalQuestions) * 100;
        double coins = x;
        System.out.println("the value of quiz= "+coins);
        //

        txtTotalQuesion.setText(String.valueOf(totalQuestions));
        txtCoins.setText(String.valueOf(coins));
        txtCorrectQues.setText(String.valueOf(correct));
        txtWrongQues.setText(String.valueOf(wrong));


        btPlayAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(ResultActivity.this, One.class);

                startActivity(intent);
                finish();


            }
        });

        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timerDialog.timerDialog();
            }
        });

    }







    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(ResultActivity.this, One.class);
        startActivity(intent);
        finish();
    }
}