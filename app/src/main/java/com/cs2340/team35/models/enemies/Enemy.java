package com.cs2340.team35.models.enemies;
public abstract class Enemy {
    public abstract int getDamage();
    public abstract int getNextPositionX();
    public abstract int getNextPositionY();
    public abstract int getX();
    public abstract void setX(int x);
    public abstract String getId();
    public abstract int getY();
    public abstract void setY(int y);
    public abstract void reverseSpeed();
    public abstract int getDamageMultiplier();

    public abstract int getSizeX();
    public abstract int getSizeY();
    public abstract void setDamageMultiplier(int multiplier);


}
