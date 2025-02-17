package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

public class WordProvider {

    private final Random random = new Random();

    public String provide() {
        List<String> dictionary;
        String path = "src/main/resources/words.txt";

        try {
            dictionary = Files.readAllLines(Paths.get(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        int dictionarySize = dictionary.size();

        return dictionary.get(random.nextInt(dictionarySize));
    }

}
