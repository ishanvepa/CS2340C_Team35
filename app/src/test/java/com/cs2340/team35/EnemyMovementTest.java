package com.cs2340.team35;

import com.cs2340.team35.models.PlayerModel;
import com.cs2340.team35.models.enemies.Boo;
import com.cs2340.team35.models.enemies.Bowser;
import com.cs2340.team35.models.enemies.Enemy;

import org.junit.Test;
import org.junit.Assert;


public class EnemyMovementTest {
    @Test
    public void testEnemyMovement() {
        //test Boo movement
        Enemy boo = new Boo(10, 10, 1, "Booey");
        Assert.assertEquals(boo.getNextPositionX(), 40);
        Assert.assertEquals(boo.getNextPositionY(), 40);

        //test Bowser movement
        Enemy bowser = new Boo(10, 10, 1, "Bowser");
        Assert.assertEquals(bowser.getNextPositionX(), 40);
        Assert.assertEquals(bowser.getNextPositionY(), 40);
    }
    @Test
    public void testEnemyReverseSpeed() {
        //test Boo SpeedReverse
        Boo boo = new Boo(10, 10, 1, "Booey");
        boo.reverseSpeed();
        Assert.assertEquals(boo.getSpeedMultiplier(), -1);

        //test Bowser SpeedReverse
        Bowser bowser = new Bowser(10, 10, 1, "Bowser");
        bowser.reverseSpeed();
        Assert.assertEquals(bowser.getSpeedMultiplier(), -1);


    }
}
