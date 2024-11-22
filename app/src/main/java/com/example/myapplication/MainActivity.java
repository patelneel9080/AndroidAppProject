package com.example.myapplication;

import static com.example.myapplication.R.*;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer1;
    private MediaPlayer mediaPlayer2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Button button1 = findViewById(R.id.button);
        Button button2 = findViewById(R.id.button2);

        mediaPlayer1 = MediaPlayer.create(this, raw.sound1);
        mediaPlayer2 = MediaPlayer.create(this, raw.sound2);

        button1.setOnClickListener(view -> {
            if (mediaPlayer1.isPlaying()) {
                mediaPlayer1.pause(); // Pause current playback
                mediaPlayer1.seekTo(0); // Reset to the start
            } else {
                if (mediaPlayer2.isPlaying()) {
                    mediaPlayer2.pause(); // Stop mediaPlayer2 if playing
                    mediaPlayer2.seekTo(0);
                }
                mediaPlayer1.start(); // Start mediaPlayer1
            }
        });

        button2.setOnClickListener(view -> {
            if (mediaPlayer2.isPlaying()) {
                mediaPlayer2.pause(); // Pause current playback
                mediaPlayer2.seekTo(0); // Reset to the start
            } else {
                if (mediaPlayer1.isPlaying()) {
                    mediaPlayer1.pause(); // Stop mediaPlayer1 if playing
                    mediaPlayer1.seekTo(0);
                }
                mediaPlayer2.start(); // Start mediaPlayer2
            }
        });

        // Handle window insets for edge-to-edge UI
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Release MediaPlayer resources to prevent memory leaks
        if (mediaPlayer1 != null) {
            mediaPlayer1.release();
            mediaPlayer1 = null;
        }
        if (mediaPlayer2 != null) {
            mediaPlayer2.release();
            mediaPlayer2 = null;
        }
    }
}
