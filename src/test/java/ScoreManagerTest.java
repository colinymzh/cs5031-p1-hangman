import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import stacs.ScoreManager;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test class for the ScoreManager class.
 */
public class ScoreManagerTest {

    private ScoreManager scoreManager;

    @BeforeEach
    void setUp() {
        scoreManager = new ScoreManager();
    }

    /**
     * Tests updating the score based on correct guesses.
     */
    @Test
    void testScoreUpdate() {
        String previousGuess = "_____";
        String currentGuess = "__a__";

        scoreManager.updateScore(previousGuess, currentGuess);
        assertEquals(10, scoreManager.getScore(), "Score should be 10 after one correct guess");

        previousGuess = currentGuess;
        currentGuess = "__a_e";

        scoreManager.updateScore(previousGuess, currentGuess);
        assertEquals(20, scoreManager.getScore(), "Score should be 20 after two correct guesses");
    }

    /**
     * Tests resetting the score to zero.
     */
    @Test
    void testScoreReset() {
        String previousGuess = "_____";
        String currentGuess = "__a__";

        scoreManager.updateScore(previousGuess, currentGuess);
        scoreManager.resetScore();
        assertEquals(0, scoreManager.getScore(), "Score should be reset to 0");
    }
}
