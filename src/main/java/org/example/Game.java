package org.example;

import java.util.Scanner;

public class Game {

    private final String word;
    private final int maxAttempts;

    public Game() {
        WordGenerator wordGenerator = new WordGenerator();
        this.word = wordGenerator.generate();
        this.maxAttempts = 6;
    }

    public void loop() {
        Scanner scanner = new Scanner(System.in);
        HiddenWord hiddenWord = new HiddenWord(word);
        Printer printer = new Printer();
        int attempts = maxAttempts;

        while (!hiddenWord.isWordGuessed() && attempts > 0) {
            printer.printGameState(attempts, hiddenWord);
            printer.printLetterPrompt();

            String letter = scanner.nextLine();
            if (hiddenWord.guessLetter(letter.charAt(0))) {
                printer.printLetterGuessedMessage();
            } else {
                printer.printWrongLetterMessage();
                attempts--;
            }
        }

        String word = hiddenWord.getWord();
        if (hiddenWord.isWordGuessed()) {
            printer.printWinMessage(word);
        } else {
            printer.printDefeatMessage(word);
        }
    }

}
