package com.example.sub17;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle s) {
        super.onCreate(s);
        setContentView(R.layout.activity_main);

        Button b = findViewById(R.id.b);

        b.setOnClickListener(v -> {
            startActivity(new Intent(Intent.ACTION_DIAL));
        });
    }
}