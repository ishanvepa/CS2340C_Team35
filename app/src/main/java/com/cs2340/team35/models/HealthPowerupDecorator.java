package com.cs2340.team35.models;

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
}
