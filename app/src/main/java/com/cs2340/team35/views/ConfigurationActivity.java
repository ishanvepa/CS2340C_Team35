package com.cs2340.team35.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.cs2340.team35.R;
import com.cs2340.team35.models.GameModel;
import com.cs2340.team35.models.PlayerModel;
import com.cs2340.team35.models.ScoreModel;
import com.cs2340.team35.viewmodels.GameViewModel;
import com.cs2340.team35.viewmodels.PlayerViewModel;
import com.google.android.material.textfield.TextInputEditText;

import java.util.concurrent.atomic.AtomicReference;

public class ConfigurationActivity extends AppCompatActivity {
    private String getAttributeText(String name, String difficulty) {
        return "Current Name: " + name + "\nCurrent Difficulty: " + difficulty;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuration);
        Button easyButton = findViewById(R.id.Easy);
        Button mediumButton = findViewById(R.id.Medium);
        Button hardButton = findViewById(R.id.Hard);
        ImageButton marioButton = findViewById(R.id.Mario);
        ImageButton luigiButton = findViewById(R.id.Luigi);
        ImageButton peachButton = findViewById(R.id.Peach);
        TextInputEditText name = findViewById(R.id.Input);
        TextView attributes = findViewById(R.id.currentAttributes);
        Button next = findViewById(R.id.next);

        GameViewModel gameViewModel = new ViewModelProvider(this).get(GameViewModel.class);
        PlayerViewModel playerViewModel = new ViewModelProvider(this).get(PlayerViewModel.class);

        playerViewModel.setScore(new ScoreModel(100));

        easyButton.setOnClickListener(v -> {
            // Set Difficulty to Easy
            gameViewModel.setDifficulty(GameModel.Difficulty.EASY.toString());
            playerViewModel.setHealth(150);
            attributes.setText(getAttributeText(playerViewModel.getCharacterName(), gameViewModel.getDifficulty()));

        });

        mediumButton.setOnClickListener(v -> {
            // Set Difficulty to Medium
            gameViewModel.setDifficulty(GameModel.Difficulty.MEDIUM.toString());
            playerViewModel.setHealth(100);
            attributes.setText(getAttributeText(playerViewModel.getCharacterName(), gameViewModel.getDifficulty()));
        });

        hardButton.setOnClickListener(v -> {
            // Set Difficulty to Hard
            gameViewModel.setDifficulty(GameModel.Difficulty.HARD.toString());
            playerViewModel.setHealth(50);
            attributes.setText(getAttributeText(playerViewModel.getCharacterName(), gameViewModel.getDifficulty()));
        });

        marioButton.setOnClickListener(v -> {
            // Set Sprite to Mario
            playerViewModel.setCharacterName(PlayerModel.CharacterName.MARIO.toString());
            attributes.setText(getAttributeText(playerViewModel.getCharacterName(), gameViewModel.getDifficulty()));
        });

        luigiButton.setOnClickListener(v -> {
            // Set Sprite to Luigi
            playerViewModel.setCharacterName(PlayerModel.CharacterName.LUIGI.toString());
            attributes.setText(getAttributeText(playerViewModel.getCharacterName(), gameViewModel.getDifficulty()));
        });

        peachButton.setOnClickListener(v -> {
            // Set Sprite to Peach
            playerViewModel.setCharacterName(PlayerModel.CharacterName.PEACH.toString());
            attributes.setText(getAttributeText(playerViewModel.getCharacterName(), gameViewModel.getDifficulty()));
        });

        next.setOnClickListener(v -> {
            // Set Screen to next Screen
            if (!(name.getText() == null || name.getText().toString().trim().equals(""))) {
                Intent i = new Intent(getApplicationContext(), GameActivity.class);
                gameViewModel.setTimeElapsed(0);
                gameViewModel.resetLevel();
                playerViewModel.setScore(new ScoreModel(100));
                startActivity(i);
            }
        });

    }
}