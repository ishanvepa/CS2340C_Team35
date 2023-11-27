package com.cs2340.team35.models;

import android.graphics.Rect;

public class SizePowerupDecorator extends PowerupDecorator {

    public SizePowerupDecorator(PowerupInterface powerUp) {
        super(powerUp);
    }

    @Override
    public void activate() {
        super.activate();
        PlayerModel instance = PlayerModel.getInstance();
        instance.setWidth(instance.originalWidth / 2);
        instance.setHeight(instance.originalHeight / 2);
    }

    @Override
    public String getType() {
        return "size";
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
