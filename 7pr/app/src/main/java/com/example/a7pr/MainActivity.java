package com.example.a7pr;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends Activity {
    ProgressBar p1, p2;
    Button b1, b2;
    TextView tv;

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);

        p1 = findViewById(R.id.p1);
        p2 = findViewById(R.id.p2);
        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        tv = findViewById(R.id.tv);

        b1.setOnClickListener(x -> new T().execute(p1.getProgress()));

        b2.setOnClickListener(x -> p1.setProgress(p1.getProgress() + 10));
    }

    class T extends AsyncTask<Integer, Integer, Void> {
        @Override
        protected void onPreExecute() {
            p2.setVisibility(View.VISIBLE);
            tv.setText("Loading...");
        }

        @Override
        protected Void doInBackground(Integer... p) {
            int start = p[0];
            for (int i = start; i <= 100; i += 10) {
                publishProgress(i);
                try { Thread.sleep(500); } catch (Exception e) {}
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... val) {
            p1.setProgress(val[0]);
        }

        @Override
        protected void onPostExecute(Void r) {
            p2.setVisibility(View.GONE);
            tv.setText("Done");
        }
    }
}