package org.example.core;

public enum HangmanStage {

    STAGE_1("""
            ________
            |      |
            |
            |
            |
            |
            ********
            """),
    STAGE_2("""
            ________
            |      |
            |      0
            |
            |
            |
            ********
            """),
    STAGE_3("""
            ________
            |      |
            |      0
            |      |
            |
            |
            ********
            """),
    STAGE_4("""
            ________
            |      |
            |      0
            |     /|
            |
            |
            ********
            """),
    STAGE_5("""
            ________
            |      |
            |      0
            |     /|\\
            |
            |
            ********
            """),
    STAGE_6("""
            ________
            |      |
            |      0
            |     /|\\
            |     / \\
            |
            ********""");

    private final String hangman;

    HangmanStage(String hangman) {
        this.hangman = hangman;
    }

    public String getHangman() {
        return hangman;
    }

}
