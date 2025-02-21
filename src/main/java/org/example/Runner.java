package org.example;

import java.util.Scanner;

public class Runner {

    private final Printer printer = new Printer();
    private final Scanner scanner = new Scanner(System.in);

    public void run() {
        Settings settings = new Settings();

        while (true) {
            printer.printGameMenu();

            String action = scanner.nextLine();

            switch (action) {
                case "1" -> new Game(settings).loop();
                case "2" -> Settings.showActionMenu(settings);
                // case "3" -> showStatistics();
                case "4" -> {
                    return;
                }
                default -> printer.printWrongInputError();
            }
        }
    }

    /*private void showStatistics() {
    }*/

}