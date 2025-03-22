package org.example.difficulty;

import java.util.Map;

public class DifficultyInfoProvider {

    private static final Map<Difficulty, String> NAMES = Map.of(
            Difficulty.EASY, "Легкий",
            Difficulty.MEDIUM, "Средний",
            Difficulty.HARD, "Сложный"
    );

    public static String getName(Difficulty difficulty) {
        return NAMES.getOrDefault(difficulty, "Неизвестный");
    }

    public static String getDescription(Difficulty difficulty) {
        if (difficulty.getMaxLength() == Integer.MAX_VALUE) {
            return String.format("Слова длиной от %d символов", difficulty.getMinLength());
        }
        return String.format("Слова длиной от %d до %d символов",
                difficulty.getMinLength(), difficulty.getMaxLength());
    }

}
