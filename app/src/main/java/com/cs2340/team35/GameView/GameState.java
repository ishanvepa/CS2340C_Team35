package com.cs2340.team35.GameView;

;
;
public class GameState {
    public int Health;
    public final Difficulty difficulty;
    public final CharacterName characterName;
    public final int mainCharacterX;
    public final int mainCharacterY;


    public GameState(Difficulty difficulty, CharacterName characterName, int mainCharacterX, int mainCharacterY) {
        this.difficulty = difficulty;
        if (this.difficulty == Difficulty.HARD) {
            Health = 50;
        } else if (this.difficulty == Difficulty.MEDIUM) {
            Health = 100;
        } else if (this.difficulty == Difficulty.EASY) {
            Health = 150;
        }
        this.characterName = characterName;
        this.mainCharacterX = mainCharacterX;
        this.mainCharacterY = mainCharacterY;
    }
}