package stacs;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * The Leaderboard class maintains a list of records consisting of scores and dates.
 * It provides methods to add new records and display the leaderboard.
 */
public class Leaderboard {

    /**
     * Represents a single record in the leaderboard, containing a score and the date it was achieved.
     */
    private static class Record {
        int score;
        String date;

        /**
         * Constructs a new Record with the given score and date.
         * @param score The score achieved
         * @param date The date when the score was achieved
         */
        Record(int score, String date) {
            this.score = score;
            this.date = date;
        }

        /**
         * Returns a string representation of the Record.
         * @return The string representation of the Record
         */
        @Override
        public String toString() {
            return date + " - Score: " + score;
        }
    }

    private final List<Record> records;

    /**
     * Constructs a new Leaderboard with an empty list of records.
     */
    public Leaderboard() {
        this.records = new ArrayList<>();
    }

    /**
     * Adds a new record with the given score and the current date to the leaderboard.
     * @param score The score to be added to the leaderboard
     */
    public void addRecord(int score) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDate = now.format(formatter);
        records.add(new Record(score, formattedDate));
    }

    /**
     * Displays the leaderboard in descending order of scores.
     */
    public void displayLeaderboard() {
        System.out.println("\nLeaderboard:");
        // Sort in descending order of score
        records.sort((r1, r2) -> Integer.compare(r2.score, r1.score));
        for (Record record : records) {
            System.out.println(record);
        }
    }
}
