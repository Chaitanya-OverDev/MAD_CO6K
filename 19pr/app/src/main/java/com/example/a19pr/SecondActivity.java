package com.example.a19pr;

import android.app.*;
import android.os.*;
import android.widget.*;

public class SecondActivity extends Activity {
    protected void onCreate(Bundle b){
        super.onCreate(b);
        setContentView(R.layout.activity_second);

        ((TextView)findViewById(R.id.t))
                .setText(getIntent().getStringExtra("k"));
    }
}