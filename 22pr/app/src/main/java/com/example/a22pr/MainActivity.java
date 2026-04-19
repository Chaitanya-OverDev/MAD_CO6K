package com.example.a22pr; 
import android.database.*;
import android.database.sqlite.*;
import android.os.*;
import android.widget.*;
import androidx.appcompat.app.*;

public class MainActivity extends AppCompatActivity {
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);

        EditText n = findViewById(R.id.n); 
        EditText e = findViewById(R.id.e); 
        TextView t = findViewById(R.id.t);

        
        db = openOrCreateDatabase("MyDb", MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS Reg(Name VARCHAR, Email VARCHAR);");

        
        findViewById(R.id.bIn).setOnClickListener(v -> {
            try {
                String name = n.getText().toString().trim();
                String email = e.getText().toString().trim();
                db.execSQL("INSERT INTO Reg VALUES('"+name+"','"+email+"');");
                Toast.makeText(this, "Inserted", Toast.LENGTH_SHORT).show();
            } catch (Exception ex) { Toast.makeText(this, "Error Insert", Toast.LENGTH_SHORT).show(); }
        });

        
        findViewById(R.id.bGet).setOnClickListener(v -> {
            Cursor c = db.rawQuery("SELECT * FROM Reg", null);
            if(c.getCount() == 0) { t.setText("No Data Found"); return; }
            StringBuilder sb = new StringBuilder();
            while(c.moveToNext()) {
                sb.append("Name: ").append(c.getString(0)).append("\nEmail: ").append(c.getString(1)).append("\n\n");
            }
            t.setText(sb.toString());
        });

        findViewById(R.id.bUp).setOnClickListener(v -> {
            try {
                String name = n.getText().toString().trim();
                String email = e.getText().toString().trim();
                db.execSQL("UPDATE Reg SET Email='"+email+"' WHERE Name='"+name+"';");
                Toast.makeText(this, "Updated", Toast.LENGTH_SHORT).show();
            } catch (Exception ex) { Toast.makeText(this, "Error Update", Toast.LENGTH_SHORT).show(); }
        });

       
        findViewById(R.id.bDel).setOnClickListener(v -> {
            try {
                String name = n.getText().toString().trim();
                db.execSQL("DELETE FROM Reg WHERE Name='"+name+"';");
                Toast.makeText(this, "Deleted", Toast.LENGTH_SHORT).show();
            } catch (Exception ex) { Toast.makeText(this, "Error Delete", Toast.LENGTH_SHORT).show(); }
        });
    }
}