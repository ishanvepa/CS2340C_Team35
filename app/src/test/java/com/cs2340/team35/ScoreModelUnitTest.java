package com.cs2340.team35;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import com.cs2340.team35.models.ScoreModel;

public class ScoreModelUnitTest {

    @Test
    public void TestScoreModelInitialization() {
        ScoreModel sMod = new ScoreModel(0);
        assertEquals(sMod.currentScore, 0);

        ScoreModel sMod2 = new ScoreModel(5);
        assertEquals(sMod2.currentScore, 5);

        //We are allowing negative scores in a ScoreModel
        ScoreModel sMod3 = new ScoreModel(-7);
        assertEquals(sMod3.currentScore, -7);
    }

    @Test
    public void TestCompareScoreModels() {
        ScoreModel sMod = new ScoreModel(0);
        ScoreModel sMod2 = new ScoreModel(5);
        ScoreModel sMod3 = new ScoreModel(-7);

        assertEquals(sMod.compareTo(sMod2), -1);
        assertEquals(sMod.compareTo(sMod3), 1);
        assertEquals(sMod2.compareTo(sMod3), 1);
        assertEquals(sMod2.compareTo(sMod), 1);
        assertEquals(sMod3.compareTo(sMod), -1);
        assertEquals(sMod3.compareTo(sMod2), -1);
    }
}
