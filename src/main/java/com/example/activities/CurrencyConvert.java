package com.example.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.linearlayoutpractice.R;

import java.util.ArrayList;

public class CurrencyConvert extends AppCompatActivity {

    Spinner spUSD, spUnit;
    ArrayAdapter<String> arrayAdapter;
    ArrayList<String> currencyData;
    ArrayList<Double> currencyRate;
    EditText editTxt;
    TextView txtResult;
    double curRate1, curRate2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency_convert);

        addControl();
        txtResult.setText("0");

        spUSD.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                curRate1 = currencyRate.get(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spUnit.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                curRate2 = currencyRate.get(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        editTxt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.toString().trim().length() == 0) {
                    txtResult.setText("0");
                    return;
                }

                if (s.toString().charAt(s.toString().length() - 1) != '.') {
                    double result = ConvertCurrency(curRate1, curRate2, s.toString());
                    txtResult.setText(String.valueOf(result));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private double ConvertCurrency(double curRate1, double curRate2, String text){
        double t2n = Double.parseDouble(text);
        t2n = t2n / curRate1 * curRate2;
        return t2n;
    }

    private void addControl(){
        spUSD = findViewById(R.id.spUSD);
        spUnit = findViewById(R.id.spUnit);
        editTxt = findViewById(R.id.editTxt);
        txtResult = findViewById(R.id.txtResult);

        currencyData = new ArrayList<String>();
        currencyData.add("USD"); currencyData.add("VND"); currencyData.add("EUR");
        currencyData.add("THB"); currencyData.add("WON"); currencyData.add("YEN");
        currencyData.add("AOA"); currencyData.add("RUB"); currencyData.add("LAK"); currencyData.add("KHR");

        arrayAdapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, currencyData);

        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spUSD.setAdapter(arrayAdapter);
        spUnit.setAdapter(arrayAdapter);

        currencyRate = new ArrayList<Double>();
        currencyRate.add(1.0); currencyRate.add(23274.0); currencyRate.add(0.844);
        currencyRate.add(30.445); currencyRate.add(1.114); currencyRate.add(104.994);
        currencyRate.add(659.009); currencyRate.add(76.417); currencyRate.add(9267.34); currencyRate.add(4089.13);
    }


}