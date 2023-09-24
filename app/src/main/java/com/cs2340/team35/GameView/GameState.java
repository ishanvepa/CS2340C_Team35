package com.cs2340.team35.GameView;

public class GameState {

    public enum Difficulty { EASY, MEDIUM, HARD }
    public enum CharacterName { MARIO, LUIGI, PEACH }
    private int health;
    private final Difficulty difficulty;
    private final CharacterName characterName;
    private final String username;
    private final int mainCharacterX;
    private final int mainCharacterY;


    public GameState(Difficulty difficulty, CharacterName characterName, int mainCharacterX,
                     int mainCharacterY, String username) {
        this.difficulty = difficulty;
        if (this.difficulty == Difficulty.HARD) {
            health = 50;
        } else if (this.difficulty == Difficulty.MEDIUM) {
            health = 100;
        } else if (this.difficulty == Difficulty.EASY) {
            health = 150;
        }
        this.characterName = characterName;
        this.mainCharacterX = mainCharacterX;
        this.mainCharacterY = mainCharacterY;
        this.username = username;
    }
    public int getHealth() {
        return health;
    }
    public void setHealth(int health) {
        this.health = health;
    }
    public Difficulty getDifficulty() {
        return difficulty;
    }
    public CharacterName getCharacterName() {
        return characterName;
    }
    public String getUsername() {
        return username;
    }
    public int getMainCharacterX() {
        return mainCharacterX;
    }
    public int getMainCharacterY() {
        return mainCharacterY;
    }
}