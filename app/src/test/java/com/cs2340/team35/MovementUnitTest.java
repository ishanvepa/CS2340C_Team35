package com.cs2340.team35;
import static org.junit.Assert.assertEquals;
import com.cs2340.team35.models.PlayerModel;
import com.cs2340.team35.views.Movement;
import com.cs2340.team35.views.MovementDown;
import com.cs2340.team35.views.MovementUp;

import org.junit.Test;

import java.util.Optional;

public class MovementUnitTest {
    @Test
    public void testMovementUp() {
        PlayerModel playerModel = PlayerModel.getInstance();
        playerModel.setX(50);
        playerModel.setY(50);
        Movement strategy = new MovementUp();
        strategy.movementStrategy(playerModel, 1000000, 1000000);
        int y = playerModel.getY();
        assertEquals(60, y);
    }
    @Test
    public void testMovementDown() {
        PlayerModel playerModel = PlayerModel.getInstance();
        playerModel.setX(50);
        playerModel.setY(50);
        Movement strategy = new MovementDown();
        strategy.movementStrategy(playerModel, 1000000, 1000000);
        int y = playerModel.getY();
        assertEquals(40, y);
    }
}
