package com.cs2340.team35.models.enemies;

public class Boo extends Enemy {

    private int deltaTX;
    private int deltaTY;
    private int speedMultiplier;
    private int damage;

    private int damageMultiplier;
    private int x;
    private int y;

    private int sizeX;
    private int sizeY;

    private String id;

    public Boo(int startX, int startY, int damageMultiplier, String id) {
        this.x = startX;
        this.y = startY;
        this.damage = 10;
        this.damageMultiplier = damageMultiplier;
        this.deltaTX = 30;
        this.deltaTY = 50;
        this.speedMultiplier = 1;
        this.sizeX = 100;
        this.sizeY = 100;
        this.id = id;
    }
    @Override
    public int getDamage() {
        return this.damageMultiplier * this.damage;
    }

    @Override
    public int getNextPositionX() {
        return x + speedMultiplier * deltaTX;
    }

    @Override
    public int getNextPositionY() {
        return y + speedMultiplier * deltaTX;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }

    @Override
    public void reverseSpeed() {
        this.speedMultiplier = -this.speedMultiplier;
    }

    @Override
    public int getDamageMultiplier() {
        return 0;
    }

    @Override
    public int getSizeX() {
        return sizeX;
    }

    @Override
    public int getSizeY() {
        return sizeY;
    }

    @Override
    public void setDamageMultiplier(int multiplier) {
        this.damageMultiplier = multiplier;
    }
}