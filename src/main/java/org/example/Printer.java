package org.example;

import java.util.List;

public class Printer {

    public void printGameMenu() {
        String menuActions = """
                Выберите действие:
                [1] - Начать игру
                [2] - Настройки
                [4] - Выйти
                """;
        System.out.println(menuActions);
    }

    public void printSettingsMenu() {
        String menuActions = """
                Выберите действие:
                [1] - Изменить сложность
                [2] - Изменить словарь
                [3] - Вернуть настройки по умолчанию
                [4] - Назад
                """;
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

    public void printSettingsState(Settings settings) {
        Difficult currentDifficult = settings.getDifficult();
        String dictionaryFilePath = settings.getDictionaryFilePath().toString();
        boolean isDefaultDictionary = "src\\main\\resources\\words.txt".equals(dictionaryFilePath);

        System.out.println("\nВаш уровень сложности: " + currentDifficult.getName() +
                " (" + currentDifficult.getDescription() + ")");
        System.out.println("Ваш словарь: " +
                (isDefaultDictionary ? "по умолчанию" : dictionaryFilePath) + "\n");
    }

    public void printLetterPrompt() {
        System.out.println("Введите букву:");
    }

    public void printLetterGuessedMessage() {
        System.out.println("Вы угадали букву!\n");
    }

    public void printDifficultPrompt() {
        String menuActions = """
                Выберите уровень сложности:
                [1] - Легкий (Слова длиной от 5 до 6 символов)
                [2] - Средний (Слова длиной от 7 до 9 символов)
                [3] - Сложный (Слова длиной более 10 символов)
                [4] - Назад
                """;
        System.out.println(menuActions);
    }

    public void printDictionaryFilePrompt() {
        System.out.println("Введите абсолютный адрес файла со словарем (н/п, D:\\files\\words.txt)");
    }

    public void printWrongLetterMessage() {
        System.out.println("К сожалению, такой буквы нет.\n");
    }

    public void printWrongInputError() {
        System.out.println("Неверный ввод!\n");
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
