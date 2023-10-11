package com.cs2340.team35.models;

public class ScoreModel implements Comparable<ScoreModel> {
    public int currentScore;
    public ScoreModel(int i) {
        this.currentScore = i;
    }
    @Override
    public int compareTo(ScoreModel scoreModel) {
        return currentScore > scoreModel.currentScore ? 1 : -1;
    }
}