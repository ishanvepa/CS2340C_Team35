package com.cs2340.team35;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import com.cs2340.team35.GameView.CharacterName;
import com.cs2340.team35.GameView.Difficulty;
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
        AtomicReference<Difficulty> difficulty = new AtomicReference<Difficulty>(Difficulty.EASY);
        ImageButton marioButton = findViewById(R.id.Mario);
        ImageButton luigiButton = findViewById(R.id.Luigi);
        ImageButton peachButton = findViewById(R.id.Peach);
        AtomicReference<CharacterName> characterName = new AtomicReference<CharacterName>(CharacterName.MARIO);;
        TextInputEditText name = findViewById(R.id.Input);
        Button next = findViewById(R.id.next);
        easyButton.setOnClickListener(v -> {
            // Set Difficulty to Easy
            difficulty.set(Difficulty.EASY);
        });

        mediumButton.setOnClickListener(v -> {
            // Set Difficulty to Medium
            difficulty.set(Difficulty.MEDIUM);
        });

        hardButton.setOnClickListener(v -> {
            // Set Difficulty to Hard
            difficulty.set(Difficulty.HARD);
        });

        marioButton.setOnClickListener(v -> {
            // Set Sprite to Mario
            characterName.set(CharacterName.MARIO);
        });

        luigiButton.setOnClickListener(v -> {
            // Set Sprite to Luigi
            characterName.set(CharacterName.LUIGI);
        });

        peachButton.setOnClickListener(v -> {
            // Set Sprite to Peach
            characterName.set(CharacterName.PEACH);
        });

        next.setOnClickListener(v -> {
            // Set Screen to next Screen
            if(!(name.getText() == null || name.getText().toString().trim().equals(""))) {
                setContentView(R.layout.activity_game);
            }
        });

    }
}