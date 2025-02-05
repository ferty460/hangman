public class Printer {

    public void displayGameState(Round round) {
        System.out.println("----------------------------------------\n" +
                round.getState() +
                "\n\nВведите букву: ");
    }

    public void displayActions() {
        System.out.println("""
                  Выберите действие:
                    1. Начать игру
                    2. Выйти
                  """);
    }

    public void displayError() {
        System.out.println("Ошибка! Попробуйте еще раз.");
    }

    public void displayWinMessage(Round round) {
        System.out.println("Поздравляем! Вы угадали слово: " + round.getWord() + "\n");
    }

    public void displayDefeatMessage(Round round) {
        System.out.println("Игра окончена. Загаданное слово было: " + round.getWord() + "\n");
    }

    public void displayLetterInfo(boolean isRightLetter) {
        System.out.println(isRightLetter ? "\nВы угадали букву!\n" : "\nУпс, такой буквы нет!\n");
    }

}
