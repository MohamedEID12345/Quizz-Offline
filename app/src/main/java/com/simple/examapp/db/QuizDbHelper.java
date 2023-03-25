package com.simple.examapp.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.simple.examapp.db.Model.QuizModel;
import com.simple.examapp.db.QuizContract.QuestionTable;


import java.util.ArrayList;

public class QuizDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "TriviaQuiz.db";
    private static final int DATABASE_VERSION = 1;

    private SQLiteDatabase db;
public static int lastIdDB;
    public QuizDbHelper(Context context) {
        super(context, DATABASE_NAME,null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        this.db = db;

        final String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE " +
                QuestionTable.TABLE_NAME + " ( " +
                QuestionTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionTable.COLUMN_QUESTION + " TEXT, " +
                QuestionTable.COLUMN_OPTION1 + " TEXT, " +
                QuestionTable.COLUMN_OPTION2 + " TEXT, " +
                QuestionTable.COLUMN_OPTION3 + " TEXT, " +
                QuestionTable.COLUMN_OPTION4 + " TEXT, " +
                QuestionTable.COLUMN_ANSWER_NR + " TEXT, " +
                QuestionTable.COLUMN_LEVEL + " TEXT " +
                ")";

        db.execSQL(SQL_CREATE_QUESTIONS_TABLE);
        fillQuestionsTable();

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + QuestionTable.TABLE_NAME);
        onCreate(db);
    }



    private void fillQuestionsTable()
    {

        QuizModel q1 = new QuizModel("أول صحابي حيّا الرسول صلّ الله عليه وسلم بتحية الإسلام هو…؟","أبو بكر الصديق","أبو أيوب الأنصاري","أبو ذر الغفاري","أبو موسى الأشعري","أبو ذر الغفاري",QuizModel.E3dady_1_Shmla_1);
        addQuestions(q1);

        QuizModel q2 = new QuizModel("ما هو البحر الذي يسمى بحر القلزم؟","البحر العربي","البحر الأحمر","بحر قزوين","البحر الأسود","البحر العربي",QuizModel.E3dady_1_Shmla_1);
        addQuestions(q2);

        QuizModel q3= new QuizModel("من مؤلفات الطبيب العربي أبو بكر الرازي كتاب ..؟","الطب والحكمة","فردوس الحكمة","الأدوية والعلل","هيئة الكبد","هيئة الكبد",QuizModel.E3dady_1_Shmla_1);
        addQuestions(q3);

        QuizModel q4= new QuizModel("ما المقصود بيوم الفرقان الذي ذكره الله تعالى في القرآن؟","غزوة بدر","غزوة أحد","غزوة الخندق","غزوة حنين","غزوة بدر",QuizModel.E3dady_1_Shmla_1);
        addQuestions(q4);

        QuizModel q5= new QuizModel("من شعراء العصر الأموي ..؟","أبو الطيب المتنبي","ابن خفاجي الأندلسي","ابن هانئ الأندلسي","الكميت","الكميت",QuizModel.E3dady_1_Shmla_1);
        addQuestions(q5);

        QuizModel q6= new QuizModel("اكبر دولة افريقية من حيث المساحة هي دولة …؟","الجزائر","مورتانيا","مصر","السودان","السودان",QuizModel.E3dady_1_Shmla_1);
        addQuestions(q6);

        QuizModel q7= new QuizModel("Who invented Linux Kernel?","Thomas Edison","Linus Torvalds","Nicholas Callan","Martin Cooper","Linus Torvalds",QuizModel.E3dady_1_Shmla_2);
        addQuestions(q7);

        QuizModel q8= new QuizModel("Who invented Computer?","Blaise Pascal","Samuel Morse","Charles Babbage","Linus Torvalds","Charles Babbage",QuizModel.E3dady_1_Shmla_2);
        addQuestions(q8);

        QuizModel q9= new QuizModel("Who invented World Wide Web (WWW)?","Casimir Funk","Brendan Eich","Lloyd M. Smith","Tim Berners-Lee and Robert Cailliau","Tim Berners-Lee and Robert Cailliau",QuizModel.E3dady_1_Shmla_2);
        addQuestions(q9);

        QuizModel q10= new QuizModel("Who invented Venn Diagram?","Nicholas Callan","Adam Osborne","Blaise Pascal","John Venn","John Venn",QuizModel.E3dady_1_Shmla_2);
        addQuestions(q10);

        QuizModel q11= new QuizModel("Who invented Raman Effect?","Blaise Pascal","George H. Heilmeier","Galileo","CV Raman","CV Raman",QuizModel.E3dady_1_Shmla_2);
        addQuestions(q11);

        QuizModel q12= new QuizModel("Who invented Vitamin?","Casimir Funk","Galileo","Casimir Funk","Brendan Eich","Casimir Funk",QuizModel.E3dady_1_Shmla_2);
        addQuestions(q12);

        QuizModel q13= new QuizModel("Who invented C Language?","Blaise Pascal","Dennis Ritchie","Galileo","Charles Babbage","Dennis Ritchie",QuizModel.E3dady_1_Mosbqa_1);
        addQuestions(q13);

        QuizModel q14= new QuizModel("Who invented Celsius?","Thomas Edison","Roger L. Easton","Anders Celsius","Nikola Tesla","Anders Celsius",QuizModel.E3dady_1_Mosbqa_1);
        addQuestions(q14);

        QuizModel q15= new QuizModel("Who invented JavaScript?","Willis Carrier","Stephanie Kwolek","Eugen Baumann","Brendan Eich","Brendan Eich",QuizModel.E3dady_1_Mosbqa_1);
        addQuestions(q15);

        QuizModel q16= new QuizModel("Who invented Carbon Nanotubes?","Sumio Iijima","Ernst Ruska","Nicholas Callan","Louis Pasteur","Sumio Iijima",QuizModel.E3dady_1_Mosbqa_1);
        addQuestions(q16);

        QuizModel q17= new QuizModel("Who invented Kevlar Material?","Thomas Edison","Stephanie Kwolek","Bjarne Stroustrup","Alan Emtage","Stephanie Kwolek",QuizModel.E3dady_1_Mosbqa_1);
        addQuestions(q17);

        QuizModel q18= new QuizModel("Who invented Calculator?","Ernest Rutherford","Douglas Engelbart","Blaise Pascal","Alan Emtage","Blaise Pascal",QuizModel.E3dady_1_Mosbqa_1);
        addQuestions(q18);

        QuizModel q19= new QuizModel("Who invented GPS (Global Positioning System)?","Alan Emtage","James Gosling","Nils Bohlin","Roger L. Easton","Roger L. Easton",QuizModel.E3dady_1_Mosbqa_2);
        addQuestions(q19);

        QuizModel q20= new QuizModel("Who invented Liquid Crystal Display?","Lloyd M. Smith","Edward Jenner","George H. Heilmeier","Christopher Latham Sholes","George H. Heilmeier",QuizModel.E3dady_1_Mosbqa_2);
        addQuestions(q20);

        QuizModel q21= new QuizModel("Who invented BarCode?","Norman Joseph Woodland and Bernard Silver","Galileo","Wright Brothers","Tim Berners-Lee and Robert Cailliau","Norman Joseph Woodland and Bernard Silver",QuizModel.E3dady_1_Mosbqa_2);
        addQuestions(q21);

        QuizModel q22= new QuizModel("Who invented Magnetic Resonance Imaging (MRI)?","William Rontgen","Raymond Damadian","Casimir Funk","Martin Cooper","Raymond Damadian",QuizModel.E3dady_1_Mosbqa_2);
        addQuestions(q22);

        QuizModel q23= new QuizModel("Who invented Printing Machine?","Nicholas Callan","Charles Babbage","Alfred Nobel","Johannes Gutenberg","Johannes Gutenberg",QuizModel.E3dady_1_Mosbqa_2);
        addQuestions(q23);

        QuizModel q24= new QuizModel("Who invented Radio?","Guglielmo Marconi","Charles Babbage","Willis Carrier","George H. Heilmeier","Guglielmo Marconi",QuizModel.E3dady_1_Mosbqa_2);
        addQuestions(q24);

        QuizModel q25= new QuizModel("Who invented Telescope?","Willis Carrier","Raymond Damadian","Galileo","Raymond Damadian","Galileo",QuizModel.Level_5);
        addQuestions(q25);

        QuizModel q26= new QuizModel("Who invented Airplane?","Wright Brothers","Theodore H. Maiman","Larry Sanger and Jimmy Wales","Dmitri Mendeleev","Wright Brothers",QuizModel.Level_5);
        addQuestions(q26);

        QuizModel q27= new QuizModel("Who invented Battery?","Louis Pasteur","Richard J. Gatling","Alessandro Volta","Blaise Pascal","Alessandro Volta",QuizModel.Level_5);
        addQuestions(q27);

        QuizModel q28= new QuizModel("Who invented Mobile Phone?","Martin Cooper","John Venn","Dennis Ritchie","CV Raman","Martin Cooper",QuizModel.Level_5);
        addQuestions(q28);

        QuizModel q29= new QuizModel("Who invented Atomic bomb?","Thor Bjørklund","Robert Oppenheimer, Edward Teller et al","Karl Landsteiner","Louis Pasteur","Robert Oppenheimer, Edward Teller et al",QuizModel.Level_5);
        addQuestions(q29);

        QuizModel q30= new QuizModel("Who invented Air conditioner?","Robert H. Goddard","James Gosling","Martin Cooper","Willis Carrier","Willis Carrier",QuizModel.Level_5);
        addQuestions(q30);

        QuizModel q31= new QuizModel("Who invented Electron Microscope?","Robert Oppenheimer","Ernst Ruska","Roger L. Easton","Nicholas Callan","Ernst Ruska",QuizModel.Level_6);
        addQuestions(q31);

        QuizModel q32= new QuizModel("Who invented Computer Mouse?","George Stephenson","Douglas Engelbart","George Stephenson","Alfred Nobel","Douglas Engelbart",QuizModel.Level_6);
        addQuestions(q32);

        QuizModel q33= new QuizModel("Who invented Induction Coil?","Ernst Ruska","Edward Jenner","Nicholas Callan","Alexander Fleming","Nicholas Callan",QuizModel.Level_6);
        addQuestions(q33);

        QuizModel q34= new QuizModel("Who invented PVC?","Eugen Baumann","Edward Jenner","George Stephenson","Eugen Baumann","Eugen Baumann",QuizModel.Level_6);
        addQuestions(q34);

        QuizModel q35= new QuizModel("Who invented C++?","Roger L. Easton","Bjarne Stroustrup","George Stephenson","Samuel Morse","Bjarne Stroustrup",QuizModel.Level_6);
        addQuestions(q35);

        QuizModel q36= new QuizModel("Who invented Laptop?","Richard J. Gatling","Bjarne Stroustrup","Adam Osborne","Richard J. Gatling","Adam Osborne",QuizModel.Level_6);
        addQuestions(q36);








    }



    private void addQuestions(QuizModel question){

        ContentValues cv = new ContentValues();
        cv.put(QuestionTable.COLUMN_QUESTION,question.getQuestion());
        cv.put(QuestionTable.COLUMN_OPTION1,question.getOption1());
        cv.put(QuestionTable.COLUMN_OPTION2,question.getOption2());
        cv.put(QuestionTable.COLUMN_OPTION3,question.getOption3());
        cv.put(QuestionTable.COLUMN_OPTION4,question.getOption4());
        cv.put(QuestionTable.COLUMN_ANSWER_NR,question.getAnswerNr());
        cv.put(QuestionTable.COLUMN_LEVEL,question.getLevel());
        db.insert(QuestionTable.TABLE_NAME,null,cv);

    }

                                    //Get All QUESTIONS
    public ArrayList<QuizModel> getAllQuestions() {

        ArrayList<QuizModel> questionList = new ArrayList<>();
        db = getReadableDatabase();

        String Projection[] = {

                QuestionTable._ID,
                QuestionTable.COLUMN_QUESTION,
                QuestionTable.COLUMN_OPTION1,
                QuestionTable.COLUMN_OPTION2,
                QuestionTable.COLUMN_OPTION3,
                QuestionTable.COLUMN_OPTION4,
                QuestionTable.COLUMN_ANSWER_NR
        };

        Cursor c = db.query(QuestionTable.TABLE_NAME, Projection, null, null, null, null, null);

        if (c.moveToFirst()) {
            do {

                QuizModel question = new QuizModel();
                question.setQuestion(c.getString(c.getColumnIndex(QuestionTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION3)));
                question.setOption4(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION4)));
                question.setAnswerNr(c.getString(c.getColumnIndex(QuestionTable.COLUMN_ANSWER_NR)));

                questionList.add(question);

            } while (c.moveToNext());

        }
        c.close();
        return questionList;
    }


                                //GET ALL QUESTION BY LEVEL
    public ArrayList<QuizModel> getQuestionsWithLevel(String label) {

        ArrayList<QuizModel> questionList = new ArrayList<>();
        db = getReadableDatabase();



        String Projection[] = {

                QuestionTable._ID,
                QuestionTable.COLUMN_QUESTION,
                QuestionTable.COLUMN_OPTION1,
                QuestionTable.COLUMN_OPTION2,
                QuestionTable.COLUMN_OPTION3,
                QuestionTable.COLUMN_OPTION4,
                QuestionTable.COLUMN_ANSWER_NR,
                QuestionTable.COLUMN_LEVEL
        };


        String selection = QuestionTable.COLUMN_LEVEL + " = ? ";
        String selectionArgs[] = {label};

        Cursor c = db.query(QuestionTable.TABLE_NAME, Projection, selection, selectionArgs, null, null, null);


        if (c.moveToFirst()) {
            do {

                QuizModel question = new QuizModel();
                question.setQuestion(c.getString(c.getColumnIndex(QuestionTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION3)));
                question.setOption4(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION4)));
                question.setAnswerNr(c.getString(c.getColumnIndex(QuestionTable.COLUMN_ANSWER_NR)));
                question.setLevel(c.getString(c.getColumnIndex(QuestionTable.COLUMN_LEVEL)));

                questionList.add(question);

            } while (c.moveToNext());
            //
            lastIdDB=c.getCount();
            System.out.println("Thel Last Id= "+lastIdDB);
        }
        c.close();
        return questionList;


    }

    public static int getLastIdDB() {
        return lastIdDB;
    }

}
