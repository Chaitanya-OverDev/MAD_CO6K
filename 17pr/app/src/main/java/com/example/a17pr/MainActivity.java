package com.example.a17pr;


import android.app.TimePickerDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button b;
    TextView t;

    @Override
    protected void onCreate(Bundle s) {
        super.onCreate(s);
        setContentView(R.layout.activity_main);

        b = findViewById(R.id.b);
        t = findViewById(R.id.t);

        b.setOnClickListener(v -> {

            Calendar c = Calendar.getInstance(); // current time

            int h = c.get(Calendar.HOUR_OF_DAY);
            int m = c.get(Calendar.MINUTE);

            TimePickerDialog tp = new TimePickerDialog(this,
                    (view, h1, m1) -> t.setText(h1 + ":" + m1),
                    h, m, true); // true = 24-hour

            tp.show();
        });
    }
}