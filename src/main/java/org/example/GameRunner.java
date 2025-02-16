package org.example;

import java.util.Scanner;

public class GameRunner {

    public void run() {
        Scanner scanner = new Scanner(System.in);
        Printer printer = new Printer();
        Game game = new Game();

        while (true) {
            printer.printMenu();

            String action = scanner.nextLine();

            switch (action) {
                case "1" -> game.loop();
                case "2" -> {
                    return;
                }
                default -> printer.printWrongInputError();
            }
        }
    }

}