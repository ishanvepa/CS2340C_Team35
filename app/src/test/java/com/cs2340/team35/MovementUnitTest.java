package com.cs2340.team35;

import static org.junit.Assert.assertEquals;

import com.cs2340.team35.models.PlayerModel;
import com.cs2340.team35.views.MovementUp;
import  com.cs2340.team35.views.Movement;
import com.cs2340.team35.views.MovementDown;

import org.junit.Test;

public class MovementUnitTest {
    @Test
    public void testMovementUp() {
        PlayerModel player = PlayerModel.getInstance();
        player.setY(1000);
        player.setX(1000);
        Movement strategy = new MovementUp();
        player.setY(strategy.movementStrategy(player.getX(), player.getY(), 10000, 10000)[1]);
        assertEquals(1010, player.getY());

    }
    @Test
    public void testMovementDown() {
        PlayerModel player = PlayerModel.getInstance();
        player.setY(1000);
        player.setX(1000);
        Movement strategy = new MovementDown();
        player.setY(strategy.movementStrategy(player.getX(), player.getY(), 10000, 10000)[1]);
        assertEquals(990, player.getY());

    }
}
