package com.cs2340.team35.models;

import android.graphics.Rect;

public class HealthPowerupDecorator extends PowerupDecorator {

    public HealthPowerupDecorator(PowerupInterface powerUp) {
        super(powerUp);
    }

    @Override
    public void activate() {
        super.activate();
        PlayerModel instance = PlayerModel.getInstance();
        instance.setHealth(instance.getHealth() + 50);
        instance.setPosition(instance.getX(), instance.getY());
    }

    @Override
    public String getType() {
        return "health";
    }

    @Override
    public void detectCollision() {
        Rect objectRect = new Rect(getX(), getY(), getX() + getLength(), getY() + getLength());
        PlayerModel instance = PlayerModel.getInstance();
        Rect playerRect = new Rect(instance.getX(), instance.getY(), instance.getX() + instance.getWidth(), instance.getY() + instance.getHeight());
        if (objectRect.intersect(playerRect)) {
            for (PowerupInterface.CollisionSubscriber cs : super.getSubscribers()) {
                cs.HandleCollision(this);
            }
        }
    }
}
