package org.example.core;

import org.example.output.ConsolePrinter;
import org.example.settings.Settings;
import org.example.settings.SettingsConsoleUI;

import java.util.Scanner;

public class GameLauncher {

    private static final String START_GAME = "1";
    private static final String SETTINGS = "2";
    private static final String STATS = "3";
    private static final String EXIT = "4";

    private final Settings settings;
    private final SettingsConsoleUI settingsUI;
    private final ConsolePrinter printer;
    private final Scanner scanner;

    public GameLauncher() {
        printer = new ConsolePrinter();
        settings = new Settings();
        settingsUI = new SettingsConsoleUI();
        scanner = new Scanner(System.in);
    }

    public void run() {
        while (true) {
            printer.printGameMenu();

            String action = scanner.nextLine();

            switch (action) {
                case START_GAME -> new Game(settings, new ConsolePrinter()).loop();
                case SETTINGS -> settingsUI.showActionMenu(settings);
                case STATS -> printer.printStats(new Statistics());
                case EXIT -> {
                    return;
                }
                default -> printer.printWrongInputError();
            }
        }
    }

}