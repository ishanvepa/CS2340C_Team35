package com.cs2340.team35.GameView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cs2340.team35.EndActivity;
import com.cs2340.team35.R;

public class GameActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Intent intent = getIntent();
        String name = intent.getStringExtra("characterName");
        String difficulty = intent.getStringExtra("difficulty");
        String username = intent.getStringExtra("name");
        GameViewModel viewModel = new ViewModelProvider(this).get(GameViewModel.class);
        viewModel.SetState(new GameState(GameState.Difficulty.valueOf(difficulty), GameState.CharacterName.valueOf(name), 100, 200, username));
        GameState state = viewModel.getGameState().getValue();
        TextView hp = (TextView) findViewById(R.id.HPView);
        TextView diff = (TextView) findViewById(R.id.difficultyText);
        Button endButton = (Button) findViewById(R.id.endScreenButton);

        endButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent i = new Intent(getApplicationContext(), EndActivity.class);
                        startActivity(i);
                    }
                }
        );

        RelativeLayout mainCharacter = null;
        RelativeLayout mario = (RelativeLayout) findViewById(R.id.marioSpriteLayout);
        RelativeLayout luigi = (RelativeLayout) findViewById(R.id.luigiSpriteLayout);
        RelativeLayout peach = (RelativeLayout) findViewById(R.id.peachSpriteLayout);

        peach.setVisibility(View.GONE);
        luigi.setVisibility(View.GONE);
        mario.setVisibility(View.GONE);

        if (state.characterName == GameState.CharacterName.MARIO) {
            mainCharacter =  mario;
        }

        else if (state.characterName == GameState.CharacterName.PEACH) {
            mainCharacter = peach;
        }

        else if (state.characterName == GameState.CharacterName.LUIGI) {
            mainCharacter = luigi;
        }

        mainCharacter.setVisibility(View.VISIBLE);

        ViewGroup.LayoutParams oldparams = mainCharacter.getLayoutParams();
        RelativeLayout.LayoutParams position = new RelativeLayout.LayoutParams(oldparams.width, oldparams.width);
        position.leftMargin = state.mainCharacterX;
        position.topMargin = state.mainCharacterY;
        mainCharacter.setLayoutParams(position);

        hp.setText(String.format("Current Health: %d", state.Health));

        String diffS = "EASY";
        if (state.difficulty == GameState.Difficulty.MEDIUM) {
            diffS = "MEDIUM";
        } else if (state.difficulty == GameState.Difficulty.HARD) {
            diffS = "HARD";
        }

        diff.setText(String.format("Difficulty Level: %s", diffS));
    }

}