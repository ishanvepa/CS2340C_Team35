package com.cs2340.team35.models.enemies;

public class Goomba extends Enemy {

    private int deltaTX;
    private int deltaTY;
    private int speedMultiplier;
    private int damage;

    private int damageMultiplier;

    private int sizeX;
    private int sizeY;

    private String id;

    public Goomba(int startX, int startY, int damageMultiplier, String id) {
        this.x = startX;
        this.y = startY;
        this.damage = 5;
        this.damageMultiplier = damageMultiplier;
        this.deltaTX = 0;
        this.deltaTY = 50;
        this.speedMultiplier = 1;
        this.sizeX = 80;
        this.sizeY = 80;
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
        return y + speedMultiplier * deltaTY;
    }

    @Override
    public String getId() {
        return this.id;
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