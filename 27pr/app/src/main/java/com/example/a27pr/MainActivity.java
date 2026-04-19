package com.example.a27pr; // CHANGE THIS TO YOUR ACTUAL PACKAGE NAME

import android.content.*;
import android.os.*;
import android.widget.*;
import androidx.appcompat.app.*;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);

        EditText t = findViewById(R.id.t); // To
        EditText s = findViewById(R.id.s); // Subject
        EditText m = findViewById(R.id.m); // Message

        findViewById(R.id.b).setOnClickListener(v -> {
            Intent i = new Intent(Intent.ACTION_SEND);
            i.setType("message/rfc822"); // Forces only Email Apps to open

            // Adding the data to the Intent
            i.putExtra(Intent.EXTRA_EMAIL, new String[]{t.getText().toString().trim()});
            i.putExtra(Intent.EXTRA_SUBJECT, s.getText().toString());
            i.putExtra(Intent.EXTRA_TEXT, m.getText().toString());

            try {
                // Opens the app chooser so user can pick Gmail, Yahoo, etc.
                startActivity(Intent.createChooser(i, "Choose an Email App"));
            } catch (Exception e) {
                Toast.makeText(this, "No Email App Installed!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}