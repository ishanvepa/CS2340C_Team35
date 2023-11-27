package com.cs2340.team35.models;

public class PowerupBase implements PowerupInterface {

    private boolean used;

    public PowerupBase(boolean used) {
        this.used = used;
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


}
