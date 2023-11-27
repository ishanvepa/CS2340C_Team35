package com.cs2340.team35.models;

public interface PowerupInterface {
    public void activate();
    public boolean isUsed();
    public int getX();
    public int getY();
    public int getLength();
    public String getId();
    public String getType();

    interface CollisionSubscriber {
        void HandleCollision(PowerupInterface p);
    }

    public void addCollisionSubscriber(CollisionSubscriber cs);
    public void detectCollision();
}
