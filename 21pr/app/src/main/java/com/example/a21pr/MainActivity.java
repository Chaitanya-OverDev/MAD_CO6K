package com.example.a21pr;

import android.content.*;
import android.media.*;
import android.os.*;
import android.provider.Settings;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    AudioManager am;

    
    BroadcastReceiver br = new BroadcastReceiver() {
        public void onReceive(Context c, Intent i) {
            TextView t = findViewById(R.id.tv);
            if (i.getAction().equals(Intent.ACTION_AIRPLANE_MODE_CHANGED)) {
                t.setText("Airplane Mode: " + (i.getBooleanExtra("state", false) ? "ON" : "OFF"));
            } else {
                t.setText("Ringer Mode Changed System-Wide!");
            }
        }
    };

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);
        am = (AudioManager) getSystemService(AUDIO_SERVICE);

        
        IntentFilter f = new IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        f.addAction(AudioManager.RINGER_MODE_CHANGED_ACTION);
        registerReceiver(br, f);

        
        findViewById(R.id.bSilent).setOnClickListener(v -> setMode(AudioManager.RINGER_MODE_SILENT));
        findViewById(R.id.bLoud).setOnClickListener(v -> setMode(AudioManager.RINGER_MODE_NORMAL));
    }

    
    void setMode(int m) {
        try {
            am.setRingerMode(m);
        } catch (SecurityException e) {
            
            startActivity(new Intent(Settings.ACTION_NOTIFICATION_POLICY_ACCESS_SETTINGS));
            Toast.makeText(this, "Please Allow Do Not Disturb Access", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(br); 
    }
}