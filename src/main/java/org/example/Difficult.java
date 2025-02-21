package org.example;

public enum Difficult {

    EASY("Легкий", "Слова длиной от 5 до 6 символов"),
    MEDIUM("Средний", "Слова длиной от 7 до 9 символов"),
    HARD("Сложный", "Слова длиной более 10 символов");

    private final String name;
    private final String description;

    Difficult(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

}
