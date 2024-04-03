package stacs;

import java.util.HashSet;
import java.util.Set;

/**
 * The {@code Hangman} class represents a text-based Hangman game.
 * It manages the game state including the word to guess, the current guess state,
 * the remaining attempts, and the letters that have already been guessed.
 */
public class Hangman {
    private String wordToGuess;
    private StringBuilder currentGuess;
    private int remainingAttempts;
    private Set<Character> guessedLetters;

    /**
     * Constructs a new Hangman game with a specified word to guess.
     *
     * @param wordToGuess The word that needs to be guessed in the game.
     */
    public Hangman(String wordToGuess) {
        this.wordToGuess = wordToGuess.toLowerCase();
        this.remainingAttempts = 6;
        this.guessedLetters = new HashSet<>();
        this.currentGuess = initializeCurrentGuess();
    }

    /**
     * Initializes the current guess with underscores representing each letter of the word to guess.
     *
     * @return A StringBuilder representing the initial state of the current guess.
     */
    private StringBuilder initializeCurrentGuess() {
        StringBuilder initialGuess = new StringBuilder();
        for (int i = 0; i < wordToGuess.length(); i++) {
            initialGuess.append("_");
        }
        return initialGuess;
    }

    /**
     * Processes the player's guess, updates the game state, and returns the current state of the guess.
     *
     * @param letter The letter guessed by the player.
     * @return The current state of the guess as a String.
     */
    public String guessLetter(char letter) {
        letter = Character.toLowerCase(letter);
        if (guessedLetters.contains(letter)) {
            return currentGuess.toString();
        }

        guessedLetters.add(letter);
        if (wordToGuess.contains(String.valueOf(letter))) {
            updateCurrentGuess(letter);
        } else {
            remainingAttempts--;
        }
        return currentGuess.toString();
    }

    /**
     * Updates the current guess by revealing the positions of the correctly guessed letter.
     *
     * @param letter The letter that was correctly guessed.
     */
    private void updateCurrentGuess(char letter) {
        for (int i = 0; i < wordToGuess.length(); i++) {
            if (wordToGuess.charAt(i) == letter) {
                currentGuess.setCharAt(i, letter);
            }
        }
    }

    /**
     * Checks if the game is won by comparing the current guess with the word to guess.
     *
     * @return {@code true} if the game is won, {@code false} otherwise.
     */
    public boolean isGameWon() {
        return currentGuess.toString().equals(wordToGuess);
    }

    /**
     * Determines if the game is over, either by winning or running out of attempts.
     *
     * @return {@code true} if the game is over, {@code false} otherwise.
     */
    public boolean isGameOver() {
        return remainingAttempts <= 0 || isGameWon();
    }

    /**
     * Gets the current state of the guess.
     *
     * @return The current guess as a String.
     */
    public String getCurrentGuess() {
        return currentGuess.toString();
    }

    /**
     * Gets the number of remaining attempts.
     *
     * @return The number of remaining attempts.
     */
    public int getRemainingAttempts() {
        return remainingAttempts;
    }

    /**
     * Provides a message for the end of the game, revealing the correct word if the game is lost.
     *
     * @return The game over message, or an empty string if the game is not over or if it is won.
     */
    public String getGameOverMessage() {
        if (isGameOver() && !isGameWon()) {
            return "The correct word was: " + wordToGuess;
        }
        return "";
    }
}
