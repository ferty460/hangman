public enum HangmanStages {

    ONE_MISTAKE_STAGE("""
        |
        |
        |
        |
        |
        |
        """),
    TWO_MISTAKES_STAGE("""
         ___
        |/  |
        |
        |
        |
        |
        |
        """),
    THREE_MISTAKES_STAGE("""
         ___
        |/  |
        |   *
        |
        |
        |
        |
        """),
    FOUR_MISTAKES_STAGE("""
         ___
        |/  |
        |   *
        |  /|\\
        |
        |
        |
        """),
    FIVE_MISTAKES_STAGE("""
         ___
        |/  |
        |   *
        |  /|\\
        |   |
        |
        |
        """),
    SIX_MISTAKES_STAGE("""
         ___
        |/  |
        |   *
        |  /|\\
        |   |
        |  / \\
        |
        """);

    private final String hangman;

    HangmanStages(String hangman) {
        this.hangman = hangman;
    }

    public String getHangman() {
        return hangman;
    }

}
