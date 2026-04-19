package com.example.sub16;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle s) {
        super.onCreate(s);
        setContentView(R.layout.activity_main);

        EditText e = findViewById(R.id.e);
        Button b = findViewById(R.id.b);

        b.setOnClickListener(v -> {
            String u = e.getText().toString();
            if (!u.startsWith("http")) {
                u = "http://" + u;
            }
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(u)));
        });
    }
}