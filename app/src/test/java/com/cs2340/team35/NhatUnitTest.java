package com.cs2340.team35;


import static org.junit.Assert.assertEquals;

import com.cs2340.team35.models.ScoreModel;

import org.junit.Test;

public class NhatUnitTest {
    @Test
    public void scoreModelTest() {
        ScoreModel score1 = new ScoreModel(9);
        ScoreModel score2 = new ScoreModel(150);
        ScoreModel score3 = new ScoreModel(100000);
        ScoreModel score4 = new ScoreModel(-1);
        ScoreModel score5 = new ScoreModel(-35);
        ScoreModel score6 = new ScoreModel(-100000);
        ScoreModel score7 = new ScoreModel(0);

        assertEquals(score1.compareTo(score4), 1);
        assertEquals(score5.compareTo(score2), -1);
        assertEquals(score3.compareTo(score6), 1);
        assertEquals(score6.compareTo(score1), -1);
        assertEquals(score4.compareTo(score1), -1);
        assertEquals(score3.compareTo(score2), 1);
        assertEquals(score1.compareTo(score2), -1);
        assertEquals(score6.compareTo(score5), -1);
        assertEquals(score7.compareTo(score6), 1);
        assertEquals(score7.compareTo(score3), -1);
        assertEquals(score7.compareTo(score4), 1);
    }

}
