package com.cs2340.team35.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.graphics.Color;
import android.opengl.Visibility;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cs2340.team35.models.GameModel;
import com.cs2340.team35.models.HealthPowerupDecorator;
import com.cs2340.team35.models.LeaderboardModel;
import com.cs2340.team35.models.PlayerModel;
import com.cs2340.team35.models.PowerupBase;
import com.cs2340.team35.models.PowerupInterface;
import com.cs2340.team35.models.ScoreModel;
import com.cs2340.team35.models.WallModel;
import com.cs2340.team35.models.enemies.Boo;
import com.cs2340.team35.models.enemies.Bowser;
import com.cs2340.team35.models.enemies.Enemy;
import com.cs2340.team35.models.enemies.Goomba;
import com.cs2340.team35.models.enemies.Koopa;
import com.cs2340.team35.viewmodels.PlayerViewModel;
import com.cs2340.team35.R;
import com.cs2340.team35.viewmodels.GameViewModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import android.view.KeyEvent;

import java.util.Map;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class GameActivity extends AppCompatActivity {
    private static int screenWidth = 1800;
    private static int screenHeight = 1900;
    private PlayerViewModel playerViewModel;
    private GameViewModel gameViewModel;
    private Timer timer;
    private Timer enemyUpdateTimer;
    private RelativeLayout mainCharacter;
    private TextView mainCharacterText;
    private Map<String, RelativeLayout> enemyViews;
    private Map<String, RelativeLayout> powerupViews;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        // set up game view model
        gameViewModel = new ViewModelProvider(this).get(GameViewModel.class);
        playerViewModel = new ViewModelProvider(this).get(PlayerViewModel.class);

        // set up text elements
        TextView hp = (TextView) findViewById(R.id.HPView);
        TextView diff = (TextView) findViewById(R.id.difficultyText);
        TextView score = (TextView) findViewById(R.id.Score);
        TextView timeElapsed = (TextView) findViewById(R.id.timeElapsed);
        TextView level = (TextView) findViewById(R.id.level);

        mainCharacterText = (TextView) findViewById(R.id.playerName);
        mainCharacterText.setText(playerViewModel.getUserName());

        // setup main character
        RelativeLayout mario = (RelativeLayout) findViewById(R.id.marioSpriteLayout);
        RelativeLayout luigi = (RelativeLayout) findViewById(R.id.luigiSpriteLayout);
        RelativeLayout peach = (RelativeLayout) findViewById(R.id.peachSpriteLayout);

        peach.setVisibility(View.GONE);
        luigi.setVisibility(View.GONE);
        mario.setVisibility(View.GONE);

        RelativeLayout rootLayout = (RelativeLayout) findViewById(R.id.rootLayout);

        mainCharacter = new RelativeLayout(this);
        mainCharacter.setLayoutParams(new RelativeLayout.LayoutParams(PlayerModel.getInstance().getWidth(), PlayerModel.getInstance().getHeight()));
        RelativeLayout.LayoutParams mcParams = new RelativeLayout.LayoutParams(PlayerModel.getInstance().getWidth(), PlayerModel.getInstance().getHeight());
        mcParams.leftMargin = playerViewModel.getPosition().getValue()[0];
        mcParams.topMargin = playerViewModel.getPosition().getValue()[1];

        if (playerViewModel.getCharacterName() == "MARIO") {
            mainCharacter.setBackground(getDrawable(R.drawable.mariosprite));
        } else if (playerViewModel.getCharacterName() == "PEACH") {
            mainCharacter.setBackground(getDrawable(R.drawable.peachsprite));
        } else if (playerViewModel.getCharacterName() == "LUIGI") {
            mainCharacter.setBackground(getDrawable(R.drawable.luigisprite));
        }

        rootLayout.addView(mainCharacter, mcParams);
        // setup enemies

        RelativeLayout boo = (RelativeLayout) findViewById(R.id.booSpriteLayout);
        RelativeLayout bowser = (RelativeLayout) findViewById(R.id.bowserSpriteLayout);
        RelativeLayout koopa = (RelativeLayout) findViewById(R.id.koopaSpriteLayout);
        RelativeLayout goomba = (RelativeLayout) findViewById(R.id.goombaSpriteLayout);

        boo.setVisibility(View.GONE);
        bowser.setVisibility(View.GONE);
        koopa.setVisibility(View.GONE);
        goomba.setVisibility(View.GONE);

        this.enemyViews = new HashMap<>();
        ArrayList<Enemy> enemies = this.gameViewModel.getEnemies().getValue();
        for (Enemy enemy : enemies) {
            RelativeLayout newEnemy = (RelativeLayout) new RelativeLayout(this);
            newEnemy.setLayoutParams(new RelativeLayout.LayoutParams(enemy.getSizeX(), enemy.getSizeY()));
            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(enemy.getSizeX(), enemy.getSizeY());
            params.leftMargin = enemy.getX();
            params.topMargin = enemy.getY();

            if (enemy instanceof Boo) {
                newEnemy.setBackground(getDrawable(R.drawable.boo));
            } else if (enemy instanceof Bowser) {
                newEnemy.setBackground(getDrawable(R.drawable.bowser));
            } else if (enemy instanceof Goomba) {
                newEnemy.setBackground(getDrawable(R.drawable.goombawalk));
            } else if (enemy instanceof Koopa) {
                newEnemy.setBackground(getDrawable(R.drawable.koopa));
            }

            rootLayout.addView(newEnemy, params);
            this.enemyViews.put(enemy.getId(), newEnemy);

        }

        // setup powerups
        this.powerupViews = new HashMap<>();
        ArrayList<PowerupInterface> powerupInterfaces = gameViewModel.getPowerups().getValue();
        for (PowerupInterface powerup : powerupInterfaces) {
            RelativeLayout newP = (RelativeLayout) new RelativeLayout(this);
            newP.setLayoutParams(new RelativeLayout.LayoutParams(powerup.getLength(), powerup.getLength()));
            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(powerup.getLength(), powerup.getLength());
            params.leftMargin = powerup.getX();
            params.topMargin = powerup.getY();

            if (powerup.getType() == "health") {
                newP.setBackground(getDrawable(R.drawable.heart));
            } else if (powerup.getType() == "size") {
                newP.setBackground(getDrawable(R.drawable.mushroom));
            } else if (powerup.getType() == "speed") {
                newP.setBackground(getDrawable(R.drawable.speed));
            }

            this.powerupViews.put(powerup.getId(), newP);
            rootLayout.addView(newP, params);
        }

        // setup timer
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

        enemyUpdateTimer = new Timer();
        enemyUpdateTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                gameViewModel.enemyTimestep();
            }
        }, 0, 200);

        // setup text content within text
        hp.setText(String.format("Current Health: %d", playerViewModel.getHealth().getValue()));
        score.setText(String.format("Current score: %d",
                playerViewModel.getScore().getValue().getCurrentScore()));
        level.setText(String.format("Current level: %d", gameViewModel.getLevel()));
        String diffS = gameViewModel.getDifficulty();
        diff.setText(String.format("Difficulty Level: %s", diffS));

        screenWidth = getResources().getDisplayMetrics().widthPixels;
        screenHeight = getResources().getDisplayMetrics().heightPixels;
        playerViewModel.setPosition(screenWidth / 2, screenHeight / 2);

        playerViewModel.getHealth().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                hp.setText(String.format("Current Health: %d", playerViewModel.getHealth().getValue()));
                if (integer <= 0 && gameViewModel.getTimeElapsed().getValue() > 0) {
                    cancelTimers();
                    Intent i = new Intent(getApplicationContext(), EndActivity.class);
                    startActivity(i);
                }
            }
        });

        // initial renders
        renderPlayer();
        renderWalls();

        int currentLevel = gameViewModel.getLevel();
        View root = findViewById(android.R.id.content);
        if (currentLevel == 1) {
            root.setBackgroundResource(R.drawable.peachscastle);
        } else if (currentLevel == 2) {
            root.setBackgroundResource(R.drawable.luigimansion);
        } else if (currentLevel == 3) {
            root.setBackgroundResource(R.drawable.bowserscastle);
        }
        // subsequent renders and event driven reactions
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
                renderPlayer();
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

        gameViewModel.getEnemies().observe(this, new Observer<List<Enemy>>() {
            @Override
            public void onChanged(List<Enemy> enemies) {
                renderEnemies();
            }
        });

        gameViewModel.getPowerups().observe(this, new Observer<List<PowerupInterface>>() {
            @Override
            public void onChanged(List<PowerupInterface> powerups) {
                renderPowerups();
            }
        });
    }

    private void renderPlayer() {
        int posX = this.playerViewModel.getPosition().getValue()[0];
        int posY = this.playerViewModel.getPosition().getValue()[1];
        RelativeLayout.LayoutParams position = new RelativeLayout.LayoutParams(PlayerModel.getInstance().getWidth(),
                PlayerModel.getInstance().getHeight());
        position.leftMargin =  posX;
        position.topMargin =  posY;

        mainCharacter.setLayoutParams(position);
        position = new RelativeLayout.LayoutParams(PlayerModel.getInstance().getWidth(),
                PlayerModel.getInstance().getHeight());
        position.leftMargin = posX;
        position.topMargin = posY - 40;
        mainCharacterText.setLayoutParams(position);
    }

    private void renderWalls() {
        List<WallModel> walls = this.gameViewModel.getWalls();
        RelativeLayout layout = findViewById(R.id.walls);
        for (WallModel wall : walls) {
            View v = new View(this);
            v.setBackgroundColor(Color.BLACK);
            v.setLayoutParams(new RelativeLayout.LayoutParams(wall.getWidth(), wall.getHeight()));
            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(wall.getWidth(), wall.getHeight());
            params.leftMargin = wall.getLeftMargin();
            params.topMargin = wall.getTopMargin();
            layout.addView(v, params);
        }
    }

    private void renderPowerups() {
        List<PowerupInterface> powerups = this.gameViewModel.getPowerups().getValue();
        for (PowerupInterface powerup : powerups) {
            RelativeLayout powerupView = powerupViews.get(powerup.getId());
            if (powerupView != null) {
                if (powerup.isUsed()) {
                    powerupView.setVisibility(View.GONE);
                    //increase score when powerup is collected
                    ScoreModel incScore = playerViewModel.getScore().getValue();
                    playerViewModel.setScore(new ScoreModel(incScore.getCurrentScore() + 10));
                }
            }
        }
    }

    private void renderEnemies() {
        ArrayList<Enemy> enemies = this.gameViewModel.getEnemies().getValue();
        for (Enemy enemy : enemies) {
            RelativeLayout enemyLayout = enemyViews.get(enemy.getId());
            if (enemyLayout != null) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) enemyLayout.getLayoutParams();

                layoutParams.leftMargin = enemy.getX();
                layoutParams.topMargin = enemy.getY();

                enemyLayout.setLayoutParams(layoutParams);
            }
        }
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

        if (strategy == null) {
            return true;
        }

        Integer[] newPosition = strategy.movementStrategy(currPosition[0],
                currPosition[1], screenWidth, screenHeight);

        if (GameModel.isAtExit(newPosition[0], newPosition[1])) {
            if (gameViewModel.getLevel() >= 3) {
                cancelTimers();
                Intent i = new Intent(getApplicationContext(), EndActivity.class);
                LeaderboardModel leaderboardModel = LeaderboardModel.getInstance();
                leaderboardModel.addScore(playerViewModel.getScore().getValue());
                startActivity(i);
            } else {
                gameViewModel.increaseLevel();
                cancelTimers();
                Intent i = new Intent(getApplicationContext(), GameActivity.class);
                startActivity(i);
            }
        }

        if (!this.gameViewModel.isCollision(newPosition[0], newPosition[1], 130, 80)) {
            playerViewModel.setPosition(newPosition[0], newPosition[1]);
        }

        return true;
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        cancelTimers();
    }

    private void cancelTimers() {
        if (timer != null) {
            timer.cancel();
            timer.purge();
            timer  = null;
        }

        if (enemyUpdateTimer != null) {
            enemyUpdateTimer.cancel();
            enemyUpdateTimer.purge();
            enemyUpdateTimer  = null;
        }
    }
}