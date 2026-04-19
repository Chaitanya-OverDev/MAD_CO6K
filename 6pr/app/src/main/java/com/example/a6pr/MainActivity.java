package com.example.a6pr;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.*;

public class MainActivity extends Activity {
    CheckBox c1, c2, c3;
    RadioButton r1, r2;
    RadioGroup rg;
    Button b1, b2;
    TextView tv;

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);

        c1 = findViewById(R.id.c1);
        c2 = findViewById(R.id.c2);
        c3 = findViewById(R.id.c3);
        r1 = findViewById(R.id.r1);
        r2 = findViewById(R.id.r2);
        rg = findViewById(R.id.rg);
        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        tv = findViewById(R.id.tv);

        b1.setOnClickListener(v -> {
            int c = 0;
            String s = "";
            if(c1.isChecked()){ c++; s += c1.getText() + " "; }
            if(c2.isChecked()){ c++; s += c2.getText() + " "; }
            if(c3.isChecked()){ c++; s += c3.getText() + " "; }
            tv.setText("Hobbies: " + s + "\nCount: " + c);
        });

        b2.setOnClickListener(v -> {
            c1.setChecked(false);
            c2.setChecked(false);
            c3.setChecked(false);
            rg.clearCheck();
            r1.setTextColor(Color.BLACK);
            r2.setTextColor(Color.BLACK);
            tv.setText("Result");
        });

        rg.setOnCheckedChangeListener((g, i) -> {
            r1.setTextColor(Color.BLACK);
            r2.setTextColor(Color.BLACK);
            if(i != -1){
                RadioButton r = findViewById(i);
                r.setTextColor(Color.RED);
            }
        });
    }
}