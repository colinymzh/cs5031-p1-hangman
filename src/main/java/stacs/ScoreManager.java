package stacs;

/**
 * The ScoreManager class manages the score of a game.
 * It provides methods to update the score based on the progression of the game, retrieve the current score,
 * and reset the score to zero.
 */
public class ScoreManager {
    private int score;

    /**
     * Constructs a new ScoreManager with an initial score of zero.
     */
    public ScoreManager() {
        this.score = 0;
    }

    /**
     * Updates the score based on the number of newly revealed letters in the current guess compared to the previous guess.
     * Adds 10 points for each newly revealed letter.
     *
     * @param previousGuess The previous state of the guessed word.
     * @param currentGuess The current state of the guessed word.
     */
    public void updateScore(String previousGuess, String currentGuess) {
        for (int i = 0; i < currentGuess.length(); i++) {
            // Check if the current letter was revealed in the current guess but not in the previous guess
            if (previousGuess.charAt(i) == '_' && currentGuess.charAt(i) != '_') {
                this.score += 10; // Add 10 points for each newly revealed letter
            }
        }
    }

    /**
     * Retrieves the current score.
     *
     * @return The current score.
     */
    public int getScore() {
        return score;
    }

    /**
     * Resets the score to zero.
     */
    public void resetScore() {
        this.score = 0;
    }
}
