package com.cs2340.team35;

import com.cs2340.team35.models.PowerupBase;
import com.cs2340.team35.models.PowerupInterface;
import com.cs2340.team35.models.enemies.Enemy;

import org.junit.Test;
import org.junit.Assert;

import java.util.ArrayList;

public class PowerupSterlingTests {

    @Test
    public void TestIsUsed() {
        PowerupBase pUp = new PowerupBase(false, 5, 5, "pUp", "star");
        boolean isUsed = false;
        Assert.assertEquals(isUsed, pUp.isUsed());
        PowerupBase pUp2 = new PowerupBase(true, 5, 5, "pUp2", "mushroom");
        isUsed = true;
        Assert.assertEquals(isUsed, pUp2.isUsed());
    }

    @Test
    public void TestActivate() {
        PowerupBase pUp = new PowerupBase(false, 5, 5, "pUp", "star");
        boolean isUsed = false;
        Assert.assertEquals(isUsed, pUp.isUsed());
        pUp.activate();
        isUsed = true;
        Assert.assertEquals(isUsed, pUp.isUsed());
        PowerupBase pUp2 = new PowerupBase(true, 5, 5, "pUp", "mushroom");
        boolean isUsed2 = true;
        Assert.assertEquals(isUsed, pUp2.isUsed());
    }

    @Test
    public void TestList() {
        ArrayList<PowerupInterface.CollisionSubscriber> list = new ArrayList<>();
        PowerupBase pUp = new PowerupBase(false, 5, 5, "pUp", "star");
        PowerupInterface.CollisionSubscriber cs = new PowerupInterface.CollisionSubscriber() {
            @Override
            public void HandleCollision(PowerupInterface p) {
                return;
            }
        };
        pUp.addCollisionSubscriber(cs);
        list.add(cs);
        Assert.assertEquals(pUp.getSubscribers().size(), list.size());
        PowerupInterface.CollisionSubscriber cs2 = new PowerupInterface.CollisionSubscriber() {
            @Override
            public void HandleCollision(PowerupInterface p) {
                return;
            }
        };
        pUp.addCollisionSubscriber(cs2);
        list.add(cs2);
        Assert.assertEquals(pUp.getSubscribers().size(), list.size());
    }
}
