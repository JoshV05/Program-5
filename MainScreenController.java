package mario.kart.program5;
// importing the necessary things
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import java.io.IOException;
import java.util.Random;

public class MainScreenController extends Main {
    // rng variable used for setting new times
    // time variable also used while setting new times
    // record times array are the minimum times that the randomized
    // times are based on
    Random rng = new Random();
    int time;
    public static int[] recordTimes = { 115, 117, 115, 100 };

    // this method creates and opens the register scene when called
    public void openRegisterWindow() {
        try {
            // gets the fxml file for the register scene
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("register.fxml"));
            Parent root = loader.load();
            // calls the get register stage method
            Main.getRegisterStage().setScene(new Scene(root));

            RegisterController registerController = loader.getController();
            // opens the register scene
            Main.getRegisterStage().show();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    // this method creates and opens the search competitor scene when called
    public void openSearchWindow() {
        try {
            // gets the fxml file for the search competitor scene
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("search.fxml"));
            Parent root = loader.load();
            // calls the get search competitor stage method
            Main.getSearchStage().setScene(new Scene(root));

            SearchController searchController = loader.getController();
            // opens the search competitor scene
            Main.getSearchStage().show();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    // this method creates and opens the leaderboard scene when called
    public void openLeaderboardWindow(){
        try {
            // gets the fxml file for the leaderboard scene
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("leaderboard.fxml"));
            Parent root = loader.load();
            // calls the get leaderboard stage method
            Main.getLeaderboardStage().setScene(new Scene(root));

            LeaderboardController leaderboardController = loader.getController();
            // opens the leaderboard scene
            Main.getLeaderboardStage().show();
        }catch (IOException ex){
            System.out.println(ex);
        }
    }


    // this method runs when a button is clicked
    public void onMouseClick(MouseEvent mouseEvent) {
        // gets the button that was clicked and the text on the button
        Button button = (Button) mouseEvent.getSource();
        String buttonText = button.getText();
        // switch case based on the button text
        switch(buttonText){
            case "Register a new competitor": {
                // opens the register a competitor scene
                openRegisterWindow();
                break;
            }
            case "Search for a competitor by ID number": {
                // opens the search competitor scene
                openSearchWindow();
                break;
            }
            case "Perform Time Trial": {
                // performs time trials for all competitors on all maps
                // loops over whole competitors array
                for (int i = 0; i < RegisterController.competitorsList.length; i++) {
                    // makes sure the index isn't empty
                    if (RegisterController.competitorsList[i] != null) {
                        // loops over every track
                        for (int track = 1; track <= 4; track++) {
                            // sets the time with 0-30 seconds added onto the record time for the track
                            time = rng.nextInt(30) + recordTimes[track-1];
                            RegisterController.competitorsList[i].setBestTimes(track, time);
                        }
                    }
                }
                System.out.println("All competitors have new times recorded for all tracks");
                break;
            }
            case "Display Leaderboard": {
                // opens the leaderboard scene
                openLeaderboardWindow();
                break;
            }
            case "Erase all competitor times and reset Leaderboard": {
                // resets every competitors time for every track
                // loops over whole competitors array
                for (int i = 0; i < RegisterController.competitorsList.length; i++) {
                    // makes sure the index isn't empty
                    if (RegisterController.competitorsList[i] != null) {
                        // loops over every track
                        for (int track = 1; track <= 4; track++) {
                            // sets their time to 0
                            RegisterController.competitorsList[i].setBestTimes(track, 0);
                        }
                    }
                }
                break;
            }
            case "Quit":
                // closes program when pressed
                System.out.println("Don't let the door hit you on the way out.");
                // get a handle to the stage
                Stage stage = (Stage) button.getScene().getWindow();
                // do what you have to do
                stage.close();
                break;
        }
    }
}