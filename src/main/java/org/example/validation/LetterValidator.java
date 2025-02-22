package org.example.validation;

import java.util.List;

public interface LetterValidator extends Validator<String> {

    void checkLetterNotUsed(char letter, List<Character> usedLetters);

}
