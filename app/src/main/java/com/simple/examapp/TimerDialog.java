package com.simple.examapp;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Random;

public class TimerDialog {

    private Context mContext;
    private Dialog TimerDialog;

    private TextView issueDate;
    private EditText editText;
   public static String value;
    public static String getname;
    public TimerDialog(Context mContext) {
        this.mContext = mContext;
    }

    public void timerDialog(){

        TimerDialog = new Dialog(mContext);
        TimerDialog.setContentView(R.layout.timer_dialog);

        issueDate = (TextView) TimerDialog.findViewById(R.id.entry_dateET);
        editText=(EditText) TimerDialog.findViewById(R.id.nameContent);
        value = editText.getText().toString();
        final Button btTimer = (Button) TimerDialog.findViewById(R.id.bt_timer);

        issueDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar c = Calendar.getInstance();
                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);

                // on below line we are creating a variable for date picker dialog.
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        // on below line we are passing context.
                        mContext,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // on below line we are setting date to our text view.
                                issueDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                            }
                        },
                        // on below line we are passing year,
                        // month and day for selected date in our date picker.
                        year, month, day);
                // at last we are calling show to
                // display our date picker dialog.
                datePickerDialog.show();
            }
        });

        btTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("the value of date = "+issueDate.getText().toString());
                TimerDialog.dismiss();
                Intent intent = new Intent(mContext, GenerateCertificate.class);
                String date = issueDate.getText().toString();
                intent.putExtra("date", date);
                String name = editText.getText().toString();
                intent.putExtra("name", name);
                mContext.startActivity(intent);
            }
        });

        TimerDialog.show();
        TimerDialog.setCancelable(false);
        TimerDialog.setCanceledOnTouchOutside(false);
        TimerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

    }
    public String generateProjectID() {
        StringBuilder sb = new StringBuilder(7);
        String DATA = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random RANDOM = new Random();
        for (int i = 0; i < 7; i++) {
            sb.append(DATA.charAt(RANDOM.nextInt(DATA.length())));
        }

        return sb.toString();
    }

}
