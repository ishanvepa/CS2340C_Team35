package com.cs2340.team35.models;

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

}
