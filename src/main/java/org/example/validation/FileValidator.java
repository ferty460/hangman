package org.example.validation;

import java.io.File;

public class FileValidator implements Validator<String> {

    private static final String FILE_EXTENSION = ".txt";

    @Override
    public void validate(String file) {
        File filePath = new File(file);
        if (!filePath.exists()) {
            throw new IllegalArgumentException("Such a file does not exist");
        }
        if (!filePath.isAbsolute()) {
            throw new IllegalArgumentException("The path must be absolute (example: E:\\files\\words.txt)");
        }
        if (!filePath.isFile()) {
            throw new IllegalArgumentException("Please enter the file address.");
        }
        if (!filePath.toString().endsWith(FILE_EXTENSION)) {
            throw new IllegalArgumentException("The file must have the extension .txt");
        }
    }

}
