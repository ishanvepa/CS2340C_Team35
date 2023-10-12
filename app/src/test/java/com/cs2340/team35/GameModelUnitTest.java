package com.cs2340.team35;

import static org.junit.Assert.assertEquals;

import com.cs2340.team35.models.GameModel;

import org.junit.Test;

public class GameModelUnitTest {
    @Test
    public void TestLevelBounds() {
        GameModel model = GameModel.getInstance();
        model.setLevel(0);
        assertEquals(model.getLevel(), 1);
        model.setLevel(4);
        assertEquals(model.getLevel(), 3);

        model.setLevel(-5000);
        assertEquals(model.getLevel(), 1);
        model.setLevel(5000);
        assertEquals(model.getLevel(), 3);
    }

    @Test
    public void TestLevelDifficulty(){
        GameModel model = GameModel.getInstance();

        //test EASY difficulty
        model.setGameDifficulty(GameModel.Difficulty.EASY);
        assertEquals(model.getGameDifficulty(), GameModel.Difficulty.EASY);

        //test MEDIUM difficulty
        model.setGameDifficulty(GameModel.Difficulty.MEDIUM);
        assertEquals(model.getGameDifficulty(), GameModel.Difficulty.MEDIUM);

        //test HARD difficulty
        model.setGameDifficulty(GameModel.Difficulty.HARD);
        assertEquals(model.getGameDifficulty(), GameModel.Difficulty.HARD);

    }
}
