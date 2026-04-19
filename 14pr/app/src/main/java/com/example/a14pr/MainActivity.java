package com.example.a14pr;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends Activity {
    Spinner sp;
    EditText et;
    Button btn;
    TextView tv;
    String[] opt = {"C to F", "F to C", "USD to EUR", "Liters to Gallons", "Gallons to Liters"};

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);

        sp = findViewById(R.id.sp);
        et = findViewById(R.id.et);
        btn = findViewById(R.id.btn);
        tv = findViewById(R.id.tv);

        sp.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, opt));

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> p, View v, int i, long id) {
                et.setHint("Enter " + opt[i].split(" ")[0]);
                tv.setText("");
            }
            public void onNothingSelected(AdapterView<?> p) {}
        });

        btn.setOnClickListener(v -> {
            String s = et.getText().toString();
            if (s.isEmpty()) {
                et.setError("Value required");
                return;
            }
            try {
                double val = Double.parseDouble(s);
                double res = 0;
                int i = sp.getSelectedItemPosition();

                if (i == 0) res = (val * 9/5) + 32;
                else if (i == 1) res = (val - 32) * 5/9;
                else if (i == 2) res = val * 0.92;
                else if (i == 3) res = val * 0.264172;
                else if (i == 4) res = val / 0.264172;

                tv.setText("Result: " + String.format("%.2f", res));
            } catch (Exception e) {
                et.setError("Invalid number");
            }
        });
    }
}