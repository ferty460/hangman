package org.example.core;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class StatisticsStorage {

    private static final Path STATS_FILE_PATH = Paths.get("src/main/resources/stats.txt");

    public void save(Statistics statistics) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(STATS_FILE_PATH.toFile()))) {
            writer.write(statistics.getTotalGames() + "\n" +
                    statistics.getWins() + "\n" +
                    statistics.getDefeats() + "\n" +
                    statistics.getTotalAttempts() + "\n" +
                    statistics.getTotalTimeSpent());
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void load(Statistics statistics) {
        if (!STATS_FILE_PATH.toFile().exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(STATS_FILE_PATH.toFile()))) {
            int totalGames = Integer.parseInt(reader.readLine());
            int wins = Integer.parseInt(reader.readLine());
            int defeats = Integer.parseInt(reader.readLine());
            int totalAttempts = Integer.parseInt(reader.readLine());
            long totalTimeSpent = Long.parseLong(reader.readLine());

            statistics.setStatistics(totalGames, wins, defeats, totalAttempts, totalTimeSpent);
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}
