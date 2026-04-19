package com.example.a4pr;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText e;
    TextView t;

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);

        e = findViewById(R.id.editText);
        t = findViewById(R.id.textView);
    }

    public void showText(View v) {
        t.setText("hello " + e.getText().toString());
    }
}