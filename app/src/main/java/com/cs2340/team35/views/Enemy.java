package com.cs2340.team35.views;

public abstract class Enemy {
    private int health;
    private int speed;
    abstract int attack();

    public int getHealth() {
        return health;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
