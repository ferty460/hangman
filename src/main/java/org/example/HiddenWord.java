package org.example;

public class HiddenWord {

    private final String word;
    private final StringBuilder revealedWord;

    public HiddenWord(String word) {
        this.word = word;
        this.revealedWord = new StringBuilder("*".repeat(word.length()));
    }

    public boolean guessLetter(char letter) {
        boolean isLetterFound = false;

        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == letter) {
                revealedWord.setCharAt(i, letter);
                isLetterFound = true;
            }
        }

        return isLetterFound;
    }

    public boolean isWordGuessed() {
        return revealedWord.toString().equals(word);
    }

    public String getRevealedWord() {
        return revealedWord.toString();
    }

    public String getWord() {
        return word;
    }

}
