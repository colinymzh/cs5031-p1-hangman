import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import stacs.WordListLoader;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The {@code WordListLoaderTest} class contains tests for the {@code WordListLoader} class.
 * It ensures that words are correctly loaded from a file and can be selected randomly.
 */
public class WordListLoaderTest {
    private WordListLoader wordListLoader;

    /**
     * Sets up a WordListLoader instance with a test word list before each test.
     * The test word list should be a file located at "/wordlist-test.txt".
     */
    @BeforeEach
    public void setUp() {
        wordListLoader = new WordListLoader("/wordlist-test.txt");
    }

    /**
     * Tests if a word can be successfully selected from the word list.
     * This test checks that the selected word is not null, has a length of 5, and consists only of letters.
     */
    @Test
    public void testSelectWordFromWordList() {
        String selectedWord = wordListLoader.selectWordFromWordList();
        assertNotNull(selectedWord);
        assertTrue(selectedWord.length() == 5);
        assertTrue(selectedWord.matches("[a-zA-Z]+"));
    }
}