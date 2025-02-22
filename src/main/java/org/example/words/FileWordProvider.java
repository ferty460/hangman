package org.example.words;

import org.example.core.Difficulty;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Random;

public class FileWordProvider implements WordSource {

    private final Path dictionaryFilePath;
    private List<String> dictionary;
    private final Difficulty difficulty;

    private final Random random;

    public FileWordProvider(Path dictionaryFilePath, Difficulty difficulty) {
        this.dictionaryFilePath = dictionaryFilePath;
        this.difficulty = difficulty;

        random = new Random();
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
            dictionary = List.of("акула", "рюкзак", "тетрадь", "шимпанзе", "клавиатура", "человеконенавистничество");
            throw new RuntimeException("Ошибка чтения словаря: " + e.getMessage());
        }
        dictionary = filterDictionaryByDifficult(dictionary, difficulty);
    }

    private List<String> filterDictionaryByDifficult(List<String> dictionary, Difficulty difficulty) {
        return dictionary.stream()
                .filter(word -> switch (difficulty) {
                    case EASY -> word.length() >= 5 && word.length() <= 6;
                    case MEDIUM -> word.length() >= 7 && word.length() <= 9;
                    case HARD -> word.length() >= 10;
                })
                .toList();
    }

}
