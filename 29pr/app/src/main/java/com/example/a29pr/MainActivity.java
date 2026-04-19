package com.example.a29pr; 

import android.os.Bundle;
import android.view.*;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.*;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    DrawerLayout dl;
    ActionBarDrawerToggle t;

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);

        dl = findViewById(R.id.dl);
      
        t = new ActionBarDrawerToggle(this, dl, R.string.app_name, R.string.app_name);
        dl.addDrawerListener(t);
        t.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NavigationView nv = findViewById(R.id.nv);
        nv.setNavigationItemSelectedListener(item -> {
           
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fl, new MyFrag(item.getTitle().toString())).commit();
            dl.closeDrawer(GravityCompat.START);
            return true;
        });
    }

    
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (t.onOptionsItemSelected(item)) return true;
        return super.onOptionsItemSelected(item);
    }
}

class MyFrag extends Fragment {
    String name;
    public MyFrag(String n) { name = n; } 

    @Override
    public View onCreateView(LayoutInflater i, ViewGroup c, Bundle b) {
        TextView tv = new TextView(getActivity());
        tv.setText(name + " Loaded!");
        tv.setTextSize(30f);
        tv.setGravity(Gravity.CENTER);
        return tv;
    }
}