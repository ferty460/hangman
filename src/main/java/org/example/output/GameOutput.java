package org.example.output;

import org.example.core.HiddenWord;
import org.example.settings.Settings;

import java.util.List;

public interface GameOutput {

    void printGameState(int attempts, HiddenWord hiddenWord, List<Character> usedLetters);
    void printGameResult(HiddenWord hiddenWord);
    void printLetterPrompt();
    void printLetterGuessedMessage();
    void printWrongLetterMessage();
    void printWrongInputError();
    void printDictionaryFilePrompt();
    void printDifficultPrompt();
    void printSettingsState(Settings settings);
    void printSettingsMenu();
    void printGameMenu();

}
