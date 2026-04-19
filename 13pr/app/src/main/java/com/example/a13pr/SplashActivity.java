package com.example.a13pr; // REPLACE THIS WITH YOUR ACTUAL PACKAGE NAME!

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash); // Matches the XML below

        // 3-second delay (3000 milliseconds)
        new Handler().postDelayed(() -> {
            Intent intent = new Intent(SplashActivity.this, MainActivity.class);
            startActivity(intent);
            finish(); // Closes the splash screen
        }, 3000);
    }
}