package org.example.core;

public class HangmanStages {

    private static final String[] STAGES = {
            "",
            """
            ________
            |      |
            |
            |
            |
            |
            ********
            """,
            """
            ________
            |      |
            |      0
            |
            |
            |
            ********
            """,
            """
            ________
            |      |
            |      0
            |      |
            |
            |
            ********
            """,
            """
            ________
            |      |
            |      0
            |     /|
            |
            |
            ********
            """,
            """
            ________
            |      |
            |      0
            |     /|\\
            |
            |
            ********
            """,
            """
            ________
            |      |
            |      0
            |     /|\\
            |     /
            |
            ********
            """
    };

    private HangmanStages() {
    }

    public static String get(int numStage) {
        return STAGES[numStage];
    }

}
