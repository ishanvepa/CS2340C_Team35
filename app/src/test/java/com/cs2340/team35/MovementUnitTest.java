package com.cs2340.team35;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import com.cs2340.team35.viewmodels.PlayerViewModel;
import com.cs2340.team35.views.MovementUp;
import com.cs2340.team35.views.MovementRight;

public class MovementUnitTest {

    @Test
    public void TestMovementUp() {
        PlayerViewModel play = new PlayerViewModel();
        play.setY(100);
        MovementUp m = new MovementUp();
        int y = play.getY().getValue();
        m.movementStrategy(play, 1000, 1000);
        assertEquals(y, play.getY().getValue() + 10);
        play.setY(2000);
        y = play.getY().getValue();
        m.movementStrategy(play, 1000, 1000);
        assertEquals(y, play.getY().getValue() + 10);
    }

    @Test
    public void TestMovementRight() {
        PlayerViewModel play = new PlayerViewModel();
        play.setX(100);
        MovementRight m = new MovementRight();
        int x = play.getX().getValue();
        m.movementStrategy(play, 1000, 1000);
        assertEquals(x, play.getX().getValue() + 10);
        play.setX(2000);
        x = play.getX().getValue();
        m.movementStrategy(play, 1000, 1000);
        assertEquals(x, play.getX().getValue() + 10);
    }
}
