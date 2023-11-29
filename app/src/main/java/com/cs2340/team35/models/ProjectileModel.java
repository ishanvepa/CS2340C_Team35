package com.cs2340.team35.models;

import java.util.ArrayList;

public class ProjectileModel {
    private int x;
    private int y;

    private int deltaX;

    private int deltaY;

    public final int SIZE_X = 50;
    public final int SIZE_Y = 50;

    public boolean isOffScreen() {
        return offScreen;
    }

    public void setOffScreen(boolean offScreen) {
        this.offScreen = offScreen;
    }

    private boolean offScreen = false;


    public ProjectileModel(int x, int y, int deltaX, int deltaY) {
        this.x = x;
        this.y = y;
        this.deltaX = deltaX;
        this.deltaY = deltaY;
    }

    public ArrayList<CollisionSubscriber> subscribers;
    public interface CollisionSubscriber {
        public void HandleCollision();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void addSubscriber(CollisionSubscriber s) {
        subscribers.add(s);
    }

    public ArrayList<CollisionSubscriber> getSubscribers() {
        return subscribers;
    }

    public void timestep() {
        this.x = this.x + deltaX;
        this.y = this.y + deltaY;
    }
}
