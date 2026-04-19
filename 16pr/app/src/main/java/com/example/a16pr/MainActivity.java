package com.example.a16pr;

import android.app.DatePickerDialog;
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

            Calendar c = Calendar.getInstance(); // current date

            int y = c.get(Calendar.YEAR);
            int m = c.get(Calendar.MONTH);
            int d = c.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog dp = new DatePickerDialog(this,
                    (view, y1, m1, d1) -> t.setText(d1 + "/" + (m1+1) + "/" + y1),
                    y, m, d);

            dp.getDatePicker().setMinDate(System.currentTimeMillis()); // no past dates

            dp.show();
        });
    }
}