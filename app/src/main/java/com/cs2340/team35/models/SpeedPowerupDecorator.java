package com.cs2340.team35.models;

import android.graphics.Rect;

public class SpeedPowerupDecorator extends PowerupDecorator {

    public SpeedPowerupDecorator(PowerupInterface powerUp) {
        super(powerUp);
    }

    @Override
    public void activate() {
        super.activate();
        PlayerModel instance = PlayerModel.getInstance();
        instance.setSpeed(2);
    }

    @Override
    public String getType() {
        return "speed";
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
