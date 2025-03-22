package org.example.settings;

import org.example.output.ConsolePrinter;
import org.example.difficulty.Difficulty;
import org.example.validation.FileValidator;
import org.example.validation.Validator;

import java.nio.file.Paths;
import java.util.Scanner;

public class SettingsConsoleUI {

    private static final String CHANGE_DIFFICULTY = "1";
    private static final String CHANGE_DICTIONARY = "2";
    private static final String DEFAULT_SETTINGS = "3";
    private static final String EXIT = "4";

    private static final String EASY = "1";
    private static final String MEDIUM = "2";
    private static final String HARD = "3";
    private static final String BACK_TO_MENU = "4";

    private final Scanner scanner;
    private final ConsolePrinter printer;

    public SettingsConsoleUI() {
        scanner = new Scanner(System.in);
        printer = new ConsolePrinter();
    }

    public void showActionMenu(Settings settings) {
        while (true) {
            printer.printDifficultyInfo(settings.getDifficulty());
            printer.printDictionarySource(settings.getDictionaryFilePath());
            printer.printSettingsMenu();

            String action = scanner.nextLine();

            switch (action) {
                case CHANGE_DIFFICULTY -> changeDifficulty(settings);
                case CHANGE_DICTIONARY -> changeDictionary(settings);
                case DEFAULT_SETTINGS -> {
                    settings.setDifficulty(Difficulty.MEDIUM);
                    settings.setDictionaryFilePath(Paths.get("src/main/resources/words.txt"));
                }
                case EXIT -> {
                    return;
                }
                default -> printer.printWrongInputError();
            }
        }
    }

    private void changeDifficulty(Settings settings) {
        printer.printDifficultyPrompt();

        String action = scanner.nextLine();

        switch (action) {
            case EASY -> settings.setDifficulty(Difficulty.EASY);
            case MEDIUM -> settings.setDifficulty(Difficulty.MEDIUM);
            case HARD -> settings.setDifficulty(Difficulty.HARD);
            case BACK_TO_MENU -> showActionMenu(settings);
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
