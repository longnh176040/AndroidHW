package com.example.linearlayoutpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    EditText fname, lname, bday, address, email;
    DatePicker dp;
    RadioGroup gender;
    CheckBox agreeCheck;
    TextView err;

    boolean dpState = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        fname = findViewById(R.id.fnameText);
        lname = findViewById(R.id.lnameText);
        bday = findViewById(R.id.bdayText);
        address = findViewById(R.id.addressText);
        email = findViewById(R.id.emailText);
        dp = findViewById(R.id.datePicker);
        gender = findViewById(R.id.genderRat);
        agreeCheck = findViewById(R.id.agreeCheck);
        err = findViewById(R.id.errorText);

        findViewById(R.id.btnSelect).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!dpState) {
                    dp.setVisibility(v.VISIBLE);
                    dpState = true;
                } else {
                    bday.setText(dp.getDayOfMonth() + "/" + dp.getMonth() + "/" + dp.getYear());
                    dp.setVisibility(v.GONE);
                    dpState = false;
                }
            }
        });

        findViewById(R.id.btnReg).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (fname.getText().toString().trim().length() <= 0 || lname.getText().toString().trim().length() <= 0 ||
                        bday.getText().toString().trim().length() <= 0 || address.getText().toString().trim().length() <= 0 ||
                        email.getText().toString().trim().length() <= 0 || gender.getCheckedRadioButtonId() == -1 ||
                        !agreeCheck.isChecked()) {
                    err.setVisibility(v.VISIBLE);
                } else {
                    err.setVisibility(v.GONE);
                }
            }
        });
    }
}