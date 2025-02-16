package org.example;

public class Printer {

    public void printMenu() {
        String menuActions = """
                Выберите действие:
                [1] - Начать игру
                [2] - Выйти
                """;
        /*String menuActions = """ todo
                Выберите действие:
                [1] - Начать игру
                [2] - Настройки
                [3] - Статистика
                [4] - Выйти
                """;*/
        System.out.println(menuActions);
    }

    public void printGameState(int attempts, HiddenWord hiddenWord) {
        String revealedWord = hiddenWord.getRevealedWord();
        System.out.println("Ваше слово: " + revealedWord);
        System.out.println("Количество попыток: " + attempts);
    }

    public void printLetterPrompt() {
        System.out.println("Введите букву:");
    }

    public void printLetterGuessedMessage() {
        System.out.println("Вы угадали букву!\n");
    }

    public void printWrongLetterMessage() {
        System.out.println("К сожалению, такой буквы нет.\n");
    }

    public void printWinMessage(String word) {
        System.out.println("Вы угадали слово: " + word + "\n");
    }

    public void printDefeatMessage(String word) {
        System.out.println("К сожалению, вы проиграли. \nЗагаданное слово: " + word + "\n");
    }

    public void printWrongInputError() {
        String error = "Неверный ввод!\n";
        System.out.println(error);
    }

}
