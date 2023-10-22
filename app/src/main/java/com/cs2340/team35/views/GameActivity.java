package com.cs2340.team35.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.cs2340.team35.models.LeaderboardModel;
import com.cs2340.team35.models.PlayerModel;
import com.cs2340.team35.models.ScoreModel;
import com.cs2340.team35.models.WallModel;
import com.cs2340.team35.viewmodels.PlayerViewModel;
import com.cs2340.team35.R;
import com.cs2340.team35.viewmodels.GameViewModel;
import java.util.ArrayList;
import java.util.List;
import android.view.KeyEvent;
import java.util.Timer;
import java.util.TimerTask;

public class GameActivity extends AppCompatActivity {
    private static int screenWidth = 1800;
    private static int screenHeight = 1900;
    private Timer timer;
    private PlayerViewModel playerViewModel;
    private void cancelTimer() {
        if (timer != null) {
            timer.cancel();
            timer.purge();
            timer  = null;
        }
    }

    private WallModel addWalls(int width, int height, int leftMargin, int topMargin) {
        RelativeLayout layout = findViewById(R.id.walls);
        View wall = new View(this);
        wall.setBackgroundColor(Color.BLACK);
        wall.setLayoutParams(new RelativeLayout.LayoutParams(width, height));
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(width, height);
        params.leftMargin = leftMargin;
        params.topMargin = topMargin;
        layout.addView(wall, params);
        return new WallModel(width, height, leftMargin, topMargin);
    }

    //private static boolean isCollision(){}
    private void handleCollision(){

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

        int currentLevel = gameViewModel.getLevel();
        if (currentLevel == 1) {
            View root = findViewById(android.R.id.content);
            root.setBackgroundResource(R.drawable.peachscastle);

            //level 1 insert walls
            List<WallModel> level1Walls = new ArrayList<>();
            level1Walls.add(addWalls(1080, 42, 0, 475)); // top wall
            level1Walls.add(addWalls(1080, 42, 0, 1425)); // bottom wall
            level1Walls.add(addWalls(42, 950, 0, 475)); // left wall
            level1Walls.add(addWalls(42, 950, 1038, 475)); // right wall

        } else if (currentLevel == 2) {
            View root = findViewById(android.R.id.content);
            root.setBackgroundResource(R.drawable.luigimansion);
            //level 2 insert walls
            List<WallModel> levels2Walls = new ArrayList<>();
            levels2Walls.add(addWalls(1080, 42, 0, 475)); // top wall
            levels2Walls.add(addWalls(1080, 42, 0, 1425)); // bottom wall
            levels2Walls.add(addWalls(42, 950, 0, 475)); // left wall
            levels2Walls.add(addWalls(42, 950, 1038, 475)); // right wall
        } else if (currentLevel == 3) {
            View root = findViewById(android.R.id.content);
            root.setBackgroundResource(R.drawable.bowserscastle);
            //level 3 insert walls
            List<WallModel> level3Walls = new ArrayList<>();
            level3Walls.add(addWalls(1080, 42, 0, 475)); // top wall
            level3Walls.add(addWalls(1080, 42, 0, 1425)); // bottom wall
            level3Walls.add(addWalls(42, 950, 0, 475)); // left wall
            level3Walls.add(addWalls(42, 950, 1038, 475)); // right wall
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
        Movement strategy = null;
        if (keyCode == KeyEvent.KEYCODE_DPAD_UP) {
            strategy = new MovementDown();
        } else if (keyCode == KeyEvent.KEYCODE_DPAD_DOWN) {
            strategy = new MovementUp();
        } else if (keyCode == KeyEvent.KEYCODE_DPAD_LEFT) {
            strategy = new MovementLeft();
        } else if (keyCode == KeyEvent.KEYCODE_DPAD_RIGHT) {
            strategy = new MovementRight();
        }
        if(strategy != null) {
            strategy.movementStrategy(playerViewModel, screenWidth, screenHeight);
            render(mainCharacter, playerName);
        }
        return true;
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        cancelTimer();
    }

}