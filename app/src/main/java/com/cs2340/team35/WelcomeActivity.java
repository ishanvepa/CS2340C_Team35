package com.cs2340.team35;

import android.widget.Button;
import android.view.View;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);

        Button startButton = findViewById(R.id.startButton);
        Button exitButton = findViewById(R.id.exitButton);

        startButton.setOnClickListener(v -> {
            // Start the game activity
            Intent intent = new Intent(WelcomeActivity.this, GameActivity.class);
            startActivity(intent);
        });

        exitButton.setOnClickListener(v -> {
            // Exit the app
            finish();
        });
    }
}