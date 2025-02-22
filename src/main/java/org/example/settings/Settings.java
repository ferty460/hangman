package org.example.settings;

import org.example.core.Difficulty;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Settings {

    private static final int DEFAULT_MAX_ATTEMPTS = 6;
    private static final Path DEFAULT_DICTIONARY_PATH = Paths.get("src/main/resources/words.txt");
    private static final Difficulty DEFAULT_DIFFICULTY = Difficulty.MEDIUM;

    private int maxAttempts;
    private Difficulty difficulty;
    private Path dictionaryFilePath;

    public Settings() {
        this.maxAttempts = DEFAULT_MAX_ATTEMPTS;
        this.difficulty = DEFAULT_DIFFICULTY;
        this.dictionaryFilePath = DEFAULT_DICTIONARY_PATH;
    }

    public int getMaxAttempts() {
        return maxAttempts;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public Path getDictionaryFilePath() {
        return dictionaryFilePath;
    }

    public void setDictionaryFilePath(Path dictionaryFilePath) {
        this.dictionaryFilePath = dictionaryFilePath;
    }

}
