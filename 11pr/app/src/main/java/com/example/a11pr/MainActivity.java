package com.example.a11pr;


import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    GridView g;
    ListView l;

    String[] t = {"B1","B2","B3","B4"};
    int[] img = {R.drawable.b1,R.drawable.b2,R.drawable.b3,R.drawable.b4};

    String[] n = {"Akash","Bolini","Chris","Dom"};
    String[] d = {"1 Jan","2 Jan","3 Jan","4 Jan"};

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);

        g = findViewById(R.id.g);
        l = findViewById(R.id.l);

        g.setAdapter(new A());
        l.setAdapter(new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_2,
                android.R.id.text1, n));

        l.setOnItemClickListener((p,v,i,id)->
                Toast.makeText(this,
                        n[i]+" "+d[i],
                        Toast.LENGTH_SHORT).show());
    }

    class A extends BaseAdapter {
        public int getCount(){ return t.length; }
        public Object getItem(int i){ return null; }
        public long getItemId(int i){ return 0; }

        public View getView(int i, View v, android.view.ViewGroup p) {
            v = getLayoutInflater().inflate(R.layout.g, null);

            ImageView im = v.findViewById(R.id.i);
            TextView tx = v.findViewById(R.id.t);

            im.setImageResource(img[i]);
            tx.setText(t[i]);

            return v;
        }
    }
}