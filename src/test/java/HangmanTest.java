import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import stacs.Hangman;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The {@code HangmanTest} class tests the functionality of the {@code Hangman} class.
 * It covers various scenarios such as initialization, correct and incorrect guesses,
 * winning and losing the game, repeated guesses, and game over messages.
 */
class HangmanTest {
    private Hangman game;

    /**
     * Sets up a new game before each test with the word "test".
     */
    @BeforeEach
    void setUp() {
        game = new Hangman("test");
    }

    /**
     * Tests if the game is correctly initialized.
     */
    @Test
    void testInitialization() {
        assertEquals("____", game.getCurrentGuess());
        assertEquals(6, game.getRemainingAttempts());
    }

    /**
     * Tests guessing a correct letter.
     */
    @Test
    void testCorrectGuess() {
        game.guessLetter('t');
        assertEquals("t__t", game.getCurrentGuess());
    }

    /**
     * Tests guessing an incorrect letter.
     */
    @Test
    void testIncorrectGuess() {
        game.guessLetter('z');
        assertEquals("____", game.getCurrentGuess());
        assertEquals(5, game.getRemainingAttempts());
    }

    /**
     * Tests the behavior when multiple letters are guessed, including both correct and incorrect guesses.
     */
    @Test
    void testMultipleGuesses() {
        game.guessLetter('t');
        game.guessLetter('e');
        assertEquals("te_t", game.getCurrentGuess());
    }

    /**
     * Tests the scenario where the player guesses all letters correctly and wins the game.
     */
    @Test
    void testWinningGame() {
        for (char letter : "test".toCharArray()) {
            game.guessLetter(letter);
        }
        assertTrue(game.isGameWon());
        assertTrue(game.isGameOver());
    }

    /**
     * Tests the scenario where the player makes enough incorrect guesses and loses the game.
     */
    @Test
    void testLosingGame() {
        for (char letter : "abcdfg".toCharArray()) {
            game.guessLetter(letter);
        }
        assertFalse(game.isGameWon());
        assertTrue(game.isGameOver());
    }

    /**
     * Tests repeated guesses of a correct letter.
     */
    @Test
    void testRepeatedGuessesRight() {
        game.guessLetter('t');
        game.guessLetter('t'); // Repeated guess
        assertEquals("t__t", game.getCurrentGuess());
        assertEquals(6, game.getRemainingAttempts()); // No penalty for repeated guesses
    }

    /**
     * Tests repeated guesses of an incorrect letter.
     */
    @Test
    void testRepeatedGuessesWrong() {
        game.guessLetter('b');
        game.guessLetter('b'); // Repeated guess
        assertEquals("____", game.getCurrentGuess());
        assertEquals(5, game.getRemainingAttempts()); // No penalty for repeated guesses
    }

    /**
     * Tests the game over message when the game is lost.
     */
    @Test
    void testGetGameOverMessageWhenLost() {
        for (char letter : "abcdfg".toCharArray()) {
            game.guessLetter(letter);
        }

        assertTrue(game.isGameOver());
        assertFalse(game.isGameWon());
        assertEquals("The correct word was: test", game.getGameOverMessage());
    }

    /**
     * Tests the game over message when the game is won.
     */
    @Test
    void testGetGameOverMessageWhenWon() {
        for (char letter : "test".toCharArray()) {
            game.guessLetter(letter);
        }

        assertTrue(game.isGameWon());
        assertTrue(game.isGameOver());
        assertEquals("", game.getGameOverMessage());
    }

    /**
     * Tests the game over message before the game ends.
     */
    @Test
    void testGetGameOverMessageBeforeGameEnds() {
        game.guessLetter('t');

        assertFalse(game.isGameOver());
        assertEquals("", game.getGameOverMessage());
    }
}
