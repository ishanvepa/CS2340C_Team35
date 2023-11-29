package com.cs2340.team35.models;

import android.graphics.Rect;

import com.cs2340.team35.models.enemies.Enemy;
import com.cs2340.team35.models.enemies.EnemyFactory;

import java.util.ArrayList;
import java.util.List;

public class PlayerModel implements Enemy.CollisionSubscriber, PowerupInterface.CollisionSubscriber {

    private static PlayerModel instance;
    private static int x;
    private static int y;

    public final int originalWidth = 130;
    public final int originalHeight = 130;

    private int width = originalWidth;
    private int height = originalHeight;
    private int speed = 1;

    private static ScoreModel score;
    private static int health;

    private static ArrayList<ProjectileModel> projectiles;

    @Override
    public void HandleCollision(Enemy e) {
        this.setHealth(this.getHealth() - e.getDamage());
        setPosition(100, 600);
        score.setCurrentScore(score.getCurrentScore() - 20);
    }

    @Override
    public void HandleCollision(PowerupInterface p) {
        if (!p.isUsed()) {
            p.activate();

            for (Subscriber s : subscriberList) {
                s.powerupUpdated();
            }
        }
    }

    public enum CharacterName { MARIO, LUIGI, PEACH }
    private static CharacterName character;
    private static String userName;

    private List<Subscriber> subscriberList;


    public void addSubscriber(Subscriber s) {
        subscriberList.add(s);
    }

    private PlayerModel() {
        x = 100;
        y = 600;
        character = CharacterName.MARIO;
        userName = "";
        health = 0;
        score = new ScoreModel(10);
        subscriberList = new ArrayList<>();
        projectiles = new ArrayList<>();
    }

    public void addProjectile(int deltaX, int deltaY) {
        ProjectileModel p = new ProjectileModel(x, y, deltaX, deltaY);
        projectiles.add(p);
    }

    public void projectileTimestep() {
        for (ProjectileModel pm : projectiles) {
            pm.timestep();

            if (pm.getX() < 0 || pm.getX() > 2000 || pm.getY() < 0 || pm.getY() > 3000) {
                pm.setOffScreen(true);
            }
        }
    }

    public void resetProjectiles() {
        projectiles = new ArrayList<>();
    }

    public static ArrayList<ProjectileModel> getProjectiles() {
        return projectiles;
    }

    public static PlayerModel getInstance() {
        if (instance == null) {
            instance = new PlayerModel();
        }
        return instance;
    }

    public void setX(int newX) {
        if (newX < 0) {
            newX = 0;
        }
        x = newX;
    }

    public void setY(int newY) {
        if (newY < 0) {
            newY = 0;
        }

        y = newY;
    }

    public void setPosition(int newX, int newY) {
        if (newX < 0) {
            newX = 0;
        }
        x = newX;

        if (newY < 0) {
            newY = 0;
        }
        y = newY;
        for (Subscriber s : subscriberList) {
            s.positionUpdated(newX, newY);
        }

        for (Enemy enemy : GameModel.getInstance().getEnemies()) {
            enemy.detectCollision();
        }

        for (PowerupInterface pi : GameModel.getInstance().getPowerups()) {
            pi.detectCollision();
        }
    }

    public void setCharacter(CharacterName character) {
        PlayerModel.character = character;
    }

    public static CharacterName getCharacter() {
        return character;
    }

    public void setUserName(String userName) {
        PlayerModel.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public ScoreModel getScore() {
        return score;
    }

    public void setScore(ScoreModel score) {
        this.score = score;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int newHealth) {
        health = newHealth;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public interface Subscriber {
        public void positionUpdated(int newX, int newY);
        public void powerupUpdated();
    }

}
