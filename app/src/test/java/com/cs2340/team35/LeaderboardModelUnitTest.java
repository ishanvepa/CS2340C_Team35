package com.cs2340.team35;

import static org.junit.Assert.assertEquals;

import com.cs2340.team35.models.GameModel;
import com.cs2340.team35.models.PlayerModel;
import com.cs2340.team35.models.ScoreModel;
import com.cs2340.team35.models.LeaderboardModel;
import java.util.ArrayList;

import org.junit.Test;

public class LeaderboardModelUnitTest {
    @Test
    public void TestLeaderBoard() {
        PlayerModel model = PlayerModel.getInstance();
        ScoreModel score = new ScoreModel(5);
        model.setScore(score);
        LeaderboardModel leaderboardModel = LeaderboardModel.getInstance();
        leaderboardModel.addScore(score);
        ArrayList<ScoreModel> scores = new ArrayList<ScoreModel>();
        scores.add(score);
        assertEquals(scores, leaderboardModel.getScores());
    }
}