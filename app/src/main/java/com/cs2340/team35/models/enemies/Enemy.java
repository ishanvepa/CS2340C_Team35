package com.cs2340.team35.models.enemies;

import android.graphics.Rect;

import com.cs2340.team35.models.GameModel;
import com.cs2340.team35.models.PlayerModel;

import java.util.ArrayList;

public abstract class Enemy {

    public int x;
    public int y;
    public abstract int getDamage();
    public abstract int getNextPositionX();
    public abstract int getNextPositionY();
    private boolean isDead;
    public int getX() {
        return x;
    };
    public void setX(int x) {
        this.x = x;
        detectCollision();
    };

    public abstract String getId();
    public int getY() {
        return y;
    };
    public void setY(int y) {
        this.y = y;
        detectCollision();
    };
    public abstract void reverseSpeed();
    public abstract int getDamageMultiplier();

    public abstract int getSizeX();
    public abstract int getSizeY();
    public abstract void setDamageMultiplier(int multiplier);

    public boolean isDead() {
        return isDead;
    }

    public void setDead(boolean dead) {
        isDead = dead;
    }


    public interface CollisionSubscriber {
        void HandleCollision(Enemy e);
    }

    public ArrayList<CollisionSubscriber> subscribers = new ArrayList<>();

    public void addCollisisonSubscriber(CollisionSubscriber cs) {
        subscribers.add(cs);
    };

    public void detectCollision() {
        Rect objectRect = new Rect(getX(), getY(), getX() + getSizeX(), getY() + getSizeY());
        PlayerModel instance = PlayerModel.getInstance();
        Rect playerRect = new Rect(instance.getX(), instance.getY(), instance.getX() + instance.getWidth(), instance.getY() + instance.getHeight());
        if (objectRect.intersect(playerRect)) {
            for (CollisionSubscriber cs : subscribers) {
                cs.HandleCollision(this);
            }
        }
    };
    public void removeFromGame() {
        GameModel instance = GameModel.getInstance();
        instance.getEnemies().remove(this);
        isDead = true;
    }



}
