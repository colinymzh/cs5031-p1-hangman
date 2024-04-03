package stacs;

import java.util.Scanner;

/**
 * The {@code GameMain} class is the main class for the Hangman game.
 * It handles the game setup, user interactions, and the main game loop.
 */
public class GameMain {
    private final Scanner scanner;
    private final WordListLoader wordListLoader;
    private Hangman hangman;
    private ScoreManager scoreManager;
    private Leaderboard leaderboard;



    /**
     * Constructs a new GameMain instance.
     *
     * @param scanner         The Scanner object for reading user input.
     * @param wordListLoader  The WordListLoader object for loading the list of words.
     */
    public GameMain(Scanner scanner, WordListLoader wordListLoader) {
        this.scanner = scanner;
        this.wordListLoader = wordListLoader;
        this.scoreManager = new ScoreManager();
        this.leaderboard = new Leaderboard();
    }

    /**
     * Starts the Hangman game. This method sets up the game and manages the main game loop.
     */
    public void startGame() {
        boolean keepPlaying = true;

        while (keepPlaying) {
            String wordToGuess = wordListLoader.selectWordFromWordList().toUpperCase();
            hangman = new Hangman(wordToGuess);
            System.out.println("Welcome to the Hangman game!");
            while (!hangman.isGameOver()) {
                DisplayManager.drawHangman(6 - hangman.getRemainingAttempts());
                System.out.println("Current guess: " + hangman.getCurrentGuess());
                System.out.print("Enter a letter: ");

                // Reading and validating user input
                String input = scanner.nextLine();
                if (input.isEmpty() || !Character.isLetter(input.charAt(0))) {
                    System.out.println("Invalid input. Please enter a letter.");
                    continue;
                }

                char guess = input.charAt(0);
                processGuess(guess);
            }

            concludeGame();

            // If the game is won, ask the player if they want to play another round
            if (hangman.isGameWon()) {
                System.out.print("Do you want to play another round? (yes/no): ");
                String playAgain = scanner.nextLine();
                keepPlaying = playAgain.equalsIgnoreCase("yes");
            } else {
                keepPlaying = false; // End the game if the player loses
            }

            if (!keepPlaying) {
                // Add the final score to the leaderboard and reset the score
                leaderboard.addRecord(scoreManager.getScore());
                scoreManager.resetScore();
            }
        }
    }

    /**
     * Processes the user's guess and updates the game state.
     *
     * @param guess The character guessed by the user.
     */
    private void processGuess(char guess) {
        String previousGuess = hangman.getCurrentGuess();
        String result = hangman.guessLetter(guess);

        // Checking if the guess was correct or already made
        if (result.equals(previousGuess)) {
            System.out.println("You have already guessed '" + guess + "' or it's a wrong guess.");
        } else {
            System.out.println("Good guess!");
            // Update the score based on the guess
            scoreManager.updateScore(previousGuess, result);
        }
        System.out.println("Remaining attempts: " + hangman.getRemainingAttempts());
    }

    /**
     * Concludes the game by displaying a win or lose message.
     */
    private void concludeGame() {
        if (hangman.isGameWon()) {
            System.out.println("Congratulations, you won! The word was: " + hangman.getCurrentGuess());
        } else {
            System.out.println("Game over. " + hangman.getGameOverMessage());
        }
        System.out.println("Your final score: " + scoreManager.getScore());
    }

    /**
     * Displays the start menu and handles user selections.
     */
    private void startMenu() {
        boolean exit = false;
        while (!exit) {
            System.out.println("\nWelcome to Hangman!");
            System.out.println("1. Start Game\n2. Leaderboard\n3. Exit Game");
            System.out.print("Please select an option (1-3): ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    startGame();
                    break;
                case "2":
                    leaderboard.displayLeaderboard();
                    break;
                case "3":
                    exit = true;
                    System.out.println("Exiting game. Thank you for playing!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    /**
     * The main method to start the Hangman game.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        WordListLoader wordListLoader = new WordListLoader("/wordlist.txt");
        GameMain game = new GameMain(new Scanner(System.in), wordListLoader);
        game.startMenu();
    }
}
