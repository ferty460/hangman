package org.example.core;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Statistics {

    private int totalGames;
    private int wins;
    private int defeats;
    private int totalAttempts;
    private long totalTimeSpent; // milliseconds

    private static final Path STATS_FILE = Paths.get("src/main/resources/stats.txt");

    public Statistics() {
        loadStats();
    }

    private void loadStats() {
        if (!STATS_FILE.toFile().exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(STATS_FILE.toFile()))) {
            totalGames = Integer.parseInt(reader.readLine());
            wins = Integer.parseInt(reader.readLine());
            defeats = Integer.parseInt(reader.readLine());
            totalAttempts = Integer.parseInt(reader.readLine());
            totalTimeSpent = Long.parseLong(reader.readLine());
        } catch (IOException | NumberFormatException e) {
            System.err.println("Ошибка загрузки статистики: " + e.getMessage());
        }
    }

    public void recordGame(boolean won, int attempts, long timeSpent) {
        totalGames++;
        if (won) {
            wins++;
        } else {
            defeats++;
        }
        totalAttempts += attempts;
        totalTimeSpent += timeSpent;
        saveStats();
    }

    private void saveStats() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(STATS_FILE.toFile()))) {
            writer.write(totalGames + "\n" + wins + "\n" + defeats + "\n" + totalAttempts + "\n" + totalTimeSpent);
        } catch (IOException e) {
            System.err.println("Ошибка сохранения статистики: " + e.getMessage());
        }
    }

    public double getAverageAttempts() {
        return (totalGames > 0) ? (double) totalAttempts / totalGames : 0;
    }

    public double getAverageTimeSpent() {
        return (totalGames > 0) ? (double) totalTimeSpent / totalGames / 1000 : 0; // seconds
    }

    public void printStats() {
        System.out.println("=== Статистика игры ===");
        System.out.println("Сыграно игр: " + totalGames);
        System.out.println("Победы: " + wins);
        System.out.println("Поражения: " + defeats);
        System.out.printf("Среднее число попыток: %.2f%n", getAverageAttempts());
        System.out.printf("Среднее время игры: %.2f секунд%n", getAverageTimeSpent());
        System.out.println("=======================\n");
    }

}
