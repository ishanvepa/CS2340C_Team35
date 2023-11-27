package com.cs2340.team35.models;

import java.util.ArrayList;

public abstract class PowerupDecorator implements PowerupInterface {
    protected PowerupInterface powerupInterface;

    public PowerupDecorator(PowerupInterface powerUp) {
        this.powerupInterface = powerUp;
    }

    @Override
    public void activate() {
        this.powerupInterface.activate();
    }

    @Override
    public boolean isUsed() {
        return this.powerupInterface.isUsed();
    }

    @Override
    public int getLength() {
        return this.powerupInterface.getLength();
    }

    @Override
    public int getX() {
        return this.powerupInterface.getX();
    }

    @Override
    public int getY() {
        return this.powerupInterface.getY();
    }

    @Override
    public String getType() {
        return this.powerupInterface.getType();
    }

    @Override
    public String getId() {
        return this.powerupInterface.getId();
    }

    @Override
    public void detectCollision() {
        this.powerupInterface.detectCollision();
    }

    @Override
    public void addCollisionSubscriber(CollisionSubscriber cs) {
        this.powerupInterface.addCollisionSubscriber(cs);
    }

    @Override
    public ArrayList<CollisionSubscriber> getSubscribers() {
        return this.powerupInterface.getSubscribers();
    }
}
