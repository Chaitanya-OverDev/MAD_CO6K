package com.example.a8pr;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.*;

public class MainActivity extends Activity {
    EditText u, p;
    RadioGroup rg;
    CheckBox c;
    Button b;
    ProgressBar pb;

    @Override
    protected void onCreate(Bundle bd) {
        super.onCreate(bd);
        setContentView(R.layout.activity_main);

        u = findViewById(R.id.u);
        p = findViewById(R.id.p);
        rg = findViewById(R.id.rg);
        c = findViewById(R.id.c);
        b = findViewById(R.id.b);
        pb = findViewById(R.id.pb);

        TextWatcher tw = new TextWatcher() {
            public void beforeTextChanged(CharSequence s, int x, int y, int z) {}
            public void onTextChanged(CharSequence s, int x, int y, int z) {
                b.setEnabled(!u.getText().toString().trim().isEmpty() && !p.getText().toString().trim().isEmpty());
            }
            public void afterTextChanged(Editable s) {}
        };

        u.addTextChangedListener(tw);
        p.addTextChangedListener(tw);

        b.setOnClickListener(v -> {
            pb.setVisibility(View.VISIBLE);
            b.setEnabled(false);

            new Handler().postDelayed(() -> {
                pb.setVisibility(View.GONE);
                b.setEnabled(true);

                int i = rg.getCheckedRadioButtonId();
                String g = i != -1 ? ((RadioButton) findViewById(i)).getText().toString() : "None";
                String msg = "Welcome " + u.getText() + "\nGender: " + g + "\nRemember Me: " + c.isChecked();

                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_LONG).show();
            }, 2000);
        });
    }
}