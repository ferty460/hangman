package org.example;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Game {

    private final int maxAttempts;
    private final HiddenWord hiddenWord;
    private final List<Character> usedLetters;

    private final Validator validator;
    private final Printer printer;

    public Game() {
        String word = new WordProvider().provide();
        this.maxAttempts = 6;
        this.usedLetters = new LinkedList<>();
        this.validator = new Validator(usedLetters);
        this.printer = new Printer();
        this.hiddenWord = new HiddenWord(word);
    }

    public void loop() {
        Scanner scanner = new Scanner(System.in);
        int attempts = maxAttempts;

        while (!hiddenWord.isWordGuessed() && attempts > 0) {
            printer.printGameState(attempts, hiddenWord, usedLetters);
            printer.printLetterPrompt();

            String input = scanner.nextLine();
            try {
                validator.validateLetter(input);
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: " + e.getMessage() + "\n");
                continue;
            }

            char letter = input.charAt(0);
            usedLetters.add(letter);
            attempts = processUserGuess(hiddenWord, letter, attempts);
        }

        printer.printGameResult(hiddenWord);
    }

    private int processUserGuess(HiddenWord hiddenWord, char letter, int attempts) {
        if (hiddenWord.guessLetter(letter)) {
            printer.printLetterGuessedMessage();
        } else {
            printer.printWrongLetterMessage();
            attempts--;
        }

        return attempts;
    }

}
