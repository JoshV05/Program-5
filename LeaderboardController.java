package mario.kart.program5;
// importing the necessary things
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class LeaderboardController {
    // connects the Labels from Scene Builder to code,
    // so they can be changed or accessed
    @FXML
    private Label trackOne;
    @FXML
    private Label trackTwo;
    @FXML
    private Label trackThree;
    @FXML
    private Label trackFour;

    // sets the appropriate text for each track when this scene is called
    // can't set it ahead of time because you don't know what times to display until they load this
    // calls the displayLeaderboard method to do this which is slightly modified from program 3 to work here
    public void initialize() {
        trackOne.setText("Sunshine Airport:\n"+displayLeaderBoard(RegisterController.competitorsList,0,1));
        trackTwo.setText("Dolphin Shoals:\n"+displayLeaderBoard(RegisterController.competitorsList,1,2));
        trackThree.setText("Electrodome:\n"+displayLeaderBoard(RegisterController.competitorsList,2,3));
        trackFour.setText("Mount Wario:\n"+displayLeaderBoard(RegisterController.competitorsList,3,4));
    }

    // returns the leaderboard for every track
    // program 3 printed results to console
    // this returns the string for a given track, so we can set the Label
    public static String displayLeaderBoard(Competitor[] competitors, int trackNumber, int trackNumberPlusOne) {
        int bestTime = 0;
        int bestCompetitor = 0;
        // loops over every track and does the necessary logic
        // instead of looping over all 4 tracks like in program 3
        // this "loops" only 1 time for the desired track
        for (int j = trackNumber; j < trackNumberPlusOne; j++) {
            bestTime = Integer.MAX_VALUE; // start at BIGGEST int because we want SMALLER times
            // loops over the number of competitors created
            for (int i = 0; i < Competitor.getNumCompetitors(); i++) {
                // checks if their time on the current track is NOT 0
                if (competitors[i].getBestTimes(j + 1) != 0) {
                    // then checks if their time is faster than the bestTime int and that it's greater than 0 (maybe redundant?)
                    // first time through will always save something because it will be faster than Integer.MAX_VALUE
                    if (competitors[i].getBestTimes(j + 1) < bestTime && competitors[i].getBestTimes(j + 1) > 0) {
                        bestTime = competitors[i].getBestTimes(j + 1); // saves the time as an int
                        bestCompetitor = i; // saves which competitor had the best time
                    }
                }
            } // if the bestTime is still MAX_VALUE, everything was still 0
            // and therefore no time trials were recorded
            if (bestTime == Integer.MAX_VALUE) {
                return "      no time trials recorded";
            } else { // goes here if any time trial was recorded for the specific track
                // here is the print abomination from program 2
                // it works and that's all that matters
                // basically just makes the time print 2'10" and not 2'010" etc
                return String.format("      %s %s (ID: %d)\r\n" + //
                                "      Character: %s\r\n" + //
                                "      Vehicle:   %s\r\n" + //
                                "      Time:      %s\n", competitors[bestCompetitor].getFirstName(),
                        competitors[bestCompetitor].getLastName(), competitors[bestCompetitor].getID(),
                        competitors[bestCompetitor].getCharacter(),
                        competitors[bestCompetitor].getVehicle(),
                        (competitors[bestCompetitor].getBestTimes(j + 1) % 60 >= 10)
                                ? "" + competitors[bestCompetitor].getBestTimes(j + 1) / 60 + "'"
                                + competitors[bestCompetitor].getBestTimes(j + 1) % 60 + "\""
                                : "" + competitors[bestCompetitor].getBestTimes(j + 1) / 60 + "'0"
                                + competitors[bestCompetitor].getBestTimes(j + 1) % 60 + "\"");
            }
            // this is the end of ONE track, goes back and repeats for every track
        }
        return null; // IntelliJ complained when I didn't have this
        // it probably thinks there is a chance the return statements above are never reached
        // but they one of them should always happen if my logic isn't bad
    }
}