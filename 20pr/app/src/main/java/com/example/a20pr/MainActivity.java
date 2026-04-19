package com.example.a20pr;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.bluetooth.*;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);

        TextView t = findViewById(R.id.tv);
        BluetoothAdapter ba = BluetoothAdapter.getDefaultAdapter();


        findViewById(R.id.btOn).setOnClickListener(v -> {
            try { startActivity(new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE)); }
            catch (Exception e) { startActivity(new Intent(Settings.ACTION_BLUETOOTH_SETTINGS)); }
        });


        findViewById(R.id.btOff).setOnClickListener(v -> startActivity(new Intent(Settings.ACTION_BLUETOOTH_SETTINGS)));


        findViewById(R.id.wfOn).setOnClickListener(v -> startActivity(new Intent(Settings.Panel.ACTION_WIFI)));
        findViewById(R.id.wfOff).setOnClickListener(v -> startActivity(new Intent(Settings.Panel.ACTION_WIFI)));


        findViewById(R.id.list).setOnClickListener(v -> {
            try {
                String s = "Paired Devices:\n";
                for(BluetoothDevice d : ba.getBondedDevices()) s += d.getName() + "\n";
                t.setText(s);
            } catch (SecurityException e) { t.setText("Go to Phone Settings -> Apps -> Allow Nearby Devices!"); }
        });
    }
}