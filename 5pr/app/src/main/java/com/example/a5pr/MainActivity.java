package com.example.a5pr;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    ImageButton imageButton;
    ToggleButton toggleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        imageButton = findViewById(R.id.imageButton);
        toggleButton = findViewById(R.id.toggleButton);

        // ImageButton Click
        imageButton.setOnClickListener(v ->
                Toast.makeText(MainActivity.this,
                        "Image Button Pressed",
                        Toast.LENGTH_SHORT).show()
        );

        // ToggleButton Change
        toggleButton.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                textView.setText("Toggle is ON");
            } else {
                textView.setText("Toggle is OFF");
            }
        });
    }

    // Button Click
    public void showMessage(View v) {
        Toast.makeText(this, "Button Clicked!", Toast.LENGTH_SHORT).show();
    }
}