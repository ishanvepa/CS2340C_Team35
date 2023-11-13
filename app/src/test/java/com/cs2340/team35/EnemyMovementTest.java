package com.cs2340.team35;

import com.cs2340.team35.models.enemies.Boo;
import com.cs2340.team35.models.enemies.Enemy;

import org.junit.Test;
import org.junit.Assert;


public class EnemyMovementTest {
    @Test
    public void testEnemyMovement{
        //test Boo movement
        Enemy boo = new Boo(10, 10, 1, "Booey");
        Assert.assertEquals(boo.getNextPositionX(), 40);
        Assert.assertEquals(boo.getNextPositionY(), 60);

        //test Bowser movement
        Enemy bowser = new Boo(10, 10, 1, "Bowser");
        Assert.assertEquals(bowser.getNextPositionX(), 20);
        Assert.assertEquals(bowser.getNextPositionY(), 10);
    }

    @Test
    public void testEnemyCollision{
        Assert.assertEquals();


    }
}
