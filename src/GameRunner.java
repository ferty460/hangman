import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class GameRunner {

    private final Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
    private final Printer printer = new Printer();

    public void run() {
        while (true) {
            printer.displayActions();
            String action = scanner.nextLine();

            switch (action) {
                case "1" -> play();
                case "2" -> {
                    return;
                }
                default -> printer.displayError();
            }
        }
    }

    private void play() {
        Round round = new Round();
        while (round.getNumAttempts() > 0) {
            printer.displayGameState(round);
            String letter = getUserInput();

            if (processLetter(round, letter)) {
                printer.displayWinMessage(round);
                return;
            }
        }
        printer.displayDefeatMessage(round);
    }

    private String getUserInput() {
        return scanner.nextLine().toLowerCase();
    }

    private boolean processLetter(Round round, String letter) {
        try {
            boolean isRightLetter = round.isRightLetter(letter);
            printer.displayLetterInfo(isRightLetter);

            if (!isRightLetter) {
                round.minusAttempt();
            }
            return round.isWordGuessed();
        } catch (IllegalArgumentException e) {
            System.err.println("\n" + e.getMessage() + "\n");
            return false;
        }
    }

}