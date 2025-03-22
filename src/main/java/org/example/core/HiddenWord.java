package org.example.core;

import org.example.difficulty.Difficulty;
import org.example.words.InMemoryWordProvider;
import org.example.words.FileWordProvider;
import org.example.words.WordSource;

import java.nio.file.Path;

public class HiddenWord {

    private static final String MASKED_SYMBOL = "*";

    private final String word;
    private final StringBuilder revealedWord;

    public HiddenWord(Path dictionaryPath, Difficulty difficulty) {
        WordSource source;
        try {
            source = new FileWordProvider(dictionaryPath, difficulty);
        } catch (RuntimeException e) {
            source = new InMemoryWordProvider();
        }
        String word = source.getRandomWord();
        String mask = MASKED_SYMBOL.repeat(word.length());
        this.word = word;
        this.revealedWord = new StringBuilder(mask);
    }

    public boolean containsLetter(char letter) {
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == letter) {
                return true;
            }
        }
        return false;
    }

    public void openLetter(char letter) {
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == letter) {
                revealedWord.setCharAt(i, letter);
            }
        }
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
