package com.cs2340.team35.GameView;

public class GameState {
    public final int Health;
    public final int Difficulty;
    public String CharacterName = "Mario";
    public int mainCharacterX = 50;
    public int mainCharacterY = 50;


    public GameState(int health, int difficulty) {
        Health = health;
        Difficulty = difficulty;
    }
}