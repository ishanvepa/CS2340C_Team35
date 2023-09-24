package com.cs2340.team35;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import com.cs2340.team35.GameView.GameActivity;
import com.cs2340.team35.GameView.GameState;
import com.google.android.material.textfield.TextInputEditText;

import java.util.concurrent.atomic.AtomicReference;

public class ConfigurationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuration);
        Button easyButton = findViewById(R.id.Easy);
        Button mediumButton = findViewById(R.id.Medium);
        Button hardButton = findViewById(R.id.Hard);
        AtomicReference<GameState.Difficulty> difficulty = new AtomicReference<GameState.Difficulty>(GameState.Difficulty.EASY);
        ImageButton marioButton = findViewById(R.id.Mario);
        ImageButton luigiButton = findViewById(R.id.Luigi);
        ImageButton peachButton = findViewById(R.id.Peach);
        AtomicReference<GameState.CharacterName> characterName = new AtomicReference<>(GameState.CharacterName.MARIO);;
        TextInputEditText name = findViewById(R.id.Input);
        Button next = findViewById(R.id.next);
        easyButton.setOnClickListener(v -> {
            // Set Difficulty to Easy
            difficulty.set(GameState.Difficulty.EASY);
        });

        mediumButton.setOnClickListener(v -> {
            // Set Difficulty to Medium
            difficulty.set(GameState.Difficulty.MEDIUM);
        });

        hardButton.setOnClickListener(v -> {
            // Set Difficulty to Hard
            difficulty.set(GameState.Difficulty.HARD);
        });

        marioButton.setOnClickListener(v -> {
            // Set Sprite to Mario
            characterName.set(GameState.CharacterName.MARIO);
        });

        luigiButton.setOnClickListener(v -> {
            // Set Sprite to Luigi
            characterName.set(GameState.CharacterName.LUIGI);
        });

        peachButton.setOnClickListener(v -> {
            // Set Sprite to Peach
            characterName.set(GameState.CharacterName.PEACH);
        });

        next.setOnClickListener(v -> {
            // Set Screen to next Screen
            if(!(name.getText() == null || name.getText().toString().trim().equals(""))) {
                Intent i = new Intent(getApplicationContext(), GameActivity.class);
                startActivity(i);
            }
        });

    }
}