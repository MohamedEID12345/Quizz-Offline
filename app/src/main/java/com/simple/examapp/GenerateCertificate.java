package com.simple.examapp;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;


import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.pdf.PdfDocument;
import android.media.Image;

import android.os.Bundle;
import android.os.Environment;

import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;

import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;



import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class GenerateCertificate extends AppCompatActivity {
TextView ids;
    TextView name;
    TextView date;
    String newString;
    private Button btn,change;
    private RelativeLayout linearLayout;
    private TimerDialog timerDialog;
    private Bitmap bitmap;
    String dirpath;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
        }

        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate_certificate);
        ids = findViewById(R.id.certificate_ID);
        name = findViewById(R.id.name);
        date = findViewById(R.id.date);
        btn = findViewById(R.id.btn);
        change = findViewById(R.id.btn_change_input);
        linearLayout = findViewById(R.id.llPdf);
        timerDialog = new TimerDialog(this);

        ids.setText(timerDialog.generateProjectID());
        name.setText(getIntent().getStringExtra("name"));
        System.out.println("the value of name= " + name);
        date.setText(getIntent().getStringExtra("date"));

        //generate PDF
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d ( "size", linearLayout.getWidth () + " " + linearLayout.getHeight () );
                bitmap = loadBitmapFromView ( linearLayout, linearLayout.getWidth (), linearLayout.getHeight () );
                createPdf ();
            }
        });
        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timerDialog.timerDialog();
            }
        });
    }
    private void createPdf() {
        DisplayMetrics displayMetrics = new DisplayMetrics ();
        this.getWindowManager ().getDefaultDisplay ().getMetrics ( displayMetrics );
        float height = displayMetrics.heightPixels;
        float width = displayMetrics.widthPixels;

        int convertHeight = (int) height,
                convertWidth = (int) width;

        PdfDocument document = new PdfDocument ();
        PdfDocument.PageInfo pageInfo = new PdfDocument.PageInfo.Builder ( convertWidth, convertHeight, 1 ).create ();
        PdfDocument.Page page = document.startPage ( pageInfo );

        Canvas canvas = page.getCanvas ();
        Paint paint = new Paint();
        canvas.drawPaint ( paint );
        bitmap = Bitmap.createScaledBitmap ( bitmap, convertWidth, convertHeight, true );
        canvas.drawBitmap ( bitmap, 0, 0, null );
        document.finishPage ( page );

        Calendar instance = Calendar.getInstance ();
        String format = new SimpleDateFormat( "MM/dd/yyyy", Locale.getDefault () ).format ( instance.getTime () );
        String format2 = new SimpleDateFormat ( "HH:mm:ss", Locale.getDefault () ).format ( instance.getTime () );
        String[] split = format.split ( "/" );
        String[] split2 = format2.split ( ":" );
        String str = (split[0] + split[1] + split[2]) + (split2[0] + split2[1] + split2[2]) + "_course code";
        File path = null;
            path=Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS) ;
        String targetPdf = path+"/"+ str + ".pdf";
        File filepath = new File ( targetPdf );
        try {
            document.writeTo (Files.newOutputStream(filepath.toPath()));
        } catch (IOException e) {
            e.printStackTrace ();
            Toast.makeText ( this, "something want wrong try again" + e.toString (), Toast.LENGTH_SHORT ).show ();
        }
        //close document
        document.close ();
        //progress bar
        ProgressDialog progressDialog;
        progressDialog = new ProgressDialog( this );
        progressDialog.setMessage ( "Saving..." + targetPdf );
        progressDialog.show ();

        new Handler().postDelayed (new Runnable () {
            @Override
            public void run() {
                progressDialog.cancel ();
            }
        }, 5000 );
    }
    private Bitmap loadBitmapFromView(RelativeLayout linearLayout, int width, int height) {
        bitmap = Bitmap.createBitmap ( width, height, Bitmap.Config.ARGB_8888 );
        Canvas canvas = new Canvas ( bitmap );
        linearLayout.draw ( canvas );
        return bitmap;
    }
}