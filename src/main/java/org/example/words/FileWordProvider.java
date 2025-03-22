package org.example.words;

import org.example.difficulty.Difficulty;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Random;

public class FileWordProvider implements WordSource {

    private final Path dictionaryFilePath;
    private final Difficulty difficulty;
    private final Random random;
    private List<String> dictionary;

    public FileWordProvider(Path dictionaryFilePath, Difficulty difficulty) {
        this.dictionaryFilePath = dictionaryFilePath;
        this.difficulty = difficulty;
        this.random = new Random();
        loadDictionary();
    }

    @Override
    public String getRandomWord() {
        return dictionary.get(random.nextInt(dictionary.size()));
    }

    private void loadDictionary() {
        try {
            dictionary = Files.readAllLines(dictionaryFilePath);
        } catch (IOException e) {
            throw new RuntimeException("Error loading dictionary: " + e.getMessage());
        }
        dictionary = difficulty.filterWords(dictionary);
    }

}
