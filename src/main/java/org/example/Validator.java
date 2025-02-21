package org.example;

import java.io.File;
import java.util.List;

public class Validator {

    public void validateLetter(String letter, List<Character> usedLetters) {
        if (letter == null || letter.isEmpty()) {
            throw new IllegalArgumentException("Пожалуйста, введите букву");
        }
        if (letter.length() != 1) {
            throw new IllegalArgumentException("Введите только одну букву");
        }
        if (!letter.matches("[а-яё-]+")) {
            throw new IllegalArgumentException("Только кириллица маленькими буквами");
        }
        if (usedLetters.contains(letter.charAt(0))) {
            throw new IllegalArgumentException("Вы уже использовали эту букву");
        }
    }

    public void validateFile(String file) {
        File filePath = new File(file);
        if (!filePath.exists()) {
            throw new IllegalArgumentException("Такой файл не существует");
        }
        if (!filePath.isAbsolute()) {
            throw new IllegalArgumentException("Путь должен быть абсолютными (пример: E:\\files\\words.txt)");
        }
        if (!filePath.isFile()) {
            throw new IllegalArgumentException("Пожалуйста, введите адрес файла");
        }
        if (!filePath.toString().endsWith(".txt")) {
            throw new IllegalArgumentException("Файл должен быть с расширением .txt");
        }
    }

}
