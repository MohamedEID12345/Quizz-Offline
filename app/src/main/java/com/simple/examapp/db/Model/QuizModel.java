package com.simple.examapp.db.Model;

public class QuizModel {


    public static final String E3dady_1_Shmla_1 = "Level1";
    public static final String E3dady_1_Shmla_2 = "Level2";
    public static final String E3dady_1_Mosbqa_1 = "Level3";
    public static final String E3dady_1_Mosbqa_2 = "Level4";
    public static final String Level_5 = "Level5";
    public static final String Level_6 = "Level6";
    public static final String Level_7 = "Level7";
    public static final String Level_8 = "Level8";
    public static final String Level_9 = "Level9";
    public static final String Level_10 = "Level10";



    private String question;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String answerNr;
    private String level;


    public QuizModel(){

    }




    public QuizModel(String question, String option1, String option2, String option3, String option4, String answerNr, String level) {
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.answerNr = answerNr;
        this.level = level;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public String getOption4() {
        return option4;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }

    public String getAnswerNr() {
        return answerNr;
    }

    public void setAnswerNr(String answerNr) {
        this.answerNr = answerNr;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
