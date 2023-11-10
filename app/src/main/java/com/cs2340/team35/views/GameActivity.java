package com.cs2340.team35.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cs2340.team35.models.EnemyModel;
import com.cs2340.team35.models.GameModel;
import com.cs2340.team35.models.LeaderboardModel;
import com.cs2340.team35.models.ScoreModel;
import com.cs2340.team35.models.WallModel;
import com.cs2340.team35.viewmodels.EnemyViewModel;
import com.cs2340.team35.viewmodels.PlayerViewModel;
import com.cs2340.team35.R;
import com.cs2340.team35.viewmodels.GameViewModel;
import java.util.ArrayList;
import java.util.List;
import android.view.KeyEvent;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class GameActivity extends AppCompatActivity {
    private static int screenWidth = 1800;
    private static int screenHeight = 1900;
    private Timer timer;
    private PlayerViewModel playerViewModel;
    private GameViewModel gameViewModel;
    private List<WallModel> level1Walls = new ArrayList<>();
    private List<WallModel> level2Walls = new ArrayList<>();
    private List<WallModel> level3Walls = new ArrayList<>();
    private void cancelTimer() {
        if (timer != null) {
            timer.cancel();
            timer.purge();
            timer  = null;
        }
    }

    public WallModel addWalls(int width, int height, int leftMargin, int topMargin) {
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
    protected void createEnemies(GameModel.Difficulty difficulty) {
        Random random = new Random();
        RelativeLayout mainLayout = findViewById(R.id.rootLayout);
        if (difficulty == GameModel.Difficulty.EASY) {
            for(int i = 0; i < 3; i++) {
                EnemyModel model = new EnemyModel();
                int initialPosX = random.nextInt(screenWidth);
                int initialPosY = random.nextInt(screenHeight);
                model.setPosition(initialPosX, initialPosY);
                RelativeLayout enemyView = new RelativeLayout(this);
                enemyView.setLayoutParams(new RelativeLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                ));
                setEnemyBackground(enemyView, model.getEnemySpecies());
                enemyRender(enemyView, initialPosX, initialPosY);
                mainLayout.addView(enemyView);
            }
        } else if (difficulty == GameModel.Difficulty.MEDIUM) {
            for(int i = 0; i < 5; i++) {
                EnemyModel model = new EnemyModel();
                int initialPosX = random.nextInt(screenWidth);
                int initialPosY = random.nextInt(screenHeight);
                model.setPosition(initialPosX, initialPosY);
                RelativeLayout enemyView = new RelativeLayout(this);
                enemyView.setLayoutParams(new RelativeLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                ));
                setEnemyBackground(enemyView, model.getEnemySpecies());
                enemyRender(enemyView, initialPosX, initialPosY);
                mainLayout.addView(enemyView);
            }
        } else if (difficulty == GameModel.Difficulty.HARD) {
            for(int i = 0; i < 10; i++) {
                EnemyModel model = new EnemyModel();
                int initialPosX = random.nextInt(screenWidth);
                int initialPosY = random.nextInt(screenHeight);
                model.setPosition(initialPosX, initialPosY);
                RelativeLayout enemyView = new RelativeLayout(this);
                enemyView.setLayoutParams(new RelativeLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                ));
                setEnemyBackground(enemyView, model.getEnemySpecies());
                enemyRender(enemyView, initialPosX, initialPosY);
                mainLayout.addView(enemyView);
            }
        }
    }
    private void setEnemyBackground(RelativeLayout enemyView, String enemyType) {
        switch (enemyType) {
            case "Boo":
                enemyView.setBackgroundResource(R.drawable.boo);
                break;
            case "Koopa":
                enemyView.setBackgroundResource(R.drawable.koopa);
                break;
            case "Bowser":
                enemyView.setBackgroundResource(R.drawable.bowser);
                break;
            case "Goomba":
                enemyView.setBackgroundResource(R.drawable.goombawalk);
                break;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        gameViewModel = new ViewModelProvider(this).get(GameViewModel.class);
        playerViewModel = new ViewModelProvider(this).get(PlayerViewModel.class);

        TextView hp = (TextView) findViewById(R.id.HPView);
        TextView diff = (TextView) findViewById(R.id.difficultyText);
        TextView score = (TextView) findViewById(R.id.Score);
        TextView timeElapsed = (TextView) findViewById(R.id.timeElapsed);
        TextView level = (TextView) findViewById(R.id.level);
        TextView playerName = (TextView) findViewById(R.id.playerName);
        playerName.setText(playerViewModel.getUserName());

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

        hp.setText(String.format("Current Health: %d", playerViewModel.getHealth().getValue()));
        score.setText(String.format("Current score: %d",
                playerViewModel.getScore().getValue().getCurrentScore()));
        level.setText(String.format("Current level: %d", gameViewModel.getLevel()));
        String diffS = gameViewModel.getDifficulty();
        diff.setText(String.format("Difficulty Level: %s", diffS));

        screenWidth = getResources().getDisplayMetrics().widthPixels;
        screenHeight = getResources().getDisplayMetrics().heightPixels;
        playerViewModel.setPosition(screenWidth / 2, screenHeight / 2);
        RelativeLayout mainCharacter = getMainCharacter();
        mainCharacter.setVisibility(View.VISIBLE);
        Integer[] startPosition = playerViewModel.getPosition().getValue();
        render(mainCharacter, playerName, startPosition[0], startPosition[1]);

        int currentLevel = gameViewModel.getLevel();
        if (currentLevel == 1) {
            View root = findViewById(android.R.id.content);
            root.setBackgroundResource(R.drawable.peachscastle);

            //level 1 insert walls
            level1Walls.add(addWalls(1080, 42, 0, 475)); // top wall
            level1Walls.add(addWalls(42, 950, 0, 475)); // left wall
            level1Walls.add(addWalls(42, 950, 1038, 475)); // right wall

        } else if (currentLevel == 2) {
            View root = findViewById(android.R.id.content);
            root.setBackgroundResource(R.drawable.luigimansion);
            //level 2 insert walls
            level1Walls.add(addWalls(1080, 42, 0, 475)); // top wall
            level1Walls.add(addWalls(42, 950, 0, 475)); // left wall
            level1Walls.add(addWalls(42, 950, 1038, 475)); // right wall
        } else if (currentLevel == 3) {
            View root = findViewById(android.R.id.content);
            root.setBackgroundResource(R.drawable.bowserscastle);
            //level 3 insert walls
            level1Walls.add(addWalls(1080, 42, 0, 475)); // top wall
            level1Walls.add(addWalls(42, 950, 0, 475)); // left wall
            level1Walls.add(addWalls(42, 950, 1038, 475)); // right wall
        }

        playerViewModel.getScore().observe(this, new Observer<ScoreModel>() {
            @Override
            public void onChanged(ScoreModel scoreModel) {
                score.setText(String.format("Current score: %d",
                        playerViewModel.getScore().getValue().getCurrentScore()));
            }
        });

        playerViewModel.getPosition().observe(this, new Observer<Integer[]>() {
            @Override
            public void onChanged(Integer[] integers) {
                render(mainCharacter, playerName, integers[0], integers[1]);
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
        createEnemies(GameModel.getInstance().getGameDifficulty());
    }

    private void render(RelativeLayout mainCharacter, TextView nameLabel, int posX, int posY) {
        ViewGroup.LayoutParams oldparams = mainCharacter.getLayoutParams();
        RelativeLayout.LayoutParams position = new RelativeLayout.LayoutParams(oldparams.width,
                oldparams.width);
        position.leftMargin =  posX;
        position.topMargin =  posY;

        mainCharacter.setLayoutParams(position);
        oldparams = nameLabel.getLayoutParams();
        position = new RelativeLayout.LayoutParams(oldparams.width,
                oldparams.width);
        position.leftMargin = posX;
        position.topMargin = posY - 40;
        nameLabel.setLayoutParams(position);
    }
    private void enemyRender(RelativeLayout enemy, int posX, int posY) {
       RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) enemy.getLayoutParams();
       params.leftMargin = posX;
       params.topMargin = posY;
       params.width = 100;
       params.height = 100;
       enemy.setLayoutParams(params);
    }
    //Movement
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        PlayerViewModel playerViewModel = new ViewModelProvider(this).get(PlayerViewModel.class);
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

        Integer[] currPosition = playerViewModel.getPosition().getValue();

        if (strategy != null) {
            Integer[] newPosition = strategy.movementStrategy(currPosition[0],
                    currPosition[1], screenWidth, screenHeight);

            if (GameModel.isAtExit(newPosition[0], newPosition[1])) {
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

            if (!WallModel.isCollision(newPosition[0], newPosition[1], level1Walls)) {
                playerViewModel.setPosition(newPosition[0], newPosition[1]);
            }
        }

        return true;
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        cancelTimer();
    }

}