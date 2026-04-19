package com.example.a9pr;

import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText n,e,p;
    CheckBox c;
    Button b;

    @Override
    protected void onCreate(Bundle s){
        super.onCreate(s);
        setContentView(R.layout.activity_main);

        n=findViewById(R.id.n);
        e=findViewById(R.id.e);
        p=findViewById(R.id.p);
        c=findViewById(R.id.c);
        b=findViewById(R.id.b);

        b.setOnClickListener(v->{

            if(!c.isChecked()){
                Toast.makeText(this,"Accept Terms First",Toast.LENGTH_SHORT).show();
                return;
            }

            Toast.makeText(this,"Registered Successfully",Toast.LENGTH_SHORT).show();

        });

    }
}