package org.example.settings;

import org.example.output.ConsolePrinter;
import org.example.core.Difficulty;
import org.example.validation.FileValidator;
import org.example.validation.Validator;

import java.nio.file.Paths;
import java.util.Scanner;

public class SettingsConsoleUI {

    private final Scanner scanner;
    private final ConsolePrinter printer;

    public SettingsConsoleUI() {
        scanner = new Scanner(System.in);
        printer = new ConsolePrinter();
    }

    public void showActionMenu(Settings settings) {
        while (true) {
            printer.printSettingsState(settings);
            printer.printSettingsMenu();

            String action = scanner.nextLine();

            switch (action) {
                case "1" -> changeDifficulty(settings);
                case "2" -> changeDictionary(settings);
                case "3" -> {
                    settings.setDifficulty(Difficulty.MEDIUM);
                    settings.setDictionaryFilePath(Paths.get("src/main/resources/words.txt"));
                }
                case "4" -> {
                    return;
                }
                default -> printer.printWrongInputError();
            }
        }
    }

    private void changeDifficulty(Settings settings) {
        printer.printDifficultPrompt();

        String action = scanner.nextLine();

        switch (action) {
            case "1" -> settings.setDifficulty(Difficulty.EASY);
            case "2" -> settings.setDifficulty(Difficulty.MEDIUM);
            case "3" -> settings.setDifficulty(Difficulty.HARD);
            case "4" -> showActionMenu(settings);
            default -> printer.printWrongInputError();
        }
    }

    private void changeDictionary(Settings settings) {
        Validator<String> validator = new FileValidator();
        printer.printDictionaryFilePrompt();

        String dictionary = scanner.nextLine();
        try {
            validator.validate(dictionary);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return;
        }

        settings.setDictionaryFilePath(Paths.get(dictionary));
    }

}
