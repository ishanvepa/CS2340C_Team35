package com.cs2340.team35.models.enemies;

public class Koopa extends Enemy {

    private int deltaTX;
    private int deltaTY;
    private int speedMultiplier;
    private int damage;

    private int damageMultiplier;

    private int sizeX;
    private int sizeY;

    private String id;

    public Koopa(int startX, int startY, int damageMultiplier, String id) {
        this.x = startX;
        this.y = startY;
        this.damage = 15;
        this.damageMultiplier = damageMultiplier;
        this.deltaTX = -40;
        this.deltaTY = 20;
        this.speedMultiplier = 1;
        this.sizeX = 120;
        this.sizeY = 120;
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

    public int getSpeedMultiplier(){
        return this.speedMultiplier;
    }
}