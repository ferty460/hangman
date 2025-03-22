package org.example.difficulty;

import java.util.List;
import java.util.stream.Collectors;

public enum Difficulty {

    EASY(5, 6),
    MEDIUM(7, 9),
    HARD(10, Integer.MAX_VALUE);

    private final int minLength;
    private final int maxLength;

    Difficulty(int minLength, int maxLength) {
        this.minLength = minLength;
        this.maxLength = maxLength;
    }

    public List<String> filterWords(List<String> words) {
        return words.stream()
                .filter(word -> word.length() >= minLength && word.length() <= maxLength)
                .collect(Collectors.toList());
    }

    public int getMinLength() {
        return minLength;
    }

    public int getMaxLength() {
        return maxLength;
    }

}
