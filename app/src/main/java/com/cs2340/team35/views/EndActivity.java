package com.cs2340.team35.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.cs2340.team35.R;

public class EndActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);
        Button restartButton = findViewById(R.id.restartButton);

        restartButton.setOnClickListener(v -> {
            // Start the game activity
            Intent intent = new Intent(EndActivity.this,
                    WelcomeActivity.class);
            startActivity(intent);
        });
    }
}