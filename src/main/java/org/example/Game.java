package org.example;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

    private final Settings settings;
    private final HiddenWord hiddenWord;
    private final List<Character> usedLetters;

    private static final Validator validator = new Validator();
    private static final Printer printer = new Printer();

    public Game(Settings settings) {
        this.settings = settings;
        this.usedLetters = new ArrayList<>();

        Path file = settings.getDictionaryFilePath();
        Difficult difficult = settings.getDifficult();
        String word = new WordProvider(file, difficult).provide();
        this.hiddenWord = new HiddenWord(word);
    }

    public void loop() {
        Scanner scanner = new Scanner(System.in);
        int attempts = settings.maxAttempts;

        while (!hiddenWord.isWordGuessed() && attempts > 0) {
            printer.printGameState(attempts, hiddenWord, usedLetters);
            printer.printLetterPrompt();

            String input = scanner.nextLine();
            try {
                validator.validateLetter(input, usedLetters);
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
