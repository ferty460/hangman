package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Random;

public class WordProvider {

    private final Path dictionaryFilePath;
    private final Difficult difficult;

    private final Random random = new Random();

    public WordProvider(Path dictionaryFilePath, Difficult difficult) {
        this.dictionaryFilePath = dictionaryFilePath;
        this.difficult = difficult;
    }

    public String provide() {
        List<String> dictionary;

        try {
            dictionary = Files.readAllLines(dictionaryFilePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        dictionary = filterDictionaryByDifficult(dictionary, difficult);

        int dictionarySize = dictionary.size();

        return dictionary.get(random.nextInt(dictionarySize));
    }

    private List<String> filterDictionaryByDifficult(List<String> dictionary, Difficult difficult) {
        return dictionary.stream()
                .filter(word -> switch (difficult) {
                    case EASY -> word.length() >= 5 && word.length() <= 6;
                    case MEDIUM -> word.length() >= 7 && word.length() <= 9;
                    case HARD -> word.length() >= 10;
                })
                .toList();
    }

}
