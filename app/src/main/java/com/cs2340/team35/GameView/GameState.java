package com.cs2340.team35.GameView;

enum CharacterName { MARIO, LUIGI, PEACH };
public class GameState {
    public final int Health;
    public final int Difficulty;
    public final CharacterName characterName;
    public final int mainCharacterX;
    public final int mainCharacterY;


    public GameState(int health, int difficulty, CharacterName characterName, int mainCharacterX, int mainCharacterY) {
        Health = health;
        Difficulty = difficulty;
        this.characterName = characterName;
        this.mainCharacterX = mainCharacterX;
        this.mainCharacterY = mainCharacterY;
    }
}