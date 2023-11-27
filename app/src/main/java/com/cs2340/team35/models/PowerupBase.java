package com.cs2340.team35.models;

public class PowerupBase implements PowerupInterface {

    private boolean used;
    private int x;
    private int y;

    private String id;

    private String type;

    private final int LENGTH = 100;

    public PowerupBase(boolean used, int x, int y, String id, String type) {
        this.used = used;
        this.x = x;
        this.y = y;
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
}
