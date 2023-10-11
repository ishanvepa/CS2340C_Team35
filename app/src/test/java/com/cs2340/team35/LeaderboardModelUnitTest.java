package com.cs2340.team35;

import static org.junit.Assert.assertEquals;

import com.cs2340.team35.models.PlayerModel;
import com.cs2340.team35.models.ScoreModel;
import com.cs2340.team35.models.LeaderboardModel;
import java.util.ArrayList;

import org.junit.Test;

public class LeaderboardModelUnitTest {
    @Test
    public void TestLeaderBoardAdd() {
        PlayerModel model = PlayerModel.getInstance();
        ScoreModel score = new ScoreModel(5);
        model.setScore(score);
        LeaderboardModel leaderboardModel = LeaderboardModel.getInstance();
        leaderboardModel.addScore(score);
        ArrayList<ScoreModel> scores = new ArrayList<ScoreModel>();
        scores.add(score);
        assertEquals(scores, leaderboardModel.getScores());
        leaderboardModel.clearScore();
    }

    @Test
    public void TestLeaderBoardOrder() {
        PlayerModel model = PlayerModel.getInstance();
        ScoreModel score1 = new ScoreModel(1);
        model.setScore(score1);
        ScoreModel score2 = new ScoreModel(2);
        model.setScore(score2);
        ScoreModel score3 = new ScoreModel(3);
        model.setScore(score3);
        ScoreModel score4 = new ScoreModel(4);
        model.setScore(score4);
        ScoreModel score5 = new ScoreModel(5);
        model.setScore(score5);
        LeaderboardModel leaderboardModel = LeaderboardModel.getInstance();
        leaderboardModel.addScore(score1);
        leaderboardModel.addScore(score2);
        leaderboardModel.addScore(score3);
        leaderboardModel.addScore(score4);
        leaderboardModel.addScore(score5);
        ArrayList<ScoreModel> scores = new ArrayList<>();
        scores.add(score1);
        scores.add(score2);
        scores.add(score3);
        scores.add(score4);
        scores.add(score5);
        assertEquals(scores, leaderboardModel.getScores());
        leaderboardModel.clearScore();
    }
}