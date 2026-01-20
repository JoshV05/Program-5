package mario.kart.program5;

// Joshua Veal - jveal@mocs.flsouthern.edu
// Joel Peters - jpeters2@mocs.flsouthern.edu
// HONOR CODE POLICY: “I will practice academic and personal integrity and excellence of character and expect the same from others.”
// Date: 04/28/2024
// Desc: Program 5: JavaFX Application - 2290

// importing the necessary things
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;

public class Main extends Application {
    // creating the stages for each scene
    private static Stage registerStage = null;
    private static Stage searchStage = null;
    private static Stage leaderboardStage = null;

    // creates and loads the main page while setting options like name and size
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("main.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 550);
        stage.setResizable(false);
        stage.setTitle("Mario Kart Tournament");
        stage.setScene(scene);
        stage.show();
        // creates the other stages so they can be used later
        createRegisterStage();
        createSearchStage();
        createLeaderboardStage();
    }

    // creates the register stage when called
    public void createRegisterStage(){
        registerStage = new Stage();
        registerStage.setTitle("Register a new competitor");
        registerStage.setAlwaysOnTop(true);
        registerStage.setResizable(false);
        registerStage.initModality(Modality.APPLICATION_MODAL);

    }
    // gets the register stage to display it
    public static Stage getRegisterStage(){
        return registerStage;
    }
    // creates the search competitor stage
    public void createSearchStage(){
        searchStage = new Stage();
        searchStage.setTitle("Search for a Competitor");
        searchStage.setAlwaysOnTop(true);
        searchStage.setResizable(false);
        searchStage.initModality(Modality.APPLICATION_MODAL);

    }
    // gets the search competitor stage to display it
    public static Stage getSearchStage(){
        return searchStage;
    }
    // creates the leaderboard stage
    public void createLeaderboardStage(){
        leaderboardStage = new Stage();
        leaderboardStage.setTitle("Leaderboard");
        leaderboardStage.setAlwaysOnTop(true);
        leaderboardStage.setResizable(false);
        leaderboardStage.initModality(Modality.APPLICATION_MODAL);

    }
    // gets the leaderboard stage to display it
    public static Stage getLeaderboardStage(){
        return leaderboardStage;
    }


    // main function that starts whole project
    public static void main(String[] args) {
        launch();
    }
}