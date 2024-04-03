# Hangman Game in Java

Dive into the classic world of Hangman, a compelling text-based Java game. This rendition of the timeless word-guessing game offers a delightful mix of challenge and fun, perfect for word game enthusiasts.

## Key Features

- **Engaging Text-Based Gameplay:** Experience the thrill of Hangman in a simple console interface.
- **Random Word Selection:** Each game is a fresh challenge with words randomly picked from a curated list.
- **User-Friendly Interface:** Clear instructions and real-time feedback make for an accessible and enjoyable game.
- **Scoring System:** Keep track of your score with each correct guess.
- **Leaderboard:** View your scores over time in a sorted leaderboard.

## How to Play

1. **Launch the Game:** Choose from several methods to start playing.
2. **Make Your Guesses:** Input letters one at a time to guess the hidden word.
3. **Win or Learn:** The game ends when you successfully guess the word or exhaust your attempts.

## Starting the Game

You can start the Hangman game in several ways:

1. **IDEA (IntelliJ IDEA):**
   - Open the project in IntelliJ IDEA.
   - Navigate to `src/main/java/stacs/GameMain.java`.
   - Right-click and select 'Run GameMain.main()'.
2. **Executable JAR:**
   - Run `mvn clean package` to generate .jar file.
   - Open a terminal or command prompt.
   - Navigate to the `./Hangman/target` directory.
   - Run `java -jar Hangman-1.0-SNAPSHOT.jar`.

## Project Structure

The Hangman game is structured into several key Java classes, each with a specific role:

- **`GameMain`**: 
  - The entry point of the game.
  - Orchestrates the game setup and manages the main game loop.
  - Interacts with `WordListLoader` for word selection and `Hangman` for game logic.
  - Handles user inputs and game progression.

- **`Hangman`**: 
  - Manages the core game logic.
  - Keeps track of the word to be guessed, the current state of the player's guess, and the number of remaining attempts.
  - Provides methods to process player guesses and determine the outcome of the game.

- **`DisplayManager`**: 
  - Responsible for the visual representation of the game in the console.
  - Displays the hangman figure and updates the game status based on the number of incorrect guesses.

- **`WordListLoader`**: 
  - Handles loading of words from a file.
  - Selects a random word from the loaded list, providing the target word for each game.

- **`ScoreManager`**: 
  - Manages the scoring system.
  - Calculates scores based on the player's performance, particularly the number of correct guesses.

- **`Leaderboard`**: 
  - Records and maintains game scores.
  - Displays scores in a sorted leaderboard, showing player achievements over time.

## Testing

The project includes comprehensive unit tests for its main components to ensure the reliability and correctness of the game's functionality. To run these tests, execute `mvn test` in the project's root directory. The test classes cover various aspects of the game:

- **`DisplayManagerTest`**: 
  - Focuses on testing the `DisplayManager` class.
  - Ensures that the hangman figure is correctly drawn for different counts of wrong guesses.

- **`HangmanTest`**: 
  - Tests various scenarios in the `Hangman` game logic.
  - Covers game initialization, correct and incorrect guesses, game-winning and losing conditions, and repeated guesses.

- **`WordListLoaderTest`**: 
  - Verifies the functionality of the `WordListLoader` class.
  - Ensures that words are correctly loaded from the file and can be randomly selected.

- **`ScoreManagerTest`**: 
  - Tests the `ScoreManager` class.
  - Checks the accuracy of score calculations based on player guesses.

- **`LeaderboardTest`**: 
  - Validates the `Leaderboard` class.
  - Confirms that scores are correctly recorded and displayed in descending order.