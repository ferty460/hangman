package org.example;

import java.util.List;

public class Validator {

    private final List<Character> usedLetters;

    public Validator(List<Character> usedLetters) {
        this.usedLetters = usedLetters;
    }

    public void validateLetter(String letter) {
        if (letter == null || letter.isEmpty()) {
            throw new IllegalArgumentException("Пожалуйста, введите букву");
        }
        if (letter.length() != 1) {
            throw new IllegalArgumentException("Введите только одну букву");
        }
        if (!letter.matches("[а-яё]+")) {
            throw new IllegalArgumentException("Только кириллица маленькими буквами");
        }
        if (usedLetters.contains(letter.charAt(0))) {
            throw new IllegalArgumentException("Вы уже использовали эту букву");
        }
    }

}
