package com.cs2340.team35.GameView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.cs2340.team35.MainWelcomeActivity;
import com.cs2340.team35.R;

public class GameActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        GameViewModel viewModel = new ViewModelProvider(this).get(GameViewModel.class);
        GameState state = viewModel.getGameState().getValue();
        TextView hp = (TextView) findViewById(R.id.HPView);
        TextView diff = (TextView) findViewById(R.id.difficultyText);
        Button endButton = (Button) findViewById(R.id.endScreenButton);

        endButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent i = new Intent(getApplicationContext(), MainWelcomeActivity.class);
                        startActivity(i);
                    }
                }
        );
        hp.setText(String.format("Current Health: %d", state.Health));
        diff.setText(String.format("Difficulty Level: %d", state.Difficulty));
    }

}