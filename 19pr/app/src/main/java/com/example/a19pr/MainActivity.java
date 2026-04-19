package com.example.a19pr;


import android.app.*;
import android.os.*;
import android.content.*;

public class MainActivity extends Activity {
    protected void onCreate(Bundle b){
        super.onCreate(b);
        setContentView(R.layout.activity_main);

        findViewById(R.id.b).setOnClickListener(v->{
            Intent i=new Intent(this,SecondActivity.class);
            i.putExtra("k","hello");
            startActivity(i);
        });
    }
}