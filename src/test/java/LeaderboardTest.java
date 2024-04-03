import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import stacs.Leaderboard;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test class for the Leaderboard class.
 */
public class LeaderboardTest {

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private Leaderboard leaderboard;

    @BeforeEach
    void setUp() {
        leaderboard = new Leaderboard();
        System.setOut(new PrintStream(outputStreamCaptor)); // Capture the System.out output
    }

    /**
     * Tests adding records and displaying the leaderboard.
     */
    @Test
    void testAddAndDisplayRecord() {
        leaderboard.addRecord(100);
        leaderboard.addRecord(200);

        leaderboard.displayLeaderboard();

        String output = outputStreamCaptor.toString().trim();
        String[] lines = output.split(System.lineSeparator());

        // Check if the leaderboard has the correct number of records
        assertTrue(lines.length >= 3); // Includes the "Leaderboard:" title and at least two records

        // Check if the first record is greater or equal to the second record (descending order)
        int firstScore = extractScore(lines[1]);
        int secondScore = extractScore(lines[2]);
        assertTrue(firstScore >= secondScore);
    }

    /**
     * Extracts the score from a leaderboard record line.
     * @param recordLine The line representing a record in the leaderboard.
     * @return The score extracted from the record line.
     * @throws IllegalArgumentException if the record line has an invalid format.
     */
    private int extractScore(String recordLine) {
        Pattern pattern = Pattern.compile(".*Score: (\\d+)");
        java.util.regex.Matcher matcher = pattern.matcher(recordLine);
        if (matcher.find()) {
            return Integer.parseInt(matcher.group(1));
        }
        throw new IllegalArgumentException("Invalid record line format");
    }
}
