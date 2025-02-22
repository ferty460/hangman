package org.example.validation;

import java.util.List;

public class LetterValidatorImpl implements LetterValidator {

    @Override
    public void validate(String letter) {
        if (letter == null || letter.isEmpty()) {
            throw new IllegalArgumentException("Пожалуйста, введите букву");
        }
        if (letter.length() != 1) {
            throw new IllegalArgumentException("Введите только одну букву");
        }
        if (!letter.matches("[а-яё-]+")) {
            throw new IllegalArgumentException("Только кириллица маленькими буквами");
        }
    }

    @Override
    public void checkLetterNotUsed(char letter, List<Character> usedLetters) {
        if (usedLetters.contains(letter)) {
            throw new IllegalArgumentException("Вы уже использовали эту букву.");
        }
    }

}
