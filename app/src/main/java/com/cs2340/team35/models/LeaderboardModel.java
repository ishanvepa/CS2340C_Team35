package com.cs2340.team35.models;

import java.util.ArrayList;
import java.util.Comparator;

public class LeaderboardModel {
    private static ArrayList<ScoreModel>scores;
    private static LeaderboardModel instance;

    private LeaderboardModel() {
        this.scores = new ArrayList<>();
    }

    public void addScore(ScoreModel n) {
        scores.add(n);
        scores.sort(Comparator.naturalOrder());
    }

    public ArrayList<ScoreModel> getScores() {
        return scores;
    }

    public static LeaderboardModel getInstance() {
        if (instance == null) {
            instance = new LeaderboardModel();
        }

        return instance;
    }

}
