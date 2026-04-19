package com.example.a18pr;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class WelcomeActivity extends Activity {
    TextView t;

    @Override
    protected void onCreate(Bundle bd) {
        super.onCreate(bd);
        setContentView(R.layout.activity_welcome);

        t = findViewById(R.id.t);
        String u = getIntent().getStringExtra("user");
        t.setText("Welcome " + u);
    }
}