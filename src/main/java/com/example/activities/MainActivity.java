package com.example.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;

import com.example.linearlayoutpractice.R;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    float a = 0, b = 0;
    boolean nextOp = false, wait = false, end = false;
    enum operator {add, minus, times, div};
    operator curOp;

    public static String removeLastCharacter(String str) {
        String result = null;
        if ((str != null) && (str.length() > 0)) {
            result = str.substring(0, str.length() - 1);
        }
        return result;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);

        findViewById(R.id.button0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textView.getText().toString().equals("0") || end) {
                    textView.setText("0");
                    textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
                    textView.setTextColor(Color.GREEN);
                    textView.setTypeface(null, Typeface.ITALIC);
                    end = false;
                }
                else textView.setText(textView.getText() + "0");
            }
        });

        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textView.getText().toString().equals("0") || end) {
                    textView.setText("1");
                    end = false;
                }
                else textView.setText(textView.getText() + "1");
            }
        });

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textView.getText().toString().equals("0") || end) {
                    textView.setText("2");
                    end = false;
                }
                else textView.setText(textView.getText() + "2");
            }
        });

        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textView.getText().toString().equals("0") || end) {
                    textView.setText("3");
                    end = false;
                }
                else textView.setText(textView.getText() + "3");
            }
        });

        findViewById(R.id.button4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textView.getText().toString().equals("0") || end) {
                    textView.setText("4");
                    end = false;
                }
                else textView.setText(textView.getText() + "4");
            }
        });

        findViewById(R.id.button5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textView.getText().toString().equals("0") || end) {
                    textView.setText("5");
                    end = false;
                }
                else textView.setText(textView.getText() + "5");
            }
        });

        findViewById(R.id.button6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textView.getText().toString().equals("0") || end) {
                    textView.setText("6");
                    end = false;
                }
                else textView.setText(textView.getText() + "6");
            }
        });

        findViewById(R.id.button7).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textView.getText().toString().equals("0") || end) {
                    textView.setText("7");
                    end = false;
                }
                else textView.setText(textView.getText() + "7");
            }
        });

        findViewById(R.id.button8).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textView.getText().toString().equals("0") || end) {
                    textView.setText("8");
                    end = false;
                }
                else textView.setText(textView.getText() + "8");
            }
        });

        findViewById(R.id.button9).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textView.getText().toString().equals("0") || end) {
                    textView.setText("9");
                    end = false;
                }
                else textView.setText(textView.getText() + "9");
            }
        });

        findViewById(R.id.buttonBS).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textView.getText().length() <= 1) {
                    textView.setText("0");
                }
                else textView.setText(removeLastCharacter(textView.getText().toString()));
            }
        });

        findViewById(R.id.buttonC).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("0");
            }
        });

        findViewById(R.id.buttonCE).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nextOp) {
                    b = 0;
                }
                else {
                    a = 0;
                }
                textView.setText("0");
            }
        });

        findViewById(R.id.buttonPoint).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(textView.getText() + ".");
            }
        });

        findViewById(R.id.buttonCombine).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float r = 0 - Float.parseFloat(textView.getText().toString());
                textView.setText(String.valueOf(r));
            }
        });

        findViewById(R.id.buttonAdd).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a = Float.parseFloat(textView.getText().toString());
                textView.setText("0");
                curOp = operator.add;
                nextOp = true;
            }
        });

        findViewById(R.id.buttonMinus).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a = Float.parseFloat(textView.getText().toString());
                textView.setText("0");
                curOp = operator.minus;
                nextOp = true;
            }
        });

        findViewById(R.id.buttonTimes).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a = Float.parseFloat(textView.getText().toString());
                textView.setText("0");
                curOp = operator.times;
                nextOp = true;
            }
        });

        findViewById(R.id.buttonDiv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a = Float.parseFloat(textView.getText().toString());
                textView.setText("0");
                curOp = operator.div;
                nextOp = true;
            }
        });

        findViewById(R.id.buttonEqual).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b = Float.parseFloat(textView.getText().toString());
                textView.setText("0");
                if (curOp == operator.add) {
                    float c = a + b;
                    textView.setText(String.valueOf(c));
                }
                else if (curOp == operator.minus) {
                    float c = a - b;
                    textView.setText(String.valueOf(c));
                }
                else if (curOp == operator.times) {
                    float c = a * b;
                    textView.setText(String.valueOf(c));
                }
                else if (curOp == operator.div) {
                    if (b == 0) textView.setText("Math ERROR");
                    else {
                        float c = a / b;
                        textView.setText(String.valueOf(c));
                    }
                }
                else {
                    textView.setText(String.valueOf(a));
                }
                end = true;
                nextOp = false;
            }
        });
    }
}