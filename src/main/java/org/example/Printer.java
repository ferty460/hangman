package org.example;

import java.util.List;

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

    public void printGameState(int attempts, HiddenWord hiddenWord, List<Character> usedLetters) {
        String revealedWord = hiddenWord.getRevealedWord();

        String hangman = switch (attempts) {
            case 5 -> HangmanStage.STAGE_1.getHangman();
            case 4 -> HangmanStage.STAGE_2.getHangman();
            case 3 -> HangmanStage.STAGE_3.getHangman();
            case 2 -> HangmanStage.STAGE_4.getHangman();
            case 1 -> HangmanStage.STAGE_5.getHangman();
            default -> "";
        };

        System.out.println("Ваше слово: " + revealedWord);
        System.out.print(hangman);
        System.out.println("Количество попыток: " + attempts);
        System.out.println("Использованные буквы: " + usedLetters);
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

    public void printWrongInputError() {
        String error = "Неверный ввод!\n";
        System.out.println(error);
    }

    public void printGameResult(HiddenWord hiddenWord) {
        String word = hiddenWord.getWord();
        if (hiddenWord.isWordGuessed()) {
            System.out.println("Вы угадали слово: " + word + "\n");
        } else {
            System.out.println(HangmanStage.STAGE_6.getHangman());
            System.out.println("К сожалению, вы проиграли. \nЗагаданное слово: " + word + "\n");
        }
    }

}
