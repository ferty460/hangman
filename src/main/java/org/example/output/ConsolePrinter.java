package org.example.output;

import org.example.core.Statistics;
import org.example.difficulty.Difficulty;
import org.example.difficulty.DifficultyInfoProvider;
import org.example.core.HangmanStages;
import org.example.core.HiddenWord;

import java.nio.file.Path;
import java.util.List;

public class ConsolePrinter implements GameOutput {

    @Override
    public void printGameState(int attempts, HiddenWord hiddenWord, List<Character> usedLetters) {
        String revealedWord = hiddenWord.getRevealedWord();

        System.out.printf("Ваше слово: %s%nКоличество попыток: %s%nИспользованные буквы: %s%n",
                revealedWord, attempts, usedLetters);
    }

    @Override
    public void printHangman(int numStage) {
        System.out.println(HangmanStages.get(numStage));
    }

    @Override
    public void printLetterPrompt() {
        System.out.println("Введите букву:");
    }

    @Override
    public void printLetterGuessedMessage() {
        System.out.println("Вы угадали букву!\n");
    }

    @Override
    public void printWrongLetterMessage() {
        System.out.println("К сожалению, такой буквы нет.\n");
    }

    @Override
    public void printWinMessage(String hiddenWord) {
        System.out.println("Вы угадали слово: " + hiddenWord + "\n");
    }

    @Override
    public void printLoseMessage(String hiddenWord) {
        System.out.println("К сожалению, вы проиграли. \nЗагаданное слово: " + hiddenWord + "\n");
    }

    @Override
    public void printGameMenu() {
        String menuActions = """
                Выберите действие:
                [1] - Начать игру
                [2] - Настройки
                [3] - Статистика
                [4] - Выйти
                """;
        System.out.println(menuActions);
    }

    @Override
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

    @Override
    public void printDictionarySource(Path dictionaryFilePath) {
        String strDictionaryFilePath = dictionaryFilePath.toString();
        System.out.printf("Ваш словарь: %s %n%n", strDictionaryFilePath);
    }

    @Override
    public void printDifficultyPrompt() {
        String menuActions = """
                Выберите уровень сложности:
                [1] - Легкий (Слова длиной от 5 до 6 символов)
                [2] - Средний (Слова длиной от 7 до 9 символов)
                [3] - Сложный (Слова длиной более 10 символов)
                [4] - Назад
                """;
        System.out.println(menuActions);
    }

    @Override
    public void printDifficultyInfo(Difficulty difficulty) {
        System.out.printf("\nВаш уровень сложности: %s (%s)",
                DifficultyInfoProvider.getName(difficulty),
                DifficultyInfoProvider.getDescription(difficulty));
    }

    @Override
    public void printDictionaryFilePrompt() {
        System.out.println("Введите абсолютный адрес файла со словарем (н/п, D:\\files\\words.txt)");
    }

    @Override
    public void printWrongInputError() {
        System.out.println("Неверный ввод!\n");
    }

    public void printStats(Statistics statistics) {
        System.out.println("=== Статистика игры ===");
        System.out.println("Сыграно игр: " + statistics.getTotalGames());
        System.out.println("Победы: " + statistics.getWins());
        System.out.println("Поражения: " + statistics.getDefeats());
        System.out.printf("Среднее число попыток: %.2f%n", statistics.getAverageAttempts());
        System.out.printf("Среднее время игры: %.2f секунд%n", statistics.getAverageTimeSpent());
        System.out.println("=======================\n");
    }

}
