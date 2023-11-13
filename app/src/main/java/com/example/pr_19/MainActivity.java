package com.example.pr_19;


import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.net.CookieHandler;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView timePick;
    Button btnTime, btnDate;
    Calendar GateAndTime=Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timePick = findViewById(R.id.time_pick);
        btnDate = findViewById(R.id.button_date);
        btnTime = findViewById(R.id.button_time);

        btnDate.setOnClickListener(this);
        btnTime.setOnClickListener(this);

        setInitialDateAndTime();
    }

    public void showCustom(View view)
    {
        CustomDialogFragment frag =  new CustomDialogFragment(this);
        frag.show(getSupportFragmentManager(),"custom");
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.button_date) {
            new DatePickerDialog(MainActivity.this, dateSetListener,
                    GateAndTime.get(Calendar.YEAR),
                    GateAndTime.get(Calendar.MONTH),
                    GateAndTime.get(Calendar.DAY_OF_MONTH))
                    .show();
        }

        if(view.getId()==R.id.button_time) {
            new TimePickerDialog(MainActivity.this, timeSetListener,
                    GateAndTime.get(Calendar.HOUR_OF_DAY),
                    GateAndTime.get(Calendar.MINUTE), true)
                    .show();
        }

    }
    private DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            GateAndTime.set(Calendar.YEAR, year);
            GateAndTime.set(Calendar.MONTH, month);
            GateAndTime.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            setInitialDateAndTime();
        }
    };
    public void setInitialDateAndTime() {
        timePick.setText(DateUtils.formatDateTime(this,
                GateAndTime.getTimeInMillis(),
                DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_SHOW_YEAR
                        | DateUtils.FORMAT_SHOW_TIME));
    }

    private TimePickerDialog.OnTimeSetListener timeSetListener = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            GateAndTime.set(Calendar.HOUR_OF_DAY, hourOfDay);
            GateAndTime.set(Calendar.MINUTE, minute);
            setInitialDateAndTime();
        }
    };

}