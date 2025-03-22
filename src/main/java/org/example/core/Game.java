package org.example.core;

import org.example.output.GameOutput;
import org.example.settings.Settings;
import org.example.validation.LetterFormatValidator;
import org.example.validation.LetterUsageValidator;
import org.example.validation.Validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

    private final Settings settings;
    private final HiddenWord hiddenWord;
    private final List<Character> usedLetters;
    private final Statistics statistics;
    private final Validator<String> formatValidator;
    private final Validator<Character> usageValidator;
    private final GameOutput printer;
    private final Scanner scanner;
    private int attempts;

    public Game(Settings settings, GameOutput printer) {
        this.settings = settings;
        this.hiddenWord = new HiddenWord(settings.getDictionaryFilePath(), settings.getDifficulty());
        this.usedLetters = new ArrayList<>();
        this.attempts = Settings.MAX_ATTEMPTS;
        this.statistics = new Statistics();
        this.formatValidator = new LetterFormatValidator();
        this.usageValidator = new LetterUsageValidator(usedLetters);
        this.printer = printer;
        this.scanner = new Scanner(System.in);
    }

    public void loop() {
        long startTime = System.currentTimeMillis();

        processGame();
        finalizeGame();

        long endTime = System.currentTimeMillis();
        recordStatistics(startTime, endTime);
    }

    private void processGame() {
        while (isRunning()) {
            printer.printHangman(Settings.MAX_ATTEMPTS - attempts);
            printer.printGameState(attempts, hiddenWord, usedLetters);
            printer.printLetterPrompt();

            String input = scanner.nextLine().toLowerCase();
            if (!validateLetter(input)) {
                continue;
            }

            char letter = input.charAt(0);
            usedLetters.add(letter);

            if (hiddenWord.containsLetter(letter)) {
                hiddenWord.openLetter(letter);
                printer.printLetterGuessedMessage();
            } else {
                printer.printWrongLetterMessage();
                attempts--;
            }
        }
    }

    private void finalizeGame() {
        if (hiddenWord.isWordGuessed()) {
            printer.printWinMessage(hiddenWord.getWord());
        } else {
            printer.printHangman(Settings.MAX_ATTEMPTS - attempts);
            printer.printLoseMessage(hiddenWord.getWord());
        }
    }

    private boolean isRunning() {
        return !hiddenWord.isWordGuessed() && attempts > Settings.MIN_ATTEMPTS;
    }

    private boolean validateLetter(String strLetter) {
        try {
            formatValidator.validate(strLetter);
            usageValidator.validate(strLetter.charAt(0));
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage() + "\n");
            return false;
        }
    }

    private void recordStatistics(long startTime, long endTime) {
        statistics.recordGame(
                hiddenWord.isWordGuessed(),
                Settings.MAX_ATTEMPTS - attempts,
                endTime - startTime
        );
    }
}
