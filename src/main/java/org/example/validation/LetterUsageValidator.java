package org.example.validation;

import java.util.List;

public class LetterUsageValidator implements Validator<Character> {

    private final List<Character> usedLetters;

    public LetterUsageValidator(List<Character> usedLetters) {
        this.usedLetters = usedLetters;
    }

    @Override
    public void validate(Character letter) {
        if (usedLetters.contains(letter)) {
            throw new IllegalArgumentException("You have already used this letter");
        }
    }

}
