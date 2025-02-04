import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class GameRunner {
    private final Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);

    public void run() {
        while (true) {
            System.out.println("""
                  Выберите действие:
                    1. Начать игру
                    2. Выйти
                  """);
            String action = scanner.nextLine();

            switch (action) {
                case "1" -> play();
                case "2" -> {
                    return;
                }
                default -> System.out.println("Ошибка! Попробуйте еще раз.");
            }
        }
    }

    private void play() {
        Round round = new Round();
        while (round.getNumAttempts() > 0) {
            displayGameState(round);
            char letter = getUserInput();

            if (processLetter(round, letter)) {
                System.out.println("Поздравляем! Вы угадали слово: " + round.getWord() + "\n");
                return;
            }
        }
        System.out.println("Игра окончена. Загаданное слово было: " + round.getWord() + "\n");
    }

    private void displayGameState(Round round) {
        System.out.println("----------------------------------------\n" +
                round.getState() +
                "\n\nВведите букву: ");
    }

    private char getUserInput() {
        return Character.toLowerCase(scanner.nextLine().charAt(0));
    }

    private boolean processLetter(Round round, char letter) {
        try {
            boolean isRightLetter = round.isRightLetter(letter);
            System.out.println(isRightLetter ? "\nВы угадали букву!\n" : "\nУпс, такой буквы нет!\n");

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