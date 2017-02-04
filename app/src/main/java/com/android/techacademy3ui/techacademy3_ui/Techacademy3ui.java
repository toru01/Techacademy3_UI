package com.android.techacademy3ui.techacademy3_ui;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.DatePicker;

public class Techacademy3ui extends AppCompatActivity implements View.OnClickListener {
    TextView mTextView;
    int p_hour = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_techacademy3ui);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);

        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(this);

        mTextView = (TextView) findViewById(R.id.textView);

    }
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button3) {
            showTimePickerDialog();
        } else if (v.getId() == R.id.button1) {
            //mTextView.setText(mEditText.getText().toString());
            if (p_hour >= 2 && p_hour < 10) {
                mTextView.setText("おはよう");
            } else if (p_hour >= 10 && p_hour < 18) {
                mTextView.setText("こんにちは");
            } else {
                mTextView.setText("こんばんは");
            }}
    }

    private void showTimePickerDialog() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        p_hour = hourOfDay;
                        Log.d("UI-PARTS", String.valueOf(hourOfDay) + ":" + String.valueOf(minute));
                    }
                },
                0, // 初期値（時間）
                0,  // 初期値（分）
                true);
        timePickerDialog.show();
    }


}
