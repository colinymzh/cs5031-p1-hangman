package stacs;

/**
 * The {@code DisplayManager} class is responsible for displaying the hangman
 * drawing in the console. This class provides a static method to draw the
 * hangman figure based on the number of wrong guesses.
 */
public class DisplayManager {

    /**
     * Draws the hangman figure in the console based on the number of wrong guesses.
     * The hangman figure is composed of different parts that are revealed
     * progressively as the number of wrong guesses increases.
     *
     * @param wrongGuessesCount The number of wrong guesses made by the player.
     */
    public static void drawHangman(int wrongGuessesCount) {
        System.out.println("*       HANGMAN         *");
        System.out.println("*                       *");
        System.out.println("*  ________             *");
        System.out.println("*  |    |               *");
        System.out.println("*  |    |               *");

        // Draw the head if at least one wrong guess
        if (wrongGuessesCount >= 1) {
            System.out.println("*  |    O               *");
        }

        // Draw the body and arms based on the number of wrong guesses
        if (wrongGuessesCount >= 3) {
            System.out.println("*  |   /|\\             *");
        } else if (wrongGuessesCount >= 2) {
            System.out.println("*  |    |              *");
        } else {
            System.out.println("*  |                    *");
        }

        // Draw the legs based on the number of wrong guesses
        if (wrongGuessesCount >= 5) {
            System.out.println("*  |   / \\             *");
        } else if (wrongGuessesCount >= 4) {
            System.out.println("*  |   /               *");
        } else {
            System.out.println("*  |                    *");
        }

        System.out.println("* _|_                   *");
    }
}
