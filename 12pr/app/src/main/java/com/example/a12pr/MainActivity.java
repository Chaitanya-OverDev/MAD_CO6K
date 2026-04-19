package com.example.a12pr;

import android.app.*;
import android.os.*;
import android.widget.*;

public class MainActivity extends Activity {

    TextView t;
    double a,b;
    String op="";

    protected void onCreate(Bundle b1){
        super.onCreate(b1);
        setContentView(R.layout.activity_main);

        t=findViewById(R.id.t);
        GridLayout g=findViewById(R.id.g);

        for(int i=0;i<g.getChildCount();i++){
            Button bt=(Button)g.getChildAt(i);

            bt.setOnClickListener(v->{
                String s=bt.getText().toString();

                try{

                    if("+-*/".contains(s)){
                        a=Double.parseDouble(t.getText()+"");
                        op=s;
                        t.setText("");
                    }

                    else if(s.equals("=")){
                        b=Double.parseDouble(t.getText()+"");
                        double r=0;

                        if(op.equals("+")) r=a+b;
                        if(op.equals("-")) r=a-b;
                        if(op.equals("*")) r=a*b;

                        if(op.equals("/")){
                            if(b==0){ t.setText("Error"); return; }
                            r=a/b;
                        }

                        t.setText(r+"");
                    }

                    else t.append(s);

                }catch(Exception e){
                    t.setText("Error");
                }

            });
        }
    }
}