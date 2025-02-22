package org.example.core;

import org.example.output.ConsolePrinter;
import org.example.settings.Settings;
import org.example.validation.LetterValidator;
import org.example.validation.LetterValidatorImpl;
import org.example.words.FileWordProvider;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

    private final HiddenWord hiddenWord;
    private final List<Character> usedLetters;
    private int attempts;

    private final LetterValidator validator;
    private final ConsolePrinter printer;

    public Game(Settings settings) {
        this.usedLetters = new ArrayList<>();
        this.attempts = settings.getMaxAttempts();

        Path file = settings.getDictionaryFilePath();
        Difficulty difficulty = settings.getDifficulty();
        String word = new FileWordProvider(file, difficulty).getRandomWord();
        this.hiddenWord = new HiddenWord(word);

        validator = new LetterValidatorImpl();
        printer = new ConsolePrinter();
    }

    public void loop() {
        Scanner scanner = new Scanner(System.in);

        while (isRunning()) {
            printer.printGameState(attempts, hiddenWord, usedLetters);
            printer.printLetterPrompt();

            String input = scanner.nextLine();
            try {
                validator.validate(input);
                validator.checkLetterNotUsed(input.charAt(0), usedLetters);
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

    private boolean isRunning() {
        return !hiddenWord.isWordGuessed() && attempts > 0;
    }

}
