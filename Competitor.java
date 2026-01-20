package mario.kart.program5;
// copy and pasted from Joel's program 3 basically without changes
// setters aren't used in current code but help with debugging
// and could be used in future
// also you get to see my glorious toString method one final time :D
public class Competitor {
    // creating the class with all its data members
    private int id;
    private String firstName;
    private String lastName;
    private String character;
    private String vehicle;
    private int[] bestTimes;
    private static int numCompetitors = 0; // number of competitors that can be used for logic in main file

    // no argument constructor
    // shouldn't ever be used in this program
    public Competitor() {
    }

    // all argument constructor for competitors
    public Competitor(int id, String firstName, String lastName, String character, String vehicle) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.character = character;
        this.vehicle = vehicle;
        this.bestTimes = new int[4];
        numCompetitors++; // increases the number of competitors at the end
    }

    // basic getters and setters
    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    // gets the best time at a specified track
    public int getBestTimes(int track) {
        return bestTimes[track - 1];
    }

    // sets the time for a specified track
    public void setBestTimes(int track, int time) {
        this.bestTimes[track - 1] = time;
    }

    public static int getNumCompetitors() {
        return numCompetitors;
    }

    // overrides the default toString from the Object class
    @Override
    // puts all the information of a competitor
    // into a string with formatted strings
    public String toString() {
        // starts with empty string and concatenates onto it
        String s = "";
        // String.format allows for easy concatenation
        // also uses same ugly time formatting as explained in displayLeaderBoard
        s += String.format(
                "   %s %s (ID: %d)\r\n" + //
                        "   Character: %s\r\n" + //
                        "   Vehicle:   %s\r\n" + //
                        "   ***Best Times***\r\n" + //
                        "      Sunshine Airport: %s\r\n" + //
                        "      Dolphin Shoals:   %s\r\n" + //
                        "      Electrodrome:     %s\r\n" + //
                        "      Mount Wario:      %s\n\n",
                firstName, lastName,
                id, character, vehicle,
                ((bestTimes[0] == 0) ? "no time recorded"
                        : (bestTimes[0] % 60 >= 10)
                        ? "" + bestTimes[0] / 60 + "'" + bestTimes[0] % 60 + "\""
                        : "" + bestTimes[0] / 60 + "'0" + bestTimes[0] % 60 + "\""),
                ((bestTimes[1] == 0) ? "no time recorded"
                        : (bestTimes[1] % 60 >= 10)
                        ? "" + bestTimes[1] / 60 + "'" + bestTimes[1] % 60 + "\""
                        : "" + bestTimes[1] / 60 + "'0" + bestTimes[1] % 60 + "\""),
                ((bestTimes[2] == 0) ? "no time recorded"
                        : (bestTimes[2] % 60 >= 10)
                        ? "" + bestTimes[2] / 60 + "'" + bestTimes[2] % 60 + "\""
                        : "" + bestTimes[2] / 60 + "'0" + bestTimes[2] % 60 + "\""),
                ((bestTimes[3] == 0) ? "no time recorded"
                        : (bestTimes[3] % 60 >= 10)
                        ? "" + bestTimes[3] / 60 + "'" + bestTimes[3] % 60 + "\""
                        : "" + bestTimes[3] / 60 + "'0" + bestTimes[3] % 60 + "\""));
        return s; // returns the final string since this method doesn't actually do the printing
    }

}
