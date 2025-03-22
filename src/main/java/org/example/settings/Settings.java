package org.example.settings;

import org.example.difficulty.Difficulty;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Settings {

    public static final int MAX_ATTEMPTS = 6;
    public static final int MIN_ATTEMPTS = 0;
    private static final Path DEFAULT_DICTIONARY_PATH = Paths.get("src/main/resources/words.txt");
    private static final Difficulty DEFAULT_DIFFICULTY = Difficulty.MEDIUM;

    private Difficulty difficulty;
    private Path dictionaryFilePath;

    public Settings() {
        this.difficulty = DEFAULT_DIFFICULTY;
        this.dictionaryFilePath = DEFAULT_DICTIONARY_PATH;
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
