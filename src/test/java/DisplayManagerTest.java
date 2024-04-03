import org.junit.jupiter.api.Test;
import stacs.DisplayManager;

/**
 * The {@code DisplayManagerTest} class contains tests for the {@code DisplayManager} class.
 * It primarily focuses on testing the drawHangman method with different counts of wrong guesses.
 */
public class DisplayManagerTest {
    @Test
    public void testDrawHangman() {
        // Testing for various wrongGuessesCount values
        DisplayManager.drawHangman(0); // No wrong guesses
        DisplayManager.drawHangman(1); // One wrong guess
        DisplayManager.drawHangman(2); // Two wrong guesses
        DisplayManager.drawHangman(3); // Three wrong guesses
        DisplayManager.drawHangman(4); // Four wrong guesses
        DisplayManager.drawHangman(5); // Five wrong guesses
        DisplayManager.drawHangman(6); // Six wrong guesses
    }
}
