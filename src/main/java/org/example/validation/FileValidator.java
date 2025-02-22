package org.example.validation;

import java.io.File;

public class FileValidator implements Validator<String> {

    @Override
    public void validate(String file) {
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
