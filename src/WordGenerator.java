import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

public class WordGenerator {
    private final List<String> words;

    public WordGenerator(String filePath) {
        try {
            words = Files.readAllLines(Paths.get(filePath));
        } catch (IOException e) {
            throw new RuntimeException("Ошибка при чтении файла", e);
        }
    }

    public String getWord() {
        return words.isEmpty() ? "" : words.get(new Random().nextInt(words.size()));
    }
}
