package com.example.a15pr;

import android.app.Activity;
import android.content.Context;
import android.os.*;
import android.widget.*;

public class MainActivity extends Activity {
    EditText e;
    TextView t;
    Button b1, b2;
    CountDownTimer c;
    Vibrator v;

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);

        e = findViewById(R.id.e);
        t = findViewById(R.id.t);
        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        b1.setOnClickListener(x -> {
            if (c != null) c.cancel();
            b2.setEnabled(false);

            String s = e.getText().toString();
            long ms = (s.isEmpty() ? 10 : Long.parseLong(s)) * 1000;

            c = new CountDownTimer(ms, 1000) {
                public void onTick(long m) {
                    t.setText(String.valueOf(m / 1000));
                }
                public void onFinish() {
                    t.setText("Time’s up!");
                    b2.setEnabled(true);
                    try {
                        if (v != null && v.hasVibrator()) {
                            if (Build.VERSION.SDK_INT >= 26) {
                                v.vibrate(VibrationEffect.createOneShot(500, VibrationEffect.DEFAULT_AMPLITUDE));
                            } else {
                                v.vibrate(500);
                            }
                        }
                    } catch (Exception ex) {}
                }
            }.start();
        });
    }
}