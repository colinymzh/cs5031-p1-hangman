package stacs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * The {@code WordListLoader} class is responsible for loading a list of words
 * from a specified file and providing functionality to select a random word
 * from this list.
 */
public class WordListLoader {
    private List<String> wordList;

    /**
     * Constructs a new WordListLoader and loads the word list from the given path.
     *
     * @param path The path to the file containing the word list.
     */
    public WordListLoader(String path) {
        wordList = new ArrayList<>();
        // Load words from the specified file path
        InputStream inputStream = WordListLoader.class.getResourceAsStream(path);
        if (inputStream != null) {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    wordList.add(line.trim());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.err.println("Failed to load wordlist.txt");
        }
    }

    /**
     * Selects a random word from the loaded word list.
     *
     * @return A randomly selected word from the list.
     * @throws IllegalStateException if the word list is empty.
     */
    public String selectWordFromWordList() {
        if (wordList.isEmpty()) {
            throw new IllegalStateException("Word list is empty.");
        }

        Random random = new Random();
        int randomIndex = random.nextInt(wordList.size());
        return wordList.get(randomIndex);
    }
}
