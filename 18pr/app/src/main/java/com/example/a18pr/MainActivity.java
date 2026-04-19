package com.example.a18pr;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.*;

public class MainActivity extends Activity {
    EditText u, p;
    Button b;

    @Override
    protected void onCreate(Bundle bd) {
        super.onCreate(bd);
        setContentView(R.layout.activity_main);

        u = findViewById(R.id.u);
        p = findViewById(R.id.p);
        b = findViewById(R.id.b);

        b.setOnClickListener(v -> {
            Intent i = new Intent(this, WelcomeActivity.class);
            i.putExtra("user", u.getText().toString());
            startActivity(i);
        });
    }
}