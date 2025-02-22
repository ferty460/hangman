package org.example.core;

import org.example.output.ConsolePrinter;
import org.example.settings.Settings;
import org.example.settings.SettingsConsoleUI;

import java.util.Scanner;

public class GameLauncher {

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
                case "1" -> new Game(settings).loop();
                case "2" -> settingsUI.showActionMenu(settings);
                case "3" -> showStatistics();
                case "4" -> {
                    return;
                }
                default -> printer.printWrongInputError();
            }
        }
    }

    private void showStatistics() {
    }

}