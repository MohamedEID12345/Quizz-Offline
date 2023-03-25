package com.simple.examapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.simple.examapp.db.Model.Constant;
import com.simple.examapp.db.Model.QuizModel;
import com.simple.examapp.db.QuizDbHelper;
import com.simple.examapp.e3dady.One;

import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class QuizActivity extends AppCompatActivity {

    Button buttonA,buttonB,buttonC,buttonD;
    TextView questionText,txtTotalQuesText,timeText,scoreText,txtCorrect,txtWrong;

    QuizDbHelper triviaQuizHelper;

    QuizModel currentQuestion;
    LinearLayout lin;

    List<QuizModel> list;

    int qid = 1;

    int sizeofQuiz = 5; // total size of Quiz

    AnimationDrawable anim;

    private final Handler handler = new Handler(Looper.getMainLooper());
    private final Handler handler2 = new Handler(Looper.getMainLooper());

    private static final long COUNTDOWN_IN_MILLIS = 11000;

    private CountDownTimer countDownTimer;

    private long timeLeftMillis;

    long savedTime =0;

//    private TimerDialog timerDialog;

    int correct=0;
    int wrong = 0;
    int coins = 0;

    Animation correctAnsAnimation;
    Animation wrongAnsAnimation;

    int FLAG = -1;
    //PlayAudio playAudio;

    String levelValue;

    long backPressedTime = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        //getSupportActionBar().hide();

        questionText = findViewById(R.id.txtQuestion);
        txtTotalQuesText = findViewById(R.id.txtTotalQuestion);
        buttonA = findViewById(R.id.buttonA);
        buttonB = findViewById(R.id.buttonB);
        buttonC = findViewById(R.id.buttonC);
        buttonD = findViewById(R.id.buttonD);
        timeText = findViewById(R.id.txtTimer);
        scoreText = findViewById(R.id.txtScore);
        txtCorrect = findViewById(R.id.txtCorrect);
        txtWrong = findViewById(R.id.txtWrong);
        lin= findViewById(R.id.background);
        Intent intentCategory = getIntent();
        levelValue = intentCategory.getStringExtra("Lvl");
      //  timerDialog = new TimerDialog(this);

lin.setBackgroundResource(R.drawable.cds);
        triviaQuizHelper = new QuizDbHelper(this);
        triviaQuizHelper.getReadableDatabase();

        list = triviaQuizHelper.getQuestionsWithLevel(levelValue);

        Collections.shuffle(list);

        currentQuestion = list.get(qid);

        txtTotalQuesText.setText(qid + "/" + sizeofQuiz);

        txtCorrect.setText(String.valueOf(correct));
        txtWrong.setText(String.valueOf(wrong));
        scoreText.setText(String.valueOf(coins));
        updateQueAnsOptions();
    }


    private void updateQueAnsOptions() {

        buttonA.setBackgroundResource(R.drawable.default_button_bg);
        buttonB.setBackgroundResource(R.drawable.default_button_bg);
        buttonC.setBackgroundResource(R.drawable.default_button_bg);
        buttonD.setBackgroundResource(R.drawable.default_button_bg);

        questionText.setText(currentQuestion.getQuestion());
        buttonA.setText(currentQuestion.getOption1());
        buttonB.setText(currentQuestion.getOption2());
        buttonC.setText(currentQuestion.getOption3());
        buttonD.setText(currentQuestion.getOption4());


        timeLeftMillis = COUNTDOWN_IN_MILLIS;
       startCountDown();

    }

    private void SetNewQuestion(){

        qid++;

        txtTotalQuesText.setText(qid + "/" + sizeofQuiz);

        currentQuestion = list.get(qid);

        enableOptions();

        updateQueAnsOptions();
    }


    private void correctTextUpdate(int correct){

        txtCorrect.setText(String.valueOf(correct));

    }

    private void wrongTextUpdate(int wrong){

        txtWrong.setText(String.valueOf(wrong));
    }

    private void coinsUpdateText(double coins){
        scoreText.setText(String.valueOf(coins));
    }


    public void buttonA(View view) {
        System.out.println("this is Button A");
        countDownTimer.cancel();

        disableOptions();

        buttonA.setBackgroundResource(R.drawable.flash_background);
        anim = (AnimationDrawable) buttonA.getBackground();
        anim.start();


        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                if (currentQuestion.getOption1().equals(currentQuestion.getAnswerNr())){

                    buttonA.setBackgroundResource(R.drawable.correct_button_bg);
                    //buttonA.startAnimation(correctAnsAnimation);
                    correct++;
                    correctTextUpdate(correct);

                    //FLAG = 1;
                    //playAudio.setAudioforEvent(FLAG);

                    coins = correct;
                    coinsUpdateText(coins);

                    Log.i("QuizInfo","Correct");

                    handler2.postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            if (qid != sizeofQuiz){

                                SetNewQuestion();

                            }else {

                                finalResult();
                            }


                        }
                    },2000);
                }else {

                    buttonA.setBackgroundResource(R.drawable.wrong_button_bg);
                    // buttonA.startAnimation(wrongAnsAnimation);
                    wrong++;
                    wrongTextUpdate(wrong);
                    //FLAG = 2;
                    //playAudio.setAudioforEvent(FLAG);
                    Handler handler3 = new Handler();
                    handler3.postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            if(currentQuestion.getOption2().equals(currentQuestion.getAnswerNr())){
                                buttonB.setBackgroundResource(R.drawable.correct_button_bg);
                            }else if (currentQuestion.getOption3().equals(currentQuestion.getAnswerNr())){
                                buttonC.setBackgroundResource(R.drawable.correct_button_bg);
                            }else {
                                buttonD.setBackgroundResource(R.drawable.correct_button_bg);
                            }
                        }
                    },2000);

                    Handler handler4 = new Handler();
                    handler4.postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            if (qid != sizeofQuiz){

                                SetNewQuestion();

                            }else {
                                finalResult();
                            }
                        }
                    },3000);


                }


            }
        },5000);

    }

    public void buttonB(View view) {
        System.out.println("this is Button B");
        countDownTimer.cancel();

        disableOptions();
        buttonB.setBackgroundResource(R.drawable.flash_background);
        anim = (AnimationDrawable) buttonB.getBackground();
        anim.start();


        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                if (currentQuestion.getOption2().equals(currentQuestion.getAnswerNr())){

                    buttonB.setBackgroundResource(R.drawable.correct_button_bg);
                    //buttonB.startAnimation(correctAnsAnimation);
                    correct++;
                    correctTextUpdate(correct);
                    //FLAG = 1;
                    //playAudio.setAudioforEvent(FLAG);
                    coins = correct;
                    coinsUpdateText(coins);

                    Log.i("QuizInfo","Correct");

                    handler2.postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            if (qid != sizeofQuiz){

                                SetNewQuestion();

                            }else {
                                finalResult();
                            }


                        }
                    },2000);
                }else {

                    buttonB.setBackgroundResource(R.drawable.wrong_button_bg);
                    //buttonB.startAnimation(wrongAnsAnimation);
                    wrong++;
                    wrongTextUpdate(wrong);
                    //FLAG = 2;
                    //playAudio.setAudioforEvent(FLAG);
                    Handler handler3 = new Handler();
                    handler3.postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            if(currentQuestion.getOption1().equals(currentQuestion.getAnswerNr())){
                                buttonA.setBackgroundResource(R.drawable.correct_button_bg);
                            }else if (currentQuestion.getOption3().equals(currentQuestion.getAnswerNr())){
                                buttonC.setBackgroundResource(R.drawable.correct_button_bg);
                            }else {
                                buttonD.setBackgroundResource(R.drawable.correct_button_bg);
                            }
                        }
                    },2000);

                    Handler handler4 = new Handler();
                    handler4.postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            if (qid != sizeofQuiz){

                                SetNewQuestion();

                            }else {
                                finalResult();
                            }
                        }
                    },3000);


                }


            }
        },5000);


    }

    public void buttonC(View view) {
        System.out.println("this is Button C");
        countDownTimer.cancel();

        disableOptions();
        buttonC.setBackgroundResource(R.drawable.flash_background);
        anim = (AnimationDrawable) buttonC.getBackground();
        anim.start();


        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                if (currentQuestion.getOption3().equals(currentQuestion.getAnswerNr())){

                    buttonC.setBackgroundResource(R.drawable.correct_button_bg);
                    //buttonC.startAnimation(correctAnsAnimation);
                    correct++;
                    correctTextUpdate(correct);
                    //FLAG = 1;
                    //playAudio.setAudioforEvent(FLAG);
                    coins = correct;
                    coinsUpdateText(coins);

                    Log.i("QuizInfo","Correct");

                    handler2.postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            if (qid != sizeofQuiz){

                                SetNewQuestion();

                            }else {
                                finalResult();
                            }


                        }
                    },2000);
                }else {

                    buttonC.setBackgroundResource(R.drawable.wrong_button_bg);
                    //buttonC.startAnimation(wrongAnsAnimation);
                    wrong++;
                    wrongTextUpdate(wrong);
                    //FLAG = 2;
                    //playAudio.setAudioforEvent(FLAG);
                    Handler handler3 = new Handler();
                    handler3.postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            if(currentQuestion.getOption2().equals(currentQuestion.getAnswerNr())){
                                buttonB.setBackgroundResource(R.drawable.correct_button_bg);
                            }else if (currentQuestion.getOption1().equals(currentQuestion.getAnswerNr())){
                                buttonA.setBackgroundResource(R.drawable.correct_button_bg);
                            }else {
                                buttonD.setBackgroundResource(R.drawable.correct_button_bg);
                            }
                        }
                    },2000);

                    Handler handler4 = new Handler();
                    handler4.postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            if (qid != sizeofQuiz){

                                SetNewQuestion();

                            }else {
                                finalResult();
                            }
                        }
                    },3000);


                }


            }
        },5000);

    }

    public void buttonD(View view) {
        System.out.println("this is Button D");
        countDownTimer.cancel();
        disableOptions();
        buttonD.setBackgroundResource(R.drawable.flash_background);
        anim = (AnimationDrawable) buttonD.getBackground();
        anim.start();


        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                if (currentQuestion.getOption4().equals(currentQuestion.getAnswerNr())){

                    buttonD.setBackgroundResource(R.drawable.correct_button_bg);
                    //FLAG = 1;
                    //playAudio.setAudioforEvent(FLAG);
                    correct++;
                    correctTextUpdate(correct);

                    coins = correct;
                    coinsUpdateText(coins);

                    Log.i("QuizInfo","Correct");

                    handler2.postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            if (qid != sizeofQuiz){

                                SetNewQuestion();

                            }else {
                                finalResult();
                            }


                        }
                    },2000);
                }else {

                    buttonD.setBackgroundResource(R.drawable.wrong_button_bg);
                    //buttonD.startAnimation(wrongAnsAnimation);

                    //FLAG = 2;
                    //playAudio.setAudioforEvent(FLAG);

                    Handler handler3 = new Handler();
                    handler3.postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            if(currentQuestion.getOption2().equals(currentQuestion.getAnswerNr())){
                                buttonB.setBackgroundResource(R.drawable.correct_button_bg);
                            }else if (currentQuestion.getOption3().equals(currentQuestion.getAnswerNr())){
                                buttonC.setBackgroundResource(R.drawable.correct_button_bg);
                            }else {
                                buttonA.setBackgroundResource(R.drawable.correct_button_bg);
                            }
                        }
                    },2000);

                    Handler handler4 = new Handler();
                    handler4.postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            if (qid != sizeofQuiz){

                                SetNewQuestion();

                            }else {
                                finalResult();
                            }
                        }
                    },3000);


                }


            }
        },5000);

    }

    @Override
    protected void onResume() {
        super.onResume();
       // countDownTimer.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        countDownTimer.cancel();
    }

    @Override
    protected void onStop() {
        super.onStop();
        countDownTimer.cancel();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        countDownTimer.cancel();
        finish();
    }

    @Override
    public void onBackPressed() {
        countDownTimer.cancel();

        if (backPressedTime + 2000 > System.currentTimeMillis()){
            Intent intent = new Intent(QuizActivity.this, One.class);
            startActivity(intent);
            finish();
        }else {
            Toast.makeText(this, "Press Again to Exit", Toast.LENGTH_SHORT).show();
        }

        backPressedTime = System.currentTimeMillis();


    }

    private void disableOptions(){
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

    }

    private void enableOptions(){
        buttonA.setEnabled(true);
        buttonB.setEnabled(true);
        buttonC.setEnabled(true);
        buttonD.setEnabled(true);

    }

    private void finalResult(){

        Intent resultIntent = new Intent(QuizActivity.this,ResultActivity.class);
        resultIntent.putExtra(Constant.TOTAL_QUESTIONS,sizeofQuiz);
        resultIntent.putExtra(Constant.SCORE,coins);
        resultIntent.putExtra(Constant.WRONG,wrong);
        resultIntent.putExtra(Constant.CORRECT,correct);
        resultIntent.putExtra("Lvl",levelValue);
        startActivity(resultIntent);
        finish();


    }

    private void startCountDown(){

        countDownTimer = new CountDownTimer(timeLeftMillis,1000) {
            @Override
            public void onTick(long millsUnilFinished) {
                timeLeftMillis = millsUnilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {

                timeLeftMillis = 0;
                ////////////////////////////
                disableOptions();
                wrong++;
                wrongTextUpdate(wrong);
                //FLAG = 2;
                //playAudio.setAudioforEvent(FLAG);
                Handler handler3 = new Handler();
                handler3.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        if(currentQuestion.getOption1().equals(currentQuestion.getAnswerNr())){
                            buttonA.setBackgroundResource(R.drawable.correct_button_bg);
                        }else if (currentQuestion.getOption2().equals(currentQuestion.getAnswerNr())){
                            buttonB.setBackgroundResource(R.drawable.correct_button_bg);
                        }else if (currentQuestion.getOption3().equals(currentQuestion.getAnswerNr())){
                            buttonC.setBackgroundResource(R.drawable.correct_button_bg);}
                        else {
                            buttonD.setBackgroundResource(R.drawable.correct_button_bg);
                        }
                    }
                },2000);

                Handler handler4 = new Handler();
                handler4.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        if (qid != sizeofQuiz){

                            SetNewQuestion();

                        }else {
                            finalResult();
                        }
                    }
                },3000);

                ////////////////
                //SetNewQuestion();
                updateCountDownText();

            }
        }.start();


    }



    private void updateCountDownText() {


        int seconds = (int) (timeLeftMillis / 1000) % 60;

        String timeFormatted = String.format(Locale.getDefault(), "%02d", seconds);
        savedTime = Long.parseLong(timeFormatted);
        timeText.setText(timeFormatted);

        if (timeLeftMillis < 6000) {

            timeText.setTextColor(ContextCompat.getColor(this, R.color.red));

        } else {

            timeText.setTextColor(ContextCompat.getColor(this, R.color.white));

        }

        if (timeLeftMillis == 0) {

            Toast.makeText(this, "Times Up!", Toast.LENGTH_SHORT).show();
            disableOptions();

            /////////

            ////////////

        }
    }
    }