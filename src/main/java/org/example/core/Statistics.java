package org.example.core;

public class Statistics {

    private int totalGames;
    private int wins;
    private int defeats;
    private int totalAttempts;
    private long totalTimeSpent; // milliseconds

    private final StatisticsStorage storage;

    public Statistics() {
        storage = new StatisticsStorage();
        storage.load(this);
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
        storage.save(this);
    }

    public double getAverageAttempts() {
        return (totalGames > 0) ? (double) totalAttempts / totalGames : 0;
    }

    public double getAverageTimeSpent() {
        return (totalGames > 0) ? (double) totalTimeSpent / totalGames / 1000 : 0; // seconds
    }

    public int getTotalGames() { return totalGames; }
    public int getWins() { return wins; }
    public int getDefeats() { return defeats; }
    public int getTotalAttempts() { return totalAttempts; }
    public long getTotalTimeSpent() { return totalTimeSpent; }

    public void setStatistics(int totalGames, int wins, int defeats, int totalAttempts, long totalTimeSpent) {
        this.totalGames = totalGames;
        this.wins = wins;
        this.defeats = defeats;
        this.totalAttempts = totalAttempts;
        this.totalTimeSpent = totalTimeSpent;
    }

}
