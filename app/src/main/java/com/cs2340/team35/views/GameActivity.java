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
import com.cs2340.team35.R;
import com.cs2340.team35.viewmodels.GameViewModel;

import android.view.KeyEvent;

import java.util.Timer;
import java.util.TimerTask;

public class GameActivity extends AppCompatActivity {

    private Timer timer;
    int screenWidth, screenHeight;
    private PlayerViewModel playerViewModel;
    private void cancelTimer() {
        if (timer != null) {
            timer.cancel();
            timer.purge();
            timer  = null;
        }
    }

    private RelativeLayout getMainCharacter() {
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
        return mainCharacter;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        GameViewModel gameViewModel = new ViewModelProvider(this).get(GameViewModel.class);
        playerViewModel = new ViewModelProvider(this).get(PlayerViewModel.class);

        TextView hp = (TextView) findViewById(R.id.HPView);
        TextView diff = (TextView) findViewById(R.id.difficultyText);
        TextView score = (TextView) findViewById(R.id.Score);
        TextView timeElapsed = (TextView) findViewById(R.id.timeElapsed);
        TextView level = (TextView) findViewById(R.id.level);
      //  Button nextButton = (Button) findViewById(R.id.next);
        TextView playerName = (TextView) findViewById(R.id.playerName);

        playerName.setText(playerViewModel.getUserName());

       /* nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (gameViewModel.getLevel() >= 3) {
                    Intent i = new Intent(getApplicationContext(), EndActivity.class);
                    cancelTimer();
                    LeaderboardModel leaderboardModel = LeaderboardModel.getInstance();
                    leaderboardModel.addScore(playerViewModel.getScore().getValue());
                    startActivity(i);
                } else {
                    gameViewModel.increaseLevel();
                    Intent i = new Intent(getApplicationContext(), GameActivity.class);
                    cancelTimer();
                    startActivity(i);
                }
            }
        });
*/
        int currentLevel = gameViewModel.getLevel();
        if (currentLevel == 1) {
            View root = findViewById(android.R.id.content);
            root.setBackgroundResource(R.drawable.peachscastle);
        } else if (currentLevel == 2) {
            View root = findViewById(android.R.id.content);
            root.setBackgroundResource(R.drawable.luigimansion);
        } else if (currentLevel == 3) {
            View root = findViewById(android.R.id.content);
            root.setBackgroundResource(R.drawable.bowserscastle);
        }
        screenWidth = getResources().getDisplayMetrics().widthPixels;
        screenHeight = getResources().getDisplayMetrics().heightPixels;
        // Spawn player in middle of screen
        playerViewModel.setX(screenWidth / 2);
        playerViewModel.setY(screenHeight/2);

        if (timer != null) {
            timer.cancel();
        }
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                ScoreModel old = playerViewModel.getScore().getValue();
                playerViewModel.setScore(new ScoreModel(old.getCurrentScore() - 1));
            }
        }, 5000, 5000);

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                gameViewModel.incrementTimeElapsed();
            }
        }, 0, 1000);

        RelativeLayout mainCharacter = getMainCharacter();

        mainCharacter.setVisibility(View.VISIBLE);

        render(mainCharacter, playerName);

        hp.setText(String.format("Current Health: %d", playerViewModel.getHealth().getValue()));
        score.setText(String.format("Current score: %d",
                playerViewModel.getScore().getValue().getCurrentScore()));
        level.setText(String.format("Current level: %d", gameViewModel.getLevel()));

        playerViewModel.getScore().observe(this, new Observer<ScoreModel>() {
            @Override
            public void onChanged(ScoreModel scoreModel) {
                score.setText(String.format("Current score: %d",
                        playerViewModel.getScore().getValue().getCurrentScore()));
            }
        });

        gameViewModel.getTimeElapsed().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                timeElapsed.setText(
                        String.format("Current time elapsed: %d",
                                gameViewModel.getTimeElapsed().getValue()));
            }
        });

        String diffS = gameViewModel.getDifficulty();

        diff.setText(String.format("Difficulty Level: %s", diffS));
    }

    private void render(RelativeLayout mainCharacter, TextView nameLabel) {
        ViewGroup.LayoutParams oldparams = mainCharacter.getLayoutParams();
        RelativeLayout.LayoutParams position = new RelativeLayout.LayoutParams(oldparams.width,
                oldparams.width);
        position.leftMargin =  playerViewModel.getX().getValue();
        position.topMargin =  playerViewModel.getY().getValue();

        mainCharacter.setLayoutParams(position);
        oldparams = nameLabel.getLayoutParams();
        position = new RelativeLayout.LayoutParams(oldparams.width,
                oldparams.width);
        position.leftMargin = playerViewModel.getX().getValue();
        position.topMargin = playerViewModel.getY().getValue() - 40;
        nameLabel.setLayoutParams(position);
    }
    //Movement
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        PlayerViewModel playerViewModel = new ViewModelProvider(this).get(PlayerViewModel.class);
        TextView playerName = (TextView) findViewById(R.id.playerName);
        RelativeLayout mainCharacter = getMainCharacter();
        if (keyCode == KeyEvent.KEYCODE_DPAD_UP) {
            if (playerViewModel.getY().getValue() - 10 >= 0) {
                playerViewModel.setY(playerViewModel.getY().getValue() - 10);
            }
        } else if (keyCode == KeyEvent.KEYCODE_DPAD_DOWN) {
            if (playerViewModel.getY().getValue() + 10 <= screenHeight) {
                playerViewModel.setY(playerViewModel.getY().getValue() + 10);
            }

        } else if (keyCode == KeyEvent.KEYCODE_DPAD_LEFT) {
            if (playerViewModel.getX().getValue() - 10 <= screenWidth) {
                playerViewModel.setX(playerViewModel.getX().getValue() - 10);
            }
        } else if (keyCode == KeyEvent.KEYCODE_DPAD_RIGHT) {
            if (playerViewModel.getX().getValue() + 10 <= screenWidth) {
                playerViewModel.setX(playerViewModel.getX().getValue() + 10);
            }
        }
        render(mainCharacter, playerName);
        return true;
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        cancelTimer();
    }

}