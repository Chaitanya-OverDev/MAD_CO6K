package com.example.sub20;

import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private void t(String m) {
        Toast.makeText(this, m, 0).show();
    }

    @Override
    protected void onCreate(Bundle s) {
        super.onCreate(s);
        setContentView(R.layout.activity_main);
        t("onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        t("onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        t("onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        t("onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        t("onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        t("onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        t("onRestart");
    }
}