package org.example.validation;

public class LetterFormatValidator implements Validator<String> {

    private static final String CYRILLIC_REGEX = "^[а-яё-]$";

    @Override
    public void validate(String letter) {
        if (letter == null || letter.isEmpty()) {
            throw new IllegalArgumentException("Please enter the letter");
        }
        if (!letter.matches(CYRILLIC_REGEX)) {
            throw new IllegalArgumentException("Enter only one cyrillic letter");
        }
    }

}
