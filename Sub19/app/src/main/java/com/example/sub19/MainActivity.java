package com.example.sub19;

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

        EditText n = findViewById(R.id.n);
        EditText m = findViewById(R.id.m);
        Button b = findViewById(R.id.b);

        b.setOnClickListener(v -> {
            Intent i = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:" + n.getText().toString()));
            i.putExtra("sms_body", m.getText().toString());
            startActivity(i);
        });
    }
}