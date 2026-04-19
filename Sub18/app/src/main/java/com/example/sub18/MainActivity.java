package com.example.sub18;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle s) {
        super.onCreate(s);
        setContentView(R.layout.activity_main);

        ImageView i = findViewById(R.id.i);
        Button b = findViewById(R.id.b);

        ActivityResultLauncher<Void> l = registerForActivityResult(
                new ActivityResultContracts.TakePicturePreview(),
                r -> i.setImageBitmap(r)
        );

        b.setOnClickListener(v -> l.launch(null));
    }
}