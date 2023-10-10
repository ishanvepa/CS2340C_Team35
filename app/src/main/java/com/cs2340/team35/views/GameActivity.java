package com.cs2340.team35.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cs2340.team35.models.LeaderboardModel;
import com.cs2340.team35.models.PlayerModel;
import com.cs2340.team35.models.ScoreModel;
import com.cs2340.team35.viewmodels.PlayerViewModel;
import com.cs2340.team35.views.EndActivity;
import com.cs2340.team35.R;
import com.cs2340.team35.viewmodels.GameState;
import com.cs2340.team35.viewmodels.GameViewModel;
import com.google.android.material.color.utilities.Score;

import java.util.Timer;
import java.util.TimerTask;

public class GameActivity extends AppCompatActivity {

    private Timer timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        GameViewModel gameViewModel = new ViewModelProvider(this).get(GameViewModel.class);
        PlayerViewModel playerViewModel = new ViewModelProvider(this).get(PlayerViewModel.class);

        TextView hp = (TextView) findViewById(R.id.HPView);
        TextView diff = (TextView) findViewById(R.id.difficultyText);
        TextView score = (TextView) findViewById(R.id.Score);
        TextView timeElapsed = (TextView) findViewById(R.id.timeElapsed);
        TextView level = (TextView) findViewById(R.id.level);
        Button endButton = (Button) findViewById(R.id.endScreenButton);

        if (timer != null) {
            timer.cancel();
        }
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                ScoreModel old = playerViewModel.getScore().getValue();
                playerViewModel.setScore(new ScoreModel(old.currentScore - 1));
            }
        }, 5000, 5000);

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
               gameViewModel.setTimeElapsed(gameViewModel.getTimeElapsed().getValue() + 1);
            }
        }, 0, 1000);

        endButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent i = new Intent(getApplicationContext(), EndActivity.class);
                        timer.cancel();
                        LeaderboardModel leaderboardModel = LeaderboardModel.getInstance();
                        leaderboardModel.addScore(playerViewModel.getScore().getValue());
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

        playerViewModel.getScore().observe(this, new Observer<ScoreModel>() {
            @Override
            public void onChanged(ScoreModel scoreModel) {
                score.setText(String.format("Current score: %d", playerViewModel.getScore().getValue().currentScore));
            }
        });

        gameViewModel.getTimeElapsed().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                timeElapsed.setText(String.format("Current time elapsed: %d", gameViewModel.getTimeElapsed().getValue()));
            }
        });

        String diffS = gameViewModel.getDifficulty();

        diff.setText(String.format("Difficulty Level: %s", diffS));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        this.timer.cancel();
    }
}