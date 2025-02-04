import java.util.ArrayList;
import java.util.List;

public class Round {
    private int numAttempts = 6;
    private final String word;
    private final List<Character> usedLetters = new ArrayList<>();
    private String maskedWord;

    private static final String[] HANGMAN_STAGES = {
            """
        |
        |
        |
        |
        |
        |
        """,
            """
         ___
        |/  |
        |
        |
        |
        |
        |
        """,
            """
         ___
        |/  |
        |   *
        |
        |
        |
        |
        """,
            """
         ___
        |/  |
        |   *
        |  /||
        |
        |
        |
        """,
            """
         ___
        |/  |
        |   *
        |  /||
        |   |
        |
        |
        """,
            """
         ___
        |/  |
        |   *
        |  /||
        |   |
        |  / \\
        |
        """
    };

    public Round() {
        this.word = new WordGenerator("src\\words.txt").getWord();
        this.maskedWord = "*".repeat(word.length());
    }

    public boolean isRightLetter(char letter) {
        validateLetter(letter);
        if (word.indexOf(letter) >= 0) {
            unmaskWord(letter);
            return true;
        }
        return false;
    }

    private void validateLetter(char letter) {
        if (!Character.isLetter(letter)) {
            throw new IllegalArgumentException("Неверный формат буквы");
        }
        if (!isCyrillic(letter)) {
            throw new IllegalArgumentException("Допускается только кириллица");
        }
        if (usedLetters.contains(letter)) {
            throw new IllegalArgumentException("Буква уже использована");
        }
        usedLetters.add(letter);
    }

    private boolean isCyrillic(char letter) {
        return (letter >= 'А' && letter <= 'я') || letter == 'ё' || letter == 'Ё';
    }

    private void unmaskWord(char letter) {
        StringBuilder updatedMask = new StringBuilder(maskedWord);
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == letter) {
                updatedMask.setCharAt(i, letter);
            }
        }
        maskedWord = updatedMask.toString();
    }

    public String getState() {
        return "Ваше слово: " + maskedWord +
                "\nОставшиеся попытки: " + numAttempts +
                (numAttempts < 6 ? "\n\n" + HANGMAN_STAGES[5 - numAttempts] : "") +
                "\nИспользованные буквы: " + usedLetters;
    }

    public int getNumAttempts() {
        return numAttempts;
    }

    public String getWord() {
        return word;
    }

    public boolean isWordGuessed() {
        return maskedWord.equals(word);
    }

    public void minusAttempt() {
        numAttempts--;
    }

}
