import java.util.ArrayList;
import java.util.List;

public class Round {

    private int numAttempts = 6;
    private final String word;
    private final List<Character> usedLetters = new ArrayList<>();
    private String maskedWord;

    public Round() {
        this.word = new WordGenerator("src\\words.txt").getWord();
        this.maskedWord = "*".repeat(word.length());
    }

    public boolean isRightLetter(String input) {
        char letter = validateLetter(input);
        if (word.indexOf(letter) >= 0) {
            unmaskWord(letter);
            return true;
        }
        return false;
    }

    private char validateLetter(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("Пожалуйста, введите букву");
        }
        if (input.length() > 1) {
            throw new IllegalArgumentException("Пожалуйста, введите только одну букву");
        }

        char letter = input.charAt(0);
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

        return letter;
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
                "\n" + getHangman() +
                "\nИспользованные буквы: " + usedLetters;
    }

    private String getHangman() {
        int numMistakes = 6 - numAttempts;
        return switch (numMistakes) {
            case 1 -> HangmanStages.ONE_MISTAKE_STAGE.getHangman();
            case 2 -> HangmanStages.TWO_MISTAKES_STAGE.getHangman();
            case 3 -> HangmanStages.THREE_MISTAKES_STAGE.getHangman();
            case 4 -> HangmanStages.FOUR_MISTAKES_STAGE.getHangman();
            case 5 -> HangmanStages.FIVE_MISTAKES_STAGE.getHangman();
            case 6 -> HangmanStages.SIX_MISTAKES_STAGE.getHangman();
            default -> "";
        };
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
