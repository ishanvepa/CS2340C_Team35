package com.cs2340.team35.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cs2340.team35.viewmodels.PlayerViewModel;
import com.cs2340.team35.views.EndActivity;
import com.cs2340.team35.R;
import com.cs2340.team35.viewmodels.GameState;
import com.cs2340.team35.viewmodels.GameViewModel;

public class GameActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        GameViewModel gameViewModel = new ViewModelProvider(this).get(GameViewModel.class);
        PlayerViewModel playerViewModel = new ViewModelProvider(this).get(PlayerViewModel.class);

        TextView hp = (TextView) findViewById(R.id.HPView);
        TextView diff = (TextView) findViewById(R.id.difficultyText);
        TextView score = (TextView) findViewById(R.id.Score);
        TextView level = (TextView) findViewById(R.id.level);
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

        if (playerViewModel.getCharacterName() == "MARIO") {
            mainCharacter =  mario;
        } else if (playerViewModel.getCharacterName() == "PEACH") {
            mainCharacter = peach;
        } else if (playerViewModel.getCharacterName() == "LUIGI") {
            mainCharacter = luigi;
        }

        mainCharacter.setVisibility(View.VISIBLE);
        TextView nametext = (TextView) mainCharacter.getChildAt(1);
        nametext.setText(playerViewModel.getUserName());

        ViewGroup.LayoutParams oldparams = mainCharacter.getLayoutParams();
        RelativeLayout.LayoutParams position = new RelativeLayout.LayoutParams(oldparams.width,
                oldparams.width);
        position.leftMargin = playerViewModel.getX().getValue();
        position.topMargin = playerViewModel.getY().getValue();
        mainCharacter.setLayoutParams(position);

        hp.setText(String.format("Current Health: %d", playerViewModel.getHealth().getValue()));
        score.setText(String.format("Current score: %d", playerViewModel.getScore().getValue().currentScore));

        String diffS = gameViewModel.getDifficulty();

        diff.setText(String.format("Difficulty Level: %s", diffS));
    }

}