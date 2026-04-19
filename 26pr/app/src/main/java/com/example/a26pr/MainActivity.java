package com.example.a26pr; // CHANGE THIS TO YOUR ACTUAL PACKAGE NAME

import android.content.*;
import android.os.*;
import android.provider.Telephony;
import android.telephony.*;
import android.widget.*;
import androidx.appcompat.app.*;

public class MainActivity extends AppCompatActivity {
    TextView t;

    // 1. Receiver to catch incoming SMS
    BroadcastReceiver br = new BroadcastReceiver() {
        public void onReceive(Context c, Intent i) {
            for (SmsMessage s : Telephony.Sms.Intents.getMessagesFromIntent(i)) {
                t.setText("Received From: " + s.getOriginatingAddress() + "\nMsg: " + s.getMessageBody());
            }
        }
    };

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);

        // Request SMS permissions on startup
        requestPermissions(new String[]{"android.permission.SEND_SMS", "android.permission.RECEIVE_SMS"}, 1);

        EditText p = findViewById(R.id.p); // Phone
        EditText m = findViewById(R.id.m); // Message
        t = findViewById(R.id.t);          // Text Output

        // Register Receiver dynamically
        registerReceiver(br, new IntentFilter("android.provider.Telephony.SMS_RECEIVED"));

        // 2. Send SMS Button (Includes Validation!)
        findViewById(R.id.b).setOnClickListener(v -> {
            String num = p.getText().toString().trim();
            String msg = m.getText().toString().trim();

            // Validation (Answers Q2)
            if (num.length() < 10 || msg.isEmpty()) {
                Toast.makeText(this, "Invalid Phone or Empty Message!", Toast.LENGTH_SHORT).show();
                return;
            }

            // Send Logic
            try {
                SmsManager.getDefault().sendTextMessage(num, null, msg, null, null);
                Toast.makeText(this, "SMS Sent!", Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                Toast.makeText(this, "Failed! Did you grant permissions?", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(br); // Prevent memory leaks
    }
}