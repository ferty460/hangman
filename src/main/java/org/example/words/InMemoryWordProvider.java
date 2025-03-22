package org.example.words;

import java.util.List;
import java.util.Random;

public class InMemoryWordProvider implements WordSource {

    private static final List<String> DEFAULT_WORDS = List.of("акула", "рюкзак", "тетрадь", "шимпанзе", "клавиатура");
    private final Random random;

    public InMemoryWordProvider() {
        random = new Random();
    }

    @Override
    public String getRandomWord() {
        return DEFAULT_WORDS.get(random.nextInt(DEFAULT_WORDS.size()));
    }

}
