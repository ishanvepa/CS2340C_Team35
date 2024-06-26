package com.cs2340.team35.views;

import android.widget.Button;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.cs2340.team35.R;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);

        Button startButton = findViewById(R.id.startButton);
        Button exitButton = findViewById(R.id.exitButton);

        startButton.setOnClickListener(v -> {
            // Start the game activity
            Intent intent = new Intent(WelcomeActivity.this,
                    ConfigurationActivity.class);
            setContentView(R.layout.activity_configuration);
            startActivity(intent);
        });

        exitButton.setOnClickListener(v -> {
            // Exit the app
            finish();
        });
    }
}