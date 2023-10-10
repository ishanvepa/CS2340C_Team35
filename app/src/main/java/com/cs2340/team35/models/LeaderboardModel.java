package com.cs2340.team35.models;

import java.util.ArrayList;
import java.util.Comparator;

public class LeaderboardModel {
    private ArrayList<ScoreModel>scores;

    public LeaderboardModel() {
        this.scores = new ArrayList<>();
    }

    public void addScore(ScoreModel n) {
        this.scores.add(n);
        this.scores.sort(Comparator.naturalOrder());
    }

    public ArrayList<ScoreModel> getScores() {
        return this.scores;
    }
}
