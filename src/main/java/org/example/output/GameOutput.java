package org.example.output;

import org.example.difficulty.Difficulty;
import org.example.core.HiddenWord;

import java.nio.file.Path;
import java.util.List;

public interface GameOutput {

    void printGameState(int attempts, HiddenWord hiddenWord, List<Character> usedLetters);
    void printGameMenu();
    void printWinMessage(String hiddenWord);
    void printLoseMessage(String hiddenWord);
    void printLetterPrompt();
    void printLetterGuessedMessage();
    void printWrongLetterMessage();
    void printWrongInputError();
    void printDictionaryFilePrompt();
    void printDictionarySource(Path dictionaryFilePath);
    void printDifficultyPrompt();
    void printDifficultyInfo(Difficulty difficulty);
    void printSettingsMenu();
    void printHangman(int numStage);

}
