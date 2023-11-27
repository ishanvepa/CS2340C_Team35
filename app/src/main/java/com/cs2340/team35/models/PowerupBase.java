package com.cs2340.team35.models;

import android.graphics.Rect;

import com.cs2340.team35.models.enemies.Enemy;

import java.util.ArrayList;

public class PowerupBase implements PowerupInterface {

    private boolean used;
    private int x;
    private int y;

    private String id;

    private String type;

    private ArrayList<PowerupInterface.CollisionSubscriber> subscribers;

    private final int LENGTH = 100;

    public PowerupBase(boolean used, int x, int y, String id, String type) {
        this.used = used;
        this.x = x;
        this.y = y;
        this.id = id;
        this.type = type;
        this.subscribers = new ArrayList<>();
    }

    @Override
    public void activate() {
        setUsed(true);
    }

    private void setUsed(boolean used) {
        this.used = used;
    }

    @Override
    public boolean isUsed() {
        return this.used;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public int getLength() {
        return LENGTH;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void addCollisionSubscriber(CollisionSubscriber cs) {
        subscribers.add(cs);
    }

    public ArrayList<CollisionSubscriber> getSubscribers() {
        return subscribers;
    }

    @Override
    public void detectCollision() {
        Rect objectRect = new Rect(getX(), getY(), getX() + getLength(), getY() + getLength());
        PlayerModel instance = PlayerModel.getInstance();
        Rect playerRect = new Rect(instance.getX(), instance.getY(), instance.getX() + instance.getWidth(), instance.getY() + instance.getHeight());
        if (objectRect.intersect(playerRect)) {
            for (PowerupInterface.CollisionSubscriber cs : subscribers) {
                cs.HandleCollision(this);
            }
        }
    }
}
