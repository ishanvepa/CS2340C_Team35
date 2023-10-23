package com.cs2340.team35;

import static org.junit.Assert.assertEquals;

import com.cs2340.team35.models.GameModel;

import org.junit.Test;

public class AtExitUnitTest {

    @Test
    public void testActuallyExit() {
        boolean ret = GameModel.isAtExit(100, 2000);
        assertEquals(true, ret);
        ret = GameModel.isAtExit(100, 1800);
        assertEquals(true, ret);
    }

    @Test
    public void testNotExit() {
        boolean ret = GameModel.isAtExit(100, 200);
        assertEquals(false, ret);
        ret = GameModel.isAtExit(100, 1700);
        assertEquals(false, ret);
    }
}
