package org.example;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Settings {

    public final int maxAttempts = 6;
    private Difficult difficult;
    private Path dictionaryFilePath;

    private static final Printer printer = new Printer();
    private static final Scanner scanner = new Scanner(System.in);

    public Settings() {
        this.difficult = Difficult.MEDIUM;
        this.dictionaryFilePath = Paths.get("src/main/resources/words.txt");
    }

    public static void showActionMenu(Settings settings) {
        while (true) {
            printer.printSettingsState(settings);
            printer.printSettingsMenu();

            String action = scanner.nextLine();

            switch (action) {
                case "1" -> changeDifficult(settings);
                case "2" -> changeDictionary(settings);
                case "3" -> settings = new Settings();
                case "4" -> {
                    return;
                }
                default -> printer.printWrongInputError();
            }
        }
    }

    private static void changeDifficult(Settings settings) {
        printer.printDifficultPrompt();

        String action = scanner.nextLine();

        switch (action) {
            case "1" -> settings.setDifficult(Difficult.EASY);
            case "2" -> settings.setDifficult(Difficult.MEDIUM);
            case "3" -> settings.setDifficult(Difficult.HARD);
            case "4" -> showActionMenu(settings);
            default -> printer.printWrongInputError();
        }
    }

    private static void changeDictionary(Settings settings) {
        Validator validator = new Validator();
        printer.printDictionaryFilePrompt();

        String dictionary = scanner.nextLine();
        try {
            validator.validateFile(dictionary);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return;
        }

        settings.setDictionaryFilePath(Paths.get(dictionary));
    }

    // getters, setters

    public Difficult getDifficult() {
        return difficult;
    }

    public void setDifficult(Difficult difficult) {
        this.difficult = difficult;
    }

    public Path getDictionaryFilePath() {
        return dictionaryFilePath;
    }

    public void setDictionaryFilePath(Path dictionaryFilePath) {
        this.dictionaryFilePath = dictionaryFilePath;
    }

}
