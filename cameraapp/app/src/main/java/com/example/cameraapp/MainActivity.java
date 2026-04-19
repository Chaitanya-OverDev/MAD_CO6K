package com.example.cameraapp;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {

    VideoView videoView;
    Button btnRecord;
    Uri videoUri;


    ActivityResultLauncher<Intent> videoLauncher =
            registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {

                if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                    videoUri = result.getData().getData();

                    // Play recorded video
                    videoView.setVideoURI(videoUri);
                    MediaController controller = new MediaController(this);
                    controller.setAnchorView(videoView);
                    videoView.setMediaController(controller);
                    videoView.start();

                } else {
                    Toast.makeText(this, "Recording cancelled", Toast.LENGTH_SHORT).show();
                }
            });

    // Permission launcher
    ActivityResultLauncher<String[]> permissionLauncher =
            registerForActivityResult(new ActivityResultContracts.RequestMultiplePermissions(), result -> {

                boolean camera = Boolean.TRUE.equals(result.get(Manifest.permission.CAMERA));
                boolean audio = Boolean.TRUE.equals(result.get(Manifest.permission.RECORD_AUDIO));

                if (camera && audio) {
                    openCamera();
                } else {
                    Toast.makeText(this, "Permissions denied", Toast.LENGTH_SHORT).show();
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        videoView = findViewById(R.id.videoView);
        btnRecord = findViewById(R.id.btnRecord);

        btnRecord.setOnClickListener(v -> {

            if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                    == PackageManager.PERMISSION_GRANTED &&
                    ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO)
                            == PackageManager.PERMISSION_GRANTED) {

                openCamera();

            } else {
                permissionLauncher.launch(new String[]{
                        Manifest.permission.CAMERA,
                        Manifest.permission.RECORD_AUDIO
                });
            }
        });
    }

    private void openCamera() {
        Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        videoLauncher.launch(intent);
    }
}